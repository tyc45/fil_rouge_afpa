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
public class Telephone {
    private String numeroTelephone, typeTelephone;
    private Individu proprietaire;
    
    
    
    public Telephone(String numPhone, String typePhone, Individu proprio)
    {
        this.numeroTelephone = numPhone;
        this.typeTelephone = typePhone;
        this.proprietaire = proprio;
    }
    
    
    
    public String getNumeroTelephone()
    {
        return numeroTelephone;
    }
    
    
    
    public String getTypeTelephone()
    {
        return typeTelephone;
    }
    
    
    
    public Individu getProprietaire()
    {
        return proprietaire;
    }
    
    
    
    public void setNumeroTelephone(String numPhone)
    {
        numeroTelephone =  numPhone;
    }
    
    
    
    public void setTypeTelephone(String typePhone)
    {
        typeTelephone = typePhone;
    }
    
    
    
    public void setProprietaire(Individu proprio)
    {
        proprietaire = proprio;
    }
    
    
    
    @Override
    public String toString()
    {
        return numeroTelephone+"||"+typeTelephone+"||"+proprietaire;
    }
}
