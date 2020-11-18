package lesson1;

import java.util.Arrays;

/**
 *  класс Team, который будет содержать: название команды, массив из 4-х участников
 *  (т.е. в конструкторе можно сразу всех участников указывать), метод для вывода
 *  информации о членах команды прошедших дистанцию, метод вывода информации обо всех членах команды*/
public class Team {
    private String nameTeam;
    Action [] teamsMember;

    public Team(String nameTeam, Action ... teamsMember)  {
        this.nameTeam = nameTeam;
        this.teamsMember = teamsMember;
    }

    public void winTeam () {
        String winMember = "Команда " + nameTeam + " прошли дистанцию: \n";

        for (Action i : teamsMember) {
            if (i.isOnDistance()) {
                winMember += i.getName() + "\n";
            }
        }
        System.out.println(winMember);
    }

    public void allTeam () {
        System.out.println("Команда " + nameTeam + ":");

        for (Action i : teamsMember) {
            if (i.isOnDistance()) {
                System.out.println(i.getName() + " прошел препятствия");
            } else {
                System.out.println(i.getName() + " не смог пройти препятствия");
            }
        }
        System.out.println('\n');
    }


    public Action [] getTeamsMember( ) {
        return teamsMember ;
    }

    @Override
    public String toString() {
        return "Team{" +
                "nameTeam='" + nameTeam + '\'' +
                ", teamsMember=" + Arrays.toString(teamsMember) +
                '}';
    }
}
