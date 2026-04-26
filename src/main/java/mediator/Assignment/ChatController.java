package mediator.Assignment;

import javafx.scene.control.*;

public class ChatController {

    private final ChatClient client;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> userSelector;

    public ChatController(ChatClient client) {
        this.client = client;
        client.setController(this);
    }

    public void initUI(TextArea chatArea, TextField messageField, ComboBox<String> userSelector) {
        this.chatArea = chatArea;
        this.messageField = messageField;
        this.userSelector = userSelector;
    }

    public void sendMessage() {
        String msg = messageField.getText();
        String recipient = userSelector.getValue();

        if (msg.isEmpty() || recipient == null) return;

        client.sendMessage(msg, recipient);
        displayMessage("Me → " + recipient + ": " + msg);

        messageField.clear();
    }

    public void displayMessage(String message) {
        chatArea.appendText(message + "\n");
    }
}
