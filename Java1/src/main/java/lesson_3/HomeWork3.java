package lesson_3;

import java.util.Scanner;

public class HomeWork3 {

    static Scanner sc = new Scanner (System.in);

    static int getRandomNumber (int upperLimit) {
        return (int) (Math.random() * (upperLimit ) );
    }

    static int replay(int flag){
        int answer = 6;
        System.out.println("Повторить игру еще раз? »(1 – повторить, 0 – нет)");
        answer = sc.nextInt();
        if (answer !=0 && answer !=1) {
            while (true) {
                System.out.println("Введите 1 – да / 0 – нет");
                answer = sc.nextInt();
                if (answer ==0 || answer == 1) {
                    break;
                }
            }
        }
        return answer;
    }

    static void gameGuessNumber(){
        int flag = 0;
        int num, userAnswer;
        int count;
        System.out.printf("Сыграем в игру. \nВаша задача угадать зазгаданное число " +
                "в диапазоне от 0 до 9.\nУ Вас 3 попытки \n\n");
        do {
            count = 0;
            num = getRandomNumber (10);
            System.out.println("Число загадано!!!");
            for (int i = 1; i <= 3; i++) {
                System.out.printf("Попытка №%d \tЗагаданное число?\n",i);
                userAnswer = sc.nextInt();
                    if ( userAnswer == num) {
                        System.out.println("Поздравляем, Вы угадали!!!");
                        flag = replay(flag);
                        break;
                    }
                    else if (userAnswer < num) System.out.println("Ваше число меньше загаданного.");
                    else System.out.println("Ваше число больше загаданного.");
                count++;
            }
            if (count == 3) {
                System.out.println("\nК сожалению Вы не уложились в 3 попытки и проиграли...\n" +
                        "Загаданное числобыло:" + num + "\n");
                flag = replay(flag);
            }
        }while (flag == 1);
    }

    static void gameWords(){
        int indexWord, indexLetter, flag = 0;
        String userAnswer;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.printf("\t\tСыграем в игру. \nВаша задача угадать зазгаданное слово. " +
                "\nМожно использовать только прописные буквы \n\n");

        do{
            indexLetter =0;
            indexWord = getRandomNumber(words.length);
            System.out.println("Слово загадано.");
            do{
                System.out.println("Ваше слово?");
                userAnswer = sc.next();
                if (words[indexWord].equals(userAnswer)) System.out.println("Поздравляем, Вы выйграли!!!");
                if (!words[indexWord].equals(userAnswer)){
                    System.out.println("Подсказка:");
                    int i = 0;
                    for (i = 0; i <=indexLetter ; i++) System.out.print( words[indexWord].charAt(i));
                    if (words[indexWord].length()== i) {
                        System.out.println("\nК сожалению вы не смогли угадть слово. \n " +
                                "Загаданое слово было: " + words[indexWord]);
                        break;
                    }
                    for (int j = i; j < 16; j++) System.out.print("#");
                    System.out.println("");
                    }
                indexLetter++;
            }while ( !words[indexWord].equals(userAnswer) );
            flag = replay(flag);
        }while (flag == 1);
    }

    public static void main(String[] args) {
        /**
         * 1. Написать программу, которая загадывает случайное число от 0 до 9,
         * и пользователю дается 3 попытки угадать это число.
         * При каждой попытке компьютер должен сообщить больше ли указанное
         * пользователем число чем загаданное, или меньше.
         * После победы или проигрыша выводится запрос –
         * «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/
//        gameGuessNumber();

        /**
         * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
         * "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
         * "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
         * "pineapple", "pumpkin", "potato"};
         *
         *  При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
         * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
         * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
         * apple – загаданное
         * apricot - ответ игрока
         * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
         * Для сравнения двух слов посимвольно, можно пользоваться:
         * String str = "apple";
         * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
         * Играем до тех пор, пока игрок не отгадает слово
         * Используем только маленькие буквы*/
//        gameWords();
    }
}
