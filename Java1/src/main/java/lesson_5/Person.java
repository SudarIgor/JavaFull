package lesson_5;


public class Person {

    private String fistNane;
    private String patronymic;
    private String lastName;
    private String position;
    private String telephone;
    private String email;
    private float salary;
    private int age;

    public Person(String fistNane, String patronymic, String lastName,
                  String position, String telephone, String email, float salary, int age) {
        this.fistNane = fistNane;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.position = position;
        this.telephone = telephone;
        this.email = email;
        this.salary = salary;
        this.age = age;

    }

    public int getAge(){
        return age;
    }
    public void printDataPerson(){
        System.out.printf ("Фамилия:\t%s\nИмя:\t\t%s\nОтчество:\t%s\nДолжность:" +
                "\t%s\nТелефон:\t%s\nemail:\t\t%s\nЗарплата:\t%.2f\nВозраст:\t%d" +
                        "\n_______________________\n",
                lastName, fistNane, patronymic, position, telephone, email, salary, age);
    }

}
