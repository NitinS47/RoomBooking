/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author NITIN
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class table {
    public static void main(String args[]){
        Connection con=null;
        Statement st= null;
        try{
        con=ConnectionProvider.getCon();
        st=con.createStatement();
        
       st.executeUpdate("CREATE TABLE users ("
                    + "name VARCHAR(200), "
                    + "regno VARCHAR(200) PRIMARY KEY, "
                    + "password VARCHAR(50)"
                    + ")");

 st.executeUpdate("CREATE TABLE room ("
                    + "roomNo VARCHAR(200) PRIMARY KEY, "
                    + "roomType VARCHAR(200) , "
                    + "status VARCHAR(20)"
                    + ")");

st.executeUpdate("CREATE TABLE customer ("
                    + "id int, "
                    + "name VARCHAR(50) , "
                    + "mobileNumber VARCHAR(20) , "
                    + "class VARCHAR(50), "
                    + "regno VARCHAR(50), "
                    + "date VARCHAR(20), "
                    + "time VARCHAR(50), "
                    + "roomType VARCHAR(50), "
                    + "roomNo VARCHAR(50), "
                    + "availability VARCHAR(50)"
                    + ")");

       st.executeUpdate("CREATE TABLE admins ("
                    + "name VARCHAR(200), "
                    + "adminno VARCHAR(200) PRIMARY KEY, "
                    + "password VARCHAR(50)"
                    + ")");

        JOptionPane.showMessageDialog(null, "table created successfully");
        }
        catch (SQLIntegrityConstraintViolationException e) {
          
            JOptionPane.showMessageDialog(null, "Already registered");
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);}
        finally{
            try{
                con.close();
                st.close();
            }
            catch(Exception e){}
        }
    }
}
