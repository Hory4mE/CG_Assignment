// Image ref : https://chatsticker.com/sticker/rabbo-the-muscle-rabbit-1/3542558
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Bunny extends JFrame{

    public static void main(String[] args) {
        Lab3 tools = new Lab3();
        Bunny Bunny = new Bunny();
        Bunny.add(tools);
        Bunny.setSize(620, 620);
        Bunny.setTitle("Bezier & Polygon & FloodFill");
        Bunny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bunny.setVisible(true);

        
    }
}

class Lab3 extends JPanel {

    public void paintComponent(Graphics g) {

        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        // Background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        

        g2.setColor(Color.BLACK); // draft Color
        //head
        int xPoly[] = {100,92,82,78,77,77,78,80,83,83,75,69,59,56,55,58,62,71,75,79,84,88,91,94,96,97,98,104,114,123,127,141,145,149,150,153,158,163,166,175,178,186,190,192,192,190,188,189,192,195,196,198,198,197,197,196,195,193,192,190,187,183,181,178,176,173,169,163,154,150,131,126,118,115,112,109,105,102,100};
        int yPoly[] = {371,364,350,339,334,321,318,309,301,299,291,283,263,251,242,235,230,230,233,237,244,251,260,269,276,282,282,276,271,267,265,265,265,268,269,262,258,255,254,254,256,264,270,273,284,288,293,296,301,309,313,316,330,331,336,337,339,344,347,350,354,358,362,364,366,368,371,374,378,379,380,380,379,378,377,375,373,372,371};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(poly);
        //neck
        bresenhamLine(g2,3, 196, 360, 191, 343);
        bezierPaint(g2,3, 191,360,192,361,195,361,196,360);
        //left arm
        bezierPaint(g2,3, 196,365,230,335,261,333,286,362);
        bezierPaint(g2, 3, 285,362,305,355,328,371,339,384); // linked with Left Leg
        bezierPaint(g2, 3, 339,384,354,401,359,431,345,449);
        bresenhamLine(g2,3, 345,449,320,481);
        bezierPaint(g2, 2,253,388,263,395,271,405,276,413);
        bezierPaint(g2, 2,285,405,275,414,270,432,268,450);
        bezierPaint(g2, 2,268,450,269,476,266,510,269,513);
        //left hand
        bezierPaint(g2, 3,320,481,311,493,310,508,317,516);
        bezierPaint(g2, 3,317,516,320,520,320,526,313,530);
        bezierPaint(g2, 3, 313,530,311,532,315,535,314,541);
        bezierPaint(g2, 3, 314,541,317,541,319,543,321,545);
        bezierPaint(g2, 3, 313,562,314,563,314,566,313,567);
        bezierPaint(g2, 3, 313,568,309,567,308,566,308,562);
        bresenhamLine(g2,3, 308,562,305,562);
        bresenhamLine(g2,3, 305,562,290,571);
        bresenhamLine(g2,3, 290,571,286,567);
        bezierPaint(g2, 3, 286,567,285,571,283,572,278,570);
        bezierPaint(g2, 3, 278,570,266,562,264,565,259,565); // End Left hand
        //Body
        bezierPaint(g2, 3, 259,565,229,565,226,564,223,560);
        bezierPaint(g2, 3, 223,560,219,559,219,561,221,563);
        bezierPaint(g2, 3, 221,563,221,567,206,577,202,575);
        bezierPaint(g2, 3, 202,575,201,582,177,582,177,574);
        bezierPaint(g2, 3, 177,573,156,573,147,570,141,570);
        bezierPaint(g2, 3, 141,569,121,569,106,572,89,578);
        bezierPaint(g2, 3, 89,578,78,579,71,576,63,576);
        bezierPaint(g2, 3, 63,576,49,573,41,568,32,567);
        bezierPaint(g2, 3, 32,566,30,562,30,552,32,549);
        bezierPaint(g2, 3, 31,548,31,521,33,518,33,517);
        bezierPaint(g2, 3, 30,518,23,499,23,480,29,466);
        bezierPaint(g2, 3,26,467,13,445,19,417,40,390);
        bezierPaint(g2, 3, 40,390,57,381,72,380,79,383);
        //brest muscle
        bezierPaint(g2, 2, 198,364,206,367,216,372,222,378);
        bezierPaint(g2, 2, 222,388,210,398,193,413,193,417);
        bezierPaint(g2, 2, 184,423,175,416,175,416,162,415);
        bezierPaint(g2, 2, 162,415,136,411,119,408,116,408);
        bezierPaint(g2, 2,116,408,108,408,103,403,98,398);
        bresenhamLine(g2,2,87,393,80,383);
        bezierPaint(g2, 2, 87,412,81,417,76,423,72,429);
        bezierPaint(g2, 2,95,472,109,482,120,490,130,497);
        bezierPaint(g2, 2, 111,483,104,484,101,489,102,499);
        bezierPaint(g2, 2, 102,499,110,508,113,510,117,511);
        bezierPaint(g2, 2, 117,511,124,515,135,516,141,515);
        bresenhamLine(g2, 2,140,516,146,522);
        bezierPaint(g2, 2, 141,515,147,513,153,517,159,520);
        bezierPaint(g2, 2,105,504,106,509,117,520,122,522);
        bezierPaint(g2, 2, 122,522,123,526,138,528,142,534);
        bezierPaint(g2, 2, 194,432,204,446,209,455,213,468);
        bezierPaint(g2, 2,213,468,215,474,204,485,184,497);
        bezierPaint(g2, 2,184,497,167,502,150,501,141,497);
        bezierPaint(g2, 2,186,506,198,515,210,515,238,496);
        bezierPaint(g2, 2, 200,438,209,447,216,457,222,469);
        bezierPaint(g2, 2,228,469,234,472,245,466,268,446);
        bezierPaint(g2, 3, 79,383,85,375,94,374,104,373);
        bezierPaint(g2, 2,237,528,247,527,254,518,260,509);
        bezierPaint(g2, 2,246,490,252,490,262,480,268,475);
        bezierPaint(g2, 2, 269,513,266,517,266,539,266,563);
        bezierPaint(g2, 2,229,480,242,489,254,491,258,499);
        bezierPaint(g2, 2, 230,382,232,381,233,379,235,379);
        bezierPaint(g2, 2,246,379,254,372,268,367,285,365);
        bezierPaint(g2, 2,227,542,233,538,241,535,245,535);
        bresenhamLine(g2, 2, 251,533,259,527);
        //left arm muscle line
        bezierPaint(g2, 2, 315,395,304,400,296,406,291,413);
        bezierPaint(g2, 2, 287,435,285,451,288,470,295,496);
        bezierPaint(g2, 2, 281,469,276,478,273,486,274,499);
        //left hand line
        bezierPaint(g2, 2, 276,552,282,561,285,565,288,569);
        bezierPaint(g2, 2,306,561,303,558,300,554,298,550);
        //right hand line
        bezierPaint(g2, 2,220,561,218,558,215,555,211,553);
        bezierPaint(g2, 2,202,578,202,571,199,567,194,562);
        //right arm line
        bezierPaint(g2, 2,73,558,78,553,86,552,91,553);
        bezierPaint(g2, 2, 96,552,109,551,128,552,137,556);
        bezierPaint(g2, 2, 71,437,77,446,75,449,65,445);
        bezierPaint(g2, 2,65,445,61,446,57,448,55,450);
        //right leg line
        bezierPaint(g2, 2,334,529,340,533,344,535,350,535);
        bezierPaint(g2, 2, 381,537,399,531,419,517,429,508);
        bezierPaint(g2, 2, 351,570,344,567,337,564,334,559);
        bezierPaint(g2, 2,385,551,402,551,415,554,430,560);
        bezierPaint(g2, 2,435,556,431,552,427,549,423,548);
        bezierPaint(g2, 2, 423,531,425,528,429,524,435,522);
        bezierPaint(g2, 2,444,559,438,553,437,539,441,532);
        bezierPaint(g2, 2, 437,565,448,557,455,551,457,549);
        bezierPaint(g2, 2,457,549,467,540,467,534,452,522);
        bezierPaint(g2, 2,572,542,570,544,566,544,563,543);
        bezierPaint(g2, 2,571,554,569,555,560,555,559,554);
        bezierPaint(g2, 2, 360,405,375,396,388,392,403,393);
        //left leg line
        bezierPaint(g2, 2, 403,393,414,407,418,432,414,441);
        bezierPaint(g2, 2,400,392,401,389,404,386,405,386);
        bezierPaint(g2, 2, 412,391,421,402,425,405,438,393);
        bezierPaint(g2, 2,442,390,446,393,449,393,456,385);
        bezierPaint(g2, 2,451,409,465,421,477,461,454,465);
        bezierPaint(g2, 2,513,517,517,514,521,510,526,509);
        //fill shadow brest (100,508)
        // int xPolyFillbrest[] = {98,109,103,102,101,101,102,106,105,109,121,123,117,113,110,106,99,95,93,89,92,94,96,97,97,94,92,99,99,98};
        // int yPolyFillBrest[] = {474,482,484,487,488,498,500,504,508,512,522,526,527,525,523,520,514,510,508,505,505,506,504,501,475,471,466,473,473,474};
        // g2.setColor(new Color(255,148,148));
        // g2.fillPolygon(xPolyFillbrest, yPolyFillBrest, xPolyFillbrest.length);
        //end of fill shadow brest
        
        //fill underpant
        // floodFill(buffer, 327, 497, Color.white, new Color(255,148,148));
        //Right arm
        bezierPaint(g2, 2, 224,558,224,552,216,544,170,531);
        bezierPaint(g2, 2, 169,531,162,531,168,522,153,532);
        bresenhamLine(g2,2, 151,532,125,530);
        bezierPaint(g2, 2, 129,532,106,524,87,500,68,499);
        bezierPaint(g2, 2, 97,514,98,504,98,479,96,471);
        bezierPaint(g2, 2, 96,471,94,465,83,454,74,447);
        //left leg
        int xPolyLeftLeg[] = {339,342,357,373,389,395,400,413,419,423,428,433,440,443,444,459,464,471,476,483,490,491,491,497,504,517,530,537,539,577,582,583,577,575,575,574,573,573,574,575,575,574,563,553,539,521,512,498,486,473,466,460,456,451,456,441,439,437,435,432,430,427,424,424,422,420,417,416,414,413,412,411,410,409,408,407,406,403,399,391,382,374,364,360,354,346,343,345,351,352,352,353,352,342,339};
        int yPolyLeftLeg[] = {384,384,374,363,356,353,350,351,347,344,344,342,342,345,347,359,360,367,372,383,396,403,407,421,437,461,487,498,504,528,535,549,552,550,546,545,544,542,540,538,536,534,527,524,523,522,516,509,501,492,483,474,470,471,468,468,467,466,466,465,463,460,456,454,450,444,441,439,443,446,449,453,457,460,463,467,468,473,477,482,486,488,488,482,474,464,456,450,438,426,411,404,396,389,384};
        poly = new Polygon(xPolyLeftLeg, yPolyLeftLeg, xPolyLeftLeg.length);
        g2.drawPolygon(poly);
        //right leg
        int xPolyRightLeg[] = {361,372,386,401,407,409,413,414,416,419,422,425,430,432,437,444,451,452,465,469,472,475,500,502,504,506,510,515,516,522,527,539,555,565,573,574,574,573,572,569,570,572,574,575,575,572,570,571,571,569,566,516,512,507,506,501,485,474,469,462,460,453,444,438,437,433,428,417,411,406,400,358,356,350,343,336,329,324,319,316,316,316,315,322,323,322,323,323,325,326,328,329,331,337,339,343,347,349,352,353,356,358,359,361};
        int yPolyRightLeg[] = {491,488,485,485,486,488,488,489,491,491,494,496,500,500,495,491,490,489,489,490,493,494,511,512,513,514,516,519,520,524,524,524,525,528,534,536,540,541,542,543,544,545,547,548,553,554,555,556,558,560,561,564,564,564,561,561,568,568,569,570,571,573,572,570,567,569,571,571,572,572,573,574,573,572,573,571,571,569,569,568,565,563,562,555,554,542,541,540,537,535,532,530,526,520,517,512,509,505,501,501,497,494,493,491};
        poly = new Polygon(xPolyRightLeg, yPolyRightLeg, xPolyRightLeg.length);
        g2.drawPolygon(poly);


        // buffer = floodFill(buffer, 200, 400, Color.WHITE, Color.cyan);
        g.drawImage(buffer, 0, 0, null);
    }

    public void bezierPaint(Graphics g,int size, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // plotPoint(g, x1, y1, x2, y2, x3, y3, x4, y4); !! -- open me if you want the point of line --!!
        g.setColor(Color.BLACK);
        for (double t = 0; t <= 1; t += 0.001) {
            double xt = (Math.pow((1 - t), 3)) * x1 + (3 * t) * (Math.pow((1 - t), 2)) * x2
                    + 3 * (Math.pow(t, 2)) * (1 - t) * x3 + (Math.pow(t, 3)) * x4;
            double yt = (Math.pow((1 - t), 3)) * y1 + (3 * t) * (Math.pow((1 - t), 2)) * y2
                    + 3 * (Math.pow(t, 2)) * (1 - t) * y3 + (Math.pow(t, 3)) * y4;
            plot(g, (int) Math.round(xt), (int) Math.round(yt), size, size);
        }
    }
    public void bresenhamLine(Graphics g,int size, int x1,int y1,int x2, int y2){
        double dx = Math.abs(x2-x1);
        double dy = Math.abs(y2-y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;
        if(dy > dx){
            double tmp = dx;
            dx = dy;
            dy = tmp;
            isSwap = true;
        }
        double D = 2*dy-dx;
        double x=x1,y=y1;
        for(int i = 1;i < dx;i++){
            plot(g, (int) x,(int) y,size,size);
            if(D >= 0){
                if(isSwap)x+=sx;
                else y+=sy;

                D -= 2*dx;
            }
            if(isSwap)y+=sy;
            else x+=sx;
                D += 2*dy;
        }
    }

    public void plotPoint(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        g.setColor(Color.red);
        plot(g, x1, y1, 5, 5);
        plot(g, x2, y2, 5, 5);
        plot(g, x3, y3, 5, 5);
        plot(g, x4, y4, 5, 5);
        g.setColor(Color.BLACK);
    }

    public void plot(Graphics g, int x, int y, int w, int h) {
        g.fillRect(x, y, w, h);
    }

    public BufferedImage floodFill(BufferedImage bf, int x, int y, Color target_colour, Color replacement_colour) {
        Queue<Point> queue = new LinkedList<Point>();
        Graphics2D g3 = bf.createGraphics();

        if (bf.getRGB(x, y) == target_colour.getRGB()) {
            g3.setColor(replacement_colour);
            plot(g3, x, y, 1, 1);
            queue.add(new Point(x, y));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // south
            if (p.y < 600 && bf.getRGB(p.x, p.y + 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y + 1, 1, 1);
                queue.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && bf.getRGB(p.x, p.y - 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y - 1, 1, 1);
                queue.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && bf.getRGB(p.x + 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x + 1, p.y, 1, 1);
                queue.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && bf.getRGB(p.x - 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x - 1, p.y, 1, 1);
                queue.add(new Point(p.x - 1, p.y));
            }
        }
        return bf;
    }
}