package chainOfResponsibility.Assignment;

public class Main {

    public static void main(String[] args) {

        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler development = new DevelopmentSuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        compensation.setNextHandler(contact);
        contact.setNextHandler(development);
        development.setNextHandler(general);

        Message m1 = new Message(
                MessageType.COMPENSATION_CLAIM,
                "My order arrived damaged and I want compensation.",
                "alice@email.com"
        );

        Message m2 = new Message(
                MessageType.CONTACT_REQUEST,
                "Please call me regarding my account.",
                "bob@email.com"
        );

        Message m3 = new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "Add dark mode to the application.",
                "carol@email.com"
        );

        Message m4 = new Message(
                MessageType.GENERAL_FEEDBACK,
                "Great service, thank you!",
                "dave@email.com"
        );

        compensation.handle(m1);
        System.out.println();

        compensation.handle(m2);
        System.out.println();

        compensation.handle(m3);
        System.out.println();

        compensation.handle(m4);
    }
}
