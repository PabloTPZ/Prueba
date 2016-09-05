package com.example.hola.opengl10escena.Dibujo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Toast;


import com.example.hola.opengl10escena.clases.Rectangulo;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by perez on 30-08-16.
 */
public class Renderiza extends GLSurfaceView implements GLSurfaceView.Renderer{

    private int alto;
    private int ancho;
    Context contexto;
    Rectangulo rectangulo;


    public Renderiza(Context context) {
        super(context);
        this.contexto=context;
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);//renderiza una vez
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        rectangulo=new Rectangulo();
        gl.glClearColor(0,1,1,0);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        ancho=w;
        alto=h;
        gl.glViewport(0,0,w,h);//considertamos toda la pantalla
        gl.glMatrixMode(GL10.GL_PROJECTION);//definimos area de trabajo
        gl.glLoadIdentity();//matriz de proyeccion
        GLU.gluOrtho2D(gl,-4,4,-6,6);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float posx=event.getX();
        float posy=event.getY();
        if(event.getAction()==MotionEvent.ACTION_UP){//dejamos de precionar con action_up

            //nueva posiscion en valores del opengl
            posx =posx*8/(float)ancho-4;
            posy=(12-posy*12/(float) alto)-6;

            if(puntoDentroRectangulo(posx,posy,-1,3,2,2)){
                Toast.makeText(contexto.getApplicationContext(),"Rojo",Toast.LENGTH_SHORT).show();

            }
            if(puntoDentroRectangulo(posx,posy,-1,-1,2,2)){
                Toast.makeText(contexto.getApplicationContext(),"Azul",Toast.LENGTH_SHORT).show();

            }
        }
        return true;
    }
    public static Boolean puntoDentroRectangulo(float posx,float posy,int x,int y,int ancho,int alto){
        return (x<posx && posx<x+ancho && y<posy && posy<y+alto);
    }
    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        rectangulo.dibuja(gl);
    }
}
