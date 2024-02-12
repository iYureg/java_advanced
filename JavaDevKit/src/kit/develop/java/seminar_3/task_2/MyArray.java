package kit.develop.java.seminar_3.task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyArray<E> implements Iterable<E> {
    private Object[] array;
    private int size;

    public MyArray() {
        this.size = 0;
        array = new Object[size];
    }

    public MyArray<E> add(E element){
        if(size >= array.length) {
            Object[] newArray = new Object[size +  ((size / 2) + 1)];
            System.arraycopy(array, 0,newArray, 0, size);
            array = newArray;
        }
        array[size++] = element;
        return this;
    }


    public void remove(int index){
        if(index >= size || index < 0){
            return;
        }
        System.arraycopy(array, index + 1, array, index, size - index);

        size--;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');

//        for (int i = 0; i < size; i++) {
//            sb.append(array[i]).append(',');
//        }

        Arrays.stream(array).forEach(e -> sb.append(e).append(','));

        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator(){
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((E) array[i]);
        }
        return new MyIteratorForArray<>(list);
    }
}
