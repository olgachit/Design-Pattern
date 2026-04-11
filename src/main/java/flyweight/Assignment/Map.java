package flyweight.Assignment;

import java.util.Random;

public abstract class Map {

    protected Tile[][] tiles;
    protected Random random = new Random();

    private int rows;
    private int cols;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        tiles = new Tile[rows][cols];
        generateMap();
    }

    protected abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

class WildernessMap extends Map {
    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    protected Tile createTile() {
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            default:
                return new ForestTile();
        }
    }
}

class CityMap extends Map {
    public CityMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    protected Tile createTile() {
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                return new RoadTile();
            case 1:
                return new BuildingTile();
            default:
                return new ForestTile();
        }
    }
}

