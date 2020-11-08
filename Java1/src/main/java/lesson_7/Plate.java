package lesson_7;

public class Plate {

    private int food;

    public Plate(int food) throws Exception {
        this.food = food;
        if (food <0) {
            throw new UnsupportedOperationException("Нельзя положить в тарелку отрицательное количество еды");
        }
    }

    public boolean decreaseFood(int n, boolean satiety) {
        if (food >=n) {
            food -= n;
            return true;
        }
        return false;
    }

    public void addFood(int food){
        this.food+=food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

}
