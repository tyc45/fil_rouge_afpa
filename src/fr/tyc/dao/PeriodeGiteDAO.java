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
public class PeriodeGiteDAO {
    private Connect connection;
    private ResultSet rs;
    
    
    
    public ArrayList<PeriodeGite> getLike(int idGite)
    {
        ArrayList<PeriodeGite> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT ID_PERIODE, ANNEE, SEMAINE_DEBUT, SEMAINE_FIN, "
                    + "Periode.NOM_SAISON, TARIF, Periode.ID_GITE FROM Periode "
                    + "JOIN Tarif_Gite ON Periode.NOM_SAISON = Tarif_Gite.NOM_SAISON "
                    + "AND Periode.ID_GITE = Tarif_Gite.ID_GITE "
                    + "WHERE Tarif_gite.ID_GITE = "+idGite+" ORDER BY ID_GITE";
            rs = stm.executeQuery(str);
            while(rs.next())
            {
                list.add(new PeriodeGite(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                rs.getString(5), rs.getInt(6), new Gite(rs.getInt(7))));
            }
            rs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public ArrayList<PeriodeGite> getAll()
    {
        ArrayList<PeriodeGite> list = new ArrayList<>();
        
        try
        {
            Statement stm = connection.getInstance().getConnection().createStatement();
            String str = "SELECT ID_PERIODE, ANNEE, SEMAINE_DEBUT, SEMAINE_FIN, "
                    + "P.NOM_SAISON, TARIF, P.ID_GITE FROM Periode AS P"
                    + "JOIN Tarif_Gite AS T ON P.NOM_SAISON = T.NOM_SAISON"
                    + "AND P.ID_GITE = T.ID_GITE ORDER BY ID_GITE";
            rs = stm.executeQuery(str);
            
            while(rs.next())
            {
                list.add(new PeriodeGite(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                rs.getString(5), rs.getInt(6), new Gite(rs.getInt(7))));
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
