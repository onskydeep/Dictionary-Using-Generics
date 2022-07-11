package exam;

import java.util.*;
import java.util.stream.Stream;

public class ListDictionary<K, V> implements Dictionary<K, V> {

    List<K> keys = new ArrayList<>();
    List<V> values = new ArrayList<>();

    @Override
    public Option get(K key) {
        if (!containsKey(key)) {
            return Option.none();
        } else {
            return Option.some(values.get(getIndex(key)));
        }
    }

    @Override
    public V get(K key, V defaultValue) {
        if (containsKey(key)) {
            return values.get(getIndex(key));
        } else return defaultValue;
    }


    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public boolean put(K key, V value) {
        if (containsKey(key)) return false;
        else {
            keys.add(key);
            values.add(value);
            return true;
        }
    }

    @Override
    public boolean update(K key, V value) {
        if (!containsKey(key)) return false;
        else{
            values.set(getIndex(key),value);
            return true;
        }
    }

    @Override
    public void clear(K key){
        if(containsKey(key)){
            values.remove(getIndex(key));
            keys.remove(getIndex(key));
        }
    }

    @Override
    public Stream<K> keyStream() {
        return keys.stream();
    }

    @Override
    public Stream<V> valueStream() {
        return values.stream();
    }

    public int getIndex(K key) {
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == key) {
                index = i;
                break;
            }
        }
        return index;
    }


}
