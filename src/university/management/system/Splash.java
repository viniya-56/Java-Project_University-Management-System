//package name
package university.management.system;

//import libraries
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        //Constructor - automatically called when the object is created
        //Frame coding is written here
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myIcons/first.jpg"));   //imageicon is created
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);         //scaled image
        ImageIcon i3 = new ImageIcon(i2);       //image is again converted to imageicon as we can't pass image object to the class of JLabel
        JLabel image = new JLabel(i3);           //JLable is used to put anything on the frame
        add(image);
        
        t = new Thread(this);
        t.start();      //this start method will internally call the run method
        
        setVisible(true);   //to make the frame visible
        
        // to slowly open the main window
        int x = 1;
        for(int i=2; i<600; i+=4, x+=1){
            setLocation(600-((i+x)/2),350-(i/2));   //to set the location of the frame - x & y
            setSize(i+3*x,i+x/2);       //to set the size of the frame - length and breadth
            
            try{
                Thread.sleep(10);
            } catch(Exception o){}
        }
    }
    public void run(){
        try{
            Thread.sleep(5000); //to create the delay of 5 seconds
            setVisible(false);   //to hide the frame

            //next frame
            new Login();
            // object of login class is created and the constructor will automatically get executed
        } catch(Exception o){
        }
    }
    
    public static void main(String[] args){
        new Splash();   //new Splash object is created (Anonymous - variable is not used)
    }
}


