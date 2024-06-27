package com.rtemi.model;

public interface ArrayListImpl<E> extends Iterable<E>{
    /*
    Implement put
    Implement get by index
    Implement Delete by index
    Implement resize
     */
    boolean isEmpty();
    int size();
    boolean add(E element);
    boolean add(int index, E element);
    void remove(E element);
    void remove(int index);
    E get(int index);
}
