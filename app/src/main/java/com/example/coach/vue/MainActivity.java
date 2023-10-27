package com.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // declarations
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Button btnCalc;
    private Controle controle;
    private Integer poids = 0;
    private Integer taille = 0;
    private Integer age = 0;
    private Integer sexe = 0;

    /**
     * methode qui permet de faire le lien entre propriété et objet correspondant
     */
    private void init(){
        txtPoids = (EditText) findViewById(R.id.txtPoids) ;
        txtTaille = (EditText) findViewById(R.id.txtTaille) ;
        txtAge = (EditText) findViewById(R.id.txtAge) ;
        rdHomme = (RadioButton) findViewById(R.id.rdHomme) ;
        lblIMG = (TextView) findViewById(R.id.lblIMG) ;
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley) ;
        btnCalc = (Button) findViewById(R.id.btnCalc) ;
        controle = Controle.getInstance();
        ecoutCalcul();
    }

    /**
     * methode permettant de verifier les conditions de calculs
     */
    private void ecoutCalcul(){
        btnCalc.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch(Exception e){}
                if(rdHomme.isChecked()){
                    sexe = 1;
                }
                if(poids == 0 || taille == 0 || age == 0){
                    Toast.makeText(MainActivity.this, "Veuillez saisir tous les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**
     * Affiche l'image et le message correspondant au calcul de l'img
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe) {
        controle.creerProfil(poids, taille, age, sexe);
        float img = controle.getImg();
        String message = controle.getMessage();
        switch(message){
            case "normal":
                imgSmiley.setImageResource(R.drawable.normal);
                lblIMG.setTextColor(Color.GREEN);
                break;
            case "trop faible":
                imgSmiley.setImageResource(R.drawable.maigre);
                lblIMG.setTextColor(Color.RED);
                break;
            case "trop élevé":
                imgSmiley.setImageResource(R.drawable.graisse);
                lblIMG.setTextColor(Color.RED);
                break;
        }
        lblIMG.setText(String.format("%.01f", img)+" : IMG "+message);
    }

}