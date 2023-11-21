/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

/**
 *
 * @author kal bugrara
 */

public class Person {
    
    String id;
    String name; //Added for Dashboard
    
    public Person(String id) {
        this.id = id;
    }
    
    
    public Person() {
        
    }
    
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    public String getPersonId() {
        return id;
    }
    
    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
