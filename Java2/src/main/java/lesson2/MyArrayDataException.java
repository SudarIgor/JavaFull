package lesson2;

public class MyArrayDataException extends NumberFormatException {
    private final String[][] array;

    private static boolean flag = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public MyArrayDataException(String [][] array) {
        super("Ошибка формата");
        this.array = array;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    Integer.parseInt(array[i][j]);
                    flag = false;
                } catch (NumberFormatException e) {
                   flag = true;
                }
                if (flag) {
                    System.out.printf(ANSI_RED+ "Элемент массива в столбце %d строке %d " +
                            "не является целым числом.\n" + ANSI_RESET , (i+1), (j+1));
                }
            }
        }
    }

}
