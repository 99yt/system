package com.blb.entily;

public class Animal {
    private int id;
    private String name;
    private int age;
    private String kind;
    private String gender;

    public Animal() {
    }
    public Animal( String name, int age, String kind, String gender) {

        this.name = name;
        this.age = age;
        this.kind = kind;
        this.gender = gender;
    }

    public Animal(int id, String name, int age, String kind, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kind = kind;
        this.gender = gender;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Aniaml{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", kind='" + kind + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
