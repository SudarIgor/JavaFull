package lesson5;

import java.util.Arrays;

/**1)+ Создают одномерный длинный массив, например:
 * 2)+ Заполняют этот массив единицами;
 * 3)+ Засекают время выполнения: long a = System.currentTimeMillis();
 * 4)+ Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * 5)+ Проверяется время окончания метода System.currentTimeMillis();
 * 6)+ В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *
 * Отличие первого метода от второго:
 * Первый просто бежит по массиву и вычисляет значения.
 * Второй разбивает массив на два массива, в двух потоках высчитывает новые
 * значения и потом склеивает эти массивы обратно в один.
 * */

public class Main {



    public static float [] one(float [] array){
        long timeT = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++ ) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        timeT = System.currentTimeMillis() - timeT;
        System.out.printf("\nВремя заполнения массива одним потоком: %d мc \n",  timeT );
//        System.out.println(Arrays.toString(array));

        return array;
    }

    public static float[] two(float [] array){

    long timeT = System.currentTimeMillis();
    float [] arr1 = new float[array.length/2];
    float [] arr2 = new float[array.length/2];

    System.arraycopy(array,0,arr1,0,array.length/2);
    System.arraycopy(array,array.length/2,arr2,0,array.length/2);

    new Thread(() -> fillingArr(arr1)).start();
    new Thread(() -> fillingArr(arr1)).start();

    System.arraycopy(arr1,0,array,0,arr1.length);
    System.arraycopy(arr2,0,array, array.length/2,arr2.length);


    timeT = System.currentTimeMillis() - timeT;

    System.out.printf("\nВремя заполнения массива двумя потоками: %d мc\n", timeT );
//    System.out.println(Arrays.toString(array));
        return array;
    }

    public static void fillingArr (float [] array){
        for (int i = 0; i < array.length; i++ ) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        int n = 10_000_000;
        float [] array = new float[n];
        for (int i = 0 ; i < array.length; i++) {
            array [i] = 1;
        }

        long timeT = System.currentTimeMillis();
        float [] myArray1 = new float[n];
        float [] myArray2 = new float[n];
        myArray1 = one(array);
        myArray2 = two(array);

        Boolean result = Arrays.equals(myArray1, myArray2);
        System.out.println(result);
        System.out.printf("\nFull time %d мc", (System.currentTimeMillis() - timeT) );
    }
}
