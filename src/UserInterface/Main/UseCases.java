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
        Top3Negotiated();
        
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
    
    
}

