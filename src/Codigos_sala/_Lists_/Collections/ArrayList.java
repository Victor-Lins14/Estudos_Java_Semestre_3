package Codigos_sala._Lists_.Collections;

public class ArrayList<E> extends StaticList<E> {

    @SuppressWarnings("unchecked")
    public ArrayList() {
        list = (E[]) new Object[MAX_SIZE];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int maxSize) {
        list = (E[]) new Object[maxSize];
    }

    private void recreateArray() {
        @SuppressWarnings("unchecked")
        E[] newList = (E[]) new Object[list.length*2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    @Override
    public void add(E value)  {
        if (isFull()) recreateArray();
        super.add(value);
    }

    @Override
    public void insert(E value) {
        if (isFull()) recreateArray();
        super.insert(value);
    }

    @Override
    public void insert(int index, E value) {
        if (isFull()) recreateArray();
        super.insert(index, value);
    }

}
