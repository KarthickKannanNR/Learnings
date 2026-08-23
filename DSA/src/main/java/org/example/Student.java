package org.example;

import java.util.HashMap;

public class Student {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getFriend() {
        return friend;
    }

    public void setFriend(Student friend) {
        this.friend = friend;
    }

    private String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    Student friend;

    public static void main(String[] args) {
        Student s1= new Student(1,"karthick");
        Student s2 = new Student(2, "kannan");
        s1.friend = s2;

        System.out.println(s1);
        System.out.println(s2);
        s2 = null;
        System.out.println(s1.friend);
        System.out.println(s2);


        Student s3 = new Student(3,"john");
        HashMap<Student, String> studentMap = new HashMap<>();
        studentMap.put(s3,"developer");
        s3.setName("sam");
        s3 = null;
        
        System.out.println(studentMap.get(s3));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


