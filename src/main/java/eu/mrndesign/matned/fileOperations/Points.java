package eu.mrndesign.matned.fileOperations;

public class Points {

    public static int get (int time, int numberOfColumns, int numberOfRows, int numberOfBombs) {
        int numberOfFields = numberOfColumns*numberOfRows;
        if(numberOfBombs == numberOfFields) return 0;
        else {
            if(numberOfFields == 0) return 0;
            else return ((numberOfBombs/numberOfFields)-time/100);
        }
    }
}
