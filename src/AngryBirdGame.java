import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;


public class AngryBirdGame {
    private static final int CANVAS_WIDTH = 2500;
    private static final int CANVAS_HEIGHT = 1680;

    private CanvasWindow canvas;
    private Birds birds;
    private Bricks bricks;
    private Pigs pigs;
    private Slingshot slingshot;
    private boolean dragging = false;
    
    private static final int BRICKS_ROWS = 5;
    private static final int BRICKS_COLS = 1;
    private static final double BRICK_SPACING = 5;
    private static final double BRICK_HEIGHT = 20;
    


    public AngryBirdGame() {
        double startX = CANVAS_WIDTH / 2;
        double startY = CANVAS_HEIGHT * 0.7;
        double anchorX = 200;
        double anchorY = 500;
        canvas = new CanvasWindow("AngryBirdBattleGround", 2500, 1680);
        bricks = new Bricks(canvas);
        pigs = new Pigs(canvas, 500, 200);
        birds = new Birds(canvas, startX, startY);
        slingshot = new Slingshot(canvas, anchorX, anchorY);

        setupEvents();

        // make the bird move (no direction yet)
        canvas.animate(() -> {
            birds.updateBirdPosition();
            
            checkCollision();
        });
    }

    private void setupEvents() {
        canvas.onMouseDown(event -> {
            // Only allow dragging if the bird isn't already flying
            if (!birds.isFlying()) {
                dragging = true;
            }
        });

        canvas.onDrag(event -> {
            if (dragging) {
                Point anchor = slingshot.getAnchor();
                Point mousePos = event.getPosition();
                
                // Limit the drag distance
                double dist = mousePos.distance(anchor);
                if (dist > slingshot.getMaxDrag()) {
                    // Truncate the vector if pulled too far
                    double scale = slingshot.getMaxDrag() / dist;
                    mousePos = new Point(
                        anchor.getX() + (mousePos.getX() - anchor.getX()) * scale,
                        anchor.getY() + (mousePos.getY() - anchor.getY()) * scale
                    );
                }
                
                birds.setPosition(mousePos.getX(), mousePos.getY());
                slingshot.updateRope(new Point(mousePos.getX(), mousePos.getY()));
            }
        });

        canvas.onMouseUp(event -> {
            if (dragging) {
                dragging = false;
                slingshot.hideRope();

                // PHYSICS: Launch bird in the opposite direction of the drag
                double launchPower = 0.15; // Adjust for speed
                double diffX = slingshot.getAnchor().getX() - birds.getX();
                double diffY = slingshot.getAnchor().getY() - birds.getY();
                
                birds.setVelocity(diffX * launchPower, diffY * launchPower);
            }
        });
    }

   

    // wait for the pigs
    private void checkCollision() {
        double r = 30; 
        double birdX = birds.getX();
        double birdY = birds.getY();

        // Check the four points around the bird
        java.awt.geom.Point2D.Double[] points = {
            new java.awt.geom.Point2D.Double(birdX + r, birdY - 1),           
            new java.awt.geom.Point2D.Double(birdX + r, birdY + 2 * r + 1),   
            new java.awt.geom.Point2D.Double(birdX - 1, birdY + r),           
            new java.awt.geom.Point2D.Double(birdX + 2 * r + 1, birdY + r)    
        };

        for (java.awt.geom.Point2D.Double point : points) {
            var hitObject = canvas.getElementAt(point.getX(), point.getY());
            if (hitObject != null) {               
                return; 
            }
        }
        }
    
 
    public static void main(String[] args) {
        new AngryBirdGame();

        
    }
    
}


