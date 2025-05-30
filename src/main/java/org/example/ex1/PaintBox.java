package org.example.ex1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class PaintBox extends JPanel {
  private List<Point> pointsX = new ArrayList<>();
  private List<Point> pointsO = new ArrayList<>();

  public PaintBox() {
    setBackground(java.awt.Color.WHITE);
  }

  public void addPointX(Point point) {
    pointsX.add(point);
    repaint();
  }

  public void addPointO(Point point) {
    pointsO.add(point);
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    for (Point point : pointsX) {
      g.drawString("X", point.getX(), point.getY());
    }

    g.setColor(Color.BLUE);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    for (Point point : pointsO) {
      g.drawString("O", point.getX(), point.getY());
    }
  }
}
