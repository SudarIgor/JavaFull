package lesson1;

public class Human implements Action{
    private double maxRangeJump;
    private double maxRangeRun;
    private static String type ="Человек";
    private String name;
    private boolean onDistance;

    public Human( String name) {
        this.name = name;
        maxRangeJump = 1.5  +  (Math.random()*(1.5 * 0.2) );
        maxRangeRun = 300 +  ( (int) (Math.random()*(300 * 0.2) ) );
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
