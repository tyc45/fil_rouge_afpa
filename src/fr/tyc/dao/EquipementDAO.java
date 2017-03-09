/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.util.*;
import java.sql.*;
import fr.tyc.jobs.*;

/**
 *
 * @author 59013-52-14
 */
public class EquipementDAO {
    private Connect connection;
    private ResultSet rs;
    
    
    
    public ArrayList<Equipement> getLike(int idGite)
    {
        ArrayList<Equipement> list = new ArrayList<>();
        
        try
        {
            Statement stm  = connection.getInstance().getConnection().createStatement();
            String str = "SELECT T.NOM_ES, NOM_TYPE, TARIF, ID_GITE "
                    + "FROM Tarif_Equipement_Service AS T "
                    + "JOIN Equipement_Service ON T.NOM_ES = "
                    + "Equipement_Service.NOM_ES WHERE ID_GITE = "+idGite;
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Equipement(rs.getString(1), rs.getString(2), rs.getInt(3),
                rs.getInt(4)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public ArrayList<Equipement> getAll()
    {
        ArrayList<Equipement> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT NOM_ES, NOM_TYPE FROM Equipement_Service";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Equipement(rs.getString(1), rs.getString(2)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
