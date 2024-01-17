package util;

import rents.Status;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {
    private static String filePath = "Status.txt";

    public FileIO(Status status) {
        writeToFile(status);
    }

    public void writeToFile(Status status){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(status.getContent());
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}


