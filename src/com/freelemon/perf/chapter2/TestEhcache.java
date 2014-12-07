package com.freelemon.perf.chapter2;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-7
 * Time: 上午12:35
 * To change this template use File | Settings | File Templates.
 */
public class TestEhcache {
    public static void main(String[] args) {
//        CacheManager.create();
//        String[] cacheNames = CacheManager.getInstance().getCacheNames();
//
//        for (int i = 0; i < cacheNames.length ; i++) {
//            System.out.println(cacheNames[i]);
//        }

        CacheManager manager1 = CacheManager.newInstance("src/config/ehcache.xml");
        //CacheManager manager2 = CacheManager.newInstance("src/config/ehcache2.xml");
        String[] cacheNamesForManager1 = manager1.getCacheNames();
        //String[] cacheNamesForManager2 = manager2.getCacheNames();

        // test the loaded name
        for (int i = 0; i < cacheNamesForManager1.length ; i++) {
            System.out.println(cacheNamesForManager1[i]);
        }

        manager1.getCache("myCache1").put(new Element("test1", "test1_value" ));

        System.out.println(manager1.getCache("myCache1").get("test1"));

    }
}
