package mediator.Assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediatorImpl mediator = new ChatMediatorImpl();

        createClientWindow("Alice", mediator);
        createClientWindow("Bob", mediator);
        createClientWindow("Charlie", mediator);
    }

    private void createClientWindow(String username, ChatMediatorImpl mediator) {
        Stage stage = new Stage();

        ChatClient client = new ChatClient(username, mediator);
        mediator.registerClient(client);

        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField messageField = new TextField();
        ComboBox<String> users = new ComboBox<>();
        users.getItems().addAll(mediator.getAllUsernames());
        users.getItems().remove(username);

        Button sendBtn = new Button("Send");

        ChatController controller = new ChatController(client);
        controller.initUI(chatArea, messageField, users);

        sendBtn.setOnAction(e -> controller.sendMessage());

        VBox layout = new VBox(chatArea, users, messageField, sendBtn);

        stage.setTitle(username);
        stage.setScene(new Scene(layout, 300, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
