package iterator.Example;

import java.util.Iterator;

public interface SimpleCollection {
    void add(Integer element);

    Iterator<Integer> iterator();
}
