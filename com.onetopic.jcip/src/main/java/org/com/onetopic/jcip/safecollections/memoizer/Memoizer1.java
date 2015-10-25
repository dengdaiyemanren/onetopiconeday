package org.com.onetopic.jcip.safecollections.memoizer;

import java.math.BigInteger;
import java.util.*;

import org.com.onetopic.jcip.annotations.GuardedBy;

/**
 * Memoizer1
 * Initial cache attempt using HashMap and synchronization
 *
 * @author Brian Goetz and Tim Peierls
 * @param <A>
 * @param <V>
 */
public class Memoizer1<A, V> implements Computable<A, V>
{
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;
    
    public Memoizer1(Computable<A, V> c)
    {
        this.c = c;
    }
    
    public synchronized V compute(A arg) throws InterruptedException
    {
        V result = cache.get(arg);
        if (result == null)
        {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

interface Computable<A, V>
{
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger>
{
    public BigInteger compute(String arg)
    {
        // after deep thought...
        return new BigInteger(arg);
    }
}