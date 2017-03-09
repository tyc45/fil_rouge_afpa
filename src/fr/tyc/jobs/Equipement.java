/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.jobs;

/**
 *
 * @author 59013-52-14
 */
public class Equipement {
    private String type, nom;
    private int tarif;
    private Gite gite;
    
    
    
    public Equipement(String nom, String type)
    {
        this.type = type;
        this.nom = nom;
    }
    
    
    
    public Equipement(String nom, String type, int tarif, int idGite)
    {
        this.nom = nom;
        this.type = type;
        this.tarif = tarif;
        this.gite = new Gite(idGite);
    }
    
    
    public String getType()
    {
        return type;
    }
    
    
    
    public String getNom()
    {
        return nom;
    }
    
    
    
    public int getTarif()
    {
        return tarif;
    }
    
    
    
    public Gite getGite()
    {
        return gite;
    }
    
    
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    
    
    public void setTarif(int tarif)
    {
        this.tarif = tarif;
    }
    
    
    
    public void setGite(Gite gite)
    {
        this.gite = gite;
    }
    
    
    
    @Override
    public String toString()
    {
        return nom+"||"+tarif+"||"+gite.toString();
    }
}
