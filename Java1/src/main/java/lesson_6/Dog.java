package lesson_6;

public class Dog extends Animal {
    private double limitRangeSwime;

    public Dog() {
        setLimitRangeJump(0.5 + ( (double) (Math.random()*(0.4 * 0.2) ) ) );
        setLimitRangeRun(500 + ( (int) (Math.random()*(500 * 0.2) ) ));
        limitRangeSwime = 8  + ( (int) (Math.random()*(8 * 0.2) ) );
    }

    public double getLimitRangeSwime() {
        return limitRangeSwime;
    }

    public void setLimitRangeSwime(double limitRangeSwime) {
        this.limitRangeSwime = limitRangeSwime;
    }

    @Override
    public void run(double distRun) {
        if ( distRun <= getLimitRangeRun() ) System.out.printf("Песик пробежал %.2f\n",distRun);
        else System.out.printf("Песик не смог пробежать %.2f\n", distRun);
    }

    @Override
    public void jump(double distJump) {
        if ( distJump <= getLimitRangeJump() ) System.out.printf("Песик прыгнул на %.2f\n",distJump);
        else System.out.printf("Песик не смог прыгнуть %.2f\n", distJump);
    }

    public void swime (double distSwime){
        if ( distSwime <= limitRangeSwime ) System.out.printf("Песик проплыл %.2f\n",distSwime);
        else System.out.printf("Песик не смог проплыть %.2f\n", distSwime);
    }


}
