package lesson1;

import java.io.OutputStream;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Вася");
        Cat cat2 =new Cat("Черный");
        Human human1 = new Human("Аластор");
        Human human2 = new Human("Торри");
        Robot robot1 = new Robot("HDI12");
        Robot robot2 = new Robot("DFS321");

        Wall wall1 = new Wall(1.2);
        Wall wall2 = new Wall(2);

        RunningTrack runningTrack1 = new RunningTrack(100);
        RunningTrack runningTrack2 = new RunningTrack(200);

        Action [] action = {
                cat1,
                cat2,
                human1,
                human2,
                robot1,
                robot2
        };

        Barrier [] barriers = new Barrier[4];
        barriers [0] = wall1;
        barriers [1] = runningTrack1;
        barriers [2] = wall2;
        barriers [3] = runningTrack2;


        for ( Action i : action) {
            for (Barrier j : barriers) {
                j.moving(i);
                if (!i.isOnDistance()) break;
            }

        }
    }
}
