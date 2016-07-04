package exercise0;

import java.util.HashMap;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map

        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        hashMap.put(5, "X");
        hashMap.put(5, "E");

        for(Integer i:hashMap.keySet()){
            System.out.println("Key: "+ i+", Value: "+hashMap.get(i));
        }
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
