package com.freelemon.perf.chapter3.map;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-8
 * Time: 下午3:12
 * To change this template use File | Settings | File Templates.
 */


public class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    public Student(String name, int s){
        this.name = name;
        this.score = s;
    }


    @Override
    public int compareTo(Student o) {
        if (o.score < this.score)
            return 1;
        else if (o.score> this.score)
            return -1;

        return 0;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("name:");
        sb.append(name);
        sb.append(" ");
        sb.append("score:");
        sb.append(score);

        return sb.toString();
    }

    public String getName() {
        return name;
    }
}
