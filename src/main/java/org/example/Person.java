package org.example;
import java.util.ArrayList;

public class Person {

    private String name;
    private String middleName;
    private String lastname;
    private int age;
    private String sex;
    private Person mother;
    private Person father;
    ArrayList<Person> siblings;
    ArrayList<Person> children;
    ArrayList<Pet> pets;


    //- constructor met name, lastname, age en sex
public Person(String name, String lastname, int age, String sex) {
    this.name = name;
    this.lastname = lastname;
    this.age = age;
    this.sex = sex;
}
//- constructor met name, middleName, lastname, age en sex
    public Person(String name, String middleName, String lastname, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
    }


    public void addParents(Person father, Person mother, Person child){
        child.setMother(mother);
        mother.addChildToChildren(mother, child);
        child.setFather(father);
        father.addChildToChildren(father, child);
    }


    public void addChildToChildren(Person parent, Person child){
        ArrayList<Person> kids = new ArrayList<>();
        if(parent.getChildren()!= null) {
            for (Person person : parent.getChildren()) {
                kids.add(person);
            }
        }
        kids.add(child);
        parent.setChildren(kids);
    }

    public void addPet(Person person, Pet pet){
        ArrayList<Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public void addSibling(Person person, Person sibling) {
        ArrayList<Person> family = new ArrayList<>();
        if (person.getSiblings() != null) {
            for (Person people : person.getSiblings()) {
                family.add(people);
            }
        }
        family.add(sibling);
        person.setSiblings(family);
    }

    public ArrayList<Person> getGrandChildren(Person person){
        ArrayList<Person> grandChildren = new ArrayList<>();
        if(person.getChildren() != null){
            for (Person children : person.getChildren()) {
                if(children.getChildren() != null){
                    for (Person grandKid : children.getChildren()) {
                        grandChildren.add(grandKid);
                    }
                }
            }
        }
        return grandChildren;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(ArrayList<Person> siblings) {
        this.siblings = siblings;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Person> children) {
        this.children = children;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    //- getters & setters
//- addParents methode
//- addChild methode
//- addPet methode
//- addSibling methode
//- getGrandChildren method


}
