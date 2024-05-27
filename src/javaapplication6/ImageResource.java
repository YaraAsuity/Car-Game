/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication6;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class ImageResource {
    
    private Texture texture = null;
    private BufferedImage image = null;

    public ImageResource(String path) {
        URL url = ImageResource.class.getResource(path);

        if (url == null) {
            System.err.println("Image file not found: " + path);
            return;
        }
        try {
            image = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(ImageResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        if (image != null) {
            image.flush();
        }
    }

 /*   public Texture getTexture() {
        if (image == null) {
            return null;
        }
        if (texture == null) {
            texture = AWTTextureIO.newTexture(Render.profile, image, true);
        }
        return texture;
    }
*/public Texture getTexture() {
    if (image == null) {
        return null; // Return null if the image is null
    }
    if (texture == null) {
        texture = AWTTextureIO.newTexture(Render.profile, image, true); // Error handling: Log the exception or display an error message
        // Return a default texture or handle the error gracefully
    }
    return texture;
}

private Texture getDefaultTexture() {
    // Implement a method to create or load a default texture
    // Example:
    // return AWTTextureIO.newTexture(defaultImage, true);
    return null;
}
    
}
