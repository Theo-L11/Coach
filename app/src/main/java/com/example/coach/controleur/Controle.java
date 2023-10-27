package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {

    // decla
    private static Controle instance = null;
    private static Profil profil;

    /**
     * constructeur de la classe
     */
    private Controle(){
        super();
    }

    /**
     * retourne l'instance de Controle ou en crée une si il n'en existe pas encore
     * @return instance
     */
    public static final Controle getInstance() {
        if(instance == null){
            instance = new Controle();
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
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil = new Profil(poids, taille, sexe, age);
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
}
