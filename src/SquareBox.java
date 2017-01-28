import cs251.lab2.Display;
/**
 * @author Michael Servilla
 * @version date 2017-01-28
 */
public class SquareBox {
//    private static final int POINT_SIZE = 5; /** Size of dots. */


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
}