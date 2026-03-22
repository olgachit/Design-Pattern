package proxy.Assignment;

import java.util.HashMap;
import java.util.HashSet;

public class AccessControlService {
    private static AccessControlService instance;
    private HashMap<String, HashSet<String>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        accessMap.putIfAbsent(documentId, new HashSet<>());
        accessMap.get(documentId).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return accessMap.containsKey(documentId) &&
                accessMap.get(documentId).contains(username);
    }
}
