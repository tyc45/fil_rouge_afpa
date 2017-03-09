/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.jobs;

import java.util.ArrayList;

/**
 *
 * @author 59013-52-14
 */
public class Ville {
    private String insee, nom, numDepartement, fullInsee;
    private float longitude, latitude;
    private Departement departement;
    private ArrayList<Gite> gites;
    
    
    
    public Ville()
    {
        gites = new ArrayList<>();
    }
    
    
    
    public Ville(String insee, String numDepartement, String nom)
    {
        this.insee = insee;
        this.numDepartement = numDepartement;
        fullInsee = numDepartement+insee;
        this.nom = nom;
        gites = new ArrayList<>();
    }
    
    
    
    public Ville(String insee, String nom, Departement departement)
    {
        this.insee = insee;
        this.numDepartement = departement.getNumDepartement();
        fullInsee = insee+numDepartement;
        this.nom = nom;
        this.departement = departement;
        gites = new ArrayList<>();
    }
    
    
    
    public Ville(String insee, String nom, 
            Float longitude, Float latitude, Departement departement)
    {
        this.insee = insee;
        this.numDepartement = departement.getNumDepartement();
        this.departement = departement;
        this.longitude = longitude;
        this.latitude = latitude;
        fullInsee = numDepartement+insee;
    }
    
    
    
    public String getInsee()
    {
        return insee;
    }
    
    
    
    public String getNumDepartement()
    {
        return numDepartement;
    }
    
    
    
    public String getFullInsee()
    {
        return fullInsee;
    }
    
    
    
    public String getNom()
    {
        return nom;
    }
    
    
    
    public float getLongitude()
    {
        return longitude;
    }
    
    
    
    public float getLatitude()
    {
        return latitude;
    }
    
    
    
    public Departement getDepartement()
    {
        return departement;
    }
    
    
    
    public ArrayList<Gite> getGites()
    {
        return gites;
    }
    
    
    
    public boolean setInsee(String insee)
    {
        if(insee.length() == 3)
        {
            this.insee = insee;
            return true;
        }
        else return false;
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    
    
    public void setLongitude(float longitude)
    {
        this.longitude = longitude;
    }
    
    
    
    public void setLatitude(float latitude)
    {
        this.latitude = latitude;
    }
    
    
    
    public void setDepartement(Departement departement)
    {
        this.departement = departement;
    }
    
    
    
    public void setDepartement(String nom, String id, Region region)
    {
        this.departement = new Departement(id, nom, region);
    }
    
    
    
    public void setGites(ArrayList<Gite> gites)
    {
        this.gites = gites;
    }
    
    
    
    public void addGite(Gite gite)
    {
        gites.add(gite);
    }
    
    
    
    @Override
    public String toString()
    {
        return insee+"||"+nom+"||"+departement.getNom();
    }
}
