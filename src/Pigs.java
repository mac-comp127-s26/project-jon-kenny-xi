
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

public class Pigs {
    private Image pigImage; 

    private double dx = 5; 
    private double dy = -5; 

    private int pauseFrames = 0;

    private CanvasWindow canvas;

    public Pigs(CanvasWindow canvas, double X, double Y) {
        pigImage = new Image(0, 0, "starwarspig.png");
        pigImage.setMaxWidth(60);
        
        this.pigImage.setMaxWidth(60);
        this.pigImage.setCenter(X, Y);
        canvas.add(pigImage);
    }

    
    public double getX() {
        return pigImage.getX();
    }

    public double getY() {
        return pigImage.getY();
    }

    

}