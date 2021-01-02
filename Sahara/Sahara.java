/*
    @description:   Animate Camel and bedwen in Sahara
    @author:        Khaled Hassan El-Morshedy
    @profile:       www.github.com/elmoiv
    @date:          31-12-2020
*/

import java.awt.*;
import java.applet.*;

public class Sahara extends Applet {
    
    Color camelColor = hexColor("fec716");
    Color manClothes = hexColor("7f7f7f");
    Color globalColor = hexColor("000000");

    int x, y;
    int a = 0;
    int b = 0;
    int manWait = 0;
    String [] TEXT = {
        "\u0643\u0628\u0631 \u0627\u0644\u0634\u0627\u0634\u0629 \u064a\u0627 \u0628\u0634\u0629...",
        "\u0623\u0646\u0627 \u0628\u062c\u0631\u064a \u0639\u0644\u0649 \u064a\u062a\u0627\u0645\u0649",
        "\u0627\u062e\u0644\u0635 \u064a\u0627 \u0639\u0645",
        "\u0645\u062a\u0639\u0635\u0628\u0646\u064a\u0634 \u0628\u0642\u0648\u0644\u0643",
        "\u062a\u0633\u0644\u0645 \u064a\u0627 \u0623\u062e\u0648 \u0648\u0635\u0644\u062a \u062e\u0644\u0627\u0635",
        "\u0627\u0644\u0639\u0633\u064a\u0631\u064a \u0644\u0645\u0633\u062a\u0644\u0632\u0645\u0627\u062a \u0627\u0644\u062c\u0645\u0627\u0644",
        "\u0635\u064a\u0627\u0646\u0629",
        "\u0628\u064a\u0639",
        "\u0627\u0633\u062a\u0628\u062f\u0627\u0644"
    };
    
    public void init() {
        this.setSize(500, 350);
    }

    public void paint(Graphics g) {
        /*
            Animation variables
        */
        g.drawLine(0, 285, 1212, 285);
        
        if (x + 350 > 1199) {
            int tmp;
        }
        else if (x + 350 >= this.getWidth()) {
            manWait++;
            Font font = new Font(Font.SERIF, Font.PLAIN, 14);
            g.setFont(font);
            g.drawString(TEXT[0], x + 250, 15);
            g.drawString(TEXT[1], x + 250, 35);
            if (manWait >= 230) {
                g.drawString(TEXT[2], x + 290, 310);
            }
            if (manWait >= 630) {
                g.drawString(TEXT[3], x + 280, 350);
            }
        }
        else {
            manWait = 0;
            x++;
            if (a == 0) {
                b++;
                if (b == 30) {
                    a = 1;
                }
            }
            else {
                b--;
                if (b == -10) {
                    a = 0;
                }
            }
        }
        if (x + 350 > 1199) {
            g.drawString(TEXT[4], x + 250, 15);
        }

        drawHouse(g);
        drawCamel(g, x);
        drawMan(g, x);
        
        // Draw Rope
        g.setColor(globalColor);
        g.drawLine(254 + x, 75, 254 + x, 140);
        g.drawArc(254 + x, 75, 95, 120, 4, -180);

        drawStatics(g);
        
        /*
            Animation Process
        */
        if (x + 350 < 1200) {
            try {
                Thread.sleep(15);    
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            repaint();
        }
    }

    public void drawStatics(Graphics g) {
        g.setFont(new Font(Font.SERIF, Font.PLAIN, 13));
        int w = this.getWidth();
        int h = this.getHeight();
        g.drawString("Height: " + h, 5, h - 15);
        g.drawString("Width: " + w, 5, h);
    }

    public void drawMan(Graphics g, int x) {
        // Hat
        g.setColor(globalColor);
        g.fillOval(295 + x, 50, 33, 48);
        
        // Head
        g.setColor(camelColor);
        g.fillOval(295 + x, 67, 33, 33);

        // Face
        g.setColor(globalColor);
            //// Left Brow
            g.drawArc(300 + x, 72, 11, 11, 0, 180);
            //// Right Brow
            g.drawArc(312 + x, 72, 11, 11, 0, 180);
            //// Left Eye
            g.fillOval(303 + x, 75, 6, 6);
            //// Right Eye
            g.fillOval(315 + x, 75, 6, 6);
            //// Nose
            g.fillOval(309 + x, 80, 6, 6);
            //// Mouth
            g.fillArc(306 + x, 82, 12, 12, 180, 180);

        // Galabieh
        g.setColor(manClothes);
        int [] xGala = {305, 305, 295, 285, 340, 330, 318, 318};
        xGala = batchAddPoly(xGala, x);
        int [] yGala = {100, 110, 122, 265, 265, 122, 110, 100};
        g.fillPolygon(xGala, yGala, xGala.length);

        // Arm
        g.setColor(globalColor);
        int [] xArm = {305, 305, 317, 341, 341, 317, 317};
        xArm = batchAddPoly(xArm, x);
        int [] yArm = {120, 155, 165, 132, 122, 143, 120};
        g.fillPolygon(xArm, yArm, xArm.length);

        // Hand
        g.setColor(camelColor);
        g.fillOval(341 + x, 121, 13, 13);

        // Feet
        g.setColor(globalColor);
            //// Left Feet
            int [] xLegL = {295, 295, 315, 315, 305, 305};
            xLegL = batchAddPoly(xLegL, x + b);
            int [] yLegL = {265, 285, 285, 275, 275, 265};
            g.fillPolygon(xLegL, yLegL, xLegL.length);
            //// Right Feet
            int [] xLegR = {320, 320, 340, 340, 330, 330};
            xLegR = batchAddPoly(xLegR, x - b);
            int [] yLegR = yLegL;
            g.fillPolygon(xLegR, yLegR, xLegR.length);
    }

    public void drawCamel(Graphics g, int x) {
        g.setColor(camelColor);
        
        // Hump
        g.fillArc(25 + x, 45, 150, 140, 0, 180);

        // Butt and under hump
        int [] xButt = {26,  175, 175, 166, 26,  15};
        xButt = batchAddPoly(xButt, x);
        int [] yButt = {110, 110, 140, 158, 155, 135};
        g.fillPolygon(xButt, yButt, xButt.length);

        // Neck and ears
        int [] xNeck = {175, 220, 225, 230, 235, 240, 240, 220, 175};
        xNeck = batchAddPoly(xNeck, x);
        int [] yNeck = {110, 55,  35,  55,  35,  55,  75,  75,  140};
        g.fillPolygon(xNeck, yNeck, xNeck.length);

        // Head
        g.fillArc(218 + x, 55, 45, 20, 90, -180);
        
        // Belly
        g.fillArc(65 + x, 130, 65, 45, 180, 180);

        // Tail
        g.drawLine(15 + x, 135, 15 + x, 210);
        
        // Legs
        drawCamelLeg(g, 0,   0,  0, b);
        drawCamelLeg(g, 20,  5,  0, -b);
        drawCamelLeg(g, 99,  0,  0, b);
        drawCamelLeg(g, 119, 5, -4, -b);
        
        // Eye
        g.setColor(globalColor);
        g.fillOval(230 + x, 55, 11, 11);
    }

    public void drawCamelLeg(Graphics g, int legShift, int feetShift, int lastPoint, int legMover) {
        int [] xLeg = {26,  32,  32,  54,  54,  45,  45};
        xLeg = batchAddPoly(xLeg, x);
        int [] yLeg = {155, 275, 285, 285, 275, 275, 155};

        // Apply shift to x cords of each leg
        for (int i = 0; i < xLeg.length; i++){
            // Feet shift starts after first cord
            // to leave a space between feets
            xLeg[i] += (i > 0) ? feetShift + legShift : legShift;

            // Apply mover to legs
            xLeg[i] += (i > 0 && i < xLeg.length - 1) ? legMover : 0;
        }

        // Correct last point for 4th leg
        xLeg[xLeg.length - 1] += lastPoint;

        g.fillPolygon(xLeg, yLeg, xLeg.length);
    }

    public void drawHouse(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(1212, 37, 295, 250);
        g.setColor(Color.BLUE);
        g.fillRect(1212, 50, 295, 40);
        g.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        g.setColor(Color.WHITE);
        g.drawString(TEXT[5], 1230, 82);
        g.setColor(Color.BLUE);
        g.drawString(TEXT[6], 1330, 132);
        g.drawString(TEXT[7], 1340, 172);
        g.drawString(TEXT[8], 1330, 212);
    }
    /*
        Convert hex to RGB
    */
    public Color hexColor(String hexStr) {
        return new Color(Integer.valueOf(hexStr, 16));
    }
    /*
        Add a single value to each item in poly array
    */
    public int [] batchAddPoly(int [] poly, int fill) {
        for (int i = 0; i < poly.length; i++) {
            poly[i] += fill;
        }
        return poly;
    }
}