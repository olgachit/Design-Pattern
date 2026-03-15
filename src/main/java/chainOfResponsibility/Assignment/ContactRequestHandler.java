package chainOfResponsibility.Assignment;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected void process(Message message) {

        System.out.println("Contact request from: " + message.getSenderEmail());
        System.out.println("Forwarded to customer support team.");
    }
}