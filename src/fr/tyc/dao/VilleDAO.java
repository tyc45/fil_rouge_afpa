/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.util.ArrayList;
import java.sql.*;
import fr.tyc.jobs.*;


/**
 *
 * @author 59013-52-14
 */
public class VilleDAO {
        private Connect connection;
        private ResultSet rs;
        
        
        
        public ArrayList<Ville> getGites()
        {
            ArrayList<Ville> list = new ArrayList<>();
            
            try
            {
                Statement stm = connection.getInstance().getConnection().createStatement();
                String str = "SELECT V.CODE_INSEE, NOM_VILLE, LONGITUDE, LATITUDE, "
                        + "V.NUMERO_DEPARTEMENT, (SELECT NOM_DEPARTEMENT "
                        + "FROM Departement WHERE V.NUMERO_DEPARTEMENT = "
                        + "Departement.NUMERO_DEPARTEMENT), ID_GITE, NOM_GITE "
                        + "FROM Ville AS V JOIN Gites_Campagnards ON "
                        + "V.CODE_INSEE=Gites_Campagnards.CODE_INSEE AND "
                        + "V.NUMERO_DEPARTEMENT=Gites_Campagnards.NUMERO_DEPARTEMENT "
                        + "ORDER BY V.NUMERO_DEPARTEMENT, V.CODE_INSEE";
                rs = stm.executeQuery(str);
                
                while(rs.next())
                {
                    list.add(new Ville(rs.getString(1), rs.getString(2), 
                            rs.getFloat(3), rs.getFloat(4),
                            new Departement(rs.getString(5), rs.getString(6))));
                }
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return list;
        }
        
        
        
        public ArrayList<Ville> getAll()
        {
            ArrayList<Ville> list = new ArrayList();
            
            try
            {
                Statement stm = connection.getInstance().getConnection().createStatement();
                String str = "SELECT CODE_INSEE, NUMERO_DEPARTEMENT, NOM_VILLE, LONGITUDE, "
                        + "LATITUDE, (SELECT NOM_DEPARTEMENT FROM Departement "
                        + "WHERE V.NUMERO_DEPARTEMENT = Departement.NUMERO_DEPARTEMENT) "
                        + "FROM Ville AS V";
                rs = stm.executeQuery(str);
                
                while(rs.next())
                {
                    list.add(new Ville(rs.getString(1), rs.getString(3), rs.getFloat(4),
                    rs.getFloat(5), new Departement(rs.getString(2), rs.getString(6))));
                }
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return list;
        }
        
        
        
        public ArrayList<String> getNom()
        {
            ArrayList<String> list = new ArrayList<>();
            
            try
            {
                Statement stm = connection.getInstance().getConnection().createStatement();
                String str = "SELECT NOM_VILLE FROM VILLE";
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
            return list;
        }
        
        
        
        public ArrayList<String> getNom(String param, boolean region)
        {
            ArrayList<String> list = new ArrayList<>();
            
            try
            {
                Statement stm = connection.getInstance().getConnection().createStatement();
                String str;
                
                if(region == false) str = "SELECT NOM_VILLE FROM Ville AS V JOIN Departement AS D ON V.NUMERO_DEPARTEMENT = D.NUMERO_DEPARTEMENT WHERE NOM_DEPARTEMENT LIKE '"+param+"'";
                else str = "SELECT NOM_VILLE FROM Ville AS V JOIN Region AS R ON V.ID_REGION = R.ID_REGION WHERE NOM_REGION LIKE '"+param+"'";
                
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
            return list;
        }
}