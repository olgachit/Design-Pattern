package chainOfResponsibility.Assignment;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected void process(Message message) {

        System.out.println("Development suggestion from: " + message.getSenderEmail());
        System.out.println("Suggestion logged and added to product backlog.");
    }
}