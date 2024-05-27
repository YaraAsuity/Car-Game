package javaapplication6;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EventListener implements GLEventListener {
    
        public static GL2 gl = null;
	public static float x = -2;
	public static float xx = 5;
        public static ImageResource image  = null;
        public static ImageResource image1 = null;
        public static ImageResource image2 = null;
        public static ImageResource image3 = null;
        private static final int GL_QUADS  = 0;
        private float lineSpeed = 0.03f;
        public static float unitstalln=0;
        public static int currentidnex=0;
        public static float imageWidth = 1f;
        public static float imageHeight = 1.5f;
        public static float imageX = -2 + (2 - imageWidth) / 2;
        public static float imageY = -2 + (2 - imageHeight) / 2 - imageHeight;
        public static float imageX1 = -4 + (2 - imageWidth) / 2;
        public static float imageY1 = -3 + (2 - imageHeight) / 2 - imageHeight;
        public static float imageX2 = 2 + (2 - imageWidth) / 2;
        public static float imageY2 = -3 + (2 - imageHeight) / 2 - imageHeight;
        public static float imageX3 = -1 + (2 - imageWidth) / 2;
        public static float imageY3 = -3 + (2 - imageHeight) / 2 - imageHeight;
        boolean gameOver = false;
        GLUT glut = new GLUT();
        private ImageResource gameOverImage;
        @Override
        public void display(GLAutoDrawable drawable) {
            gl = drawable.getGL().getGL2();
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
            gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
            if (gameOver) {
            drawGameOverImage();
            }  
            else {
                drawGameScene();
            }
            
        }
       
        private void drawGameScene() {
            drawRode(); 
            drawImage();
            drawRodeLines();
            objects();
            objects2();
            objects3();
            checkCollisions();
        }
        //Rawan
         private void drawGameOverImage() {
            if (gameOverImage != null) {
                gl.glEnable(GL2.GL_TEXTURE_2D);
                Texture tex = gameOverImage.getTexture();
                if (tex != null) {
                    gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
                    float imageWidth = 10f; 
                    float imageHeight = 10f; 
                    float imageX = -imageWidth / 2; 
                    float imageY = -imageHeight / 2;
                    gl.glBegin(GL2.GL_QUADS);
                    gl.glTexCoord2f(0, 1);
                    gl.glVertex2f(imageX, imageY);
                    gl.glTexCoord2f(1, 1);
                    gl.glVertex2f(imageX + imageWidth, imageY);
                    gl.glTexCoord2f(1, 0);
                    gl.glVertex2f(imageX + imageWidth, imageY + imageHeight);
                    gl.glTexCoord2f(0, 0);
                    gl.glVertex2f(imageX, imageY + imageHeight);
                    gl.glEnd();   
                    gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
                    gl.glDisable(GL2.GL_TEXTURE_2D);
                }
            }
        }
//////////////////////////////////////////////////////////////////////////////////////
        private void checkCollisions() {
            if (checkCollision(imageX, imageY, imageWidth, imageHeight, imageX1, imageY1, imageWidth, imageHeight)
                || checkCollision(imageX, imageY, imageWidth, imageHeight, imageX2, imageY2, imageWidth, imageHeight)
                || checkCollision(imageX, imageY, imageWidth, imageHeight, imageX3, imageY3, imageWidth, imageHeight)) {
                gameOver = true;
            }
        }
        private boolean checkCollision(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
            return x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2;
        }
//////////////////////////////////////////////////////////////////
        //youssef
        private void objects() {
            if (image1 != null) {
            gl.glEnable(GL2.GL_TEXTURE_2D);
            Texture tex = image1.getTexture();
            if (tex != null) {
                gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
                gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f); 
           
                if (imageY2 == 17) {
                    float minX = -1.8f;
                    float maxX = 1.0f;
                    imageX2 = (float)Math.random() * (maxX - minX) + minX;
                }

                gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0, 1);
                gl.glVertex2f(imageX2, imageY2);
                gl.glTexCoord2f(1, 1);
                gl.glVertex2f(imageX2 + imageWidth, imageY2);
                gl.glTexCoord2f(1, 0);
                gl.glVertex2f(imageX2 + imageWidth, imageY2 + imageHeight);
                gl.glTexCoord2f(0, 0);
                gl.glVertex2f(imageX2, imageY2 + imageHeight);
                gl.glEnd();
                gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
                gl.glDisable(GL2.GL_TEXTURE_2D);

                imageY2 -= 0.04;
                if (imageY2 < -5) {
                    imageY2 = 17; 
                }
            }
        }
    }
        private void objects2() {
            if (image2 != null) {
            gl.glEnable(GL2.GL_TEXTURE_2D);
            Texture tex = image2.getTexture();
            if (tex != null) {
                gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
                gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f); 
                if (imageY1 == 8) {
                    float minX = -4.4f;
                    float maxX = -3.1f;
                    imageX1 = (float)Math.random() * (maxX - minX) + minX;
                }
                
                gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0, 1);
                gl.glVertex2f(imageX1, imageY1);
                gl.glTexCoord2f(1, 1);
                gl.glVertex2f(imageX1 + imageWidth, imageY1);
                gl.glTexCoord2f(1, 0);
                gl.glVertex2f(imageX1 + imageWidth, imageY1 + imageHeight);
                gl.glTexCoord2f(0, 0);
                gl.glVertex2f(imageX1, imageY1 + imageHeight);
                gl.glEnd();
                gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
                gl.glDisable(GL2.GL_TEXTURE_2D);

                imageY1 -= 0.04;
                if (imageY1 < -5) {
                    imageY1 = 8;
                }
            }
        }
    }
        private void objects3() {
        if (image3 != null) {
            gl.glEnable(GL2.GL_TEXTURE_2D);
            Texture tex = image3.getTexture();
            if (tex != null) {
                gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
                gl.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);

            
                if (imageY3 == 14) {
                    float minX = 2.3f;
                    float maxX = 3.4f;
                    imageX3 = (float)Math.random() * (maxX - minX) + minX;
                }

                gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0, 1);
                gl.glVertex2f(imageX3, imageY3);
                gl.glTexCoord2f(1, 1);
                gl.glVertex2f(imageX3 + imageWidth, imageY3);
                gl.glTexCoord2f(1, 0);
                gl.glVertex2f(imageX3 + imageWidth, imageY3 + imageHeight);
                gl.glTexCoord2f(0, 0);
                gl.glVertex2f(imageX3, imageY3 + imageHeight);
                gl.glEnd();
                gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
                gl.glDisable(GL2.GL_TEXTURE_2D);
                imageY3 -= 0.04;
                if (imageY3 < -5) {
                    imageY3 = 14; 
                }
            }
        }
    }
/////////////////////////////////////////////////////////////
        //yara
        private void drawRode(){
        
                float windowWidth = Render.getWindowWidth() / (Render.getWindowHeight() / Render.unitsTall);
                float leftX = -windowWidth / 2; 
                float rightX = windowWidth / 2 - 0.5f;
                float yPosLeft = x;
                for (int i = 0; i < 1000; i++) {
                    float yPos = x - 1f * (i + 1); 
                    Graphics.fillRect(leftX, yPos, 0.5f, 0.5f); 
                }
                
                float yPosRight = x - 0.5f;
                for (int i = 0; i < 1000; i++) {
                    float yPos = x - 1f * (i + 1); 
                    Graphics.fillRect(rightX, yPos, 0.5f, 0.5f); 
                }    
                if (x <-5) {
                    x = 100;
                }
            x -= lineSpeed;
            
        }        
////////////////////////////////////////////////////////////////////////////////////////////////////////////         
        private void drawRodeLines() {
            float yPosLeft = x;
                for (int i = 0; i < 10000; i++) {
                    float yPos = x - 1f * (i + 1); 
                    Graphics.fillRect2(-2f, yPos, 0.1f, 0.5f); 
                
                }
                float xPosLeft = x-0.8f;
                for (int i = 0; i < 10000; i++) {
                    float xPos = x - 1f * (i + 1); 
                    Graphics.fillRect2(2f, xPos, 0.1f, 0.5f); 
                }
		if(x<-5) {
			x=100;
		}
                 x -= lineSpeed;
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        private void increaseLineSpeed() {
            lineSpeed += 0.004f; 
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
       //salma
        private void drawImage() {
        if (image != null) {
        gl.glEnable(GL2.GL_TEXTURE_2D);
        Texture tex = image.getTexture();
        if (tex != null) {
            
            float moveSpeed = 0.1f; 
            if (Keyinput.cont == 1) { 
                if (imageX + imageWidth + moveSpeed <= (Render.unitsWide / 2) - 0.000002) {
                    imageX += moveSpeed;
                }
            } else if (Keyinput.cont == 2) { 
                if (imageX - moveSpeed >= -((Render.unitsWide / 2) - 0.000002)) {
                    imageX -= moveSpeed;
                }
            } else if (Keyinput.cont == 3) { 
                if (imageY + imageHeight + moveSpeed <= (Render.unitsTall / 2) - 0.000002) {
                    imageY += moveSpeed;
                }
            }
            gl.glDisable(GL2.GL_TEXTURE_2D);
            gl.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2f(imageX, imageY);
            gl.glVertex2f(imageX + imageWidth, imageY);
            gl.glVertex2f(imageX + imageWidth, imageY + imageHeight);
            gl.glVertex2f(imageX, imageY + imageHeight);
            gl.glEnd();
            gl.glEnable(GL2.GL_TEXTURE_2D);
            gl.glBindTexture(GL2.GL_TEXTURE_2D, tex.getTextureObject());
            gl.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
            gl.glBegin(GL2.GL_QUADS);
            gl.glTexCoord2f(0, 1);
            gl.glVertex2f(imageX, imageY);
            gl.glTexCoord2f(1, 1);
            gl.glVertex2f(imageX + imageWidth, imageY);
            gl.glTexCoord2f(1, 0);
            gl.glVertex2f(imageX + imageWidth, imageY + imageHeight);
            gl.glTexCoord2f(0, 0);
            gl.glVertex2f(imageX, imageY + imageHeight);
            gl.glEnd();

            gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
        }
        gl.glDisable(GL2.GL_TEXTURE_2D);
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////        
        @Override
        public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_TEXTURE_2D);
                gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_TEXTURE_2D);
		image = new ImageResource("/res/car.png");
                image1 = new ImageResource("/res/car_4.jpg");
                image2 = new ImageResource("/res/car_2.jpg");
                image3 = new ImageResource("/res/car_3.jpg");
                gameOverImage = new ImageResource("/res/game_over.jpg");
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.scheduleAtFixedRate(this::increaseLineSpeed, 0, 4, TimeUnit.SECONDS);
	}
        @Override
        public void dispose(GLAutoDrawable drawable) {	
        }
        @Override
        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
            	GL2 gl = drawable.getGL().getGL2();
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();		
		float unitsTall = Render.getWindowHeight() / (Render.getWindowWidth() / Render.unitsWide);
		gl.glOrtho(-Render.unitsWide/2, Render.unitsWide/2, -unitsTall/2, unitsTall/2, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}
}
