package com.example.hola.opengl10escena.clases;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hola on 23/08/2016.
 */
public class Rectangulo {
    private float vertices[]={
            -1,3,
            1,3,
            1,5,
            -1,5

    };
    private byte colores[]={
            (byte)255,0,0,0,
            (byte)255,0,0,0,
            (byte)255,0,0,0,
            (byte)255,0,0,0
    };

    private float vertices1[]={
            -1,-1,
            1,-1,
            1,1,
            -1,1

    };
    private byte colores1[]={
            0,0,(byte)255,0,
            0,0,(byte)255,0,
            0,0,(byte)255,0,
            0,0,(byte)255,0
    };
    FloatBuffer bufVertice;
    ByteBuffer bufColores;
    FloatBuffer bufVertice1;
    ByteBuffer bufColores1;

    public Rectangulo(){
        ByteBuffer bufByte=ByteBuffer.allocateDirect(vertices.length*4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertice=bufByte.asFloatBuffer();
        bufVertice.put(vertices);
        bufVertice.rewind();

        bufColores=ByteBuffer.allocateDirect(colores.length);
        bufColores.put(colores);
        bufColores.rewind();

        bufByte=ByteBuffer.allocateDirect(vertices1.length*4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertice1=bufByte.asFloatBuffer();
        bufVertice1.put(vertices1);
        bufVertice1.rewind();

        bufColores1=ByteBuffer.allocateDirect(colores1.length);
        bufColores1.put(colores1);
        bufColores1.rewind();

    }
    public void dibuja(GL10 gl){
        gl.glVertexPointer(2, GL10.GL_FLOAT,0,bufVertice);//para cada vertice se utiliza dos elementos
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);//habilita el uso del buffer

        gl.glColorPointer(4,GL10.GL_UNSIGNED_BYTE,0,bufColores);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);//va a renderizar(recorrido por filas en la pantalla)


        gl.glVertexPointer(2, GL10.GL_FLOAT,0,bufVertice1);//para cada vertice se utiliza dos elementos
        gl.glColorPointer(4,GL10.GL_UNSIGNED_BYTE,0,bufColores1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);//va a renderizar(recorrido por filas en la pantalla)

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);//desabilita
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
