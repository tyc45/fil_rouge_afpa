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
public class Individu {
    private int id;
    private String nom, prenom, email, adresse;
    private Ville ville;
    private Telephone telephone;
    private ArrayList<Gite> gites;
    private ArrayList<Disponibilite> dispos;
    private ArrayList<String> roles;
    
    
    
    public Individu(int id, String nom, String prenom, String email, 
            String numVoirie, String compNumVoirie, String nomVoirie, String compAdresse,
            String insee, String numDepartement, String nomVille)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        setAdresse(numVoirie, compNumVoirie, nomVoirie, compAdresse);
        ville = new Ville(insee, numDepartement, nomVille);
    }
    
    
    
    public Individu()
    {
        gites = new ArrayList<>();
        dispos = new ArrayList<>();
        roles = new ArrayList<>();
    }
    
    
    
    public Individu(int id)
    {
        this.id = id;
        gites = new ArrayList<>();
        dispos = new ArrayList<>();
        roles = new ArrayList<>();
    }
    
    
    
    public Individu(int id, String nom, String prenom)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        gites = new ArrayList<>();
        dispos = new ArrayList<>();
        roles = new ArrayList<>();
    }
    
    
    
    public int getId()
    {
        return id;
    }
    
    
    
    public String getNom()
    {
        return nom;
    }
    
    
    
    public String getPrenom()
    {
        return prenom;
    }
    
    
    
    public String getEmail()
    {
        return email;
    }
    
    
    
    public String getAdresse()
    {
        return adresse;
    }
    
    
    
    public Ville getVille()
    {
        return ville;
    }
    
    
    
    public ArrayList<Gite> getGites()
    {
        return gites;
    }
    
    
    
    public ArrayList<Disponibilite> getDispos()
    {
        return dispos;
    }
    
    
    
    public ArrayList<String> getRoles()
    {
        return roles;
    }
    
    
    
    public Telephone getTelephone()
    {
        return telephone;
    }
    
    
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    
    
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    
    
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    
    
    public void setAdresse(String numVoirie, String complementNumVoirie, String nomVoirie, String complementAdresse)
    {
        this.adresse = numVoirie+" "+complementNumVoirie+" "+nomVoirie+" "+complementAdresse;
    }
    
    
    
    public void setVille(Ville ville)
    {
        this.ville = ville;
    }
    
    
    
    public void setGites(ArrayList<Gite> gites)
    {
        this.gites = gites;
    }
    
    
    
    public void setDispos(ArrayList<Disponibilite> dispos)
    {
        this.dispos = dispos;
    }
    
    
    
    public void setRoles(ArrayList<String> roles)
    {
        this.roles = roles;
    }
    
    
    
    public void setTelephone(Telephone telephone)
    {
        this.telephone = telephone;
    }
    
    
    
    public void addGite(Gite gite)
    {
        gites.add(gite);
    }
    
    
    
    public void addDispo(Disponibilite dispo)
    {
        dispos.add(dispo);
    }
    
    
    
    public void addRole(String role)
    {
        roles.add(role);
    }
    
    
    
    @Override
    public String toString()
    {
        return nom+"||"+prenom+"||"+email+"||"+adresse+"||"+ville.getDepartement()+ville.getInsee();
    }
}
