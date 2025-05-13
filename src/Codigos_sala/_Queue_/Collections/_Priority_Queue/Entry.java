package Codigos_sala._Queue_.Collections._Priority_Queue;

public interface Entry<K, V> {
    K getKey();
    V getValue();
    void setKey(K newKey);
}
