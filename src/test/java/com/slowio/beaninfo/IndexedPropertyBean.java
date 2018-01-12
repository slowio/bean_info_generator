package com.slowio.beaninfo;

import java.util.List;

/**
 *
 */
public class IndexedPropertyBean {

    List<String> names;
    List<Integer> results;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Integer getResults(int index) {
        return results.get(index);
    }

    public void setResults(int index, Integer result) {
        results.set(index, result);
    }
}
