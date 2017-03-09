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
public class PeriodeGite {
    private int id, annee, semaineDebut, semaineFin, tarif;
    private String saison;
    private Gite gite;
    
    
    
    public PeriodeGite(int id, int annee, int semaineDebut, int semaineFin, String saison, int tarif, Gite gite)
    {
        this.id = id;
        this.annee = annee;
        this.semaineDebut = semaineDebut;
        this.semaineFin = semaineFin;
        this.saison = saison;
        this.tarif = tarif;
        this.gite = gite;
    }
    
    
    
    public int getId()
    {
        return id;
    }
    
    
    
    public int getAnnee()
    {
        return annee;
    }
    
    
    
    public int getSemaineDebut()
    {
        return semaineDebut;
    }
    
    
    
    public int getSemaineFin()
    {
        return semaineFin;
    }
    
    
    
    public Gite getGite()
    {
        return gite;
    }
    
    
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    
    
    public void setAnnee(int annee)
    {
        this.annee = annee;
    }
    
    
    
    public void setSemaineDebut(int semaineDebut)
    {
        this.semaineDebut = semaineDebut;
    }
    
    
    
    public void setSemaineFin(int semaineFin)
    {
        this.semaineFin = semaineFin;
    }
    
    
    
    public void setGite(Gite gite)
    {
        this.gite = gite;
    }
}
