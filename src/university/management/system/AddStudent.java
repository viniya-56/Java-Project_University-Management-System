package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;   //importing package to add the calender
import  java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfaadhar, tfx, tfxii;
    JLabel labelrollno;
    JDateChooser dcdob;  //to add the calender - date chooser
    JComboBox cbcourse, cbbranch;  //to add drop down
    JButton submit, cancel;
    
    Random ran = new Random();
    //first 4 are same and last 4 digits are created randomly
    long last4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
                            //it will give the value from 0 to 1, hence then 1000 is added
    //it may give the -ve values also from 0 to 1 hence, abs is used to ensure that only positive values will be taken
    AddStudent(){
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setForeground(Color.red);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        //to add name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 500, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(420, 150, 500, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(620, 150, 150, 30);
        add(tffname);
        
        //roll no. will be autogenerated
        JLabel lblrollno = new JLabel("Roll no. ");
        lblrollno.setBounds(50, 205, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
                
        //this is JLabel as we want label and not the textfield to enter any value
        labelrollno = new JLabel("1533" + last4);
        labelrollno.setBounds(200, 205, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);   
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(420, 205, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        //to add calender we have add the java package 
        dcdob = new JDateChooser(); //object of class dcdob: date chooser date of birth
        dcdob.setBounds(620, 205, 150, 30);
        add(dcdob);
        
        //to add Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 260, 500, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 260, 150, 30);
        add(tfaddress);
        
        //to add Phone number
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(420, 260, 500, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(620, 260, 150, 30);
        add(tfphone);
        
        //to add email ID
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50, 315, 500, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 315, 150, 30);
        add(tfemail);
        
        //Aadhar number
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(420, 315, 500, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(620, 315, 150, 30);
        add(tfaadhar);
        
        //Class 10th percentage
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(50, 370, 500, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(200, 370, 150, 30);
        add(tfx);
        
        //Class 12th percentage
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(420, 370, 500, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(620, 370, 150, 30);
        add(tfxii);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 425, 500, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        //to add the drop down list, JComboBox class is used
        String course[] = {"Select","B.Tech", "BBA", "BCA", "B.Sc","BA", "M.Sc", "MBA", "MCA", "M.Com"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 425, 150, 30);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(420, 425, 500, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        //to add the drop down list, JComboBox class is used
        String branch[] = {"Select","Computer Science", "Electronics", "Electrical", "Mechanical","Civil", "Industrial", "Data Science", "Cyber Security", "AIML"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(620, 425, 150, 30);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 540, 140, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 540, 140, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //Get the values to store after submit is clicked
        //getText is used to get the value
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText(); //to get the value of date from calender
                                //1st it is typecasted to JTextField and getText is used to get the value
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String course = (String)cbcourse.getSelectedItem(); //normally it will give object, hence typecasted to string
            String branch = (String)cbbranch.getSelectedItem();
            
            try{
                String query = "insert into student values('"+name+"', '"+fname+"', '"+rollno+"','"+dob+"', '"+address+"', '"+phone+"','"+email+"', '"+aadhar+"', '"+x+"', '"+xii+"', '"+course+"', '"+branch+"')";                      
                        //'' - single inverted comma is used as the datatype of variable is varchar
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);              
                        
            } catch (Exception e){
                e.printStackTrace();            
            }
        } else{
            //cancel button is pressed, close the window
            setVisible(false);
        }
    }  
    
    public static void main(String[] args){
        new AddStudent();
    }
}
