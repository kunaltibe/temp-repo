/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class CustomerSummary {
    CustomerProfile customer;
    int ordertotal;
    int numberofordersabovetarget;
    int numberofordersbelowtarget;
    int orderpriceperformance;
    public CustomerSummary(CustomerProfile cp){
        customer = cp;
        numberofordersabovetarget = cp.getNumberOfOrdersAboveTotalTarget();
        numberofordersbelowtarget = cp.getNumberOfOrdersBelowTotalTarget();
        orderpriceperformance = cp.getTotalPricePerformance();
    }
    public int totalOrders() {
        return ordertotal;
    }

    public int getOrdersAboveTarget() {
        return numberofordersabovetarget;
    }

    public int getOrderPricePerformance() {
        return orderpriceperformance;
    }

    public int getOrdersBelowTarget() {
        return numberofordersbelowtarget;
    }
}
