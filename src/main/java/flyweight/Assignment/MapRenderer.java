package flyweight.Assignment;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MapRenderer {

    private static final int TILE_SIZE = 40;

    public static void render(GraphicsContext gc, Map map) {

        TileGraphicFactory factory = new TileGraphicFactory();

        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {

                String type = map.getTile(i, j).getType();
                Image img = factory.getImage(type);

                gc.drawImage(
                        img,
                        j * TILE_SIZE,
                        i * TILE_SIZE,
                        TILE_SIZE,
                        TILE_SIZE
                );
            }
        }
    }
}