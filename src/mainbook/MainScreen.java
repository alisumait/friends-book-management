/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author alisu
 */
public class MainScreen extends JFrame{
    JButton addB,searchB,deleteB,showB,clearB,Exit;
    GUI b = new GUI();
    
    public MainScreen(){
        
        GridLayout g = new GridLayout(6, 1);
        setLayout(g);
       
        
        
        addB = new JButton("Add Friend");
        searchB = new JButton("Search");
        deleteB = new JButton("Delete Friend");
        showB = new JButton("Show All Friends");
        clearB = new JButton("Clear All Records");
        Exit = new JButton("Exit");
        Dimension d = new Dimension(120, 55);
        addB.setPreferredSize(d);
        searchB.setPreferredSize(d);
        deleteB.setPreferredSize(d);
        showB.setPreferredSize(d);
        clearB.setPreferredSize(d);
        Exit.setPreferredSize(d);
        
        add(addB);
        add(searchB);
        add(deleteB);
        add(showB);
        add(clearB);
        add(Exit);
      
        
        
    addB.addActionListener((ActionEvent e) -> {
        
            try {
                b.showAddGUI();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    
    
    searchB.addActionListener((ActionEvent e) ->{
       
            try {
                b.showSearchGUI();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    });
    
    
    deleteB.addActionListener((ActionEvent e) ->{
    
            try {
                b.deleteGUI();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    });
    
    
    showB.addActionListener((ActionEvent e) ->{
    
            try {
                b.showAllGUI();
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
    
    clearB.addActionListener((ActionEvent e) ->{
    
            try {
                b.clearAll();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
    
    
    
    Exit.addActionListener((ActionEvent e) ->{
        System.exit(0);
    });
    
    }
    
    
}
