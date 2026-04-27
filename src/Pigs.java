import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.CanvasWindow;

import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Pigs {
    private int bricks;
    private static final int BRICKS_ROWS = 5;
    private static final int BRICKS_COLS = 1;
    private static final double BRICK_SPACING = 5;
    private static final double BRICK_HEIGHT = 20;
    
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private List<Rectangle> brickList = new ArrayList<>();

    public Pigs(CanvasWindow canvas) {
        this.canvas = canvas;
        createBricks();
    }

    private void createBricks() {
        bricks = BRICKS_ROWS*BRICKS_COLS;
        double brickWidth = (CANVAS_WIDTH - (BRICKS_COLS+1) * BRICK_SPACING)/BRICKS_COLS;
        for (int row = 0; row < BRICKS_ROWS; row++) {
            for (int col = 0; col < BRICKS_COLS; col++) {
                double X = BRICK_SPACING+col*(brickWidth+BRICK_SPACING);
                double Y = BRICK_SPACING+row*(BRICK_HEIGHT+BRICK_SPACING)+50;
                Rectangle brick = new Rectangle(X,Y,brickWidth,BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setFillColor(Color.GREEN);
                canvas.add(brick);
            }
        }
    }
    public List<Rectangle> getBricks() {
        return brickList;
    }
}
