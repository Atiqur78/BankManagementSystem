

package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{
    
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    
    Withdraw(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Enter the amount you want to withdraw: ");
        text.setFont(new Font("System", Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,465,150,30);
        
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,510,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==withdraw)
        {
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the Amount");
            }
            else
            {
                try
                {
                Conn conn = new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+number+"')";
                conn.s.executeUpdate(query);
                
                ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
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
                if(e.getSource() !=back && balance< Integer.parseInt(number))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawal Successfully");
                
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                catch(Exception ae)
                {
                    System.out.println(ae);
                }
            }
            
        }
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdraw("");
        
    }
    
}

