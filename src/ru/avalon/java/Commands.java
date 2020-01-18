package ru.avalon.java;

/**
 * Обрабатываемые приложением команды.
 */

public class Commands{
public enum Command {
    move,
    copy,
    exit
    /*
     * TODO №8 К текущему списку команд, добавьте ещё две команды
     */
}

public Command comm;
public String[] param;

public Commands (String input) throws IllegalCommand{

}


}