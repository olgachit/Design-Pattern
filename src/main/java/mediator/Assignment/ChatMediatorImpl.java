package mediator.Assignment;

import java.util.*;

public class ChatMediatorImpl implements ChatMediator {

    private final Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        ChatClient receiver = clients.get(to);
        if (receiver != null) {
            receiver.receiveMessage(message, from);
        }
    }

    public Set<String> getAllUsernames() {
        return clients.keySet();
    }
}