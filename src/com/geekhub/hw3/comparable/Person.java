package com.geekhub.hw3.comparable;

public class Person implements Comparable {
    private String name;
    private int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.name, this.age);
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        if (this.age == person.age && this.name.equals(person.name)){
            return true;
        } else return false;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        if (this.age > person.age) {
            return 1;
        } else if (this.age < person.age) {
            return -1;
        }
        return 0;
    }
}
