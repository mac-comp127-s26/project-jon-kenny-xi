import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.Point;
import java.awt.Color;

public class Slingshot {
    private Point anchor;
    private Line rope;
    private CanvasWindow canvas;
    private double maxDrag = 100; // How far you can pull back

    public Slingshot(CanvasWindow canvas, double x, double y) {
        this.canvas = canvas;
        this.anchor = new Point(x, y);
        
        rope = new Line(x, y, x, y);
        rope.setStrokeWidth(3);
        rope.setStrokeColor(new Color(101, 67, 33));

        Line frame = new Line(x, y, x, y + 60);
        frame.setStrokeWidth(8);
        canvas.add(frame);
    }

    public void updateRope(Point birdPos) {
        rope.setEndPosition(birdPos);

        if (rope.getCanvas() == null) {
            canvas.add(rope);
        }
    }

    public void hideRope() {
        if (rope.getCanvas() != null) {
            canvas.remove(rope);
        }
    }

    public Point getAnchor() {
        return anchor;
    }

    public double getMaxDrag() {
        return maxDrag;
    }
}