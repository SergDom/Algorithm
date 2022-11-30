package com.nomad.algorithm.service;

import com.nomad.algorithm.exceptions.EmptyArgumentException;
import com.nomad.algorithm.exceptions.ElementNotFoundException;
import com.nomad.algorithm.exceptions.NullParameterException;
import com.nomad.algorithm.exceptions.OutOfBondException;


import java.util.Arrays;


public class StringListImpl implements StringList {
    private String[] list;
    private int value;
    private int size = 0;

    public StringListImpl(int value) {
        this.value = value;
        list = new String[value];
    }


    @Override
    public String add(String item) {
        return add(size, item);

    }


    @Override
    public String add(int index, String item) {
        if (index > size || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        if (item == null || item.isBlank()) {
            throw new EmptyArgumentException("Введена пустая строка");
        }
        if (index == size) {
            list[size++] = item;
            return item;
        }
        System.arraycopy(list,index,list,index+1,size-index);
        list[index]=item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= size || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        list[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                index = i;
            }
        }
        if (index == -1) {
            throw new ElementNotFoundException("Элемент остуствует");
        } else return remove(index);
    }


    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new ElementNotFoundException("Элемент отсутсвует");
        }
        String removed = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size] = null;
        size--;
        return removed;
    }


    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (size <= index || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        if (otherList == null) {
            throw new NullParameterException("Пустой список");
        }
        if (this.size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (!(list[i].equals((otherList.get(i)))))
                return false;
        }
        return true;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;

    }


    @Override
    public void clear() {
        size = 0;
    }


    @Override
    public String[] toArray() {
        return Arrays.copyOf(list, size());
    }
}
