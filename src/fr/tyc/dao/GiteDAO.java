/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import fr.tyc.jobs.*;
import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.Outils;

/**
 *
 * @author 59013-52-14
 */
public class GiteDAO {
    private static Connect connection;
    private static ResultSet rs;
    
    
    
    public static ObservableList<Gite> getAll()
    {
        ArrayList<Gite> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT ID_GITE, NOM_GITE, SURFACE, NOMBRE_CHAMBRES, NOMBRE_COUCHAGES,"
                    + "PRIX_ANIMAUX, NUMERO_VOIRIE, COMPLEMENT_NUMERO_VOIRIE,"
                    + "NOM_VOIRIE, COMPLEMENT_ADRESSE, CODE_POSTAL, ID_INDIVIDU,"
                    + "CODE_INSEE, NUMERO_DEPARTEMENT,"
                    + "(SELECT NOM_VILLE FROM VILLE WHERE CONCAT(G.CODE_INSEE, G.NUMERO_DEPARTEMENT)"
                    + "= CONCAT(Ville.CODE_INSEE, Ville.NUMERO_DEPARTEMENT))"
                    + "FROM Gites_Campagnards AS G";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Gite(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13),
                rs.getString(14), rs.getString(15)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(list);
    }
    
    
    
    public static ObservableList<Gite> getLike(int cp, String ville, 
            String nomDepartement, String nomRegion)
    {
        ArrayList<Gite> list = new ArrayList<>();
        ville = Outils.doubleQuotes(ville);
        nomDepartement = Outils.doubleQuotes(nomDepartement);
        nomRegion = Outils.doubleQuotes(nomRegion);
        
        try
        {
            Statement stm = Connect.getInstance().getConnection().createStatement();
            String str = "exec dbo.sp_lst_giteLike '',"+cp+",'"+ville+"',0,-1,'"+nomDepartement+"','"+nomRegion+"'";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Gite(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13),
                rs.getString(14), rs.getString(15)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(list);
    }
}