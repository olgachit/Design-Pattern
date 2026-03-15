package chainOfResponsibility.Assignment;

public abstract class FeedbackHandler {

    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Message message) {

        if (canHandle(message)) {
            process(message);
        }
        else if (nextHandler != null) {
            nextHandler.handle(message);
        }
        else {
            System.out.println("No handler found for message from " + message.getSenderEmail());
        }
    }

    protected abstract boolean canHandle(Message message);

    protected abstract void process(Message message);
}
