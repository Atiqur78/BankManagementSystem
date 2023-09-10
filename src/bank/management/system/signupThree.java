
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class signupThree extends JFrame implements ActionListener {
    
    JRadioButton saving, current,recurring,fixedDeposit;
    JCheckBox atmCard,internetBanking,mobileBanking,alerts, chequeBook,declaration,eStatement;
    JButton submit, cancell;
    String formno;

    signupThree(String formno) {
        this.formno = formno;
        
        
         JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(280, 40, 400, 40);
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        add(l1);
        
        JLabel accountType = new JLabel("Account Type:");
        accountType.setBounds(100, 140, 200, 30);
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        add(accountType);
        
        saving = new JRadioButton("Saving Account");
        saving.setBounds(100,180,150,20);
        saving.setBackground(Color.WHITE);
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        add(saving);
        
        current = new JRadioButton("Current Account");
        current.setBounds(350,180,150,30);
        current.setBackground(Color.WHITE);
        current.setFont(new Font("Raleway",Font.BOLD,16));
        add(current);
        
        recurring = new JRadioButton("Recurring Account");
        recurring.setBounds(100,220,250,30);
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        add(recurring);
        
        fixedDeposit =  new JRadioButton("FIxed Deposit");
        fixedDeposit.setBounds(350,220,150,30);
        fixedDeposit.setBackground(Color.WHITE);
        fixedDeposit.setFont(new Font("Raleway",Font.BOLD,16));
        add(fixedDeposit);
        
        ButtonGroup type = new ButtonGroup();
        type.add(saving);
        type.add(current);
        type.add(recurring);
        type.add(fixedDeposit);
        
        JLabel card = new JLabel("CARD NUMBER:            XXXX-XXXX-XXXX-1234");
        card.setBounds(100, 300, 500, 30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number ");
        cardDetail.setBounds(100, 330, 200, 20);
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardDetail);
        
        JLabel pin = new JLabel("PIN:                                XXXX");
        pin.setBounds(100, 370, 400, 30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        
        JLabel pinDetail = new JLabel("Your 4 Digit PIN Number ");
        pinDetail.setBounds(100, 400, 200, 40);
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinDetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setBounds(100, 450, 300, 30);
        services.setFont(new Font("Raleway",Font.BOLD,22));
        add(services);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("Raleway", Font.BOLD,16));
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(100,500,200,30);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internnet Banking");
        internetBanking.setFont(new Font("Raleway", Font.BOLD,16));
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(350,500,200,30);
        add(internetBanking);
        
         mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Raleway", Font.BOLD,16));
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(100,550,200,30);
        add(mobileBanking);
        
         chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Raleway", Font.BOLD,16));
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(350,550,200,30);
        add(chequeBook);
        
         alerts = new JCheckBox("Email & SMS");
        alerts.setFont(new Font("Raleway", Font.BOLD,16));
        alerts.setBackground(Color.WHITE);
        alerts.setBounds(100,600,200,30);
        add(alerts);
        
        eStatement = new JCheckBox("E- Statement");
        eStatement.setFont(new Font("Raleway", Font.BOLD,16));
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(350,600,200,30);
        add(eStatement);
        
         declaration = new JCheckBox("I hearby declare that the above entered information are correct to the best of my knowledge.");
        declaration.setFont(new Font("Raleway", Font.BOLD,10));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(100,660,600,30);
        add(declaration);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(250, 720, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancell = new JButton("CANCEL");
        cancell.setFont(new Font("Raleway", Font.BOLD, 16));
        cancell.setBounds(420, 720, 100, 30);
        cancell.setBackground(Color.BLACK);
        cancell.setForeground(Color.WHITE);
        cancell.addActionListener(this);
        add(cancell);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = null;
            
             if(saving.isSelected())
            {
                accountType ="Saving Account";
            }
            else if(current.isSelected())
            {
                accountType = "Current Account";
            }
            else if(recurring.isSelected())
            {
                accountType ="Recurring";
            }
            else if(fixedDeposit.isSelected())
            {
                accountType = "FIxed Diposit";
            }
            
            
            Random random = new Random();
            String cardNo ="" + Math.abs((random.nextLong()% 90000000L)+5040936000000000L);
            String pinNo =""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(atmCard.isSelected())
            {
                facility = facility +"ATM Card";
            }
            else if(internetBanking.isSelected())
            {
                facility = facility +"Internet Banking";
            }
            else if(mobileBanking.isSelected())
            {
                facility = facility + "Mobile Banking";
            }
            else if(alerts.isSelected())
            {
                facility = facility + "Email & SMS alerts";
            }
            else if(chequeBook.isSelected())
            {
                facility += "Cheque Book";
            }
            else if(eStatement.isSelected())
            {
                facility += "E-Statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "Services is Required");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signupthree values ('" + formno + "','" + accountType + "','" + cardNo + "','" + pinNo + "','" + facility + "')";
                    String query1 = "insert into login values ('" + formno + "','" + cardNo + "','" + pinNo + "')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "Your card no: " + cardNo + "\n Pin No: " + pinNo);

                    setVisible(false);
                    new Deposit(pinNo).setVisible(true);

                }
            } catch (Exception ae) {
                System.out.println(ae);
            }

        } else if (e.getSource() == cancell) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new signupThree("");
    }
}

