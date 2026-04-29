
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Birds {
    private Image birdImage; 

    private double dx = 5; 
    private double dy = -5; 

    private int pauseFrames = 0;

    public Birds(CanvasWindow canvas, double centerX, double centerY) {
        birdImage = new Image(0, 0, "redbird.png");
        birdImage.setMaxWidth(60);
        
        birdImage.setCenter(centerX, centerY);
        canvas.add(birdImage);
    }

    public void updatePosition(double canvasWidth, double canvasHeight) {
        if (pauseFrames > 0) {
            pauseFrames--;
            return; 
        }

        birdImage.moveBy(dx, dy);

    }
    public double getX() {
        return birdImage.getX();
    }

    public double getY() {
        return birdImage.getY();
    }

    public void reset(double centerX, double centerY) {
        birdImage.setCenter(centerX, centerY);
        dx = 5;
        dy = -5;
    }
}
