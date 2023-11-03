package com.example.coach.controleur;

import static com.example.coach.outils.Serializer.deSerialize;

import android.content.Context;

import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

public final class Controle {

    // decla
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveprofil";

    /**
     * constructeur de la classe
     */
    private Controle(Context uncontext){
        super();
        recupSerialize(uncontext);

    }

    /**
     * retourne l'instance de Controle ou en crée une si il n'en existe pas encore
     * @return instance
     */
    public static final Controle getInstance(Context uncontexte) {
        if(instance == null){
            instance = new Controle(uncontexte);
        }
        return instance;
    }

    /**
     * methode qui valorise le profil avec les parametres
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context uncontext){
        profil = new Profil(poids, taille, sexe, age);
        Serializer.serialize(nomFic, profil, uncontext);
    }

    /**
     * retourne l'img du profil
     * @return img
     */
    public float getImg(){
        if(profil != null) {
            return profil.getImg();
        }else{
            return 0;
        }
    }

    /**
     * retourne le message correspondant au profil
     * @return message
     */
    public String getMessage(){
        if(profil != null) {
            return profil.getMessage();
        }else{
            return "";
        }
    }

    /**
     * retourne la taille correspondante au profil
     * @return taille
     */
    public Integer getTaille(){
        if(profil != null){
            return profil.getTaille();
        }else {
            return 0;
        }
    }

    /**
     * retourne le poids correspondant au profil
     * @return poids
     */
    public Integer getPoids(){
        if(profil != null){
            return profil.getPoids();
        }else{
            return 0;
        }
    }

    /**
     * retourne l'age correspondant au profil
     * @return age
     */
    public Integer getAge(){
        if(profil != null){
            return profil.getAge();
        }else{
            return 0;
        }
    }

    /**
     * retourne le sexe correspondant au profil
     * @return sexe
     */
    public Integer getSexe(){
        if(profil != null){
            return profil.getSexe();
        }else{
            return null;
        }
    }

    private static void recupSerialize(Context uncontext){
        profil = (Profil) deSerialize(nomFic, uncontext);
    }
}
