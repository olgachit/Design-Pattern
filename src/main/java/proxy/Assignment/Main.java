package proxy.Assignment;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User alice = new User("alice");
        User bob = new User("bob");

        AccessControlService acs = AccessControlService.getInstance();

        library.addDocument(new RealDocument("doc1", "22/03/2026", "Public Content"));
        library.addProtectedDocument("doc2", "22/03/2026", "Secret Content");
        acs.grantAccess("doc2", "alice");

        try {
            //public document
            System.out.println("Alice reads doc1: " +
                    library.getDocument("doc1").getContent(alice));

            //protected
            System.out.println("Alice reads doc2: " +
                    library.getDocument("doc2").getContent(alice));

            //protected denied
            System.out.println("Bob reads doc2: " +
                    library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}