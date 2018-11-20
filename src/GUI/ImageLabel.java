package GUI;

import bl.Loader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// created by wolf: https://stackoverflow.com/questions/10634417/image-resize-to-fit-on-jpanel
public class ImageLabel extends JLabel {
  private Image _myimage;
  private Image oldImage;
  private String name;
  private String oldName;
  private Icon unselected;
  private Icon selected;
  private Color color = new Color(181, 142, 109).brighter();

  public ImageLabel(String text) {
    super(text);
  }

  public ImageLabel() {
    super();
  }

  public void setIcon(Icon icon, String name) {
    this.setIcon(icon);
    System.out.println("old: " + this.name + " - new: " + name);
    this.name = name;
    repaint();
  }

  public void setIcon(Icon icon) {
    oldImage = _myimage;
    oldName = name;
    super.setIcon(icon);
    if (icon == null) {
      _myimage = null;
      this.revalidate();
      return;
    }
    System.out.println(icon.toString());
    if (icon instanceof ImageIcon) {
      _myimage = ((ImageIcon) icon).getImage();
      this.revalidate();
    }

    Image ico = new ImageIcon(((ImageIcon) icon).getImage()).getImage();
    BufferedImage img = setSelected((BufferedImage) ico, true);
    selected = new ImageIcon(img);

    img = setSelected((BufferedImage) new ImageIcon(((ImageIcon) this.getIcon()).getImage()).getImage(), false);
    unselected = new ImageIcon(img);

    repaint();
  }

  public void setOldImage()
  {
    System.out.println(oldName + " - " + this.getName());
    if(oldImage == null)
    {
      setIcon(Loader.loadImage("null.png"), "null.png");
      oldImage = _myimage;
      oldName = name;
    }else{
      _myimage = oldImage;
      name = oldName;
    }
    repaint();
  }

  public Icon getUnselected() {
    return unselected;
  }

  public void setUnselected() {
    this.setIcon(unselected);
    repaint();
  }

  public Icon getSelected() {
    return selected;
  }

  public void setSelected() {
    this.setIcon(selected);
    repaint();
  }

  public String getIconName() {
    return name;
  }

  @Override
  public void paint(Graphics g)
  {
    g.setColor(color);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
  }

  private BufferedImage setSelected(BufferedImage img, boolean selected) {

    /*int width = img.getWidth();
    int height = img.getHeight();

    int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);

    for (int i = 0; i < pixels.length; i++) {
      Color color = new Color(pixels[i]);
      if (selected) {
        color = color.darker();
      } else {
        color = color.brighter();
      }
      int r = color.getRed();
      int g = color.getGreen();
      int b = color.getBlue();
      int a = color.getAlpha();
      //System.out.print(a + " | ");
      pixels[i] = new Color(r, g, b, a).getRGB();
    }
    //System.out.println();
    img.setRGB(0, 0, width, height, pixels, 0, width);*/
    repaint();
    return img;
  }

  public Color getColor(BufferedImage img, int col, int row) {
    Color color = new Color(img.getRGB(col, row));
    return color;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color c) {
    this.color = c;
  }

}