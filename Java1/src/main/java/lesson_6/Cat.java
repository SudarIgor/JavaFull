package lesson_6;

public class Cat extends Animal {
    public Cat() {
        setLimitRangeJump(1.8 + ( (double) (Math.random()*(2 * 0.2) ) ) );
        setLimitRangeRun(180 + ( (int) (Math.random()*(200 * 0.2) ) ));
    }


    @Override
    public void run(double distRun) {
        if ( distRun <= getLimitRangeRun() ) System.out.printf("Котик пробежал %.2f\n",distRun);
        else System.out.printf("Котик не смог пробежать %.2f\n", distRun);
    }

    @Override
    public void jump(double distJump) {
        if ( distJump <= getLimitRangeJump() ) System.out.printf("Котик прыгнул на %.2f\n",distJump);
        else System.out.printf("Котик не смог прыгнуть %.2f\n", distJump);
    }


}
