package lesson3;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiConsumer;
/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.*/

public class Fist {
    public static void main(String[] args) {
        String [] array = {"one", "two", "three", "four", "five", "six", "seven", "three",
                "four", "seven", "five", "six"};

        Set<String> setList = new HashSet<>(Arrays.asList(array));
        System.out.println(setList);

        HashMap<String, Integer> kol = new HashMap<>();
        for (String i : array) {
            kol.put(i, kol.getOrDefault(i,0)+1);
        }

        kol.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.print(s + " ");
            }
        });
        System.out.println("\n" + kol);
    }
}
