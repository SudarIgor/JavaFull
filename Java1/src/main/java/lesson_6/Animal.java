package lesson_6;

public abstract class Animal {
    private double limitRangeRun;
    private double limitRangeJump;

    public double getLimitRangeRun() {
        return limitRangeRun;
    }

    public void setLimitRangeRun(double limitRangeRun) {
        this.limitRangeRun = limitRangeRun;
    }

    public double getLimitRangeJump() {
        return limitRangeJump;
    }

    public void setLimitRangeJump(double limitRangeJump) {
        this.limitRangeJump = limitRangeJump;
    }

    public abstract void run(double distRun);

    public abstract void jump(double distJump);

}
