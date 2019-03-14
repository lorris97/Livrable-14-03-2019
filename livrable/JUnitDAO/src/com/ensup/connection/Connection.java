/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensup.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorris
 */
public class Connection {
    
    
    private static Statement statement = null;

/**
 *
 * Cette methode est présente pour faire la connexion a la base de donnée
 */
    public Statement Connection() throws SQLException, InstantiationException, IllegalAccessException {

        java.sql.Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/etudiant?user=root&password=");
            statement = conn.createStatement();

        } catch (ClassNotFoundException e) {

            System.out.println("Connextion avec la base de données impossible");
        }
        return statement;

    }

    public void Deconnection(java.sql.Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
