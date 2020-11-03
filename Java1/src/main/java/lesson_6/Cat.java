package lesson_6;

public class Cat extends Animal {

    public Cat() {
        setAnimal("Котик");
        setLimitRangeJump(1.8 + ( (double) (Math.random()*(2 * 0.2) ) ) );
        setLimitRangeRun(180 + ( (int) (Math.random()*(200 * 0.2) ) ));
    }

}
