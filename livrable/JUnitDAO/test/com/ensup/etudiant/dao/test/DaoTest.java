package com.ensup.etudiant.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ensup.bo.EtudiantBO;
import com.ensup.connection.Connection;
import com.ensup.dao.EtudiantDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lorris
 */
public class DaoTest {

    private static Statement statement = null;

    @BeforeClass
    public static void setUpMethod() throws Exception {

        Connection conn = new Connection();
        statement = conn.Connection();

        System.out.println("La connexion a bien été établie");

    }

    @Test
    public void ConnexionTest() throws Exception {

        assertNotNull(statement); // VERRIFIE QUE LA CONNEXION N'EST PAS NULL

    }

    @Test
    public void readTest() {

        EtudiantBO bo = new EtudiantBO();
        EtudiantDAO dao = new EtudiantDAO();
        bo = dao.listbyID(statement);

        assertNotNull(bo); // VERRIFIE QUE LA LISTE N'EST PAS NULL

        assertNotNull(bo.getId());     // VERRIFIE QUE L'ID N'EST PAS NULL
        assertNotNull(bo.getNom());    // VERRIFIE QUE LE NOM N'EST PAS NULL
        assertNotNull(bo.getPrenom()); // VERRIFIE QUE LE PRENOM N'EST PAS NULL
        assertNotNull(bo.getMail());   // VERRIFIE QUE LE MAIL N'EST PAS NULL

    }

    @Test
    public void verrifInfoTest() {

       EtudiantBO bo = new EtudiantBO();
        EtudiantDAO dao = new EtudiantDAO();
        bo = dao.listbyID(statement);

        assertEquals(1, bo.getId());   // VERRIFIE QUE LES VALEURS RECUS SONT BIEN CELLES CORRESPONDANTES AUX VALEURS RENTREES EN BRUT
        assertEquals("guillemot", bo.getNom()); // VERRIFIE QUE LES VALEURS RECUS SONT BIEN CELLES CORRESPONDANTES AUX VALEURS RENTREES EN BRUT
        assertEquals("lorris", bo.getPrenom()); // VERRIFIE QUE LES VALEURS RECUS SONT BIEN CELLES CORRESPONDANTES AUX VALEURS RENTREES EN BRUT
        assertEquals("lorris97@hotmail.fr", bo.getMail());  // VERRIFIE QUE LES VALEURS RECUS SONT BIEN CELLES CORRESPONDANTES AUX VALEURS RENTREES EN BRUT

    }
    
    @Test 
    public void verriferInserTest()
    {
        ArrayList<EtudiantBO> List = new ArrayList<>();
        EtudiantDAO dao = new EtudiantDAO();
        
        
        EtudiantBO etu = new EtudiantBO();
        etu.setPrenom("test");
        etu.setNom("test");
        etu.setMail("test");
        etu.setId(2);
             
        dao.InsertEtudiant(etu, statement);
        List = dao.listall(statement);
        assertEquals(List.get(1).getId(),2);
        
    }
    @Test 
    public void getAllTest()
    {
         ArrayList<EtudiantBO> List = new ArrayList<>();
        EtudiantDAO dao = new EtudiantDAO();
        List = dao.listall(statement);
        assertEquals(List.size(),2);
    }

}
