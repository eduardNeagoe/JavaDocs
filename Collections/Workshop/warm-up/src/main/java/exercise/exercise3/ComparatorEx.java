package exercise.exercise3;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Eduard on 01.07.2016.
 */
public class ComparatorEx implements Comparator<String>{



    public int compare(String o1, String o2) {
        if(o1.length() == o2.length()){
            return 0;
        }

        if(o1.length() > o2.length()){
            return -1;
        }
//        if(o1.length() < o2.length()){
//
//        }
        return 1;
    }
}
