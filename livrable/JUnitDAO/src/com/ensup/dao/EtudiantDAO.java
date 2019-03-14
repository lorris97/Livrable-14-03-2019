/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensup.dao;

import com.ensup.bo.EtudiantBO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorris
 */
public class EtudiantDAO {
    
    
    public EtudiantBO listbyID(Statement statement) 
    {
        ResultSet res = null; 
        EtudiantBO bo = new EtudiantBO();
        
        try {
            res = statement.executeQuery("SELECT * FROM `etudiant` WHERE id = 1");
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
        try {
            
            while (res.next()) {
                
                bo.setId(Integer.parseInt(res.getString("id")));
                bo.setNom(res.getString("nom"));
                bo.setPrenom(res.getString("prenom"));
                bo.setMail(res.getString("mail"));
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bo;
    

    }
    public ArrayList<EtudiantBO> listall(Statement statement) 
    {
        ResultSet res = null; 
        ArrayList<EtudiantBO> List = new ArrayList<EtudiantBO>();
        
        try {
            res = statement.executeQuery("SELECT * FROM `etudiant` ");
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
        try {
            while (res.next()) {
                EtudiantBO bo = new EtudiantBO();
                bo.setId(Integer.parseInt(res.getString("id")));
                bo.setNom(res.getString("nom"));
                bo.setPrenom(res.getString("prenom"));
                bo.setMail(res.getString("mail"));
                
                List.add(bo);
                
            }   } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return List;
    

    }
     public void InsertEtudiant(EtudiantBO b, Statement stm)  {
        
        try {
            stm.executeUpdate("INSERT INTO etudiant(`id`,`nom`, `prenom`, `mail`) VALUES ( "+b.getId() +",'"+ b.getNom()+ "','" + b.getPrenom()+ "','" + b.getMail()+ "');");
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}