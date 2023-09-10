
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

        
public class Login extends JFrame implements ActionListener {
    JButton login, clear,signUp; 
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("Automated Tailer Machine");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
       
        
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Raleway",Font.BOLD,28));
        CardNo.setBounds(120,120,400,40);
        add(CardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,120,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel Pin = new JLabel("Pin:");
        Pin.setFont(new Font("Raleway",Font.BOLD,28));
        Pin.setBounds(120,180,400,40);
        add(Pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,180,250,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,250,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(450,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,290,250,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
       setSize(800,400);
       setVisible(true);
       setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== login)
        {
            
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query ="select * from login where cardno ='"+cardnumber+"' and pinno ='"+pinnumber+"'";
            try
            {
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter Correct Details");
                }
            }
            catch(Exception ae)
            {
                System.out.println(ae);
            }
        }
        else if(e.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(e.getSource()==signUp)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
            
            
        }
        
    }
    public static void main(String[] args) {
        new Login();
        
        
    }
    
}
