/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author alisu
 */
public class GUI extends JFrame{
    
    
   
 public void showAddGUI() throws IOException {
     Friend<String> f = new Friend();
     f.getBST();
     JButton but1 = new JButton("Add");
    JButton but2 = new JButton("Back");
     
        JPanel p = new JPanel(new SpringLayout());
      
            JLabel l = new JLabel("Name: ",JLabel.TRAILING);
            p.add(l);
            JTextField item1 = new JTextField(10);
            l.setLabelFor(item1);
            p.add(item1);
            
            l = new JLabel("Street: ",JLabel.TRAILING);
            p.add(l);
            JTextField item2 = new JTextField(10);
            l.setLabelFor(item2);
            p.add(item2);
            
            l = new JLabel("Location: ",JLabel.TRAILING);
            p.add(l);
            JTextField item3 = new JTextField(10);
            l.setLabelFor(item3);
            p.add(item3);
          
            l = new JLabel("Phone: ",JLabel.TRAILING);
            
            p.add(l);
            JTextField item4 = new JTextField(10);
            l.setLabelFor(item4);
            p.add(item4);
            
            p.add(but2);
            
            p.add(but1);
            
       
        SpringUtilities.makeCompactGrid(p,
                                        5, 2, //rows, cols
                                        6, 6,    //initX, initY
                                        6, 6);   //xPad, yPad
 
        
        JFrame frame = new JFrame("Add Friend");
       
        frame.setSize(400, 300);
        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(p);
        //Display the window.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
                but2.addActionListener((ActionEvent event) -> {
                frame.dispose();
                });
    
		but1.addActionListener((ActionEvent event) -> {
         try {
             if (!f.getBST().search(item1.getText())) {
                 
                 try (PrintWriter adder = new PrintWriter(new FileOutputStream("Friends.txt", true))) {
                     adder.print(item1.getText());
                     f.getBST().insert(item1.getText());
                     adder.print(",");
                     adder.print(item2.getText());
                     adder.print(",");
                     adder.print(item3.getText());
                     adder.print(",");
                     adder.print(item4.getText());
                     adder.print(",");
                     adder.println("null");
                     adder.close();
                     
                     JOptionPane.showMessageDialog(null, "Record Added!");
                     JOptionPane.getRootFrame();
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(BST.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                 }}else if (f.getBST().search(item1.getText())) {
                 JOptionPane.showMessageDialog(null, "Friend name already exists");
             }
         } catch (IOException ex) {
             Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
         }
                });
	
                
}
 
 
 public void showSearchGUI() throws IOException {
     
           Friend<String> f = new Friend();
           f.getBST();
    
     JButton but1 = new JButton("Search");
    JButton but2 = new JButton("Back");
     
        JPanel p = new JPanel(new SpringLayout());
      
            JLabel l = new JLabel("Enter name: ",JLabel.TRAILING);
            p.add(l);
            JTextField item5 = new JTextField(10);
            l.setLabelFor(item5);
            p.add(item5);
            
            p.add(but2);
            p.add(but1);
            
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        2, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
 
        //Create and set up the window.
        JFrame frame = new JFrame("Search");
        frame.setSize(400, 300);
        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(p);
        //Display the window.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        but2.addActionListener((ActionEvent event) -> {
                frame.dispose();
                });
        
        
        but1.addActionListener((ActionEvent event) -> {
           boolean matches;
           int g = 0;
           
               try {
                   if (f.getBST().search(item5.getText())) {
                       
                       try {
                           String search = item5.getText();
                           StringBuilder sb = new StringBuilder();
                           sb.append("");
                           sb.append(search);
                           String strI = sb.toString();
                           
                           loop1:
                           for (int j = 0; j < 1; j++) {
                               
                               loop2:
                               for (int i = 0; i < f.readName().size(); i++) {
                                   try {
                                       
                                       matches = f.readName().get(i).toString().matches(strI);
                                       g = i;
                                       if (matches) {
                                           JOptionPane.showMessageDialog(null, "Name: "+f.readName().get(g)+"\nStreet: "+f.readStreet().get(g)+"\nCity: "+f.readCity().get(g)+"\nPhone: "+f.readPhone().get(g));
                                           break loop1;
                                       }
                                   } catch (IOException ex) {
                                       Logger.getLogger(BST.class.getName()).log(Level.SEVERE, null, ex);
                                       
                                       
                                   }
                               }
                               JOptionPane.showMessageDialog(null, search+": Does not exist in records!");
                           }
                           
                       } catch (IOException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }else if (!f.getBST().search(item5.getText()))
                       JOptionPane.showMessageDialog(null, item5.getText()+": Does not exist in records!");
               } catch (IOException ex) {
                   Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
               }
          
        });
        
 }
 
 
 
 public void showAllGUI() throws IOException{
     
    Friend f = new Friend();
    
     for (int i = 0; i < f.readFriend().size(); i++) {
         JOptionPane.showMessageDialog(null, "Name: "+f.readName().get(i)+"\nStreet: "+f.readStreet().get(i)+"\nCity: "+f.readCity().get(i)+"\nPhone: "+f.readPhone().get(i)); 
     }
     if (f.readFriend().isEmpty()) {
         JOptionPane.showMessageDialog(null, "Friends Record is Empty!"); 
     }
 }
 
 
 
 public void deleteGUI() throws IOException{
  
     
           Friend f = new Friend();
     f.getBST();
     JButton but1 = new JButton("Delete");
    JButton but2 = new JButton("Back");
     
        JPanel p = new JPanel(new SpringLayout());
      
            JLabel l = new JLabel("Enter name: ",JLabel.TRAILING);
            p.add(l);
            JTextField item6 = new JTextField(10);
            l.setLabelFor(item6);
            p.add(item6);
            
            p.add(but2);
            p.add(but1);
            
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        2, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        6, 6);       //xPad, yPad
 
        //Create and set up the window.
        JFrame frame = new JFrame("Delete Record");
        frame.setSize(400, 300);
        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(p);
        //Display the window.
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        but2.addActionListener((ActionEvent event) -> {
                frame.dispose();
                });
        
        
        but1.addActionListener((ActionEvent event) -> {
            
               try {
                   boolean matches;
                   int g;
                   if (f.getBST().search(item6.getText())) {
                       
                       
                       try {
                           String search = item6.getText();
                           StringBuilder sb = new StringBuilder();
                           sb.append("");
                           sb.append(search);
                           String strI = sb.toString();
                           
                           loop1:
                           for (int j = 0; j < 1; j++) {
                               
                               loop2:
                               for (int i = 0; i < f.readName().size(); i++) {
                                   try {
                                       
                                       matches = f.readName().get(i).toString().matches(strI);
                                       g = i;
                                       if (matches) {
                                           String re = f.readFriend().get(g).toString();
                                           f.readFriend().remove(g);
                                           BufferedWriter writer = null;
                                           try {
                                               f.getBST().delete(item6.getText());
                                               JOptionPane.showMessageDialog(null, item6.getText()+": Record was Deleted.");
                                               File inputFile = new File("Friends.txt");
                                               File tempFile = new File("FirendsTemp.txt");
                                               
                                               BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                               
                                               writer = new BufferedWriter(new FileWriter(tempFile));
                                               String lineToRemove = re;
                                               String currentLine;
                                               while((currentLine = reader.readLine()) != null) {
                                                   // trim newline when comparing with lineToRemove
                                                   String trimmedLine = currentLine.trim();
                                                   if(trimmedLine.equals(lineToRemove)) continue;
                                                   writer.write(currentLine + System.getProperty("line.separator"));
                                               }    writer.close();
                                               reader.close();
                                               inputFile.delete();
                                               boolean successful = tempFile.renameTo(inputFile);
                                           } catch (IOException ex) {
                                               Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                           } finally {
                                               try {
                                                   writer.close();
                                               } catch (IOException ex) {
                                                   Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                               }
                                           }
                                           break loop1;
                                       }
                                   } catch (IOException ex) {
                                       Logger.getLogger(BST.class.getName()).log(Level.SEVERE, null, ex);
                                       
                                       
                                   }
                               }
                               JOptionPane.showMessageDialog(null, search+": Does not exist in records!");
                           }
                           
                       } catch (IOException ex) {
                           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
                   else
                       JOptionPane.showMessageDialog(null, item6.getText()+": Does not exist in records!");
               } catch (IOException ex) {
                   Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
               }
                       
                 
             });
 }
 
 
 public void clearAll() throws FileNotFoundException, IOException{
 
           Friend f = new Friend();
           f.getBST();
           PrintWriter writer = new PrintWriter("Friends.txt");
           writer.print("");
           writer.close();
     JOptionPane.showMessageDialog(null, "All Friends records was Deleted.");
     f.getBST().postorder();
 }
 
}