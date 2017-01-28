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
            case 1: SquareBox.drawSquareBox(myDisplay, 0,
                    myDisplay.getHeight(), 0, myDisplay.getWidth());
                    break;
            case 2: CircleCircle.drawCircleCircle(myDisplay);
                    break;
            case 3: InAndOutBox.drawInBox(myDisplay, location);
        }

    }
}