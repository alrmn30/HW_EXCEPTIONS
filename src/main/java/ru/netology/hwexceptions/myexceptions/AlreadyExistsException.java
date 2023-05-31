package ru.netology.hwexceptions.myexceptions;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String s) {
        super(s);
    }
}
