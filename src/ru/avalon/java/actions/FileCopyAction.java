package ru.avalon.java.actions;

import ru.avalon.java.console.EnumReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */

//          try(Reader inputStreamReader = new InputStreamReader(System.in)){
//              BufferedReader reader = new BufferedReader(inputStreamReader);
//
//              System.out.print("input source file > ");
//              File filenameSource = new File(reader.readLine());
//
//              System.out.print("input destination file > ");
//
//              File filenameDestination = new File(reader.readLine());
//              filenameDestination.createNewFile();
//
//               try(InputStream inputStream = new FileInputStream(filenameSource);
//                  OutputStream outputStream = new FileOutputStream(filenameDestination)){
//
//                  byte[] buffer = new byte[1024];
//
//                  int length;
//                  while ((length = inputStream.read(buffer)) > 0) {
//                      outputStream.write(buffer, 0, length);
//                  }
//              }
//          } catch (IOException e) {
//              e.printStackTrace();
//          }


        try(Reader inputStreamReader = new InputStreamReader(System.in)){
              BufferedReader reader = new BufferedReader(inputStreamReader);

              System.out.print("input source file > ");
              Path filenameSource = Paths.get(reader.readLine());

              System.out.print("input destination file > ");
              Path filenameDestination = Paths.get(reader.readLine());

              Files.copy(filenameSource, filenameDestination, StandardCopyOption.REPLACE_EXISTING);


          } catch (IOException e) {
              e.printStackTrace();
          }


       // throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
