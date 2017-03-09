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
public class Region {
    private int id;
    private String nom;
    private ArrayList<Departement> departements;
    
    
    
    public Region()
    {
        departements = new ArrayList<>();
    }
    
    
    
    public Region(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
        departements = new ArrayList<>();
    }
    
    
    
    public int getId()
    {
        return id;
    }
    
    
    
    public String getNom()
    {
        return nom;
    }
    
    
    
    public ArrayList<Departement> getDepartements()
    {
        return departements;
    }
    
    
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    
    
    public void setDepartements(ArrayList<Departement> departements)
    {
        this.departements = departements;
    }
    
    
    
    public void addDepartement(Departement dpt)
    {
        departements.add(dpt);
    }
    
    
    
    @Override
    public String toString()
    {
        return id+"||"+nom;
    }
}
