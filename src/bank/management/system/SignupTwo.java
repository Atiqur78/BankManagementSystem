
package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SignupTwo extends JFrame implements ActionListener{
     
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income,Occupation, Qualification;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application - Page no. 2");
       
        
        JLabel personDetails = new JLabel("Page 2: Additional Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        
        JLabel labelReligion = new JLabel("Religion: ");
        labelReligion.setFont(new Font("Raleway",Font.BOLD,20));
        labelReligion.setBounds(100,140,100,40);
        add(labelReligion);
        
        String valReligion[]={"Hindu", "Islam","Sikh","Christans","Others"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Raleway", Font.BOLD,22));
        religion.setBounds(280,140,300,40);
        add(religion);
        
        JLabel labelCategory = new JLabel("Category: ");
        labelCategory.setFont(new Font("Raleway",Font.BOLD,20));
        labelCategory.setBounds(100,190,200,40);
        add(labelCategory);
        
        String valCategory[]= {"General","OBC","SC","ST","Others"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway", Font.BOLD,22));
        category.setBounds(280,190,300,40);
        add(category);
      
        JLabel labelIncome = new JLabel("Income: ");
        labelIncome.setFont(new Font("Raleway",Font.BOLD,20));
        labelIncome.setBounds(100,240,200,40);
        add(labelIncome);
        
        String valIncome[]= {"less than 2 lakh","2 to 5 lakh","more than 5 lakh"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Raleway", Font.BOLD,22));
        income.setBounds(280,240,300,40);
        add(income);
       
        
        JLabel labelQualification = new JLabel("Qualification: ");
        labelQualification.setFont(new Font("Raleway",Font.BOLD,20));
        labelQualification.setBounds(100,290,200,40);
        add(labelQualification);
        
        String valQualification[]= {"10th","HSC","Undergraduate","Post Graduate","PHD"};
        Qualification = new JComboBox(valQualification);
        Qualification.setFont(new Font("Raleway", Font.BOLD,22));
        Qualification.setBounds(280,290,300,40);
        add(Qualification);
        
        
        JLabel labelOccupation = new JLabel("Occupation: ");
        labelOccupation.setFont(new Font("Raleway",Font.BOLD,20));
        labelOccupation.setBounds(100,340,200,40);
        add(labelOccupation);
        
        String valOccupation[]= {"Salaried","Self Employed","Student"};
        Occupation = new JComboBox(valOccupation);
        Occupation.setFont(new Font("Raleway", Font.BOLD,22));
        Occupation.setBounds(280,340,300,40);
        add(Occupation);
        
        JLabel labelPan = new JLabel("PAN Number: ");
        labelPan.setFont(new Font("Raleway",Font.BOLD,20));
        labelPan.setBounds(100,390,200,40);
        add(labelPan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        panTextField.setBounds(280,390,300,40);
        add(panTextField);
        
        
        JLabel labelAadhar = new JLabel("Aadhar Number: ");
        labelAadhar.setFont(new Font("Raleway",Font.BOLD,20));
        labelAadhar.setBounds(100,440,200,40);
        add(labelAadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,20));
        aadharTextField.setBounds(280,440,300,40);
        add(aadharTextField);
        
        JLabel labelSenior = new JLabel("Senior Citizen: ");
        labelSenior.setFont(new Font("Raleway",Font.BOLD,20));
        labelSenior.setBounds(100,490,200,40);
        add(labelSenior);
        
        syes = new JRadioButton("YES");
        syes.setBounds(280,490,120,40);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(430,490,120,40);
        add(sno);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
    
        
        JLabel LabelExistingAccount = new JLabel("Existing Account:");
        LabelExistingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        LabelExistingAccount.setBounds(100,540,200,40);
        add(LabelExistingAccount);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(280,540,120,40);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(430,540,120,40);
        add(eno);
        
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);
        
        
        
        
        
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
        
        String sreligion  = (String)religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();  
        String soccupation =(String) Occupation.getSelectedItem();
        String squalification = (String) Qualification.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        
        
        String seniorCitizen =null;
        if(syes.isSelected())
        {
            seniorCitizen ="YES";
        }
        else
        {
            seniorCitizen ="NO";
        }
        
        String existingAccount = null;
        if(eyes.isSelected())
        {
            existingAccount ="YES";
        }
        else if(eno.isSelected())
        {
            existingAccount = "NO";
        }
        
        
        
        try
        {
            if(pan.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pan is required");
            }
            else if(aadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null," Aadhar number is required");
            }
            else if(seniorCitizen.equals(""))
            {
                JOptionPane.showMessageDialog(null,"This  is required");
            }
            else if(existingAccount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"This is required");
            }
            
            else
            {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"','"+sincome+"', '"+soccupation+"', '"+squalification+"', '"+pan+"', '"+aadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";              
                c.s.executeUpdate(query);
                
                setVisible(false);
                new signupThree(formno).setVisible(true);
                
            }
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
        
    }
    
    public static void main(String[] args)
    {
        new SignupTwo("");
    }
    
}
