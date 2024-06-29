package university.management.system;
import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
        setSize(700, 600);
        setLocation(400, 100);
        getContentPane().setBackground(Color.white);
                
        JLabel heading = new JLabel("<html>University<br/>Management<br/>System</html>");       //br:break row
        heading.setBounds(60, 60, 300, 100);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/about.png"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);           //JLable is used to put anything on the frame
        image.setBounds(350, 20, 300, 200);
        add(image);
        
        
        JLabel info = new JLabel("<html> &nbsp This university management system is a desktop application designed to automate "
                                   + "<br/> various administrative tasks within a university setting. It provides functionalities "
                                   + "<br/> for managing student-teacher information, leave application and details, recording "
                                   + "<br/>and calculating grades, and managing fees.</html>");
        info.setBounds(30, 235, 610, 100);
        info.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(info);
        
        JLabel tech = new JLabel("<html> Technologies used:  </html>");
        tech.setBounds(40, 340, 300, 18);
        tech.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(tech);
        
        JLabel techs = new JLabel("<html> <ul><li>Java (Java Swing, Java AWT)</li><li>MySQL</li></ul> </html>");
        techs.setBounds(50, 360, 400, 50);
        techs.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(techs);
        
        JLabel name = new JLabel("Developed By: Viniya Bhise");       
        name.setBounds(50, 430, 500, 35);
        name.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(name);
        
        JLabel contact = new JLabel("Contact: viniyabhise56@gmail.com");      
        contact.setBounds(50, 470, 300, 30);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(contact);
        
        
        setLayout(null);
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new About();
    }
}
