package lesson2;

public class Main {

    public static void getArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        if (array.length == 0) throw new MyArraySizeException();
        for (String [] i: array) {
            if (array.length != 4 || i.length !=4) throw new MyArraySizeException();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try { sum += Integer.parseInt(array[i][j]);
                }catch(NumberFormatException e) {
                    throw new MyArrayDataException(array);
                }
            }
        }
    }

    public static void main(String[] args) {
        String [][] arrString1;
        arrString1 = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"}
        };

        String [][] arrString2;
        arrString2 = new String[][]{
            {"1", "2", "3", "4"},
            {"5", null, "7", "8"},
            {"1", "2", "р", "4"},
            {"0,2", "6", "7", "8"}
        };

        getArray(arrString1);
        getArray(arrString2);

    }
}
