package lesson1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyArray intArr = new MyArray(1,2,3,4,5,6,7);
        MyArray strArr = new MyArray("aaa", "bbb", "ccc", "ddd", "fff");

        System.out.println(intArr.toString());
        intArr.moveItem(1,3);
        System.out.println(intArr.toString());

        System.out.println(strArr.toString());
        strArr.moveItem(1,4);
        System.out.println(strArr.toString());

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = strArr.toArrayList();
        System.out.println(arrayList);
        arrayList.add(0, "hi");
        System.out.println(arrayList);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        double w1 = orange1.getWeigh();


        Box <Apple> t1 = new Box();
        t1.addFruit(apple1);
        t1.addFruit(apple2);
        t1.addFruit(apple3);

        Box <Orange> t2 = new Box<>();
        t2.addFruit(orange1);
        t2.addFruit(orange2);
        t2.addFruit(orange3);






        System.out.println("Apple w = " + apple1.getWeigh());
        System.out.println( "weight t1 = " +  t1.getWeight());
        System.out.println( "weight t2 = " +  t2.getWeight());

        System.out.println(t1.compare(t2));
        Box <Orange> t3 = new Box<>();
        t2.addFruit(orange1);
        t2.addFruit(orange2);
        t2.addFruit(orange3);


        t2.moveFruitInThis(t3);
        System.out.println( "weight t2 = " +  t2.getWeight());
        System.out.println( "weight t3 = " +  t3.getWeight());
    }
}
