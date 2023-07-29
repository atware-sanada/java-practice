public class Human {
    private String name;
    private int age;

    Human setName(String name) {

        this.name = name;

        return this;
    }

    Human setAge(int age) {

        this.age = age;

        return this;
    }

    void show() {

        System.out.println("My name is" + name + "My age is" + age);
    }

}

//public class Human {
//    private String name;
//    private int age;
//
//    Human(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//
//    void show() {
//
//        System.out.println("My name is" + name + "My age is" + age);
//    }
//
//}
