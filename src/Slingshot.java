import edu.macalester.graphics.Line;
import edu.macalester.graphics.Point;

public class Slingshot {
    // just create the base of the slingshot, Rope.java will have the code to move the rope 
    // at the end of the slingshot with the user's mouse
    public static final double SLINGSHOT_LENGTH = 50;
    private final Line line;

    public Slingshot(double centerX, double centerY) {
        line = new Line(centerX, centerY, 0, 0);
        
    }

}
