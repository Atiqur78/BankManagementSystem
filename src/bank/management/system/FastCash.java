

package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    JButton fiveHundred, oneThousand,twoThousand, threeThousand,fiveThousand,tenThousand,exit;
    String pinnumber;
    
    FastCash(String pinnumber)
    {
        
        this.pinnumber =pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select the amount");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        fiveHundred = new JButton ("Rs 500");
        fiveHundred.setBounds(170,415,150,30);
        fiveHundred.setFont(new Font("System",Font.BOLD,16));
        fiveHundred.setForeground(Color.BLACK);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        oneThousand = new JButton ("Rs 1000");
        oneThousand.setBounds(355,415,150,30);
        oneThousand.setFont(new Font("System",Font.BOLD,16));
        oneThousand.setForeground(Color.BLACK);
        oneThousand.addActionListener(this);
        image.add(oneThousand);
        
        twoThousand = new JButton ("Rs 2000");
        twoThousand.setBounds(170,450,150,30);
        twoThousand.setFont(new Font("System",Font.BOLD,16));
        twoThousand.setForeground(Color.BLACK);
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        threeThousand = new JButton ("Rs 3000");
        threeThousand.setBounds(355,450,150,30);
        threeThousand.setFont(new Font("System",Font.BOLD,16));
        threeThousand.setForeground(Color.BLACK);
        threeThousand.addActionListener(this);
        image.add(threeThousand);
        
        fiveThousand = new JButton ("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.setFont(new Font("System",Font.BOLD,16));
        fiveThousand.setForeground(Color.BLACK);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton ("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.setFont(new Font("System",Font.BOLD,14));
        tenThousand.setForeground(Color.BLACK);
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        exit = new JButton ("EXIT");
        exit.setBounds(355,520,150,30);
        exit.setFont(new Font("System",Font.BOLD,14));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        else 
        {
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn cnn = new Conn();
            try
            {
                ResultSet rs = cnn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance =0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() !=exit && balance< Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                cnn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdraw successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        
    }
    
    
    public static void main(String[] args) {
        new FastCash("");
        
    }
    
}

