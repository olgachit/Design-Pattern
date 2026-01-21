package factory_method.Assignment;

public class Game {
    public static void main(String[] args) {
        Map map = createMap("wilderness", 5, 5);
        map.display();
    }
    public static Map createMap(String type, int rows, int cols) {
        if (type.equalsIgnoreCase("wilderness")) {
            return new WildernessMap(rows, cols);
        } else if (type.equalsIgnoreCase("city")) {
            return new CityMap(rows, cols);
        } else {
            throw new IllegalArgumentException("Unknown map type: " + type);
        }
    }
}
