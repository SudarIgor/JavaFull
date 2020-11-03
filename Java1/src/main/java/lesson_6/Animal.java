package lesson_6;

class Animal {
    private String animal;
    private double limitRangeRun;
    private double limitRangeJump;

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

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

    public void run(double distRun) {
        if (distRun <= getLimitRangeRun()) System.out.printf("%s пробежал %.2f\n", animal, distRun);
        else System.out.printf("%s не смог пробежать %.2f\n", animal, distRun);
    }

    public void jump(double distJump) {
        if (distJump <= getLimitRangeJump()) System.out.printf("%s прыгнул на %.2f\n",animal, distJump);
        else System.out.printf("%s не смог прыгнуть %.2f\n",animal, distJump);
    }
}
