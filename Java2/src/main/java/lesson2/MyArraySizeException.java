package lesson2;

public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException() {
        super("Размер массива не соответствует размеру 4х4");
    }

}
