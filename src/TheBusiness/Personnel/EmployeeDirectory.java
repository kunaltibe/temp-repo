/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Personnel;

import TheBusiness.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployeeDirectory {

    Business business;
    ArrayList<EmployeeProfile> employeelist;

    public EmployeeDirectory(Business d) {
        business = d;
        employeelist = new ArrayList();
    }
    
    public EmployeeProfile newEmployeeProfile(Person p) {
        EmployeeProfile sp = new EmployeeProfile(p);
        employeelist.add(sp);
        return sp;
    }
    
    public EmployeeProfile findEmployee(String id) {
        for (EmployeeProfile sp : employeelist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }
    
   
    @Override
    public String toString() {
        return "EmployeeDirectory{" + "business=" + business + ", employeelist=" + employeelist + '}';
    }
    /* */
    
}
