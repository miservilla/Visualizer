import cs251.lab2.Display;

import java.util.Scanner;

/**
 * @author Michael Servilla
 * @version date 2017-01-28
 */
public class Visualizer {

    public static final int POINT_SIZE = 5; /** Size of dots. */

    public static void main(String[] args) {
        Display myDisplay = new Display(50, POINT_SIZE);
        int[] location = {0, myDisplay.getHeight(),0 , myDisplay.getWidth()};
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter:");
        System.out.println("1 for 'Draw a square box.'");
        System.out.println("2 for 'Circle on a circle.'");
        System.out.println("3 for 'In and out box.'");
        int in = input.nextInt();
        switch (in){
            case 1: drawSquareBox(myDisplay, 0,
                    myDisplay.getHeight(), 0, myDisplay.getWidth());
                    break;
            case 2: drawCircleCircle(myDisplay);
                    break;
            case 3: drawInBox(myDisplay, location);
        }

    }
    public static void drawSquareBox(Display myDisplay, int yTop,
                                     int yBottom, int xLeft, int xRight) {
        int y = yTop;
        for (int x = xLeft; x < xRight; x += Visualizer.POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        int x = xRight;
        for (y = yTop; y < yBottom; y += Visualizer.POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        y = yBottom;
        for (x = xRight; x >= xLeft; x -= Visualizer.POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        x = xLeft;
        for (y = yBottom; y > yTop; y -= Visualizer.POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
    }
    public static void drawCircleCircle(Display myDisplay) {
        int centerXIC = myDisplay.getWidth() / 2;
        int centerXOC;
        int centerYIC = myDisplay.getHeight() / 2;
        int centerYOC;

        // Draw a circle starting at the top and going clock wise
        double degAngIC = 270;
        double degAngOC = 270;
        double radiusIC = 120;
        double radiusOC = 50;
        double xIC, xOC, yIC, yOC, radAngIC, radAngOC;
        while ( true ) {
            radAngIC = (degAngIC * Math.PI) / 180;
            xIC = centerXIC + radiusIC * Math.cos(radAngIC);
            yIC = centerYIC + radiusIC * Math.sin(radAngIC);
            myDisplay.drawNextPoint((int) xIC, (int) yIC);
            centerXOC = (int) xIC;
            centerYOC = (int) yIC;
            degAngIC += 0.15;
            radAngOC = (degAngOC * Math.PI) / 180;
            xOC = centerXOC + radiusOC * Math.cos(radAngOC);
            yOC = centerYOC + radiusOC * Math.sin(radAngOC);
            myDisplay.drawNextPoint((int) xOC, (int) yOC);
            degAngOC += 3;
        }
    }
    public static void drawInBox(Display myDisplay, int[] location) {
        int yTop = location[0];
        int yBottom = location[1];
        int xLeft = location[2];
        int xRight = location[3];

        while (xRight > 0){
            drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
            yTop += Visualizer.POINT_SIZE;
            yBottom -= Visualizer.POINT_SIZE;
            xLeft += Visualizer.POINT_SIZE;
            xRight -= Visualizer.POINT_SIZE;
        }
        location[0] = yTop;
        location[1] = yBottom;
        location[2] = xLeft;
        location[3] = xRight;
        drawOutBox(myDisplay, location);
    }
    public static void drawOutBox(Display myDisplay, int[] location){
        int yTop = location[0];
        int yBottom = location[1];
        int xLeft = location[2];
        int xRight = location[3];

        while (xLeft > 0){
            drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
            yTop -= Visualizer.POINT_SIZE;
            yBottom += Visualizer.POINT_SIZE;
            xLeft -= Visualizer.POINT_SIZE;
            xRight += Visualizer.POINT_SIZE;
        }
        location[0] = yTop;
        location[1] = yBottom;
        location[2] = xLeft;
        location[3] = xRight;

        drawInBox(myDisplay, location);
    }


}