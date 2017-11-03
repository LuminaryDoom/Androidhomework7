package nyc.c4q.homeworksimonsays;

import java.util.LinkedList;

/**
 * Created by c4q on 10/30/17.
 */

public class StoreTurn {


    public static int turnCounter = 0;

    public static LinkedList <String> list1 = new LinkedList<>();

    public static void addToList(String choice) {
        list1.add(choice);
    }

}
