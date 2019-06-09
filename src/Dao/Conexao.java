/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    public Connection getConnection() {
        // tentando ronaldo foi12
	     try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	         return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/costu?useTimezone=true&serverTimezone=UTC", "root", "123456");
                 
	     } catch (Exception e) {
                 System.out.println("no foi");
                 System.out.println("Model.Conexao.getConnection()"+e.getMessage());
	         //throw new RuntimeException(e);
	     }
        return null;
	 }
}
