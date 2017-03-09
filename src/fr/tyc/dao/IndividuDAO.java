/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.sql.*;
import java.util.*;
import fr.tyc.jobs.*;

/**
 *
 * @author 59013-52-14
 */
public class IndividuDAO {
    private Connect connection;
    private ResultSet rs;
    
    
    
    public ArrayList<Individu> getAll()
    {
        ArrayList<Individu> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT ID_INDIVIDU, NOM_INDIVIDU, PRENOM_INDIVIDU, "
                    + "ADRESSE_EMAIL, NUMERO_VOIRIE, COMPLEMENT_NUMERO_VOIRIE, "
                    + "NOM_VOIRIE, COMPLEMENT_ADRESSE, Individu.CODE_INSEE, "
                    + "Individu.NUMERO_DEPARTEMENT, NOM_VILLE "
                    + "FROM Individu JOIN Ville "
                    + "ON CONCAT(Individu.CODE_INSEE, Individu.NUMERO_DEPARTEMENT) = "
                    + "CONCAT(Ville.CODE_INSEE, Ville.NUMERO_DEPARTEMENT)";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Individu(rs.getInt(1), rs.getString(2), rs.getString(3), 
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public Individu getContact(int id)
    {
        Individu contact = new Individu();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT ID_INDIVIDU, NOM_INDIVIDU, PRENOM_INDIVIDU, "
                    + "ADRESSE_EMAIL, NUMERO_VOIRIE, COMPLEMENT_NUMERO_VOIRIE, "
                    + "NOM_VOIRIE, COMPLEMENT_ADRESSE, Individu.CODE_INSEE, "
                    + "Individu.NUMERO_DEPARTEMENT, NOM_VILLE, "
                    + "(SELECT NUMERO_TELEPHONE FROM Telephone WHERE "
                    + "Individu.ID_INDIVIDU = Telephone.ID_INDIVIDU), "
                    + "(SELECT ID_TYPE_TELEPHONE FROM Telephone WHERE "
                    + "Individu.ID_INDIVIDU = Telephone.ID_INDIVIDU) "
                    + "FROM Individu JOIN Ville ON CONCAT(Individu.CODE_INSEE, "
                    + "Individu.NUMERO_DEPARTEMENT) = CONCAT(Ville.CODE_INSEE, "
                    + "Ville.NUMERO_DEPARTEMENT) WHERE ID_INDIVIDU = "+id;
            rs = stm.executeQuery(str);
            
            rs.next();
            contact = new Individu(rs.getInt(1), rs.getString(2), rs.getString(3), 
                rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
            contact.setTelephone(new Telephone(rs.getString(12), rs.getString(13), contact));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return contact;
    }
}
