
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JButton submit,back;
    JTextField pinTextField;
    JPasswordField RePinTextField;
    String pinnumber;
    
    PinChange(String pinnumber)   
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setFont(new Font("System",Font.BOLD,22));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setBounds(240,310,200,30);
        image.add(text);
        
        JLabel pinText = new JLabel("Enter New Pin:");
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBackground(Color.BLACK);
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(165,350,200,30);
        image.add(pinText);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        pinTextField.setBounds(310,350,200,30);
        image.add(pinTextField);
        
        
        JLabel RepinText = new JLabel("Re-Enter New Pin:");
        RepinText.setFont(new Font("System",Font.BOLD,16));
        RepinText.setBackground(Color.BLACK);
        RepinText.setForeground(Color.WHITE);
        RepinText.setBounds(165,390,200,30);
        image.add(RepinText);
        
        RePinTextField = new JPasswordField();
        RePinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        RePinTextField.setBounds(310,390,200,30);
        image.add(RePinTextField);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("System",Font.BOLD,16));
        submit.setBounds(350,450,150,30);
        submit.addActionListener(this);
        image.add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("System",Font.BOLD,16));
        back.setBounds(350,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            try
            {
            String npin = pinTextField.getText();
            String rpin = RePinTextField.getText();
            
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                return;
            }
            else if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Re-Pin");
                return;
            }
            else if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered pin dosen't match");
                return;
            }
            Conn cnn = new Conn();
            String query= "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            String query1 ="update login set pinno ='"+rpin+"' where pinno ='"+pinnumber+"'";
            String query2 ="update signupthree set pinno ='"+rpin+"' where pinno='"+pinnumber+"'";
            
            cnn.s.executeUpdate(query);
            cnn.s.executeUpdate(query1);
            cnn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Pin has been successfully changed");
            setVisible(false);
            
            new Transaction(pinnumber).setVisible(true);
            
            
                

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
       }
        
    }
    
    public static void main(String[] args) {
        new PinChange("");
    }
    
}
