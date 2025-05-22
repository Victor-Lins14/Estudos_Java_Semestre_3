package Codigos_sala._Hash_.collections;

public interface Entry<K, V> {
    K getKey();
    V getValue();
    void setValue(V value);
}
