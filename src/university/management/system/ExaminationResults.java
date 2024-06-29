package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ExaminationResults extends JFrame implements ActionListener{
    JTextField search;
    String name;
    JButton result, cancel;
    JTable table;
    
    ExaminationResults(){
        setSize(1000, 600);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
               
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);
        
        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        result.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(result);
        
        cancel = new JButton("Back");
        cancel.setBounds(450, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 140, 1000, 500);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch(Exception e){
            e.printStackTrace();        
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString()); //to get the value of the roll no as clicked by the mouse or the pointer in the table
                            //the roll no is selected from the "row" and column with index 2 
                name = table.getModel().getValueAt(row, 0).toString();
            }
        }
        );    
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == result){
            setVisible(false);
            new Marks(search.getText(), name);       //open the next frame    
        
        } else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new ExaminationResults();
    }
}