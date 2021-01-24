package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * */

public class MyArray <T> {
    T [] object;
    private  int size;


    public MyArray(T...object) {
        this.object = object;
        size=object.length;
    }

    public Object[] moveItem(int ind1, int ind2){
        try {
            T oldInd1 =  object[ind1];
            T oldInd2 =  object[ind2];
            object [ind1] = oldInd2;
            object [ind2] = oldInd1;
        }catch (IndexOutOfBoundsException e){
            if(ind1>=size) System.out.printf("index %d outside the array\n", ind1);
            if(ind2>=size) System.out.printf("index %d outside the array\n", ind2);
        }
        return object;
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> objectArrayList = new ArrayList <T> (Arrays.asList(this.object));
        return objectArrayList;
    }

    public Object[] getObject() {
        return object;
    }

    public void setObject(T[] object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return Arrays.toString(object);
    }
}
