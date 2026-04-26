package mediator.Assignment;

public class ChatClient {

    private final String username;
    private final ChatMediator mediator;
    private ChatController controller;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public String getUsername() {
        return username;
    }

    public void setController(ChatController controller) {
        this.controller = controller;
    }

    public void sendMessage(String message, String to) {
        mediator.sendMessage(message, username, to);
    }

    public void receiveMessage(String message, String from) {
        if (controller != null) {
            controller.displayMessage(from + ": " + message);
        }
    }
}
