package com.freelemon.concurrency.chp13;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-11-15
 * Time: 下午4:22
 * To change this template use File | Settings | File Templates.
 */
public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock r = lock.readLock();
    private final Lock w = lock.writeLock();

    public ReadWriteMap(Map<K, V> map){
        this.map = map;
    }

    public V put(K key, V value){
        w.lock();
        try{
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public V get(Object key){
        r.lock();

        try{
            return map.get(key);
        } finally {
            r.unlock();
        }

    }

}
