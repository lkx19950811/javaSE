package lamdba;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author leo
 * @date 2018-05-02 14:33
 * @description:
 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
        age = new Random().nextInt(40);
        name = String.valueOf((char) new Random().nextInt(60));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.getAge();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Test
    public void test(){
        String abc = null + "sadfdsaf";
        System.out.println(abc);
        setName(abc);
    }
}
