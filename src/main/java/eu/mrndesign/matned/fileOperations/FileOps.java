package eu.mrndesign.matned.fileOperations;

import java.io.*;
import java.util.LinkedList;

class FileOps {

    private static final String PATH = "src\\main\\resources\\saper\\data\\score.s";
    private static final String THERE_WAS_A_PROBLEM_MSG = "There was a problem!";
    private static final String CLASS_NOT_FOUND_MSG = "Class not found";

    FileOps() {
    }

    void writeToFile(LinkedList list) {
        try {
            File file = new File(PATH);
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(list);
            objectOut.close();
        } catch (Exception ex) {
            System.out.println(THERE_WAS_A_PROBLEM_MSG);
        }
    }

    LinkedList readTop100ListFromFile() {
        LinkedList list;
        try
        {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (LinkedList) ois.readObject();
            ois.close();
            fis.close();
            return list;
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println(CLASS_NOT_FOUND_MSG);
            c.printStackTrace();
            return null;
        }
    }

}



