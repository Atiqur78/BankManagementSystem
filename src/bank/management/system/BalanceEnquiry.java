
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        Conn cnn = new Conn();
        int balance=0;
        try
        {
            ResultSet rs = cnn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        JLabel text = new JLabel("Your Current Balance Is:  "+ balance);
        text.setBounds(200,300,300,30);
        text.setFont( new Font("System",Font.BOLD,16));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        image.add(text);
                
        
        back = new JButton("Back");
        back.setBounds(360,420,150,30);
        back.setFont( new Font("System",Font.BOLD,22));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
    
}
