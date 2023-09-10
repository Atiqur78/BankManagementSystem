
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton deposit, withdrawl,fastcash, statement,pinChange,balanceEnquiry,exit;
    String pinnumber;
    
    Transaction(String pinnumber)
    {
        
        this.pinnumber =pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton ("Deposit");
        deposit.setBounds(170,415,160,30);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton ("Cash WIthdraw");
        withdrawl.setBounds(355,415,160,30);
        withdrawl.setFont(new Font("System",Font.BOLD,16));
        withdrawl.setForeground(Color.BLACK);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton ("Fast Cash");
        fastcash.setBounds(170,450,160,30);
        fastcash.setFont(new Font("System",Font.BOLD,16));
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        statement = new JButton ("Mini Statement");
        statement.setBounds(355,450,160,30);
        statement.setFont(new Font("System",Font.BOLD,16));
        statement.setForeground(Color.BLACK);
        statement.addActionListener(this);
        image.add(statement);
        
        pinChange = new JButton ("PIN Change");
        pinChange.setBounds(170,485,160,30);
        pinChange.setFont(new Font("System",Font.BOLD,16));
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton ("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,160,30);
        balanceEnquiry.setFont(new Font("System",Font.BOLD,16));
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton ("EXIT");
        exit.setBounds(355,520,160,30);
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
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceEnquiry)
        {
            setVisible(true);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==statement)
        {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args) {
        new Transaction("");
        
    }
    
}
