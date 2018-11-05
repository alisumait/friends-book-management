/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author alisu
 */
public class MainBook {
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
        MainScreen m = new MainScreen();
        Friend f = new Friend();
        f.getBST();
        f.getBST().inorder();
        
        m.setTitle("Friend Book Management System");
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setSize(500, 400);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }
    
}
