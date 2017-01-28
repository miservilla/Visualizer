import cs251.lab2.Display;
/**
 * @author Michael Servilla
 * @version date 2017-01-28
 */
public class CircleCircle {
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
}
