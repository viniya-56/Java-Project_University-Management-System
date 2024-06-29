package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbbranch, cbcourse, cbsemester;
    JLabel labelTotal;
    JButton update, pay, back;
    
    StudentFeeForm(){
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 60, 500, 300);
        add(image);
        
        JLabel lblrollno = new JLabel("Select Roll No.");
        lblrollno.setBounds(40, 60, 140, 20);
        lblrollno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                crollno.add(rs.getString("rollno"));    //all the values from "rollno" column will get added to the dropdown crollno
            }       
        }   catch(Exception e){
            e.printStackTrace();
        }  
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(200, 100, 150, 20);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelName);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        JLabel labelfName = new JLabel();
        labelfName.setBounds(200, 140, 150, 20);
        labelfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfName);
        
        try{
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){   //to check whether the data is present or not
                labelName.setText(rs.getString("name"));
                labelfName.setText(rs.getString("fname"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
            
                    while(rs.next()){   //to check whether the data is present or not
                        labelName.setText(rs.getString("name"));
                        labelfName.setText(rs.getString("fname"));
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }           
            }      
        });
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        //to add the drop down list, JComboBox class is used
        String course[] = {"BTech", "BSc", "BCA","MTech", "MSc", "MCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 180, 150, 20);
        cbcourse.setBackground(Color.white);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblbranch);
        
        //to add the drop down list, JComboBox class is used
        String branch[] = {"Computer Science", "Electronics", "Electrical", "Mechanical","Civil", "Industrial", "Data Science", "Cyber Security", "AIML"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 220, 150, 20);
        cbbranch.setBackground(Color.white);
        add(cbbranch);
  
        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblsemester);
        
        String semester[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 260, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labelTotal = new JLabel();
        labelTotal.setBounds(200, 300, 150, 20);
        labelTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelTotal);
        
        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        
        
        setVisible(true);
    }
            
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String course = (String)cbcourse.getSelectedItem();    //cbcourse is object and cannot be stored in String, hence typecasting is required
            String semester = (String)cbsemester.getSelectedItem();
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                
                while(rs.next()){
                    labelTotal.setText(rs.getString(semester));
                }
            
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String)cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String total = labelTotal.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"College Fee Paid successfully!");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
        
        
    }
    public static void main(String[] args){
        new StudentFeeForm();
    }
}
