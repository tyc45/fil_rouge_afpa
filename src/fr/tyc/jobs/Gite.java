/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.jobs;

import java.util.ArrayList;
import javafx.beans.property.*;

/**
 *
 * @author 59013-52-14
 */
public class Gite {
    private String adresse;
    private StringProperty nom, nomVille;
    private int surface, nbChambres, id;
    private IntegerProperty nbCouchages, animaux, cp;
    private Individu contact;
    private Ville ville;
    private ArrayList<Equipement> equipements;
    private ArrayList<PeriodeGite> periodesGite;
    
    
    
    public Gite()
    {
        this.nom = new SimpleStringProperty();
        this.nomVille = new SimpleStringProperty();
        this. nbCouchages = new SimpleIntegerProperty();
        this.animaux = new SimpleIntegerProperty();
        this.cp = new SimpleIntegerProperty();
        equipements = new ArrayList<>();
        periodesGite = new ArrayList<>();
    }
    
    
    
    public Gite(int id)
    {
        this.nom = new SimpleStringProperty();
        this.nomVille = new SimpleStringProperty();
        this. nbCouchages = new SimpleIntegerProperty();
        this.animaux = new SimpleIntegerProperty();
        this.cp = new SimpleIntegerProperty();
        this.id = id;
        equipements = new ArrayList<>();
        periodesGite = new ArrayList<>();
    }
    
    
    
    public Gite(int id, String nom)
    {
        this.nom = new SimpleStringProperty();
        this.nomVille = new SimpleStringProperty();
        this. nbCouchages = new SimpleIntegerProperty();
        this.animaux = new SimpleIntegerProperty();
        this.cp = new SimpleIntegerProperty();
        this.id = id;
        this.nom.set(nom);
        equipements = new ArrayList<>();
        periodesGite = new ArrayList<>();
    }
    
    
    
    public Gite(int id, String nom, int surface, int nbChambres, int nbCouchages,
            int animaux, String numVoirie, String compNumVoirie, String nomVoirie,
            String compAdresse, int cp, int idIndividu, String insee, String numDepartement,
            String nomVille)
    {
        this.nom = new SimpleStringProperty();
        this.nomVille = new SimpleStringProperty();
        this. nbCouchages = new SimpleIntegerProperty();
        this.animaux = new SimpleIntegerProperty();
        this.cp = new SimpleIntegerProperty();
        this.id = id;
        this.nom.set(nom);
        this.surface = surface;
        this.nbChambres = nbChambres;
        this.nbCouchages.set(nbCouchages);
        this.animaux.set(animaux);
        if(compAdresse != null) this.adresse = numVoirie+" "+compNumVoirie+" "+nomVoirie+" "+compAdresse;
        else this.adresse = numVoirie+" "+compNumVoirie+" "+nomVoirie;
        this.cp.set(cp);
        this.contact = new Individu(idIndividu);
        this.ville = new Ville(insee, numDepartement, nomVille);
        this.nomVille.set(nomVille);
    }
    
    
    
    public int getId()
    {
        return id;
    }
    
    
    
    public StringProperty nomProperty()
    {
        return nom;
    }
    
    
    
    public String getNom()
    {
        return nom.get();
    }
    
    
    
    public String getAdresse()
    {
        return adresse;
    }
    
    
    
    public int getSurface()
    {
        return surface;
    }
    
    
    
    public int getNbChambres()
    {
        return nbChambres;
    }
    
    
    
    public IntegerProperty nbCouchagesProperty()
    {
        return nbCouchages;
    }
    
    
    
    public int getNbCouchages()
    {
        return nbCouchages.get();
    }
    
    
    
    public IntegerProperty animauxProperty()
    {
        return animaux;
    }
    
    
    
    public int getAnimaux()
    {
        return animaux.get();
    }
    
    
    
    public Individu getContact()
    {
        return contact;
    }
    
    
    
    public Ville getVille()
    {
        return ville;
    }
    
    
    
    public IntegerProperty cpProperty()
    {
        return cp;
    }
    
    
    
    public int getCp()
    {
        return cp.get();
    }
    
    
    
    public StringProperty nomVilleProperty()
    {
        return nomVille;
    }
    
    
    
    public String getNomVille()
    {
        return nomVille.get();
    }
    
    
    
    public ArrayList<Equipement> getEquipements()
    {
        return equipements;
    }
    
    
    
    public ArrayList<PeriodeGite> getPeriodeGite()
    {
        return periodesGite;
    }
    
    
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom.set(nom);
    }
    
    
    
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }
    
    
    
    public void setAdresse(String numVoirie, String complementNumVoirie, String nomVoirie, String complementAdresse)
    {
        this.adresse = numVoirie+" "+complementNumVoirie+" "+nomVoirie+" "+complementAdresse;
    }
    
    
    
    public void setSurface(int surface)
    {
        this.surface = surface;
    }
    
    
    
    public void setNbChambres(int nb)
    {
        this.nbChambres = nb;
    }
    
    
    
    public void setNbCouchages(int nb)
    {
        this.nbCouchages.set(nb);
    }
    
    
    
    public void setAnimaux(int prix)
    {
        this.animaux.set(prix);
    }
    
    
    
    public void setCp(int cp)
    {
        this.cp.set(cp);
    }
    
    
    
    public void setNomVille(String nomVille)
    {
        this.nomVille.set(nomVille);
    }
    
    
    
    public void setContact(Individu contact)
    {
        this.contact = contact;
    }
    
    
    
    public void setVille(Ville ville)
    {
        this.ville = ville;
    }
    
    
    
    public void setVille(String insee, String nom, String numDepartement)
    {
        this.ville = new Ville(insee, numDepartement, nom);
    }
    
    
    
    public void setEquipements(ArrayList<Equipement> equipements)
    {
        this.equipements = equipements;
    }
    
    
    
    public void setPeriodeGite(ArrayList<PeriodeGite> periodeGite)
    {
        periodesGite = periodeGite;
    }
    
    
    
    public void addEquipement(Equipement equipement)
    {
        equipements.add(equipement);
    }
    
    
    
    public void addPeriodeGite(PeriodeGite periodeGite)
    {
        this.periodesGite.add(periodeGite);
    }
    
    
    
    @Override
    public String toString()
    {
        return nom+"||"+adresse+"||"+ville.getFullInsee();
    }
}
