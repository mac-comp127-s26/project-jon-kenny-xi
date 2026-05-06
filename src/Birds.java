
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Birds {
    private Image birdImage; 

    private double dx = 0; 
    private double dy = 0; 
    private double gravity = 0.15;
    private boolean isFlying = false;
    private int pauseFrames = 180;

    public Birds(CanvasWindow canvas, double centerX, double centerY) {
        birdImage = new Image(0, 0, "redbird.png");
        birdImage.setMaxWidth(60);
        birdImage.setCenter(centerX, centerY);
        canvas.add(birdImage);
    }

    public void setVelocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.isFlying = true;
    }

    public void updateBirdPosition() {
        if (isFlying) {
            birdImage.moveBy(dx, dy);
            dy += gravity; // Gravity makes the bird arc downward
        }
    }

    public void setPosition(double x, double y) {
        birdImage.setCenter(x, y);
    }

    public double getX() { 
        return birdImage.getX(); 
    }
    public double getY() { 
        return birdImage.getY(); 
    }
    public boolean isFlying() { 
        return isFlying; 
    }

 
    public Image getImage() {
        return birdImage;
    }
}
