
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.CanvasWindow;

import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Bricks {
    private int bricks;
    private static final int BRICKS_ROWS = 5;
    private static final int BRICKS_COLS = 1;
    private static final double BRICK_SPACING = 0;
    private static final double BRICK_HEIGHT = 20;
    private static final double BRICKS_START_X = 1000;
    private static final double BRICKS_START_Y = 800;

    private static final double TOP_BRICK_WIDTH = 100;
    private static final double TOP_BRICK_HEIGHT = 15;
    private static final double TOP_BRICK_START_X = 1230;
    private static final double TOP_BRICK_START_Y = 15;
    private static final int TOP_BRICKS_COLS = 3;
    private static final int TOP_BRICKS_ROWS = 3;
    
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private List<Rectangle> brickList = new ArrayList<>();

    public Bricks(CanvasWindow canvas) {
        this.canvas = canvas;
        createBricks();
        createTopBricks();
    }

   

    private void createBricks() {
        bricks = BRICKS_ROWS*BRICKS_COLS;
        double brickWidth = (CANVAS_WIDTH - (BRICKS_COLS+1) * BRICK_SPACING)/BRICKS_COLS;
        for (int row = 0; row < BRICKS_ROWS; row++) {
            for (int col = 0; col < BRICKS_COLS; col++) {
                double X = BRICKS_START_X+col*(brickWidth+BRICK_SPACING);
                double Y = BRICKS_START_Y+row*(BRICK_HEIGHT+BRICK_SPACING)+50;
                Rectangle brick = new Rectangle(X,Y,brickWidth,BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setFillColor(new Color(153, 102, 0));
                canvas.add(brick);
                brickList.add(brick);
            }
        }
    }

    private void createTopBricks() {
        double topOfStack = BRICKS_START_Y + 50;
        double topBrickWidth = (CANVAS_WIDTH / TOP_BRICKS_COLS) - BRICK_SPACING;
        for (int col = 0; col < TOP_BRICKS_COLS; col++) {
            for (int row = 0; row <TOP_BRICKS_ROWS; row++) {
                double x = BRICKS_START_X + col * (topBrickWidth + BRICK_SPACING);
                double brickHeight = (col == TOP_BRICKS_COLS/2)
                    ? TOP_BRICK_HEIGHT*8
                    : TOP_BRICK_HEIGHT*1.5;
                double yOffset = (col == TOP_BRICKS_COLS/2) ? -100:0;
                double y = topOfStack - TOP_BRICK_HEIGHT * (row + 1) - BRICK_SPACING * (row + 1) + yOffset;
                Rectangle topBrick = new Rectangle(x, y, TOP_BRICK_WIDTH, brickHeight);
                topBrick.setFilled(true);
                topBrick.setFillColor(new Color(153, 102, 0));
                canvas.add(topBrick);
                brickList.add(topBrick);
            }
        }
    }

    public List<Rectangle> getBricks() {
        return brickList;
    }

}
