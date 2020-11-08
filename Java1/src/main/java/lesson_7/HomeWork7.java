package lesson_7;
/**
 * 1) Расширить задачу про котов и тарелки с едой.
 * 2) Сделать так, чтобы в тарелке с едой не могло получиться отрицательного
 * количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 3) Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось покушать (хватило еды), сытость = true.
 * 4) Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
 * то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 * 5) Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
 * и потом вывести информацию о сытости котов в консоль.
 * 6) Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.*/
public class HomeWork7 {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("Barsik", 5);
        Plate plate1 = new Plate(3);
        Plate plate2 = new Plate(40);
        Cat [] cats = new Cat[10];

        plate1.info();
        cat.eat(plate1);
        cat.isSatiety();
        plate1.addFood(2);
        cat.eat(plate1);
        plate1.info();
        cat.isSatiety();
        System.out.println(cat);
        plate2.info();
        cat.eat(plate2);
        System.out.println(cat);
        plate2.info();

        for (int i = 0; i < 10; i++) {
            cats [i] = new Cat("Name" + (1+i), ( (int) (Math.random()*5+2) ));
            System.out.println(cats [i]);
        }

        for (Cat i : cats) {
            i.eat(plate2);
        }
        for (Cat i: cats) {
            i.isSatiety();
        }
    }
}
