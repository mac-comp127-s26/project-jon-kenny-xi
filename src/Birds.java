
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Birds {
    private Image birdImage; 

    public Birds(CanvasWindow canvas, double centerX, double centerY) {
        birdImage = new Image(0, 0, "redbird.png");
        birdImage.setMaxWidth(60);
        
        birdImage.setCenter(centerX, centerY);
        canvas.add(birdImage);
    }
}
