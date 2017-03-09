/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.sql.*;
import fr.tyc.jobs.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import outils.Outils;
/**
 *
 * @author 59013-52-14
 */
public class RegionDAO {
    private Connect connection;
    private ResultSet rs;
    
    
    
    public ArrayList<Region> getAll()
    {
        ArrayList<Region> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT Region.ID_REGION, NOM_REGION, NUMERO_DEPARTEMENT, "
                    + "NOM_DEPARTEMENT FROM Region JOIN Departement "
                    + "on Region.ID_REGION = Departement.ID_REGION "
                    + "ORDER BY ID_REGION, NUMERO_DEPARTEMENT";
            rs = stm.executeQuery(str);
            Region regionLue = new Region(0, "");
            while(rs.next())
            {
                if(regionLue.getId() != rs.getInt(1))
                {
                    regionLue = new Region(rs.getInt(1), rs.getString(2));
                    list.add(regionLue);
                }
                regionLue.getDepartements().add(new Departement(rs.getString(3), rs.getString(4), regionLue));
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
            String str = "SELECT NOM_REGION FROM Region ORDER BY NOM_REGION";
            rs = stm.executeQuery(str);
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
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
            String str = "SELECT NOM_REGION FROM Region AS R JOIN Departement AS D ON R.ID_REGION = D.ID_REGION WHERE NOM_DEPARTEMENT = '"+filter+"' GROUP BY R.NOM_REGION ORDER BY NOM_REGION";
            rs = stm.executeQuery(str);
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(list);
    }
}
