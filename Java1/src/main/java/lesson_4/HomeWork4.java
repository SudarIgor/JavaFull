package lesson_4;

import java.util.Scanner;

public class HomeWork4 {

    static Scanner sc = new Scanner(System.in);

    public static char[][] MAP;
    private static boolean isInGame;
    private static int SIZE;
    private static final char PLAER = 'X';
    private static final char PC = 'O';
    private static final char DEFAULT = '_';

    static void fillMap(int size) {
        isInGame = true;
        MAP = new char[size][size];
        SIZE = size;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    static void movePlayer() {
        System.out.println("\nВаш ход:");
        while (true) {
            int x, y;
            try {
                x = sc.nextInt();
                y = sc.nextInt();
                --x;
                --y;
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
                sc.nextLine();
                continue;
            }
            try {
                if (MAP[x][y] == DEFAULT) {
                    MAP[x][y] = PLAER;
                    break;
                } else {
                    System.out.println("Попробуйте снова");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Попробуйте снова");
                continue;
            }
        }
    }

    private static void moveAI() {
        System.out.println("Ход компьютера");
        int x, y;
        while (true) {
            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
            if (MAP[x][y] == DEFAULT) {
                MAP[x][y] = PC;
                break;
            }
        }
    }

    public static boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
               if (MAP [i] [j] == DEFAULT ) return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonalFourAndMore(int sq, char symbol) {


        boolean toRight, toLeft;

        for (int a = 0; a <= sq; a++) {
            for (int z = 0; z <=sq ; z++) {
                toRight = true;
                toLeft = true;
                for (int i = 0; i < 4 ; i++) {
                    toRight &= (MAP[i+a][i+z] == symbol);
                    toLeft &= (MAP[4 - i + a - 1][i+z] == symbol);
                }
                if (toRight || toLeft) return true;
            }
        }

        return false;
    }
    public static boolean checkDiagonalTree(char symbol){

        boolean toRight, toLeft;
        toRight = true;
        toLeft = true;
        for (int i=0; i<3; i++) {
            toRight &= (MAP[i][i] == symbol);
            toLeft &= (MAP[3-i-1][i] == symbol);
        }

        if (toRight || toLeft) return true;

        return false;
    }

    public static boolean win(char symbol){
        int winSer, count, sq;
        boolean diag;
        if (SIZE ==3) winSer = 3;
        else winSer = 4;
        sq=SIZE-winSer;
        // Проверка по горизонтали
//        for (int i = 0; i < SIZE - 1; i++) {
//            count = 1;
//            for (int j = 0; j < SIZE - 1; j++) {
//                if ( (MAP [i][j] == symbol) & (MAP [i][j+1] == symbol)) {
//                    count++;
//                    if (count == winSer) return true;
//                }
//                else count = 1;
//            }
//        }
//        // Проверка по вертикали
//        for (int j = 0; j < SIZE - 1; j++) {
//            count = 1;
//            for (int i = 0; i < SIZE - 1; i++) {
//                if ( (MAP [i][j] == symbol) & (MAP [i+1][j] == symbol)) {
//                    count++;
//                    if (count == winSer) return true;
//                }
//                else count = 1;
//            }
//        }
        if (SIZE == 3) diag = checkDiagonalTree(symbol);
        else {
            diag = checkDiagonalFourAndMore(sq, symbol);
        }
        if (diag) return true;

        return false;
    }

    public static void game(){
        SIZE =6;
        System.out.println("""
                Игра крестики-нолики!
                Вы играете за Х
                Для того, чтобы совершить ход: введите номер строки и номер столбца
                """);
        fillMap(SIZE);
        printMap();
        while(!isMapFull()){
            movePlayer();
            printMap();
            if (win(PLAER)) {
                System.out.println("Вы выйграли!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            moveAI();
            printMap();
            if (win(PC)) {
                System.out.println("Вы проиграли!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void main (String[]args){
        game();
    }
}

