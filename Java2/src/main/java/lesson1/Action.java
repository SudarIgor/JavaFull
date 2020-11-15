package lesson1;

public interface Action {
    void run(double rangeRun);
    void jump(double rangeJump);
    void setOnDistance(boolean onDistance );
    boolean isOnDistance();
    double getRangeJump();
    double getRangeRun();
    String getName();
}
