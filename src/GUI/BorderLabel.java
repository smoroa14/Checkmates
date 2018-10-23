package GUI;

import javax.swing.*;
import java.awt.*;

public class BorderLabel extends JLabel {
  @Override
  public void paint(Graphics g) {
    this.setFont(new Font("Arial", 0, 30));
    g.setColor(Color.DARK_GRAY.darker());
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    super.paint(g);
  }
}
