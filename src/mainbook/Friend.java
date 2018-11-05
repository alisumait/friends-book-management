/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author alisu
 * @param <E>
 */
public class Friend<E>{
    
    
        public BST <String>getBST() throws IOException{
    BST<String> b = new BST();
        Friend<String> f = new Friend();
         for (int i = 0; i < f.readName().size(); i++) {
          b.insert(f.readName().get(i).toString());
        }
        return b;
    }
    
    
    public  <E> ArrayList readFriend() throws IOException{

        ArrayList<String> frs = new ArrayList<>();
     
                 try (Scanner inputStream = new Scanner(new FileInputStream("Friends.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         String street = inputStream.next();
                         String city = inputStream.next();
                         String phone = inputStream.next();
                         
                         String friend = name+","+street+","+city+","+phone+",null";
                      
                         frs.add(friend);
                         inputStream.nextLine();
                     }
                 }
    return frs;
   
    }
    
    public  <E> ArrayList readName() throws IOException{

        ArrayList<String> names = new ArrayList<>();
     
                 try (Scanner inputStream = new Scanner(new FileInputStream("Friends.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         String street = inputStream.next();
                         String city = inputStream.next();
                         String phone = inputStream.next();
                         names.add(name);
                         
                         inputStream.nextLine();
                     }
                 } catch (Exception e){
                    System.out.println(e.getMessage());
            }
    return names;
   
    }
    
        public  <E> ArrayList readStreet() throws IOException{

        ArrayList<String> streets = new ArrayList<>();
     
                 try (Scanner inputStream = new Scanner(new FileInputStream("Friends.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         String street = inputStream.next();
                         String city = inputStream.next();
                         String phone = inputStream.next();
                         streets.add(street);
                         
                         inputStream.nextLine();
                     }
                 } catch (Exception e){
                    System.out.println(e.getMessage());
            }
    return streets;
   
    }
        
            public  <E> ArrayList readCity() throws IOException{

        ArrayList<String> cities = new ArrayList<>();
     
                 try (Scanner inputStream = new Scanner(new FileInputStream("Friends.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         String street = inputStream.next();
                         String city = inputStream.next();
                         String phone = inputStream.next();
                         cities.add(city);
                         
                         inputStream.nextLine();
                     }
                 } catch (Exception e){
                    System.out.println(e.getMessage());
            }
    return cities;
   
    }
            
                public  <E> ArrayList readPhone() throws IOException{

        ArrayList<String> phones = new ArrayList<>();
     
                 try (Scanner inputStream = new Scanner(new FileInputStream("Friends.txt"))) {
                     inputStream.useDelimiter(",");
                     
                     while(inputStream.hasNextLine()){
                         
                         String name = inputStream.next();
                         String street = inputStream.next();
                         String city = inputStream.next();
                         String phone = inputStream.next();
                         phones.add(phone);
                         
                         inputStream.nextLine();
                     }
                 } catch (Exception e){
                    System.out.println(e.getMessage());
            }
    return phones;
   
    }     
                 }

