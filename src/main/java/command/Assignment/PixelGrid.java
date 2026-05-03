package command.Assignment;

public class PixelGrid {
    private final int SIZE = 8;
    private boolean[][] pixels = new boolean[SIZE][SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public void moveUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    public void togglePixel() {
        pixels[cursorRow][cursorCol] = !pixels[cursorRow][cursorCol];
    }

    public boolean[][] getPixels() {
        return pixels;
    }

    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }
}
