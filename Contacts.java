package com.example.mhammed.gan;

/**
 * Created by mhammed on 12/04/2016.
 */
public class Contacts {
    private String name;
    private String poste;
    private String adresse;
    private String email;

    public Contacts(String name,String poste,String adresse,String email){
        this.setName(name);
        this.setPoste(poste);
        this.setAdresse(adresse);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
