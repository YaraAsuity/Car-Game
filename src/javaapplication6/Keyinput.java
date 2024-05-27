/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication6;


import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class Keyinput implements KeyListener {
    public static int check=0 ;
    public static int  cont;
    @Override
    public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_M) {
        check=(check+1)%2;
        cont=0;
    }
    if(check==0) {
       if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        if (EventListener.imageX + 1.7 <= ((Render.unitsWide / 2) - 0.000002)|| EventListener.imageX >= 8) {
          EventListener.imageX += 0.1;
        }
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        if (EventListener.imageX - 0.7 >= -((Render.unitsWide/ 2) - 0.000002) || EventListener.imageX >= 8) {
          EventListener.imageX -= 0.1;
        }
      }
      
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        if (EventListener.imageY + .5 <= ((EventListener.unitstalln / 2) - 0.000002) || EventListener.imageY >= 10) {
          EventListener. imageY+= .1;

        }
      } 
    }
    else if(check==1) {
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        cont=1;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        cont=2;
      }
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        cont=3;
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        cont=4;
      }
    }
  }
  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    }
}