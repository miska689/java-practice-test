package org.example.ex1;

import javax.swing.*;
import java.awt.*;

public class App {
  public static void main(String[] args) {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame = new JFrame("Paint Box Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setLocation(100, 100);
    frame.setSize(800, 600);

    PaintBox paintBox = new PaintBox();
    paintBox.setBounds(50, 50, 400, 500);
    paintBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    frame.add(paintBox);

    FormPanel formPanel = new FormPanel(paintBox);
    formPanel.setBounds(500, 50, 250, 500);
    formPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    frame.add(formPanel);

    frame.setVisible(true);
  }
}
