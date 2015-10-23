package org.com.onetopic.jcip.safecollections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.com.onetopic.jcip.annotations.GuardedBy;

public class SafeHiddenIterator
{
    @GuardedBy("this")
    private final Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());
    
    public synchronized void add(Integer i)
    {
        set.add(i);
    }
    
    public synchronized void remove(Integer i)
    {
        set.remove(i);
    }
    
    public void addTenThings()
    {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        // println and iterator will happen CocurrentModificationException
        System.out.println("DEBUG: added ten elements to " + set);
    }
    
}
