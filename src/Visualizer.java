import cs251.lab2.Display;

/**
 * @author Michael Servilla
 * @version date 2017-01-28
 */
public class Visualizer {

    public static final int POINT_SIZE = 5; /** Size of dots. */

    public static void main(String[] args) {
        Display myDisplay = new Display(500, POINT_SIZE);



        SquareBox.drawSquareBox(myDisplay, 0, myDisplay.getHeight(),
                0, myDisplay.getWidth());


        int[] location = {0, myDisplay.getHeight(),
                0, myDisplay.getWidth()};

//        InAndOutBox.drawInBox(myDisplay, location);

    }
}