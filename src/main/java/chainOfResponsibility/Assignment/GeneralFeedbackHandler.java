package chainOfResponsibility.Assignment;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected void process(Message message) {

        System.out.println("General feedback received from: " + message.getSenderEmail());
        System.out.println("Feedback analyzed and customer thanked.");
    }
}