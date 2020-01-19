package ru.avalon.java.actions;

import ru.avalon.java.console.EnumReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyAction implements Action {

    String source;
    String dest;

    public FileCopyAction(String source, String dest){

        this.source = source;
        this.dest = dest;
    }

    public void start(){
        new Thread(this).start();
    }


    @Override
    public void run() {

              Path filenameSource = Paths.get(source);
              Path filenameDestination = Paths.get(dest);

        try {
            Files.copy(filenameSource, filenameDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("tetst");
          //  e.printStackTrace();
        }

        System.out.println("Copying " + source + " to "+ dest + " completed");
    }

    @Override
    public void close() {

        source = null;
        dest = null;
    }
}
