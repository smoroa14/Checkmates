package bl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Loader {
  public static Icon loadImage(String filename)
  {
    BufferedImage img = null;

    try
    {
      filename = System.getProperty("user.dir")+File.separator+"src"+File.separator+"images"+File.separator+filename;
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
