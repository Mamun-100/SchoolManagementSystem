/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproject;

/**
 *
 * @author Os-10
 */
public class User {
    private  int id;
    private  String name;
    private  String title;
    private  int age;

    public User(int id, String name, String title, int age) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }
    
}
