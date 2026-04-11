package flyweight.Assignment;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {

    private final Map<String, Image> cache = new HashMap<>();

    public Image getImage(String tileType) {

        if (!cache.containsKey(tileType)) {
            System.out.println("Loading graphic for: " + tileType);
            cache.put(tileType, load(tileType));
        }

        return cache.get(tileType);
    }

    private Image load(String tileType) {

        String fileName;

        switch (tileType) {
            case "Swamp":
                fileName = "swamp.png";
                break;
            case "Water":
                fileName = "water.png";
                break;
            case "Forest":
                fileName = "swamp.png";
                break;
            case "Road":
                fileName = "road.png";
                break;
            case "Building":
                fileName = "building.png";
                break;
            default:
                fileName = "unknown.png";
        }

        return new Image(
                getClass().getResource("/" + fileName).toExternalForm()
        );
    }
}