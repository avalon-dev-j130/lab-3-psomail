package ru.avalon.java.actions;

import ru.avalon.java.Lab3;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileMoveAction implements Action {

    String source;
    String dest;

    public FileMoveAction(String source, String dest){

        this.source = source;
        this.dest = dest;
    }

    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {

        boolean error = false;

        Path filenameSource = Paths.get(source);
        Path filenameDestination = Paths.get(dest);

        try {
            Files.move(filenameSource, filenameDestination, REPLACE_EXISTING);
        } catch (IOException e) {
            Lab3.errorStatus = true;
            System.out.println("Moving error");
            System.out.print("> ");
            Lab3.errorStatus = false;
            error = true;
        }

        if(!error) {
            System.out.println("Moving " + source + " to "+ dest + " completed");
            System.out.print("> ");
        }
    }

    @Override
    public void close() {
        source = null;
        dest = null;
    }
}
