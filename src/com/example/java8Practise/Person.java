package com.example.java8Practise;
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
        return age;
    }
}