package flyweight.Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    private static final int TILE_SIZE = 40;

    @Override
    public void start(Stage stage) {

        Map map = createMap("wilderness", 10, 10);

        Canvas canvas = new Canvas(
                map.getCols() * TILE_SIZE,
                map.getRows() * TILE_SIZE
        );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        MapRenderer.render(gc, map);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("RPG Map");
        stage.setScene(scene);
        stage.show();
    }

    public static Map createMap(String type, int rows, int cols) {

        if (type.equalsIgnoreCase("wilderness")) {
            return new WildernessMap(rows, cols);
        } else if (type.equalsIgnoreCase("city")) {
            return new CityMap(rows, cols);
        }

        throw new IllegalArgumentException("Unknown map type: " + type);
    }

    public static void main(String[] args) {
        launch(args);
    }
}