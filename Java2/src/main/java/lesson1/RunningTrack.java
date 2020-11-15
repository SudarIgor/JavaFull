package lesson1;

public class RunningTrack extends Barrier {
    private double lengthTrack;

    public RunningTrack(float lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    public double getLengthTrack() {
        return lengthTrack;
    }

    public void setLengthTrack(double lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    @Override
    public String toString() {
        return "Длина беговой дорожки  " + lengthTrack;
    }

    @Override
    public boolean moving(Action action) {
        System.out.println(action.getName() + " начинает бежать");
        if (getLengthTrack() <= action.getRangeRun()) {
            System.out.println("Успех!");
            return true;
        } else {
            System.out.println("Провал!");
        }
        return false;
    }
}
