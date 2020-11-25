package lesson3;

public class Second {
    public static void main(String[] args) {
        PhoneBook phonBook1 =new PhoneBook();
        phonBook1.addPerson("P1", "111111111");
        phonBook1.addPerson("P1", "2222222");
        phonBook1.addPerson("P1", "3333333");
        phonBook1.addPerson("P1", "3333333");
        phonBook1.addPerson("Daf", "123456789012");
        phonBook1.addPerson("Daf", "1236414643");
        phonBook1.addPerson("ASdq","684116843");

        System.out.println(phonBook1.getNumberPerson("Daf"));
        System.out.println(phonBook1.getNumberPerson("P1"));
        System.out.println(phonBook1.getNumberPerson("ASdq"));
    }
}
