package chainOfResponsibility.Assignment;

public class CompensationHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected void process(Message message) {

        System.out.println("Compensation claim received from: " + message.getSenderEmail());

        if (message.getContent().length() > 20) {
            System.out.println("Claim approved and sent to finance department.");
        } else {
            System.out.println("Claim rejected due to insufficient details.");
        }
    }
}