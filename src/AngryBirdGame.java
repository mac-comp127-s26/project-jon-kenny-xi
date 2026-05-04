import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;
import java.util.ArrayList;
import java.util.List;


public class AngryBirdGame {
    private static final int CANVAS_WIDTH = 2500;
    private static final int CANVAS_HEIGHT = 1680;

    private CanvasWindow canvas;
    private Bricks bricks;
    private Pigs pigs;
    private Slingshot slingshot;
    private boolean dragging = false;
    private Birds currentBird;

    private static final int BRICKS_ROWS = 5;
    private static final int BRICKS_COLS = 1;
    private static final double BRICK_SPACING = 5;
    private static final double BRICK_HEIGHT = 20;
    private java.util.List<Pigs> pigList = new ArrayList<>();
    private List<Birds> activeBirds = new ArrayList<>();


    public AngryBirdGame() {
        double startX = CANVAS_WIDTH / 2;
        double startY = CANVAS_HEIGHT * 0.7;
        double anchorX = 150;
        double anchorY = 750;
        canvas = new CanvasWindow("AngryBirdBattleGround", 2500, 1680);
        bricks = new Bricks(canvas);
        pigList = new java.util.ArrayList<>();
        pigList.add(new Pigs(canvas, 1050, 785));
        pigList.add(new Pigs(canvas, 1250, 685));
        pigList.add(new Pigs(canvas, 1450, 785));

        slingshot = new Slingshot(canvas, anchorX, anchorY);

        prepareNewBird();

        setupEvents();

        canvas.animate(() -> {
            updateGame();
        });
    }

    private void prepareNewBird() {
        currentBird = new Birds(canvas, slingshot.getAnchor().getX(), slingshot.getAnchor().getY());
    }

    private void setupEvents() {
        canvas.onMouseDown(event -> {
            if (!currentBird.isFlying()) {
                dragging = true;
            }
        });

        canvas.onDrag(event -> {
            if (dragging) {
                Point anchor = slingshot.getAnchor();
                Point mousePos = event.getPosition();

                double dist = mousePos.distance(anchor);
                if (dist > slingshot.getMaxDrag()) {
                    double scale = slingshot.getMaxDrag() / dist;
                    mousePos = new Point(
                        anchor.getX() + (mousePos.getX() - anchor.getX()) * scale,
                        anchor.getY() + (mousePos.getY() - anchor.getY()) * scale);
                }

                currentBird.setPosition(mousePos.getX(), mousePos.getY());
                slingshot.updateRope(new Point(mousePos.getX(), mousePos.getY()));
            }
        });

        canvas.onMouseUp(event -> {
            if (dragging && currentBird != null) {
                dragging = false;
                slingshot.hideRope();

                double launchPower = 0.15;
                double diffX = slingshot.getAnchor().getX() - currentBird.getX();
                double diffY = slingshot.getAnchor().getY() - currentBird.getY();

                currentBird.setVelocity(diffX * launchPower, diffY * launchPower);

                activeBirds.add(currentBird);
                currentBird = null;
                prepareNewBird();
            }
        });
    }

    private void updateGame() {

        for (int i = activeBirds.size() - 1; i >= 0; i--) {
            Birds bird = activeBirds.get(i);

            bird.updateBirdPosition();

            boolean hitPig = checkCollision(bird);

            if (hitPig ) {
                canvas.remove(bird.getImage());
                activeBirds.remove(i);
            }
            else if (bird.getY() > CANVAS_HEIGHT) {
                canvas.remove(bird.getImage());
                activeBirds.remove(i);
            }
        }
    }


    private boolean checkCollision(Birds bird) {
        double r = 30;
        double birdX = bird.getX();
        double birdY = bird.getY();

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
                for (int j = pigList.size() - 1; j >= 0; j--) {
                    Pigs pig = pigList.get(j);

                    if (hitObject == pig.getImage()) {
                        canvas.remove(hitObject);
                        pigList.remove(j);
                        return true;
                    }
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
        new AngryBirdGame();


    }

}

