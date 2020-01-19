package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.console.ConsoleUI;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Lab3 extends ConsoleUI {

    public static void main(String[] args) {
        new Lab3().run();
    }

        @Override
    protected void onCommand(Commands command){
        switch (command.comm) {
            case copy:

                new FileCopyAction(command.param[0], command.param[1]).start();

                System.out.println("Copying started");

                break;

            case move:

                new FileMoveAction(command.param[0], command.param[1]).start();

                System.out.println("Moving started");

                break;

            case exit:

                close();

                break;

            case delete:

                //to add

                break;

            case rename:

                //to add

                break;
        }
    }
}
