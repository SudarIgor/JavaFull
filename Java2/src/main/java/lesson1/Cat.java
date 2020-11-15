package lesson1;

public class Cat implements Action {

    private double maxRangeJump;
    private double maxRangeRun;
    private static String type ="Котик";
    private String name;
    private boolean onDistance;

    public Cat( String name) {
       this.name = name;
        maxRangeJump = 2  +  (Math.random()*(2 * 0.2) );
        maxRangeRun = 100 +  ( (int) (Math.random()*(100 * 0.2) ) );
        onDistance = true;
    }

    @Override
    public void run(double rangeRun) {
        System.out.println(type + " "+ name + " побежал");
        }


    @Override
    public void jump(double rangeJump) {
        System.out.println(type + " " +name + " прыгнул");
    }

    @Override
    public void setOnDistance(boolean onDistance ) {
       this.onDistance = onDistance;
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public double getRangeJump() {
        return maxRangeJump;
    }

    @Override
    public double getRangeRun() {
        return maxRangeRun;
    }

    @Override
    public String getName() {
        return type + " " + name;
    }
}
