package prototype.Assignment;

import java.util.HashMap;
import java.util.Map;

public class RecommendationRegistry {
    private Map<String, Recommendation> prototypes = new HashMap<>();

    public void addPrototype(String key, Recommendation recommendation) {
        prototypes.put(key, recommendation);
    }

    public Recommendation getClone(String key) {
        Recommendation prototype = prototypes.get(key);
        return (prototype != null) ? prototype.clone() : null;
    }

    public void listPrototypes() {
        prototypes.keySet().forEach(System.out::println);
    }
}