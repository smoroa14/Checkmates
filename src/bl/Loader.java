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
import java.util.Map;
import java.util.TreeMap;

public class Loader {

  static {
    loadConfig();
  }

  private static String src;
  private static Map<String, ImageIcon> imageIconMap = new TreeMap<>();
  public static List<Figur> friendFigures = new LinkedList<>();
  public static List<Figur> enemyFigures = new LinkedList<>();

  public static void loadConfig() {
    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "config.config"))) {
      src = br.readLine().split(": ")[1];
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Icon loadImage(String filename) {
    if(filename.equalsIgnoreCase("null.png"))
    {
      return null;
    }
    if (imageIconMap.containsKey(filename)) {
      return imageIconMap.get(filename);
    }
    loadConfig();
    BufferedImage img = null;

    try {
      String filepath = System.getProperty("user.dir") + src + "images" + File.separator + filename;
      //System.out.println(filename);
      img = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
      img = ImageIO.read(new File(filepath));
      imageIconMap.put(filename, new ImageIcon(img));
    } catch (IOException e) {
      e.printStackTrace();
    }

    int width = img.getWidth();
    int height = img.getHeight();
/*
    int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);

    for (int i = 0; i < pixels.length; i++) {
      Color color = new Color(pixels[i]);
      int r = color.getRed();
      int g = color.getGreen();
      int b = color.getBlue();
      int a = color.getAlpha();
      //System.out.print(a + " a | r " + r + " - ");
      pixels[i] = new Color(r, g, b, a).getRGB();
    }
    System.out.println();
*/
    return new ImageIcon(img);
  }

  public static void loadSpielfeld() {
    List<Figur> curList = enemyFigures;
    String filename = System.getProperty("user.dir") + src + "res" + File.separator + "spielfeld.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      for (int i = 0; br.ready() && i < 8; i++) {
        String line = br.readLine();
        boolean yours = true;
        if (i <= 1) {
          curList = enemyFigures;
          yours = false;
        } else if (i >= 6) {
          curList = friendFigures;
          yours = true;
        }

        String[] parts = line.split(";");
        if (parts.length >= 8) {
          for (int x = 1; x <= 8; x++) {
            Figur a = Figur.getClassFromChar(parts[x - 1].charAt(0), x, i + 1, yours);
            if (a == null) {
              continue;
            }
            curList.add(a);
          }
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getSoundPath(String file) {
    loadConfig();
    return System.getProperty("user.dir") + src + "sounds" + File.separator + file;
  }
}
