package bl;

import beans.figur.Figur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Loader {

  static {
    loadConfig();
  }

  private static String src;
  public static List<Figur> friendFigures = new LinkedList<>();
  public static List<Figur> enemyFigures = new LinkedList<>();

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

  public static void loadSpielfeld()
  {
    List<Figur> curList = enemyFigures;
    String filename = System.getProperty("user.dir")+src+"res"+File.separator+"spielfeld.txt";
    System.out.println("load: " + filename);
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      for (int i = 0; br.ready() && i < 8; i++) {
        String line = br.readLine();
        if(i <= 1)
        {
          curList = enemyFigures;
        }else if(i >= 6)
        {
          curList = friendFigures;
        }

        String[] parts = line.split(";");
        if(parts.length >= 8)
        {
          for (int x = 1; x <= 8; x++) {
            curList.add(Figur.getClassFromChar(parts[x-1].charAt(0), x, i+1));
          }
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
