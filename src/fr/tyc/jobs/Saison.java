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
public class Saison {
    private String nomSaison;
    private int tarif;
    private Gite gite;
    
    
    
    public Saison(String nomSaison, int tarif, Gite gite)
    {
        this.nomSaison = nomSaison;
        this.tarif = tarif;
        this.gite = gite;
    }
    
    
    
    public String getNomSaison()
    {
        return nomSaison;
    }
    
    
    
    public int getTarif()
    {
        return tarif;
    }
    
    
    
    public Gite getGite()
    {
        return gite;
    }
    
    
    
    public void setNomSaison(String nomSaison)
    {
        this.nomSaison = nomSaison;
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
        return nomSaison+"||"+gite.toString();
    }
}
