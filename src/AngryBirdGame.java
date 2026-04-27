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
    }

    

    
    public static void main(String[] args) {
        new AngryBirdGame();

        
    }
    
}


