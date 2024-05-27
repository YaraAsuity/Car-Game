/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication6;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;



public class Graphics {
  public static float red =0;
  public static float green =0;
  public static float blue =0;
  public static float alpha =0;
  public static float rotation=0;
  
///////////////////////////////////////////////////////////////////////////////////
    public static void drawLines(float x1, float y1, float x2, float y2) {
    GL2 gl = EventListener.gl;
    gl.glColor3f(1.0f, 1.0f, 0.0f); // Set color to yellow

    gl.glBegin(GL2.GL_LINES);
    gl.glVertex2f(x1, y1); // Start point of the line
    gl.glVertex2f(x2, y2); // End point of the line
    gl.glEnd();
}
  
  
////////////////////////////////////////////////////////////////////////////////////
  
  
  public static void fillRect (float x, float y, float width , float height) {
    	 GL2 gl =EventListener.gl;
    	 gl.glColor3f(1.0f, 1.0f, 1.0f);
 		 gl.glBegin(GL2.GL_QUADS);
 		     gl.glVertex2f(x, y);
 		     gl.glVertex2f(x + width, y);
 		     gl.glVertex2f(x + width, y + height);
 		     gl.glVertex2f(x, y + height);
 	     gl.glEnd();
     }
  public static void fillRectt (float x, float y, float width , float height) {
    	 GL2 gl =EventListener.gl;
    	 gl.glColor3f(1.0f, 1.0f, 1.0f);
 		 gl.glBegin(GL2.GL_QUADS);
 		     gl.glVertex2f(x, y);
 		     gl.glVertex2f(x + width, y);
 		     gl.glVertex2f(x + width, y + height);
 		     gl.glVertex2f(x, y + height);
 	     gl.glEnd();
     }
///////////////////////////////////////////////////////////////////////////////////////////  


  public static void fillRect2 (float x, float y, float width , float height) {
                GL2 gl =EventListener.gl;
                gl.glColor3f(1.0f, 1.0f, 0.0f); // Set color to yellow
 		gl.glBegin(GL2.GL_QUADS);
 		     gl.glVertex2f(x, y);
 		     gl.glVertex2f(x + width, y);
 		     gl.glVertex2f(x + width, y + height);
 		     gl.glVertex2f(x, y + height);
                     
 	     gl.glEnd();
             
    
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
  
public static void drawImage(ImageResource image, float x, float y, float width, float height) {
	GL2 gl = EventListener.gl;
	Texture tex = image.getTexture();

	if (tex != null) {
		gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
	}
            //gl.glTranslatef(x, y, 0);
            //gl.glRotatef(-rotation, 0, 0, 1);
	
            gl.glColor4f(red, green, blue, alpha);
	    gl.glBegin(GL2.GL_QUADS);
	    gl.glTexCoord2f(0, 1);
	    gl.glVertex2f(-width/2, -height/2);
	    
	    gl.glTexCoord2f(1, 1);
	    gl.glVertex2f(width/2, -height/2);
	    
	    gl.glTexCoord2f(1, 0);
	    gl.glVertex2f(width/2, height/2);
	    
	    gl.glTexCoord2f(0, 0);
	    gl.glVertex2f(-width/2, height/2);
	    
            gl.glEnd();
            gl.glFlush();
    
            gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
    
            //gl.glRotatef(rotation, 0, 0, 1);
            //gl.glTranslatef(-x, -y, 0);
        }
       
///////////////////////////////////////////////////////////////////////////////
 

}
   