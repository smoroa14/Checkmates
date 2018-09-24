package GUI;

import javax.swing.*;
import java.awt.*;

// created by wolf: https://stackoverflow.com/questions/10634417/image-resize-to-fit-on-jpanel
public class ImageLabel extends JLabel{
  private Image _myimage;
  private String name;

  public ImageLabel(String text){
    super(text);
  }

  public ImageLabel(){
    super();
  }

  public void setIcon(Icon icon, String name) {
    super.setIcon(icon);
    this.name = name;
    if (icon instanceof ImageIcon)
    {
      _myimage = ((ImageIcon) icon).getImage();
    }
  }

  public void setIcon(Icon icon) {
    super.setIcon(icon);
    if (icon instanceof ImageIcon)
    {
      _myimage = ((ImageIcon) icon).getImage();
    }
  }

  public String getIconName()
  {
    return name;
  }

  @Override
  public void paint(Graphics g){
    g.drawImage(_myimage, 0, 0, this.getWidth(), this.getHeight(), null);
  }
}