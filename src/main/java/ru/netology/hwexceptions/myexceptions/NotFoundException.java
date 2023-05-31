package ru.netology.hwexceptions.myexceptions;
public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
