package lesson_5;

public class HomeWork5 {

    /**
     * 1.	Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
     * 2.	Конструктор класса должен заполнять эти поля при создании объекта.
     * 3.	Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     * 4.	Создать массив из 5 сотрудников.
     * 5.	С помощью цикла вывести информацию только о сотрудниках старше 40 лет.*/

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivan","Ivavocich", "Ivanov", "Engineer",
                "892312312", "ivivan@mailbox.com", 30000, 30);
        persArray[1] = new Person("Iran","Iravocich", "Iranov", "Engineer",
                "892312311", "irivan@mailbox.com", 35000, 41);
        persArray[2] = new Person("Vlad","Ivavocich", "Ivanov", "Engineer",
                "892312812", "vlad@mailbox.com", 30000, 28);
        persArray[3] = new Person("Alexandr","Alexandrovihc", "Alexandrov", "Engineer",
                "892312310", "aaa@mailbox.com", 40000, 50);
        persArray[4] = new Person("Alex","Alexeevich", "Alexiev", "Engineer",
                "892312312", "ivivan@mailbox.com", 35000, 39);

        for (Person i : persArray) {
            if (i.getAge() > 40) i.printDataPerson();
        }
    }

}
