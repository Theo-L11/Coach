package com.example.coach.modele;

import com.example.coach.outils.Serializer;

public class Profil {

    // declarations
    private Integer poids, taille, sexe, age;
    private float img = 0;
    private String message = "";

    // constante
    private static final Integer minFemme = 15; // maigre i en dessous
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer maxHomme = 25; // gros si au dessus

    /**
     * constructeur valorise les propriétés
     * @param poids
     * @param taille
     * @param sexe 1 pour les hommes, 0 pour les femmes
     * @param age
     */
    public Profil(int poids, int taille, int sexe, int age) {
        this.poids = poids;
        this.taille = taille;
        this.sexe = sexe;
        this.age = age;
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getSexe() {
        return sexe;
    }

    public int getAge() {
        return age;
    }

    /**
     * retourne img apres l'avoir calculé s'il est vide
     * @return img
     */
    public float getImg() {
        if(img == 0){
            float tailleCm = ((float)taille)/100;
            img = (float)((1.2 * poids/(tailleCm*tailleCm)) + (0.23 * age) - (10.83 * sexe) - 5.4);
        }
        return img;
    }

    /**
     * retourne le message a afficher en fonction de l'img
     * @return message
     */
    public String getMessage() {
        if(message.equals("")){
            message = "normal";
            Integer min = minFemme, max = maxFemme;
            if(sexe == 1){
                min = minHomme;
                max = maxHomme;
            }
            img = getImg();
            if(img<min){
                message = "trop faible";
            }else{
                if(img>max){
                    message = "trop élevé";
                }
            }
        }
        return message;
    }

}
