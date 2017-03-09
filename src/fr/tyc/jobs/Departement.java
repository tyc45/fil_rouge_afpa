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
public class Departement {
    private String numDepartement;
    private Region region;
    private String nom;
    private ArrayList<Ville> listVilles;
    
    
    
    public Departement()
    {
        listVilles = new ArrayList<>();
    }
    
    
    
    public Departement(String numDepartement, String nom)
    {
        this.numDepartement = numDepartement;
        this.nom = nom;
        listVilles = new ArrayList<>();
    }
    
    
    
    public Departement(String numDepartement, String nom, Region region)
    {
        this.numDepartement = numDepartement;
        this.region = region;
        this.nom = nom;
        listVilles = new ArrayList<>();
    }
    
    
    
    public String getNumDepartement()
    {
        return numDepartement;
    }
    
    
    
    public Region getRegion()
    {
        return region;
    }
    
    
    
    public String getNom()
    {
        return nom;
    }
    
    
    
    public ArrayList<Ville> getVilles()
    {
        return listVilles;
    }
    
    
    
    public void setNumDepartement(String id)
    {
        this.numDepartement = id;
    }
    
    
    
    public void setRegion(Region region)
    {
        this.region = region;
    }
    
    
    
    public void setRegion(int id, String nom)
    {
        this.region = new Region(id, nom);
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    
    
    public void setVilles(ArrayList<Ville> listVilles)
    {
        this.listVilles = listVilles;
    }
    
    
    
    public void addVilles(Ville ville)
    {
        listVilles.add(ville);
    }
    
    
    
    @Override
    public String toString()
    {
        return numDepartement+"||"+nom+"||"+region.getId();
    }
}
