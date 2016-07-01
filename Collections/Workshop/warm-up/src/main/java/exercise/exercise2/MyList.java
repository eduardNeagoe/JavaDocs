package exercise.exercise2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Radu.Hoaghe on 20.04.2015.
 *
 * Exercise 2: Create a class that inherits ArrayList<Integer> (class MyList<Integer>).
 *
 *             This list (MyList) should have the following functionality, besides the functionality
 *             that ArrayList already offers: it should retain in every moment how many different
 *             elements exist in the list.
 *                  
 *                  Examples: 1. If you have a List that contains: 7 5 3 2 4 1, there are 6 different elements.
 *                            2. If you have a List that contains: 5 6 1 2 5 6, there are 4 different elements.
 *
 *             A variable that retains the number of different elements that exist in the list in
 *             every moment was already defined (differentElements).
 *
 *             First of all, you will need to override the add methods so that every time a different
 *             element is added the counter will be updated.
 *                      Hint : check out the List documentation to see the methods signatures.
 *
 *             Secondly, you will also need to override the remove methods (Hint: of course, the List
 *             documentation) because the number of different elements in the list could change if
 *             the last element of its kind in the list is removed and by not overrriding it the
 *             counter will remain unchanged.
 *
 *             Finally, you will need to override the clear method and create a getter method for the
 *             counter (in order to access it outside the class).
 *
 *             In order to add/remove/clear the elements into/from the list you will need to use the
 *             add/remove/clear methods inherited from ArrayList.
 *
 *             To test your implementation run the Exercise2Test class.
 *
 */
public class MyList<Integer> extends ArrayList<Integer> {

    // A counter to hold the number of adds that were made on the list
    private int differentElements;

    public MyList(){
        differentElements = 0;
    }

    // TODO Exercise #2 a) Override add() and addAll() methods so that the list should retain the number of
    // TODO Exercise #2 a) different elements (Hint: check out the methods signatures on the List documentation)

    @Override
    public boolean add(Integer integer) {
//        super.add(integer);
        boolean flag = true;
        for(int i = 0 ; i < super.size(); i++){
            if(super.get(i) == integer ) {
                flag = false;
                break;
            }

        }
        if(flag == true){
            differentElements++;
        }

        return super.add(integer);
    }

    @Override
    public void add(int index, Integer integer) {
        boolean flag = true;
        for(int i = 0 ; i < super.size(); i++){
            if(super.get(i) == integer ) {
                flag = false;
                break;
            }

        }
        if(flag == true){
            differentElements++;
        }
        super.add(index, integer);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> lista) {
//        super.addAll(lista);
        for(Integer elem : lista){
            boolean flag = true;

            for(int i = 0 ; i < super.size(); i++){

                if(super.get(i) ==  elem) {
                    flag = false;
                    break;
                }

            }
            if(flag == true){
                differentElements++;
            }

        }
        return super.addAll(lista);

    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> lista) {
        for(Integer elem : lista){
            boolean flag = true;

            for(int i = 0 ; i < super.size(); i++){

                if(super.get(i) ==  elem) {
                    flag = false;
                    break;
                }

            }
            if(flag == true){
                differentElements++;
            }

        }
        return super.addAll(index, lista);
    }

    @Override
    public Integer remove(int index) {
        Integer value = super.get(index);
        boolean flag = true;


            for(int i = 0 ; i < super.size(); i++){

                if(index != i && super.get(i) ==  value) {
                    flag = false;
                    break;
                }

            }
            if(flag == true){
                differentElements--;

            }
        return super.remove(index);
    }

    @Override
    public boolean remove(Object integer) {
        super.remove(integer);

//        boolean flag = true;
        if(!this.contains(integer)){
            differentElements--;
        }

        return true;
    }

    @Override
    public void clear() {
        super.clear();
        differentElements = 0;
    }

    // TODO Exercise #2 b) Override the remove methods so that the number of different elements is updated when
    // TODO Exercise #2 b) an element is removed
    // TODO Exercise #2 b) hint: you need to update the number of different elements only when
    // TODO Exercise #2 b) the element that needs to be removed is the last element of its kind in the list

    // TODO Exercise #2 c) Override the clear method and reset the number of different elements

    // TODO Exercise #2 d) Return the number of different elements that exist into the list

    public int getDifferentElements() {

        return differentElements;
    }
}
