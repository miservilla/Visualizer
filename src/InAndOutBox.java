import cs251.lab2.Display;

/**
 * @author Michael Servilla
 * @version date 2017-01-28
 */
public class InAndOutBox {


    public static void drawInBox(Display myDisplay, int[] location) {
        int yTop = location[0];
        int yBottom = location[1];
        int xLeft = location[2];
        int xRight = location[3];

        while (xRight > 0){
            SquareBox.drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
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
            SquareBox.drawSquareBox(myDisplay, yTop, yBottom, xLeft, xRight);
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