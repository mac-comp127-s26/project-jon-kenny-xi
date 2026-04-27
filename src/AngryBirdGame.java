import edu.macalester.graphics.CanvasWindow;

public class AngryBirdGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private Birds birds;



    public AngryBirdGame() {
        double startX = CANVAS_WIDTH / 2;
        double startY = CANVAS_HEIGHT * 0.7;
        canvas = new CanvasWindow("AngryBirdBattleGround", 2500, 1680);
        birds = new Birds(canvas, startX, startY);

        // make the bird move (no direction yet)
        canvas.animate(() -> {
            birds.updatePosition(CANVAS_WIDTH, CANVAS_HEIGHT);
            
            checkCollision();
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


