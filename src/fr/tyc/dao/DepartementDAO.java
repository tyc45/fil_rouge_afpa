/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.tyc.jobs.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.Outils;
/**
 *
 * @author 59013-52-14
 */
public class DepartementDAO {
    private Connect connection;
    private ResultSet rs;
    private int mabite;
    
    
    
    public ArrayList<Departement> getAll()
    {
        ArrayList<Departement> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT D.NUMERO_DEPARTEMENT, NOM_DEPARTEMENT, ID_REGION, "
                    + "(SELECT NOM_REGION FROM Region WHERE ID_REGION = D.ID_REGION)"
                    + ", CODE_INSEE, NOM_VILLE FROM Departement as D JOIN Ville "
                    + "ON D.NUMERO_DEPARTEMENT=Ville.NUMERO_DEPARTEMENT "
                    + "ORDER BY NUMERO_DEPARTEMENT, CODE_INSEE";
            rs = stm.executeQuery(str);
            Departement departementLu = new Departement("", "");
            
            while(rs.next())
            {
                if(departementLu.getNumDepartement() != rs.getString(1))
                {
                    departementLu = new Departement(rs.getString(1), rs.getString(2), new Region(rs.getInt(3), rs.getString(4)));
                    list.add(departementLu);
                }
                departementLu.getVilles().add(new Ville(rs.getString(5), rs.getString(6), departementLu));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public ObservableList<String> getNom()
    {
        ArrayList<String> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT NOM_DEPARTEMENT FROM Departement ORDER BY NOM_DEPARTEMENT";
            rs = stm.executeQuery(str);
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(list);
    }
    
    
    
    public ObservableList<String> getNom(String filter)
    {
        ArrayList<String> list = new ArrayList<>();
        filter = Outils.doubleQuotes(filter);
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT NOM_DEPARTEMENT FROM Departement AS D "
                    + "Join Region AS R ON D.ID_REGION = R.ID_REGION "
                    + "WHERE NOM_REGION LIKE '%"+filter+"%' GROUP BY NOM_DEPARTEMENT ORDER BY NOM_DEPARTEMENT";
            rs = stm.executeQuery(str);
            while(rs.next())
            {
                list.add(rs.getString(1));
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
