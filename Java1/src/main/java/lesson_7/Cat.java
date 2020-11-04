package lesson_7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;
    private String stSatiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }


    public void eat(Plate p) {
        if (!satiety) satiety = p.decreaseFood(appetite, satiety);
    }


    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public boolean getSatiety() {
        return satiety;
    }
    public void isSatiety(){
        if (satiety) stSatiety ="поел";
        else stSatiety = "голодный";
        System.out.printf("Котик по имени %s %s\n", name, stSatiety);

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}

