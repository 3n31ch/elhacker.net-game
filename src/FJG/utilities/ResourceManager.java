/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.utilities;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public class ResourceManager {
    
    public static final String IMAGE_PATH = "/resources/images/";
    
    private static final Map<String, Image> IMAGES = new HashMap<>();
    
    public static void addImage(String code, String path) {
        if(!IMAGES.containsKey(code)) {
            Image image = new ImageIcon(ResourceManager.class.getResource(path)).getImage();
            IMAGES.put(code, image);
        }
    }
    
    public static Image getImage(String code) {
        return IMAGES.get(code);
    }
    
    public static void removeImage(String code) {
        IMAGES.remove(code);
    }
    
    
}
