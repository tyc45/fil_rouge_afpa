/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.dao;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author 59013-52-14
 */
public class Connect {
    private Connection connection;
    private static Connect instance;
    
    
    
    public Connect()
    {
        try
        {
            SQLServerDataSource ds = new SQLServerDataSource();
            
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("FilRouge");
            ds.setIntegratedSecurity(false);
            ds.setUser("jordan");
            ds.setPassword("megaman");
            
            connection = ds.getConnection();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    public Connection getConnection()
    {
        return connection;
    }
    
    
    
    public static Connect getInstance()
    {
        if(instance == null) instance = new Connect();
        return instance;
    }
}
