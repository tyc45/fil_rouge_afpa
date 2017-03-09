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
public class DisponibiliteDAO {
    private Connect connection;
    private ResultSet rs;
    
    
    
    public ArrayList<Disponibilite> getLike(int id)
    {
        ArrayList<Disponibilite> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT HEURE_DEBUT, HEURE_FIN, ID_PLAGES_HORAIRES, "
                    + "H.ID_PERIODE_CONTACT, JOUR_DEBUT, JOUR_FIN, "
                    + "H.ID_INDIVIDU FROM Plages_Horaires AS H "
                    + "JOIN Periode_Contact AS P ON H.ID_INDIVIDU = "
                    + "P.ID_INDIVIDU AND H.ID_PERIODE_CONTACT = "
                    + "P.ID_PERIODE_CONTACT = "+id;
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Disponibilite(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public ArrayList<Disponibilite> getAll()
    {
        ArrayList<Disponibilite> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT HEURE_DEBUT, HEURE_FIN, ID_PLAGES_HORAIRES, "
                    + "H.ID_PERIODE_CONTACT, JOUR_DEBUT, JOUR_FIN, "
                    + "H.ID_INDIVIDU FROM Plages_Horaires AS H "
                    + "JOIN Periode_Contact AS P ON H.ID_INDIVIDU = "
                    + "P.ID_INDIVIDU AND H.ID_PERIODE_CONTACT = "
                    + "P.ID_PERIODE_CONTACT";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new Disponibilite(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
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
