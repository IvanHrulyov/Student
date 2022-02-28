package lesson2.exceptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
