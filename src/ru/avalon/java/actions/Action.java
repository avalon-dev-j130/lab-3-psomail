package ru.avalon.java.actions;

public interface Action extends Runnable, AutoCloseable {

    default void start() {

        new Thread(this).start();
    }
}
