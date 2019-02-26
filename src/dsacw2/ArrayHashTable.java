/*
    create an array of linked lists
    the linked list should be stored as a binary tree for effenciy.
 */
package dsacw2;

import java.util.Hashtable;

/**
 *
 * @author wck17bhu
 */
public class ArrayHashTable extends Hashtable{
    Object table = new Object[10][];
    int chainSize = 5;
    
    public ArrayHashTable(int capacity){
        table = new Object[capacity][];
    }
    
}
