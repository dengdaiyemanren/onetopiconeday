package org.com.onetopic.jcip.safecollections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.com.onetopic.jcip.annotations.*;

/**
 * HiddenIterator
 * <p/>
 * Iteration hidden within string concatenation
 *
 * @author Brian Goetz and Tim Peierls
 */
@NotThreadSafe
public class HiddenIterator
{
    @GuardedBy("this") private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }
    
    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        //println and iterator will happen CocurrentModificationException 
        System.out.println("DEBUG: added ten elements to " + set);
    }
    
}
