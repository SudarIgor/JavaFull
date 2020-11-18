package lesson1;

/**
 * Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий,
 * метод который будет просить команду пройти всю полосу;*/

public class Course {
    Barrier [] barriers;

    public Course(Barrier... barriers) {
        this.barriers = barriers;
    }


    public void moving(Team team) {
        for (Action i: team.getTeamsMember()) {
            for (Barrier j: barriers ) {
                j.moving(i);

            }
        }
    }

}
