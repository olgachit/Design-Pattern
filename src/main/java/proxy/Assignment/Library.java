package proxy.Assignment;

import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    //add unprotected document
    public void addDocument(Document doc) {
        documents.put(doc.getId(), doc);
    }

    //add protected document
    public void addProtectedDocument(String id, String date, String content) {
        RealDocument realDoc = new RealDocument(id, date, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}