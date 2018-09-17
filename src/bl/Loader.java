package bl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {

  private static String src;

  public static void loadConfig()
  {
    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "config.config"))) {
      src = br.readLine().split(": ")[1];
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Icon loadImage(String filename)
  {
    loadConfig();
    BufferedImage img = null;

    try
    {
      filename = System.getProperty("user.dir")+src+"images"+File.separator+filename;
      System.out.println(filename);
      img = ImageIO.read(new File(filename));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return new ImageIcon(img);
  }
}
