package org.example.ex1;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FormPanel extends JPanel {
  Random random = new Random();

  public FormPanel(PaintBox paintBox) throws OutOfPanelException {
    setLayout(null);

    JButton buttonX = new JButton("Add X");
    buttonX.setBounds(10, 10, 100, 30);
    add(buttonX);

    JButton buttonO = new JButton("Add O");
    buttonO.setBounds(120, 10, 100, 30);
    add(buttonO);

    JLabel messageLabel = new JLabel();
    messageLabel.setBounds(10, 40, 200, 30);
    messageLabel.setForeground(Color.RED);
    add(messageLabel);

    JTextField textField = new JTextField(20);
    textField.setFont(new Font("Arial", Font.PLAIN, 14));
    textField.setBounds(10, 90, 200, 30);
    add(textField);

    JButton submitButton = new JButton("Submit");
    submitButton.setBounds(10, 130, 150, 30);
    add(submitButton);

    buttonO.addActionListener(e -> {
      int x = random.nextInt(paintBox.getWidth());
      int y = random.nextInt(paintBox.getHeight());

      if (x < 10 || x > paintBox.getWidth() - 10 || y < 10 || y > paintBox.getHeight() - 10) {
        messageLabel.setText("Point is out of panel bounds");
        throw new OutOfPanelException("Point is out of panel bounds");
      }

      messageLabel.setText("");
      paintBox.addPointO(new Point(x, y));
    });

    buttonX.addActionListener(e -> {
      int x = random.nextInt(paintBox.getWidth());
      int y = random.nextInt(paintBox.getHeight());

      if (x < 10 || x > paintBox.getWidth() - 10 || y < 10 || y > paintBox.getHeight() - 10) {
        messageLabel.setText("Point is out of panel bounds");
        throw new OutOfPanelException("Point is out of panel bounds");
      }

      messageLabel.setText("");
      paintBox.addPointX(new Point(x, y));
    });

    submitButton.addActionListener(e -> {
      String text = textField.getText();
      if (text.isEmpty()) {
        messageLabel.setText("Please enter a value");
        return;
      }

      try (BufferedWriter write = new BufferedWriter(new FileWriter("text.txt"))) {
        write.write(text);
        write.close();
      } catch (IOException err) {
        err.getMessage();
      }
    });
  }
}
