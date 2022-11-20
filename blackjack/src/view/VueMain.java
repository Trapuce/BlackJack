package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.*;
import java.awt.event.*;

import model.player.Hand;

public class VueMain extends JPanel {

    private Hand main;
    private Image img = null;

    public VueMain(Hand main) {
        this.main = main;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xPosi = 3;
        for (int i = 0; i < main.getNumberOfCard(); i++) {
            String imagePath = "src/images/" + main.getHand().getCardAtIndex(i).toString() + ".gif";
            try {
                img = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, xPosi, 200, this);
            xPosi += 80;

        }
    }

}
