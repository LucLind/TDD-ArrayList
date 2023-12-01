package org.example;

public class MyArrayList {
    private int[] array;
    private int length;

    public MyArrayList(){
        array = new int[10];
        length = 0;
    }

    public boolean add(int value){
        if (length == array.length){
            increaseArraySize();
        }
        array[length] = value;
        length++;
        return true;
    }

    public void remove(int index){
        for (int i = index; i < length - 1; i++){
            array[i] = array[i+1];
        }

        length--;
    }

    public boolean contains(int value){
        for (int i = 0; i < length; i++) {
            if (array[i] == value){
                return true;
            }
        }
        return false;
    }

    public int[] getArray(){
        int[] output = new int[length];
        for (int i = 0; i < length; i++){
            output[i] = array[i];
        }
        return output;
    }

    public int size(){
        return length;
    }

    private void increaseArraySize(){
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
