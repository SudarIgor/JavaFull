package lesson1;

public class Wall extends Barrier {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Высота препятствия  " + height;
    }

    @Override
    public boolean moving(Action action) {
        System.out.println(action.getName() + " совершает прыжок");
        if (getHeight() <= action.getRangeJump()) {
            System.out.println("Успех!");
                action.setOnDistance(true);
                return true;
            } else {
                System.out.println("Провал!");
                action.setOnDistance(false);
            }

        return false;
    }
}
