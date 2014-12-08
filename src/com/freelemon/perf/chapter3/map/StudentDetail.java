package com.freelemon.perf.chapter3.map;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-12-8
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class StudentDetail {
    Student student;
    public StudentDetail(Student student){
        this.student = student;
    }

    public String toString(){
        return student.getName() + "'s detail info";
    }
}
