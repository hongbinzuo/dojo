package com.freelemon.perf.chapter3.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-8
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class TestSortStudent {
    public static void main(String[] args) {
        Map map = new TreeMap();

        Student s1 = new Student("Billy", 95);
        Student s2 = new Student("boy", 90);
        Student s3 = new Student("Jack", 100);
        Student s4 = new Student("Smith", 87);
        Student s5 = new Student("Tom", 87);
        Student s6 = new Student("Jackson", 89);
        Student s7 = new Student("Will", 82);
        Student s8 = new Student("Thomas", 78);

        map.put(s1, new StudentDetail(s1));
        map.put(s2, new StudentDetail(s2));
        map.put(s3, new StudentDetail(s3));
        map.put(s4, new StudentDetail(s4));
        map.put(s5, new StudentDetail(s5));
        map.put(s6, new StudentDetail(s6));
        map.put(s7, new StudentDetail(s7));
        map.put(s8, new StudentDetail(s8));


        Map map1 = ((TreeMap)map).subMap(s7, s2);

        for(Iterator iterator= map1.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();

            System.out.println(key+"->"+map1.get(key));
        }

        System.out.println("subMap end");

        map1 = ((TreeMap)map).headMap(s1);

        for(Iterator iterator= map1.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();

            System.out.println(key+"->"+map1.get(key));
        }

        System.out.println("headMap end");

        map1 = ((TreeMap)map).tailMap(s1);

        for(Iterator iterator= map1.keySet().iterator();iterator.hasNext();){
            Student key = (Student) iterator.next();

            System.out.println(key+"->"+map1.get(key));
        }

        System.out.println("tailMap end");


    }
}
