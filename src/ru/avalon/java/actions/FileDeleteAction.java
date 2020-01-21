package ru.avalon.java.actions;

import ru.avalon.java.Lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileDeleteAction implements Action {

    String source;
    String dest;

    public FileDeleteAction(String source){

        this.source = source;
    }

    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {

        boolean error = false;

        Path filenameSource = Paths.get(source);

        try {
            Files.delete(filenameSource);
        } catch (IOException e) {
            Lab3.errorStatus = true;
            System.out.println("Deleting error");
            System.out.print("> ");
            Lab3.errorStatus = false;
            error = true;
        }

        if(!error) {
            System.out.println("Deleting " + source + " completed");
            System.out.print("> ");
        }
    }

    @Override
    public void close() {
        source = null;
        dest = null;
    }
}
