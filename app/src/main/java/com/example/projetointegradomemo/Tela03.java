package com.example.projetointegradomemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class Tela03 extends AppCompatActivity implements View.OnClickListener, Runnable {
    private TextView textoDoNome;
    private ImageView img1, img2, img3, img4, img5, img6;
    private ImageView imgTocado1, imgTocado2;
    private int imagemImgTocado1, imagemImgTocado2, contaToque;
    private Handler handler;

    private ArrayList<Integer> lista;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        textoDoNome = findViewById(R.id.textView3);
        Intent i = getIntent();
        if(i != null){
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                textoDoNome.setText(caixa.getString("nome"));
            }
        }
        img1 = findViewById(R.id.imageView2);
        img2 = findViewById(R.id.imageView3);
        img3 = findViewById(R.id.imageView4);
        img4 = findViewById(R.id.imageView5);
        img5 = findViewById(R.id.imageView11);
        img6 = findViewById(R.id.imageView13);

        lista = new ArrayList<Integer>();
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_6);
        lista.add(R.drawable.ic_action_name_6);

        Collections.shuffle(lista);
        img1.setImageResource(lista.get(0));
        img2.setImageResource(lista.get(1));
        img3.setImageResource(lista.get(2));
        img4.setImageResource(lista.get(3));
        img5.setImageResource(lista.get(4));
        img6.setImageResource(lista.get(5));

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);

        handler = new Handler();
        handler.postDelayed(this, 3000);
        contaToque = 0;
        imgTocado1 = new ImageView(this);
        imgTocado2 = new ImageView(this);
    }

    public void compara(int imagem1, int imagem2){
        contaToque =0;
        if(imagem1 == imagem2)
        {
            imgTocado1.setBackgroundColor(Color.GREEN);
            imgTocado2.setBackgroundColor(Color.GREEN);
            imgTocado1.setEnabled(false);
            imgTocado2.setEnabled(false);
            //deu match
        }else {
            //deu errado
            imgTocado1.setBackgroundColor(Color.RED);
            imgTocado2.setBackgroundColor(Color.RED);
            Handler h1 = new Handler();
            h1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgTocado1.setBackgroundColor(Color.WHITE);
                    imgTocado2.setBackgroundColor(Color.WHITE);
                    imgTocado1.setImageResource(R.drawable.ic_action_name_2);
                    imgTocado2.setImageResource(R.drawable.ic_action_name_2);

                }
            }, 2000);

        }

    }

    @Override
    public void onClick(View view) {
        contaToque++;
        if(view == img1){
            img1.setImageResource(lista.get(0));
            if(contaToque == 1)
            {
               imgTocado1 = img1;
               imagemImgTocado1 = lista.get(0);
            }else {
                imgTocado2 = img1;
                imagemImgTocado2 = lista.get(0);
                compara(imagemImgTocado1,imagemImgTocado2);

            }
        }
        if(view == img2){
            img2.setImageResource(lista.get(1));
            if(contaToque == 1)
            {
                imgTocado1 = img2;
                imagemImgTocado1 = lista.get(1);
            }else {
                imgTocado2 = img2;
                imagemImgTocado2 = lista.get(1);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img3){
            img3.setImageResource(lista.get(2));
            if(contaToque == 1)
            {
                imgTocado1 = img3;
                imagemImgTocado1 = lista.get(2);
            }else {
                imgTocado2 = img3;
                imagemImgTocado2 = lista.get(2);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img4){
            img4.setImageResource(lista.get(3));
            if(contaToque == 1)
            {
                imgTocado1 = img4;
                imagemImgTocado1 = lista.get(3);
            }else {
                imgTocado2 = img4;
                imagemImgTocado2 = lista.get(3);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }

        if(view == img5){
            img5.setImageResource(lista.get(4));
            if(contaToque == 1)
            {
                imgTocado1 = img5;
                imagemImgTocado1 = lista.get(4);
            }else {
                imgTocado2 = img5;
                imagemImgTocado2 = lista.get(4);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img6){
            img6.setImageResource(lista.get(5));
            if(contaToque == 1)
            {
                imgTocado1 = img6;
                imagemImgTocado1 = lista.get(5);
            }else {
                imgTocado2 = img6;
                imagemImgTocado2 = lista.get(5);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
    }

    @Override
    public void run() {
        img1.setImageResource(R.drawable.ic_action_name_2);
        img2.setImageResource(R.drawable.ic_action_name_2);
        img3.setImageResource(R.drawable.ic_action_name_2);
        img4.setImageResource(R.drawable.ic_action_name_2);
        img5.setImageResource(R.drawable.ic_action_name_2);
        img6.setImageResource(R.drawable.ic_action_name_2);



    }
}