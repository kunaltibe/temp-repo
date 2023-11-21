/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Profile;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import UserInterface.Main.WorkSpaceProfiles.BusinessManagerWorkAreaJPanel;
import UserInterface.Main.WorkSpaceProfiles.MarketingManagerWorkAreaJPanel1;
import UserInterface.Main.WorkSpaceProfiles.SalesPersonWorkAreaJPanel;
import javax.swing.JPanel;
import java.util.*;
import java.util.stream.*;
import TheBusiness.ProductManagement.Product;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;

/**
 *
 * @author sangram
 */
public final class UseCases {
    
    Business business;
    
    CustomerDirectory customerDirectory;
    MarketCatalog marketCatalog;
    MasterOrderList masterOrderList;
    PersonDirectory personDirectory;
    SalesPersonDirectory salesPersonDirectory;
    MasterSolutionOrderList masterSolutionOrderList;
    SolutionOfferCatalog solutionOfferCatalog;

    
    

    UseCases(Business business) {
        this.business = business;
        this.customerDirectory = business.getCustomerDirectory();
        this.marketCatalog = business.getMarketCatalog();
        this.masterOrderList = business.getMasterOrderList();
        this.personDirectory = business.getPersonDirectory();
        this.salesPersonDirectory = business.getSalesPersonDirectory();
        this.masterSolutionOrderList = business.getMasterSolutionOrderList();
        this.solutionOfferCatalog = business.getSolutionOfferCatalog();
        
        Top3Negotiated();
        Top3Customers();
        Top3Salesperson();
        MarketRevenues();
        
    }
    
    public void Top3Negotiated (){
        /* First Use case */
        System.out.println("Markets Top Three Best Negotiated Solutions ");
        for(Market m : this.marketCatalog.getMarkets()) {
            System.out.println("-> Market Name : " + m.getName());
            int mo = 1;
            for(SolutionOrder so : this.masterSolutionOrderList.getSolutionorderlist()) {
                if(so.getMarketName().equals(m.getName())) {
                    if(so.isSolutionOfferPriceGreaterThanProductsTargetPrice()) {
                        System.out.println(mo + ") " + so.getSolutionOrderName());
                        mo = mo + 1;
                    }
                }
            }
        }
        System.out.println("\n");
    }
    
    public void Top3Customers() {
    HashMap<String, Integer> topThreeCustomer = new HashMap<>();        
        for(CustomerProfile c : this.customerDirectory.getCustomerlist()) {
                topThreeCustomer.put(c.getPerson().getName(), c.getNumberOfOrdersAboveTotalTarget());
        }
        List<Map.Entry<String, Integer>> sortedEntries = topThreeCustomer.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
        System.out.println("Top Three Customers");
        System.out.println("--------------------------------------");
        int count = 1;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count <= 3) {
                System.out.println(count +  ") " + entry.getKey());
                count++;
            } else {
                break;
            }
        }
        System.out.println("\n");
}
    
        public void Top3Salesperson(){
        System.out.println("Top Three Sales Person");
        System.out.println("-----------------------------------");
        HashMap<String, Integer> topThreeSalesPerson = new HashMap<>(); 
        for(SalesPersonProfile s : this.salesPersonDirectory.getSalespersonlist()) {
            int salesCount = 0;
            for(Order o : this.masterOrderList.getOrders()) {
                if(s.getPerson().getName().equals(o.getSalesperson().getPerson().getName())) {
                    if(o.isOrderAboveTotalTarget()) {
                        salesCount = salesCount + 1;
                    }
                }
            }
            topThreeSalesPerson.put(s.getPerson().getName(), salesCount);
        }
        List<Map.Entry<String, Integer>> sortedEntriesSalesPersons = topThreeSalesPerson.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        int j = 1;
        for (Map.Entry<String, Integer> entry : sortedEntriesSalesPersons) {
            if (j <= 3) {
                System.out.println(j + ") " + entry.getKey());
                j++;
            } else {
                break;
            }
        }        
        System.out.println("\n");
        }
        
        public void MarketRevenues(){
             System.out.println("Market Revenues");
        System.out.println("----------------------");
        int i = 1;
        for(Market m : this.marketCatalog.getMarkets()) {
            int sum = 0;
            for(Order o : this.masterOrderList.getOrders()) {
                if(m.getName().equals(o.getMarketName())) {
                    sum = sum + o.getOrderPricePerformance();
                }
            }
            System.out.println(i + ") " + m.getName() + " : " + sum);
            i = i + 1;
        }
        }
        
        
        
}

