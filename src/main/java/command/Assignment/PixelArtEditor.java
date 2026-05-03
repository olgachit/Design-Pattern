package command.Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PixelArtEditor extends Application {

    private PixelGrid gridModel = new PixelGrid();
    private Rectangle[][] cells = new Rectangle[8][8];

    private void drawGrid() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean on = gridModel.getPixels()[i][j];

                if (i == gridModel.getCursorRow() && j == gridModel.getCursorCol()) {
                    cells[i][j].setFill(Color.RED);
                } else {
                    cells[i][j].setFill(on ? Color.BLACK : Color.WHITE);
                }
            }
        }
    }

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rect = new Rectangle(40, 40);
                rect.setStroke(Color.GRAY);
                rect.setFill(Color.WHITE);

                cells[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }

        Command up = new MoveCursorUpCommand(gridModel);
        Command down = new MoveCursorDownCommand(gridModel);
        Command left = new MoveCursorLeftCommand(gridModel);
        Command right = new MoveCursorRightCommand(gridModel);
        Command toggle = new TogglePixelCommand(gridModel);
        Command generate = new GenerateCodeCommand(gridModel);

        Button generateButton = new Button("Create Code");
        generateButton.setFocusTraversable(false);
        generateButton.setOnAction(e -> generate.execute());

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(generateButton);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> up.execute();
                case DOWN -> down.execute();
                case LEFT -> left.execute();
                case RIGHT -> right.execute();
                case SPACE -> toggle.execute();
            }
            drawGrid();
        });

        drawGrid();

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}