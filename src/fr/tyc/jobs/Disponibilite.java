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
public class Disponibilite {
    private int heureDebut, heureFin, idHoraires, idPeriode;
    private String jourDebut, jourFin;
    private Individu contact;
    
    
    
    public Disponibilite()
    {
        
    }
    
    
    
    public Disponibilite(int heureDebut, int heureFin, int idHoraires, int idPeriode,
    String jourDebut, String jourFin, int idContact)
    {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.idHoraires = idHoraires;
        this.idPeriode = idPeriode;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
        this.contact = new Individu(idContact);
    }
    
    
    
    public Disponibilite(int heureDebut, int heureFin, String jourDebut, String jourFin)
    {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
    }
    
    
    
    public int getHeureDebut()
    {
        return heureDebut;
    }
    
    
    
    public int getHeureFin()
    {
        return heureFin;
    }
    
    
    
    public int getIdHoraires()
    {
        return idHoraires;
    }
    
    
    
    public int getIdPeriode()
    {
        return idPeriode;
    }
    
    
    
    public String getJourDebut()
    {
        return jourDebut;
    }
    
    
    
    public String getJourFin()
    {
        return jourFin;
    }
    
    
    
    private Individu getContact()
    {
        return contact;
    }
    
    
    
    private void setHeureDebut(int heureD)
    {
        this.heureDebut = heureD;
    }
    
    
    
    private void setHeureFin(int heureF)
    {
        this.heureFin = heureF;
    }
    
    
    
    private void setIdHoraires(int idHoraires)
    {
        this.idHoraires = idHoraires;
    }
    
    
    
    public void setIdPeriode(int idPeriode)
    {
        this.idPeriode = idPeriode;
    }
    
    
    
    public void setJourDebut(String jourD)
    {
        this.jourDebut = jourD;
    }
    
    
    
    public void setJourFin(String jourF)
    {
        this.jourFin = jourF;
    }
    
    
    
    public void setContact(Individu contact)
    {
        this.contact = contact;
    }
    
    
    
    @Override
    public String toString()
    {
        return heureDebut+"||"+heureFin+"||"+jourDebut+"||"+jourFin+"||"+idHoraires+"||"+idPeriode;
    }
}