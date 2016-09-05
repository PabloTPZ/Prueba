package com.example.hola.opengl10escena;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hola.opengl10escena.Dibujo.Renderiza;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GLSurfaceView superficie=new Renderiza(this);
        setContentView(superficie);
    }
}
