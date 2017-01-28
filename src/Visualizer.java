import cs251.lab2.Display;

import java.util.Scanner;

/**
 * @author Michael Servilla
 * @version date 2017-01-28
 * A program that utilizes a jar file Display with code to make visual graphical
 * designs (Square box, circle on a circle, and in and out box).
 */
public class Visualizer {

    public static final int POINT_SIZE = 5; //Sets cursor size.

    public static void main(String[] args) {
        Display myDisplay = new Display(500, POINT_SIZE);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter:");
        System.out.println("1 for 'Draw a square box.'");
        System.out.println("2 for 'Circle on a circle.'");
        System.out.println("3 for 'In and out box.'");
        int in = input.nextInt();

        //Asks user which graphical design they would like.
        switch (in){
            case 1: drawSquareBox(myDisplay, 0,
                    myDisplay.getHeight(), 0, myDisplay.getWidth());
                    break;
            case 2: drawCircleCircle(myDisplay);
                    break;
            case 3: drawInBox(myDisplay, 0,
                    myDisplay.getHeight(), 0, myDisplay.getWidth());
        }

    }
    /**
     * Method to draw a square box starting from upper left corner (0, 0),
     * going clockwise, one iteration.
     * @param myDisplay Object created to host graphical interface.
     * @param yTop Vertical top location.
     * @param yBottom Vertical bottom location.
     * @param xLeft Horizontal left location.
     * @param xRight Horizontal right location.
     */
    public static void drawSquareBox(Display myDisplay, int yTop,
                                     int yBottom, int xLeft, int xRight) {
        //Draws top left to right.
        int y = yTop;
        for (int x = xLeft; x < xRight; x += POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        //Draws top right to bottom.
        int x = xRight;
        for (y = yTop; y < yBottom; y += POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        //Draws bottom right to left.
        y = yBottom;
        for (x = xRight; x > xLeft; x -= POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
        //Draws bottom left to top.
        x = xLeft;
        for (y = yBottom; y > yTop; y -= POINT_SIZE) {
            myDisplay.drawNextPoint(x, y);
        }
    }
    /**
     * Method to draw an outer circle rotating around the radius of an inner
     * circle, infinite iterations.
     * @param myDisplay Object created to host graphical interface.
     */
    public static void drawCircleCircle(Display myDisplay) {
        int centerXIC = myDisplay.getWidth() / 2;
        int centerXOC;
        int centerYIC = myDisplay.getHeight() / 2;
        int centerYOC;

        //Draw a circle starting at the top and going clock wise, original
        //code from class 251 example.
        double degAngIC = 270; //Degree angle inner circle (IC).
        double degAngOC = 270; //Degree angle outer circle (OC).
        double radiusIC = 120; //Radius inner circle.
        double radiusOC = 50; //Radius outer circle.
        double xIC, xOC, yIC, yOC, radAngIC, radAngOC;
        while ( true ) {
            radAngIC = (degAngIC * Math.PI) / 180;
            //Determines P(x, y) coordinates of the inner circle.
            xIC = centerXIC + radiusIC * Math.cos(radAngIC);
            yIC = centerYIC + radiusIC * Math.sin(radAngIC);
            myDisplay.drawNextPoint((int) xIC, (int) yIC);
            centerXOC = (int) xIC;
            centerYOC = (int) yIC;
            degAngIC += 0.15; //Decrement allows circle to rotate
            //counterclockwise. Increment allows circle to rotate clockwise.
            radAngOC = (degAngOC * Math.PI) / 180;
            //Determines the P(x, y) coordinates of the outer circle.
            xOC = centerXOC + radiusOC * Math.cos(radAngOC);
            yOC = centerYOC + radiusOC * Math.sin(radAngOC);
            myDisplay.drawNextPoint((int) xOC, (int) yOC);
            degAngOC -= 3; //Decrement allows circle to rotate
            //counterclockwise. Increment allows circle to rotate clockwise.
        }
    }
    /**
     * Method to increment drawSquareBox coordinates, recursive between
     * drawInBox and drawOutBox.
     * @param myDisplay Object created to host graphical interface.
     * @param yTop Vertical top location.
     * @param yBottom Vertical bottom location.
     * @param xLeft Horizontal left location.
     * @param xRight Horizontal right location.
     */
    public static void drawInBox(Display myDisplay, int yTop,
                                 int yBottom, int xLeft, int xRight) {

        while (xRight > 0){
            drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
            yTop += POINT_SIZE;
            yBottom -= POINT_SIZE;
            xLeft += POINT_SIZE;
            xRight -= POINT_SIZE;
        }
        drawOutBox(myDisplay, yTop, yBottom, xLeft, xRight);
    }
    /**
     * Method to increment drawSquareBox coordinates, recursive between
     * drawInBox and drawOutBox.
     * @param myDisplay Object created to host graphical interface.
     * @param yTop Vertical top location.
     * @param yBottom Vertical bottom location.
     * @param xLeft Horizontal left location.
     * @param xRight Horizontal right location.
     */
    public static void drawOutBox(Display myDisplay, int yTop,
                                  int yBottom, int xLeft, int xRight){

        while (xLeft > 0){
            drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
            yTop -= POINT_SIZE;
            yBottom += POINT_SIZE;
            xLeft -= POINT_SIZE;
            xRight += POINT_SIZE;
        }
        drawInBox(myDisplay, yTop, yBottom, xLeft, xRight);
    }
}