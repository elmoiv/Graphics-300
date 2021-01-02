/*
    @description:   Drawing Sonic using java Applet
    @author:        Khaled Hassan El-Morshedy
    @profile:       www.github.com/elmoiv
    @date:          31-12-2020
*/

import java.awt.*;
import java.applet.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Sonic extends Applet {

    public void init() {
        this.setSize(638, 634);
    }

    Color sky = hexColor("96c3ff");
    Color black = hexColor("000000");
    Color grass1 = hexColor("80e000");
    Color grass2 = hexColor("40a000");
    Color brick1 = hexColor("c06000");
    Color brick2 = hexColor("602000");
    Color sonicEye = hexColor("ffffff");
    Color sonicSkin = hexColor("f0b090");
    Color sonicBlue1 = hexColor("0169ee");
    Color sonicBlue2 = hexColor("0c39a9");
    Color sonicShoe1 = hexColor("de0103");
    Color sonicShoe2 = hexColor("830606");
    Color sonicGlove1 = hexColor("f1f2f3");
    Color sonicGlove2 = hexColor("a4dedf");
    Color sonicGlove3 = hexColor("6a9fab");
    Color sonicShoeBand1 = hexColor("ecf1f3");
    Color sonicShoeBand2 = hexColor("a6dedf");
    Color sonicShoeBandline1 = hexColor("addbdc");
    Color sonicShoeBandline2 = hexColor("62a1b6");

    public void paint(Graphics g) {
        setBackground(sky);
        brickDrawer(g);
        //grassDrawer(g);
        sonicDrawer(g);
        
    }
    /*
        Draw Sonic
    */
    public void sonicDrawer(Graphics g) {
        // Horns
        hornDrawer(g, 150, 73,  140, 112, 445, 166, 251);
        hornDrawer(g, 131, 139, 110, 181, 456, 222, 251);
        hornDrawer(g, 176, 197, 171, 256, 369, 262, 180);
        hornDrawer(g, 231, 251, 223, 333, 404, 243, 165);
        
        // Draw Grass after horns to cover remainents of horns process
        grassDrawer(g);
        
        // Shoes
        sonicShoe(g, 0, 1);
        sonicShoe(g, -65, 0);
        
        // Gloves
            //// Front Glove
            gloveDrawer(g, 367, 301, 40, 64, 28, sonicGlove2);
        
        // Legs
            //// Back Leg
            g.setColor(sonicBlue2);
            g.fillRect(327, 332, 23, 60);
            //// Front Leg
            int [] legX = {287, 309, 294, 270};
            int [] legY = {332, 332, 392, 392};
            g.setColor(sonicBlue1);
            g.fillPolygon(legX, legY, legX.length);

        // Belly
        g.fillOval(286, 255, 85, 85);
            //// Sub Belly
            g.setColor(sonicSkin);
            g.fillOval(306, 255, 64, 64);
        
        // Arm
        int [] armX = {305, 244, 244, 261, 265, 254, 296};
        int [] armY = {266, 296, 328, 339, 319, 307, 285};
        g.fillPolygon(armX, armY, armX.length);

        // Gloves
            //// Front Glove
            gloveDrawer(g, 292, 301, 40, 64, 28, sonicGlove1);
            g.setColor(sonicGlove3);
            g.fillOval(299, 312, 12, 12);

        // Glove wrest
        g.setColor(sonicGlove1);
        g.fillRect(259, 317, 18, 44);
        // Glove wrest line
        g.setColor(sonicGlove3);
        g.fillRoundRect(276, 314, 6, 49, 4, 4);
        
        
        // Head
            //// Back Ear
            g.setColor(sonicBlue2);
            int [] earBX = {391, 391, 356};
            int [] earBY = {139, 74,  109};
            g.fillPolygon(earBX, earBY, earBX.length);
            //// Chin color same size as blue oval
            g.setColor(sonicSkin);
            g.fillArc(232, 93, 170, 170, 0, 360);
            //// Blue Head with partial arc to reveal chin under
            g.setColor(sonicBlue1);
            g.fillArc(232, 93, 170, 170, -21, 275);
            g.fillRect(305, 175, 90, 37);
            g.drawOval(232, 93, 170, 170);
            g.setColor(sonicSkin);
            //// Front Ear
            g.setColor(sonicBlue2);
            int [] earFX = {306, 264, 253};
            int [] earFY = {106, 74,  127};
            g.fillPolygon(earFX, earFY, earFX.length);
            //// Left Chin part
            g.setColor(sonicSkin);
            int [] chinX = {317, 295, 276, 295};
            int [] chinY = {212, 212, 223, 261};
            g.fillPolygon(chinX, chinY, chinX.length);
            //// Front Ear skin color
            int [] earFFX = {269, 305, 259};
            int [] earFFY = {85,  111, 128};
            g.fillPolygon(earFFX, earFFY, earFFX.length);
            //// Eye white
            g.setColor(sonicEye);
            int [] eyeX = {336, 317, 317, 338, 381, 399, 401};
            int [] eyeY = {138, 148, 201, 222, 211, 216, 147};
            g.fillPolygon(eyeX, eyeY, eyeX.length);
            //// Eye Black
            g.setColor(black);
            g.fillOval(353, 155, 12, 47);
            g.fillOval(379, 155, 12, 47);
            //// Brows Blue
            g.setColor(sonicBlue1);
            int [] browX = {330, 380, 402};
            int [] browY = {129, 191, 137};
            g.fillPolygon(browX, browY, browX.length);
            //// Nose
            g.setColor(black);
            int [] noseX = {379, 401, 411, 411};
            int [] noseY = {222, 222, 217, 201};
            g.fillPolygon(noseX, noseY, noseX.length);
        
            
        
    }
    public void sonicShoe(Graphics g, int shift, int colorChoice) {
        Color [][] shoePalette = {
            {sonicShoeBand1, sonicShoe1, sonicShoeBandline1},
            {sonicShoeBand2, sonicShoe2, sonicShoeBandline2}
        };
        
        // Shoe body
        int [] shoeX = {318, 308, 308, 443, 362};
        int [] shoeY = {412, 433, 465, 465, 412};
        shoeX = batchAddPoly(shoeX, shift);
        g.setColor(shoePalette[colorChoice][1]);
        g.fillPolygon(shoeX, shoeY, shoeX.length);
        
        // Shoe Band
        int [] bandX = {370, 350, 330, 361, 392};
        int [] bandY = {415, 435, 465, 465, 429};
        bandX = batchAddPoly(bandX, shift);
        g.setColor(shoePalette[colorChoice][0]);
        g.fillPolygon(bandX, bandY, bandX.length);

        // Shoe Neck
        g.fillRect(318 + shift, 391, 45, 22);
            //// Neck line
            g.setColor(shoePalette[colorChoice][2]);
            g.fillRoundRect(316 + shift, 399, 49, 6, 4, 4);
    }
    /*
        Draw chess colored bricks
    */
    public void brickDrawer(Graphics g) {
        Color[] bricks = {brick2, brick1};
        // Row count
        for (int j = 0; j < 11; j++) {

            // Swap for next row
            Color tmp = bricks[0];
            bricks[0] = bricks[1];
            bricks[1] = tmp;

            // In Row bricks
            for (int i = 0; i < 31; i++) {
                g.setColor(bricks[i % 2]);
                g.fillRect(64 * i, 444 + 64 * j, 64, 64);
            }
        }
    }
    /*
        Draw grass over upper bricks  
    */
    public void grassDrawer(Graphics g) {
        Color[] grass = {grass1, grass2};

        // Grass Polygon cords
        int[] grassX = {0,   32,  32,  16,  0};
        int[] grassY = {422, 422, 493, 523, 493};

        // Ground Row
        for (int i = 0; i < 62; i++) {
            g.setColor(grass[i % 2]);
            g.fillPolygon(grassX, grassY, grassX.length);

            // Next grass location
            grassX = batchAddPoly(grassX, 32);
        }
    }
    /*
        Draw rotated oval shaped glove using Graphics2D
    */
    public void gloveDrawer(Graphics g, int x, int y, int w ,int h, int angle, Color c) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D e = new Ellipse2D.Double(0, 0, w, h);
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(angle));
        g2.setColor(c);
        g2.fill(at.createTransformedShape(e));
    }
    /*
        Get Sonic Horns by angle
    */
    public void hornDrawer(Graphics g, int x, int y, int x1, int y1, int x2, int y2, int size) {
        // Draw Horn full circle
        g.setColor(sonicBlue1);
        g.fillOval(x, y, size, size);
        
        // Cut with angle with sky color to show it
        // as if it is really rotated
        g.setColor(sky);
        int [] X = {x1, x2, x2, x1};
        int [] Y = {y1, y2, y2 + size - size / 6, y1 + size - size / 6};
        g.fillPolygon(X, Y, X.length);
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