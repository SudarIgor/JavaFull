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

        Course course1 = new Course(wall1, runningTrack1);
        Course course2 = new Course(wall2, runningTrack2);

        Team team1 = new Team("AAA", robot1, robot2, human1, cat1);
        Team team2 = new Team("BBB", human1, cat2, cat1, robot1 );

        course1.moving(team1);
        team1.allTeam();
        team1.winTeam();

        course2.moving(team2);
        team2.winTeam();
    }
}
