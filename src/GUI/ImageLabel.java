package GUI;

import bl.Loader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// created by wolf: https://stackoverflow.com/questions/10634417/image-resize-to-fit-on-jpanel
public class ImageLabel extends JLabel{
  private Image _myimage;
  private String name;
  private Icon unselected;
  private Icon selected;

  public ImageLabel(String text){
    super(text);
  }

  public ImageLabel(){
    super();
  }

  public void setIcon(Icon icon, String name) {
    this.setIcon(icon);
    this.name = name;
  }

  public void setIcon(Icon icon) {
    super.setIcon(icon);
    if (icon == null)
    {
      _myimage = null;
      this.revalidate();
      return;
    }
    if (icon instanceof ImageIcon)
    {
      _myimage = ((ImageIcon) icon).getImage();
      this.revalidate();
    }

    Image ico = new ImageIcon(((ImageIcon) icon).getImage()).getImage();
    BufferedImage img = setSelected((BufferedImage) ico, true);
    selected = new ImageIcon(img);

    img = setSelected((BufferedImage) new ImageIcon(((ImageIcon) this.getIcon()).getImage()).getImage(), false);
    unselected = new ImageIcon(img);

  }

  public Icon getUnselected() {
    return unselected;
  }

  public void setUnselected() {
    this.setIcon(unselected);
  }

  public Icon getSelected() {
    return selected;
  }

  public void setSelected() {
    this.setIcon(selected);
  }

  public String getIconName()
  {
    return name;
  }

  @Override
  public void paint(Graphics g){
    g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
  }

  private BufferedImage setSelected(BufferedImage img, boolean selected) {
    int width = img.getWidth();
    int height = img.getHeight();
    for (int col = 0; col < width; col++) {
      for (int row = 0; row < height; row++) {
        Color color = getColor(img, col, row);
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        if (selected) {
          color = color.darker();
        } else {
          color = color.brighter();
        }
        img.setRGB(col, row, color.getRGB());
      }
    }
    return img;
  }

  public Color getColor(BufferedImage img, int col, int row) {
    Color color = new Color(img.getRGB(col, row));
    return color;
  }
}