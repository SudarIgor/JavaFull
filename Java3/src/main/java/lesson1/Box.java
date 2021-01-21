package lesson1;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Box <T extends Fruit> extends ArrayList<Orange> {

    private double weight;

    private ArrayList<T> arrayList;

    public Box() {
       arrayList = new ArrayList<>();
       weight =0;
    }

    public double getWeight(){
        return weight;
    }

    public void addFruit (T fruit){
        arrayList.add(fruit);
        weight +=  fruit.getWeigh();
    }

    public boolean compare(Box box){
        return this.weight == box.getWeight();
    }

    public  void moveFruitInThis (ArrayList<T> arrayList){
        for (int i = 0 ; i < arrayList.size(); i++){
            this.arrayList.add(arrayList.get(i));
            arrayList.clear();
        }

    }

    @Override
    public Stream<Orange> stream() {
        return null;
    }
}
