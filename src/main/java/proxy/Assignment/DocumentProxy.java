package proxy.Assignment;

public class DocumentProxy implements Document {
    private Document realDocument;

    public DocumentProxy(Document document) {
        this.realDocument = document;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate(); // no restriction
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}