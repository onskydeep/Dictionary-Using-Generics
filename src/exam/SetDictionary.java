package exam;

import java.util.*;
import java.util.stream.Stream;

public class SetDictionary<K, V>  implements Dictionary<K,V>{

    Set<Pair<K, V>> entries = new HashSet<>();

    @Override
    public Option<V> get(K key) {
        if(!containsKey(key)) return Option.none();
        else{
            return Option.some(getValueFor(key));
        }
    }

    @Override
    public V get(K key, V defaultValue) {
        if(!containsKey(key)) return defaultValue;
        else{
            return getValueFor(key);
        }
    }

    @Override
    public boolean containsKey(K key) {
        for(Pair<K, V> pair : entries){
            if(pair.first==key) return true;
        }
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        if (containsKey(key)) return false;
        else{
            entries.add(new Pair(key,value));
            return true;
        }
    }

    @Override
    public boolean update(K key, V value) {
        if (!containsKey(key)) return false;
        else{
            Pair<K,V> replacement= new Pair(key,value);
            Pair<K,V> removal= new Pair<K,V>(null,null);
            for(Pair<K, V> pair : entries){
                if(pair.first==key) {
                    removal=pair;
                    break;
                }
            }
            entries.remove(removal);
            entries.add(replacement);
            return true;
        }
    }

    @Override
    public void clear(K key) {
        if(containsKey(key)){
            Pair<K,V> removal= new Pair<K,V>(null,null);
            for(Pair<K, V> pair : entries){
                if(pair.first==key) {
                    removal=pair;
                    break;
                }
            }
            entries.remove(removal);
        }
    }

    @Override
    public Stream<K> keyStream() {
        return entries.stream().map(pair -> pair.first);
    }

    @Override
    public Stream<V> valueStream() {
        return entries.stream().map(pair -> pair.second);
    }

    public V getValueFor(K key){
        for(Pair<K, V> pair : entries){
            if(pair.first==key) return pair.second;
        }
        return null;
    }


}
