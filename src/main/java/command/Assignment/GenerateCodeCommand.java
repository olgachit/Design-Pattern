package command.Assignment;

public class GenerateCodeCommand implements Command {
    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        boolean[][] pixels = grid.getPixels();

        System.out.println("int[][] pixelArt = {");

        for (int i = 0; i < pixels.length; i++) {
            System.out.print("    {");

            for (int j = 0; j < pixels[i].length; j++) {
                System.out.print(pixels[i][j] ? "1" : "0");
                if (j < pixels[i].length - 1) System.out.print(", ");
            }

            System.out.print("}");
            if (i < pixels.length - 1) System.out.println(",");
            else System.out.println();
        }

        System.out.println("};");
    }
}
