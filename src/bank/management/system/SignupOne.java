package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fatherNameTextField,emailTextField,addressTextField,cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male,female, single, married, other;
    JDateChooser dateChooser;
    
    SignupOne()
    {
        setLayout(null);
        Random ran = new Random();
        random= Math.abs(ran.nextLong() % 9000L +1000L);
        
        JLabel formNo = new JLabel("APPLICATION FORM NO. "+ random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,40);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(240,140,300,40);
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father Name: ");
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        fatherName.setBounds(100,190,200,40);
        add(fatherName);
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fatherNameTextField.setBounds(240,190,300,40);
        add(fatherNameTextField);
        
        JLabel dateOfBirth = new JLabel("Date Of Birth: ");
        dateOfBirth.setFont(new Font("Raleway",Font.BOLD,20));
        dateOfBirth.setBounds(100,240,200,40);
        add(dateOfBirth);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(240,240,300,40);
        add(dateChooser);
       
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,300,40);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(240,290,120,40);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(390,290,120,40);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup(); 
        genderGroup.add(male);
        genderGroup.add(female);
        
        
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(240,340,300,40);
        add(emailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(100,390,200,40);
        add(maritalStatus);
        
        single = new JRadioButton("Single");
        single.setBounds(240,390,100,40);
        add(single);
        
        married = new JRadioButton("Married");
        married.setBounds(340,390,100,40);
        add(married);
        
        other = new JRadioButton("Other");
        other.setBounds(440,390,100,40);
        add(other);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(single);
        maritalGroup.add(married);
        maritalGroup.add(other);
        
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,40);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(240,440,300,40);
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,40);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(240,490,300,40);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,40);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(240,540,300,40);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,40);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(240,590,300,40);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,22));
        next.setBounds(440,650,100,40);
        next.addActionListener(this);
        add(next);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fathername = fatherNameTextField.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender ="Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital= null;
        if(single.isSelected())
        {
            marital ="Single";
        }
        else if(married.isSelected())
        {
            marital ="Married";
        }
        else if(other.isSelected())
        {
            marital ="Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else if(fathername.equals(""))
            {
                JOptionPane.showMessageDialog(null," Father name is required");
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null,"DOB is required");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Email is required");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Address is required");
            }
            else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City is required");
            }
            else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"State is required");
            }
            else if(pincode.equals(""))
            {
                JOptionPane.showMessageDialog(null,"PIncode is required");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fathername+"','"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";              
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
        
    }
    
    public static void main(String[] args)
    {
        new SignupOne();
    }
    
}
