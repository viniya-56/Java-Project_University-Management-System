package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE); //to set the background color
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        //setBounds(distance from left, from top, width of label, height of label)
        lblusername.setBounds(40,40,100,20);
        add(lblusername);
        
        //making the input field to get input for username from user
        tfusername = new JTextField();
        tfusername.setBounds(150,40,150,25);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        //setBounds(distance from left, from top, width of label, height of label)
        lblpassword.setBounds(40,90,100,20);
        add(lblpassword);
        
        //making the input field to get input for username from user
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,90,150,25);
        add(tfpassword);
        
        login = new JButton("Login");
        
        login.setBounds(40, 160, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 160, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/login2.png"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(180, 140, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);          //JLable is used to put anything on the frame
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfusername.getText();     //to get the text entered in jtextfields
            String password = tfpassword.getText();
        
            String query = "select * from login where username= '"+username+"' and password= '"+password+"'";   //mysql query
            
            try{
                Conn c = new Conn();  //when we create this object of class Conn, connection will automatically be created
                
                //4th step - Executing MySQL Queries
                ResultSet rs = c.s.executeQuery(query); //to store results obtained after executing the query
                
                if(rs.next()){  //when entered username and password are correct
                    setVisible(false);
                    
                    //open the next frame
                    new Project();
                
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");    //to show the error message if the 
                                                                                   //username or password is incorrect or not in database              
                }
                //5th step - closing the connection (Optional)
                c.s.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            
        } 
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}