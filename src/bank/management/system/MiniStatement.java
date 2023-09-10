
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;
    JButton button;
    
    MiniStatement(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        JLabel card= new JLabel();
        card.setBounds(210,300,300,30);
        card.setForeground(Color.WHITE);
        card.setFont(new Font("System",Font.BOLD,16));
        image.add(card);
        
        JLabel statement= new JLabel();
        statement.setBounds(170,330,500,200);
        statement.setForeground(Color.WHITE);
        statement.setFont(new Font("System",Font.BOLD,12));
        image.add(statement);
        
        JLabel balance = new JLabel();
        balance.setBounds(170,490,300,30);
        balance.setFont(new Font("System",Font.BOLD,14));
        balance.setForeground(Color.WHITE);
        image.add(balance);
        
        button = new JButton("Back");
        button.setBounds(380,520,120,30);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("System",Font.BOLD,22));
        button.addActionListener(this);
        image.add(button);
        
        
        
        
        
        
        try
        {
            
            Conn cnn = new Conn();
            ResultSet rs =cnn.s.executeQuery ("select * from login where pinno ='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardno").substring(0,4)+"xxxxxxxx" +rs.getString("cardno").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn cnn = new Conn();
            ResultSet rs = cnn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            int bal =0;
            while(rs.next())
                {
                    statement.setText(statement.getText() + "<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
              
                    if(rs.getString("type").equals("Deposit"))
                    {
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            balance.setText("Your current account balance is Rs "+bal);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
                
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
        
    }
    
}
