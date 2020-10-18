package lesson_2;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork2 {

    static Scanner sc = new Scanner( System.in);

    public static int InputNaturalNumber (){
        System.out.println("Введите положительное число (размер массива)");
        return sc.nextInt();
    }

    public static int [] FillingArrayRandomNumber(int [] Array, int lowerLimit, int upperLimit){
        for (int i = 0; i < Array.length; i++) {
            Array [i] = (int) (Math.random()*( (upperLimit - lowerLimit) + 1) + lowerLimit);
        }
        return Array;
    }

    public static int [] Inverter( int [] Array){
        for (int i = 0; i < Array.length; i++) {
            if (Array [i] == 0) Array [i] = 1;
            else Array [i] = 0;
        }
        return Array;
    }

    public static void PrintSquareArray(int[][] Array, int lengthArray){
        for (int i = 0; i < lengthArray; i++) {
            for (int j = 0; j < lengthArray; j++) {
                System.out.printf("%3d", Array [i] [j]);
            }
            System.out.println();
        }
    }

    public static int [][] DiagonaForArray(int[][] Array, int length){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ( (i == j) || (i == ( (length - 1) - j) ) ){
                    Array [i][j] = 1;
                }
            }
        }
        return Array;
    }

    public static int [] GetArray (){
        int [] Array = new int [InputNaturalNumber()];
        Array = FillingArrayRandomNumber(Array,0,9);
        return Array;
    }

    public static int LeftOfArray(int [] Array, int indexArray){
        int left = 0;
        for (int i = 0; i <= indexArray; i++) {
            left += Array [i];
        }
        return left;
    }

    public static int RightOfArray(int [] Array, int indexArray){
        int right = 0;
        for (int i = indexArray+1; i < Array.length; i++) {
            right += Array [i];
        }
        return right;
    }

    public static int [] ShiftLeft(int [] Array, int shift){
        int num;
//        System.out.println(Arrays.toString(Array));
        for (int i = 0; i < shift; i++) {
            num = Array [0];
            for (int j = 0; j < Array.length-1; j++) {
                Array [j] = Array [j + 1];
            }
            Array [Array.length-1] = num;
//            System.out.println(Arrays.toString(Array));
        }
        return Array;
    }

    public static int [] ShiftRight(int [] Array, int shift){
        int num;
//        System.out.println(Arrays.toString(Array));
        for (int i = 0; i < shift; i++) {
            num = Array [Array.length - 1];
            for (int j = Array.length - 1; j > 0; j--) {
                Array [j] = Array [j - 1];
            }
            Array [0] = num;
//            System.out.println(Arrays.toString(Array));
        }
        return Array;
    }

    public static void ArrayZeroOrOne (){
        int lengthArray = InputNaturalNumber();
        int [] Array = new int[lengthArray];
        Array = FillingArrayRandomNumber(Array,0,1);
//        System.out.println(Arrays.toString(Array));
//        System.out.println("Инвертированный массив:");
        Inverter(Array);
//        System.out.println(Arrays.toString(Array));
    }

    public static void ArrayStep3(){
        int [] Array = new int[8];
        int step = 0;
        for (int i = 0; i < Array.length; i++) {
            Array [i] = step;
            step += 3;
        }
//        System.out.println(Arrays.toString(Array));
    }

    public static void IfLessThanSixMultiplyByTwo(){
        int [] Array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(Arrays.toString(Array));
//        System.out.println("Если элемент массива меньше 6, то умножим его на 2");
        for (int i = 0; i < Array.length; i++) {
            if (Array [i] < 6) Array [i] *= 2;
        }
//        System.out.println(Arrays.toString(Array));
    }

    public static void DiagonalsOfSquare(){
        int lengthArray = InputNaturalNumber();
        int [] [] Array = new int [lengthArray] [lengthArray];
        DiagonaForArray(Array, lengthArray);
        PrintSquareArray(Array,lengthArray);

    }

    public static void ArrayMinAndMax(){
        int min, max;
        int[] Array = new int [InputNaturalNumber ()];
        Array = FillingArrayRandomNumber(Array, -100, 100);
        min = max = Array [0];
        for (int i: Array) {
            if (min > i) min = i;
            if (max < i ) max = i;
        }
        System.out.println("Случайный одномерный массив :" + Arrays.toString(Array));
        System.out.printf("Минимальное значение массива: %3d \nМаксимальное значение массива: %3d", min, max);

    }

    public static boolean BalansArray(int [] Array){

        System.out.println(Arrays.toString(Array)); // для проверки метода
        int left, right;
        for (int i =0; i < Array.length-1; i++) {
            left = LeftOfArray(Array, i);
            right = RightOfArray(Array, i);
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public static int [] ShiftArray(int [] Array, int shift){
        if (shift * ( -1) > 0) Array = ShiftLeft(Array, shift * (-1));
        else Array = ShiftRight (Array, shift);
        return Array;
    }

    public static void main(String[] args) {
        /** 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
         * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
         * С помощью цикла и условия заменить 0 на 1, 1 на 0;
         *  * */
//        ArrayZeroOrOne();
        /**
         * 2. Задать пустой целочисленный массив размером 8.
         * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         * */
//        ArrayStep3();

        /**
         * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
         * пройти по нему циклом, и числа меньшие 6 умножить на 2;
         * * */
//        IfLessThanSixMultiplyByTwo();

        /**
         4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         **/
//          DiagonalsOfSquare();

        /**
         5. ** Задать одномерный массив и найти в нем
         минимальный и максимальный элементы (без помощи интернета); * */
//        ArrayMinAndMax();

        /**
         * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
         * метод должен вернуть true, если в массиве есть место,
         * в котором сумма левой и правой части массива равны.
         * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
         * checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
         * эти символы в массив не входят.
         * */
        /** для проверки метода:
         int [] Array = GetArray();
         boolean balans = BalansArray(Array);
         System.out.println(balans);
         * */
//      BalansArray(Array);

        /**
         * 7. **** Написать метод, которому на вход подается одномерный массив
         * и число n (может быть положительным, или отрицательным),
         * при этом метод должен сместить все элементымассива на n позиций.
         * Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/
        /** для проверки метода:
         int [] Array = GetArray();
         int shift = InputNaturalNumber(); */
//        ShiftArray(Array, shift);


    }
}
