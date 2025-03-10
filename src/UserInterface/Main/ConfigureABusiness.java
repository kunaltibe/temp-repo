/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */

class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");
        
        CustomerDirectory customerDirectory = new CustomerDirectory(null);
        MarketCatalog marketCatalog = new MarketCatalog();
        MasterOrderList masterOrderList = new MasterOrderList();
        PersonDirectory personDirectory = new PersonDirectory();
        SalesPersonDirectory salesPersonDirectory = new SalesPersonDirectory(null);
        MasterSolutionOrderList masterSolutionOrderList = new MasterSolutionOrderList();
        SolutionOfferCatalog solutionOfferCatalog = new SolutionOfferCatalog();
        ProductCatalog productCatalog = new ProductCatalog();
        
        /* Delete From Here*/
        /* ---------------------------------------------------------------------------------------- */
        marketCatalog.newMarket("Teenagers");
        marketCatalog.newMarket("Seniors");
        marketCatalog.newMarket("College Undergrads");
        
        Person person005 = new Person("SP1", "SalesPerson1");
        Person person006 = new Person("SP2", "SalesPerson2");
        Person person007 = new Person("SP3", "SalesPerson3");
        Person person008 = new Person("SP4", "SalesPerson4");
        Person person009 = new Person("SP5", "SalesPerson5");
        
        salesPersonDirectory.newSalesPersonProfile(person005);
        salesPersonDirectory.newSalesPersonProfile(person006);
        salesPersonDirectory.newSalesPersonProfile(person007);
        salesPersonDirectory.newSalesPersonProfile(person008);
        salesPersonDirectory.newSalesPersonProfile(person009);
        
        personDirectory.addNewPerson(person005);
        personDirectory.addNewPerson(person006);
        personDirectory.addNewPerson(person007);
        personDirectory.addNewPerson(person008);
        personDirectory.addNewPerson(person009);
        /* ---------------------------------------------------------------------------------------- */
        Product productp1 = new Product("Scanner 3  1", 500, 1500, 1000);
        Product productp2 = new Product("Scanner 4",100, 200, 150);
        Product productp3 = new Product("Printer 2",50, 150, 100);  
        Product productp4 = new Product("Photocopier 2", 50, 150, 100);
        Product productp5 = new Product("Scanner  5", 75, 125, 100);
        Product productp6 = new Product("Scanner 6", 80, 140, 110);
        
        Order order1 = new Order();
        order1.newOrderItem(productp1, 1200, 1);
        order1.newOrderItem(productp2, 175, 1);
        order1.newOrderItem(productp3, 140, 1);
        MarketChannelAssignment mca1 = new MarketChannelAssignment("Teenagers");
        order1.setMca(mca1);
        SalesPersonProfile salesPerson1 = new SalesPersonProfile(person005);
        order1.setSalesperson(salesPerson1);
        masterOrderList.newOrder(order1);
        
        Order order2 = new Order();
        order2.newOrderItem(productp4, 130,1);
        order2.newOrderItem(productp5, 140, 1);
        order2.newOrderItem(productp6, 155, 1);
        MarketChannelAssignment mca2 = new MarketChannelAssignment("Seniors");
        order2.setMca(mca2);
        SalesPersonProfile salesPerson2 = new SalesPersonProfile(person006);
        order2.setSalesperson(salesPerson2);
        masterOrderList.newOrder(order2);
        
        Person person000 = new Person("D1", "Dell");
        personDirectory.addNewPerson(person000);
        
        CustomerProfile customer1 = customerDirectory.newCustomerProfile(person000);
        
        customer1.addCustomerOrder(order1);
        customer1.addCustomerOrder(order2);
        /* ---------------------------------------------------------------------------------------- */
        Product product7 = new Product("Printer 3", 100, 150, 125);
        Product product8 = new Product("Photocopier 3", 125, 175, 150);
        
        Order order3 = new Order();
        order3.newOrderItem(product7, 110, 1);
        order3.newOrderItem(product8, 140, 1);
        MarketChannelAssignment mca3 = new MarketChannelAssignment("Teenagers");
        order3.setMca(mca3);
        SalesPersonProfile salesPerson3 = new SalesPersonProfile(person007);
        order3.setSalesperson(salesPerson3);
        masterOrderList.newOrder(order3);
        
        Person person001 = new Person("M2", "Microsoft");
        personDirectory.addNewPerson(person001);
        
        CustomerProfile customer2 = customerDirectory.newCustomerProfile(person001);
        
        customer2.addCustomerOrder(order3);
        /* ---------------------------------------------------------------------------------------- */
        Product product9 = new Product("Scanner 13  1", 100, 150, 120);
        Product product10 = new Product("Scanner 14", 120, 170, 150);
        Product product11 = new Product("Color Printer 112", 50, 80, 60);
        Product product12 = new Product("Photocopier 922 ", 150, 205, 174);
        Product product13 = new Product("Low toner Scanner  102", 160, 210, 180);
        
        Order order4 = new Order();
        order4.newOrderItem(product9, 17, 1);
        order4.newOrderItem(product10, 95, 4);
        MarketChannelAssignment mca4 = new MarketChannelAssignment("College Undergrads");
        order4.setMca(mca4);
        SalesPersonProfile salesPerson4 = new SalesPersonProfile(person008);
        order4.setSalesperson(salesPerson4);
        masterOrderList.newOrder(order4);
        
        Order order5 = new Order();
        order5.newOrderItem(product11, 70, 2);
        order5.newOrderItem(product12, 190, 3);
        order5.newOrderItem(product13, 90, 3);
        MarketChannelAssignment mca5 = new MarketChannelAssignment("Teenagers");
        order5.setMca(mca5);
        SalesPersonProfile salesPerson5 = new SalesPersonProfile(person009);
        order5.setSalesperson(salesPerson5);
        masterOrderList.newOrder(order5);
        
        Person person002 = new Person("G3", "Google");
        personDirectory.addNewPerson(person002);
        
        CustomerProfile customer3 = customerDirectory.newCustomerProfile(person002);
        
        customer3.addCustomerOrder(order4);
        customer3.addCustomerOrder(order5);
        /* ---------------------------------------------------------------------------------------- */
        Product product14 = new Product("Speedy color Scanner 611", 100, 125, 165);
        Product product15 = new Product("Premier Printer 300", 322, 470, 736);
        Product product16 = new Product("Color Photocopier 500", 350, 580, 780);
        Product product17 = new Product("Scanner 23  1", 220, 365, 250);
        Product product18 = new Product("Scanner 24", 500, 215, 165);
        Product product19 = new Product("Printer 12", 520, 490, 365); 
        Product product20 = new Product("Photocopier 3 ", 530, 870, 150);
        Product product21 = new Product("Scanner  15", 590, 126, 270);
        
        Order order6 = new Order();
        order6.newOrderItem(product14, 86, 1);
        order6.newOrderItem(product15, 100, 1);
        MarketChannelAssignment mca6 = new MarketChannelAssignment("College Undergrads");
        order6.setMca(mca6);
        SalesPersonProfile salesPerson6 = new SalesPersonProfile(person005);
        order6.setSalesperson(salesPerson1);
        masterOrderList.newOrder(order6);
        
        Order order7 = new Order();
        order7.newOrderItem(product16, 300, 10);
        order7.newOrderItem(product17, 630, 1);
        order7.newOrderItem(product18, 300, 3);
        MarketChannelAssignment mca7 = new MarketChannelAssignment("Teenagers");
        order7.setMca(mca7);
        SalesPersonProfile salesPerson7 = new SalesPersonProfile(person006);
        order7.setSalesperson(salesPerson7);
        masterOrderList.newOrder(order7);
        
        Order order8 = new Order();
        order8.newOrderItem(product19, 210, 5);
        order8.newOrderItem(product20, 230, 7);
        order8.newOrderItem(product21, 200, 4);
        MarketChannelAssignment mca8 = new MarketChannelAssignment("Seniors");
        order8.setMca(mca8);
        SalesPersonProfile salesPerson8 = new SalesPersonProfile(person007);
        order8.setSalesperson(salesPerson8);
        masterOrderList.newOrder(order8);
        
        Person person003 = new Person("JPM4", "JP Morgan");
        personDirectory.addNewPerson(person003);
        
        CustomerProfile customer4 = customerDirectory.newCustomerProfile(person003);
        
        customer4.addCustomerOrder(order6);
        customer4.addCustomerOrder(order7);
        customer4.addCustomerOrder(order8);
        /* ---------------------------------------------------------------------------------------- */
        Product product22 = new Product("Scanner 16", 90, 135, 105);
        Product product23 = new Product("Printer 4", 212, 600, 365);
        Product product24 = new Product("Photocopier 13", 300, 700, 500);
        Product product25 = new Product("Scanner 13  2", 320, 362, 185);
        Product product26 = new Product("Scanner 24", 100, 250, 165);
        Product product27 = new Product("Color Printer 222", 413, 540, 495); 
        Product product28 = new Product("Scanner 23  2", 221, 365, 250);
        Product product29 = new Product("Low toner Scanner  202", 193, 550, 362);
        Product product30 = new Product("Speedy color Scanner 711", 900, 440, 160);
        Product product31 = new Product("Premier Printer 400", 320, 470, 400);
        Product product32 = new Product("Color Photocopier 700", 350, 580, 780);
        Product product33 = new Product("Photocopier 10001 ", 430, 800, 550);
        Product product34 = new Product("Printer 122", 520, 490, 360);
        Product product35 = new Product("Scanner  225", 590, 126, 275);
        
        Order order9 = new Order();
        order9.newOrderItem(product22, 13, 1);
        order9.newOrderItem(product23, 16, 1);
        MarketChannelAssignment mca9 = new MarketChannelAssignment("Teenagers");
        order9.setMca(mca9);
        SalesPersonProfile salesPerson9 = new SalesPersonProfile(person008);
        order9.setSalesperson(salesPerson9);
        masterOrderList.newOrder(order9);
        
        Order order10 = new Order();
        order10.newOrderItem(product24, 700, 2);
        order10.newOrderItem(product25, 190, 3);
        order10.newOrderItem(product26, 200, 5);
        MarketChannelAssignment mca10 = new MarketChannelAssignment("Seniors");
        order10.setMca(mca10);
        SalesPersonProfile salesPerson10 = new SalesPersonProfile(person007);
        order10.setSalesperson(salesPerson10);
        masterOrderList.newOrder(order10);
        
        Order order11 = new Order();
        order11.newOrderItem(product27, 210, 5);
        order11.newOrderItem(product28, 230, 7);
        order11.newOrderItem(product29, 220, 4);
        MarketChannelAssignment mca11 = new MarketChannelAssignment("Teenagers");
        order11.setMca(mca11);
        SalesPersonProfile salesPerson11 = new SalesPersonProfile(person005);
        order11.setSalesperson(salesPerson11);
        masterOrderList.newOrder(order11);
        
        Order order12 = new Order();
        order12.newOrderItem(product30, 220, 3);
        order12.newOrderItem(product31, 227, 4);
        order12.newOrderItem(product32, 240, 2);
        MarketChannelAssignment mca12 = new MarketChannelAssignment("Teenagers");
        order12.setMca(mca12);
        SalesPersonProfile salesPerson12 = new SalesPersonProfile(person006);
        order12.setSalesperson(salesPerson12);
        masterOrderList.newOrder(order12);
        
        Order order13 = new Order();
        order13.newOrderItem(product33, 240, 7);
        order13.newOrderItem(product34, 250, 5);
        order13.newOrderItem(product35, 250, 9);
        MarketChannelAssignment mca13 = new MarketChannelAssignment("Seniors");
        order13.setMca(mca13);
        SalesPersonProfile salesPerson13 = new SalesPersonProfile(person007);
        order13.setSalesperson(salesPerson13);
        masterOrderList.newOrder(order13);
        
        Person person004 = new Person("SS5", "State Street");
        personDirectory.addNewPerson(person004);
        
        CustomerProfile customer5 = customerDirectory.newCustomerProfile(person004);
        
        customer5.addCustomerOrder(order9);
        customer5.addCustomerOrder(order10);
        customer5.addCustomerOrder(order11);
        customer5.addCustomerOrder(order12);
        customer5.addCustomerOrder(order13);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_01 = new SolutionOffer("Teenagers", 150, 65, 185, 125);
        
        solutionOffer_01.addProduct(productp1);
        solutionOffer_01.addProduct(productp2);
        solutionOffer_01.addProduct(productp3);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_01);
        
        SolutionOrder solutionOrder_01 = new SolutionOrder("Solution Offer 1", solutionOffer_01);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_01);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_02 = new SolutionOffer("Teenagers", 35, 205, 415, 310);
        
        solutionOffer_02.addProduct(productp4);
        solutionOffer_02.addProduct(productp5);
        solutionOffer_02.addProduct(productp6);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_02);
        
        SolutionOrder solutionOrder_02 = new SolutionOrder("Solution Offer 2", solutionOffer_02);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_02);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_03 = new SolutionOffer("Teenagers", 300, 225, 325, 275);
        
        solutionOffer_03.addProduct(product7);
        solutionOffer_03.addProduct(product8);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_03);
        
        SolutionOrder solutionOrder_03 = new SolutionOrder("Solution Offer 3", solutionOffer_03);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_03);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_04 = new SolutionOffer("Teenagers", 250, 220, 320, 270);
        
        solutionOffer_04.addProduct(product9);
        solutionOffer_04.addProduct(product10);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_04);
        
        SolutionOrder solutionOrder_04 = new SolutionOrder("Solution Offer 4", solutionOffer_04);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_04);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_05 = new SolutionOffer("Seniors", 450, 360, 490, 410);
        
        solutionOffer_05.addProduct(product11);
        solutionOffer_05.addProduct(product12);
        solutionOffer_05.addProduct(product13);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_05);
        
        SolutionOrder solutionOrder_05 = new SolutionOrder("Solution Offer 5", solutionOffer_05);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_05);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_06 = new SolutionOffer("Seniors", 300, 220, 320, 207);
        
        solutionOffer_06.addProduct(product14);
        solutionOffer_06.addProduct(product15);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_06);
        
        SolutionOrder solutionOrder_06 = new SolutionOrder("Solution Offer 6", solutionOffer_06);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_06);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_07 = new SolutionOffer("Seniors", 450, 360, 490, 410);
        
        solutionOffer_07.addProduct(product16);
        solutionOffer_07.addProduct(product17);
        solutionOffer_07.addProduct(product18);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_07);
        
        SolutionOrder solutionOrder_07 = new SolutionOrder("Solution Offer 7", solutionOffer_07);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_07);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_08 = new SolutionOffer("Seniors", 540, 535, 685, 595);
        
        solutionOffer_08.addProduct(product19);
        solutionOffer_08.addProduct(product20);
        solutionOffer_08.addProduct(product21);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_08);
        
        SolutionOrder solutionOrder_08 = new SolutionOrder("Solution Offer 8", solutionOffer_08);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_08);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_09 = new SolutionOffer("College Undergrads", 300, 220, 302, 270);
        
        solutionOffer_09.addProduct(product22);
        solutionOffer_09.addProduct(product23);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_09);
        
        SolutionOrder solutionOrder_09 = new SolutionOrder("Solution Offer 9", solutionOffer_09);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_09);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_10 = new SolutionOffer("College Undergrads", 430, 360, 490, 410);
        
        solutionOffer_10.addProduct(product24);
        solutionOffer_10.addProduct(product25);
        solutionOffer_10.addProduct(product26);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_10);
        
        SolutionOrder solutionOrder_10 = new SolutionOrder("Solution Offer 10", solutionOffer_10);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_10);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_11 = new SolutionOffer("College Undergrads", 640, 535, 685, 595);
        
        solutionOffer_11.addProduct(product27);
        solutionOffer_11.addProduct(product28);
        solutionOffer_11.addProduct(product29);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_11);
        
        SolutionOrder solutionOrder_11 = new SolutionOrder("Solution Offer 11", solutionOffer_11);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_11);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_12 = new SolutionOffer("College Undergrads", 600, 570, 720, 639);
        
        solutionOffer_12.addProduct(product30);
        solutionOffer_12.addProduct(product31);
        solutionOffer_12.addProduct(product32);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_12);
        
        SolutionOrder solutionOrder_12 = new SolutionOrder("Solution Offer 12", solutionOffer_12);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_12);
        /* ---------------------------------------------------------------------------------------- */
        business.setCustomerDirectory(customerDirectory);
        business.setMarketCatalog(marketCatalog);
        business.setMasterOrderlist(masterOrderList);
        business.setPersonDirectory(personDirectory);
        business.setSalesPersonDirectory(salesPersonDirectory);
        business.setMasterSolutionOrderlist(masterSolutionOrderList);
        business.setSolutionOfferCatalog(solutionOfferCatalog);
        /* ---------------------------------------------------------------------------------------- */
        productCatalog.newProduct(productp1);
        productCatalog.newProduct(productp2);
        productCatalog.newProduct(productp3);
        productCatalog.newProduct(productp4);
        productCatalog.newProduct(productp5);
        productCatalog.newProduct(productp6);
        productCatalog.newProduct(product7);
        productCatalog.newProduct(product8);
        productCatalog.newProduct(product9);
        productCatalog.newProduct(product10);
        productCatalog.newProduct(product11);
        productCatalog.newProduct(product12);
        productCatalog.newProduct(product13);
        productCatalog.newProduct(product14);
        productCatalog.newProduct(product15);
        productCatalog.newProduct(product16);
        productCatalog.newProduct(product17);
        productCatalog.newProduct(product18);
        productCatalog.newProduct(product19);
        productCatalog.newProduct(product20);
        productCatalog.newProduct(product21);
        productCatalog.newProduct(product22);
        productCatalog.newProduct(product23);
        productCatalog.newProduct(product24);
        productCatalog.newProduct(product25);
        productCatalog.newProduct(product26);
        productCatalog.newProduct(product27);
        productCatalog.newProduct(product28);
        productCatalog.newProduct(product29);
        productCatalog.newProduct(product30);
        productCatalog.newProduct(product31);
        productCatalog.newProduct(product32);
        productCatalog.newProduct(product33);
        productCatalog.newProduct(product34);
        productCatalog.newProduct(product35);
        /* ---------------------------------------------------------------------------------------- */
        /* Delete Till Here*/
        return business;
    }
    
}
