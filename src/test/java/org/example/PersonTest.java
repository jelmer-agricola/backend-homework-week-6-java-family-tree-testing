package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PersonTest {


    Person father;
    Person mother;
    Person child;

    @BeforeEach
    void beforeEachTest() {
        father = new Person("vader", "jonathan", "kok", 22, "male");
        mother = new Person("moeder", "kokMa", 22, "male");
        child = new Person("kind", "kokKind", 5, "male");

    }


    @Test
    void getName() {
        //   Arrange

        //   act
        String name = father.getName();

        //    assert
        assertEquals("vader", name);

    }

    @Test
    void getMiddleName() {
        //  Arrange

        // act
        String middleName = father.getMiddleName();

        //  assert
        assertEquals("jonathan", middleName);
    }

    @Test
    void getLastname() {
        //  Arrange

        // act
        String lastName = mother.getLastname();

        //  assert
        assertEquals("kokMa", lastName);
    }

    @Test
    void getAge() {
        //  Arrange


        // act
        int age = child.getAge();

        //  assert
        assertEquals(5, age);

    }

    @Test
    void getSex() {
        //  Arrange

        // act
        String sex = father.getSex();

        //  assert
        assertEquals("male", sex);
    }

    @Test
    void getMother() {
        //  Arrange
        Person kind1 = new Person("kind", "kinderson", 2, "male");
        Person moeder1 = new Person("moeder", "kinderson", 2, "male");
        kind1.setMother(moeder1);

        // act
        Person mother = kind1.getMother();

        //  assert
        assertEquals(moeder1, mother);
    }

    @Test
    void getFather() {
        //  Arrange
        Person kind1 = new Person("kind", "kinderson", 2, "male");
        Person vader1 = new Person("vader", "kinderson", 2, "male");
        kind1.setFather(vader1);

        // act
        Person mother = kind1.getFather();

        //  assert
        assertEquals(vader1, mother);
    }

    @Test
    void getSiblings() {
        //        Arrange
        Person personWithSiblings = new Person("mat", "matson", 34, "male");
        Person sibling1 = new Person("Pat", "matson", 34, "male");
        Person sibling2 = new Person("Cat", "matson", 34, "male");
        ArrayList<Person> brothersSisters = new ArrayList<>();
        brothersSisters.add(sibling1);
        brothersSisters.add(sibling2);
        personWithSiblings.setSiblings(brothersSisters);


        //        Act
        ArrayList<Person> siblings = personWithSiblings.getSiblings();

        //        Assert
        assertEquals(brothersSisters, siblings);
    }

    @Test
    void getChildren() {
        //        Arrange
        Person child1 = new Person("kind1", "ouderson", 4, "male");
        Person child2 = new Person("kind2", "ouderson", 4, "male");
        Person parent = new Person("ouder", "ouderson", 4, "male");

        ArrayList<Person> kids = new ArrayList<>();
        kids.add(child1);
        kids.add(child2);
        parent.setChildren(kids);

        //        Act
        ArrayList<Person> children = parent.getChildren();


        //        Assert
        assertEquals(kids, children);
    }


    @Test
    void getPets() {
//        Arrange
        Person petOwner = new Person("baasje", "dierenvriend", 22, "male");
        Pet dog = new Pet("Poekie", "dog", 2);
        Pet cat = new Pet("Poesje", "cat", 2);

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(dog);
        pets.add(cat);
        petOwner.setPets(pets);

//        Act
        ArrayList<Pet> animals = petOwner.getPets();


//        Assert
        assertEquals(animals, pets);


    }

    @Test
    void getPetsNames() {
        // Arrange
        Person petOwner = new Person("baasje", "dierenvriend", 22, "male");
        Pet dog = new Pet("Beethoven", "dog", 2);
        Pet cat = new Pet("Azräel", "cat", 2);

        ArrayList<Pet> expectedPetName = new ArrayList<>();
        expectedPetName.add(dog);
        expectedPetName.add(cat);
        petOwner.setPets(expectedPetName);

        // Act
        ArrayList<Pet> pets = petOwner.getPets();

        // Assert
        assertEquals(expectedPetName.size(), pets.size());
        for (int i = 0; i < expectedPetName.size(); i++) {
            assertEquals(expectedPetName.get(i).getName(), pets.get(i).getName());
        }
    }

    @Test
    void setAge() {
//        Arrange
        Person agingPerson = new Person("aging", "surname", 5, "mail");
//        Act
        agingPerson.setAge(100);
        int age = agingPerson.getAge();
//        Assert
        assertEquals(100, age);

    }

    @Test
    void setSex() {
//        Arrange
        Person person1 = new Person("mantofrow", "surname", 11, "mail");
//        Act
        person1.setSex("Email");
        String sex = person1.getSex();
//        Assert
        assertEquals("Email", sex);
    }


    @Test
    void addParents() {
        //  Arrange

        // act
        child.addParents(father, mother, child);


        //  assert
        assertEquals("vader", child.getFather().getName());
        assertEquals("moeder", child.getMother().getName());


    }

    @Test
    void addChildToChildren() {
        // Arrange
        Person parent = new Person("vader", "kokPa", 2, "male");
        Person child = new Person("kindNaam", "kokKind", 2, "male");

        // Act
        child.addChildToChildren(parent, child);

        // Assert
        assertEquals(1, parent.getChildren().size());
        assertEquals(child, parent.getChildren().get(0));
        System.out.println(child.getName());


    }


    @Test
    void addPet() {
//        Arrange
        Person dogOwner = new Person("Dogowner", "Snoop", 5, "Male");
        Pet dog = new Pet("Chiuhahaha", "dog", 2);
        Pet cat = new Pet("Miauw", "cat", 2);
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        // act
        dogOwner.addPet(dogOwner, cat);
        dogOwner.addPet(dogOwner, dog);

        //  assert
        assertEquals(pets, dogOwner.getPets());

    }

    @Test
    void addSibling() {
        //  Arrange
        ArrayList<Person> sibblings = new ArrayList<>();
        Person brother1 = new Person("Jan ", "Peterson", 32, "mail");
        Person brother2 = new Person("Piet ", "Peterson", 32, "mail");
        Person brother3 = new Person("Joris ", "Peterson", 32, "mail");

        sibblings.add(brother2);
        sibblings.add(brother3);

        brother1.addSibling(brother1, brother2);

        // act
        brother1.addSibling(brother1, brother3);

        //  assert
        assertEquals(sibblings, brother1.getSiblings());
    }


    @Test
    void getGrandChildren() {
        //  Arrange
        ArrayList<Person> grandChildren = new ArrayList<>();
        Person grandChild1 = new Person("Kleinkind", "van Opa", 16, "mail");
        Person father1 = new Person("vader", "van Opa", 45, "mail");
        Person grandFather1 = new Person("Opa", "van Opa", 70, "mail");
        grandChildren.add(grandChild1);


        // act
        father1.addChildToChildren(father1, grandChild1);
        grandFather1.addChildToChildren(grandFather1, father1);
        ArrayList<Person> arrayList = (grandFather1.getGrandChildren(grandFather1));

        //  assert
        assertEquals(grandChildren, arrayList);
        System.out.println(grandChildren.get(0).getName());
    }
}





