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
        
        Person person_06 = new Person("6", "Virendar Sehwag");
        Person person_07 = new Person("7", "KL Rahul");
        Person person_08 = new Person("8", "Bhuvaneshwar Kumar");
        Person person_09 = new Person("9", "Shikhar Dhawan");
        Person person_10 = new Person("10", "Jasprit Bumrah");
        
        salesPersonDirectory.newSalesPersonProfile(person_06);
        salesPersonDirectory.newSalesPersonProfile(person_07);
        salesPersonDirectory.newSalesPersonProfile(person_08);
        salesPersonDirectory.newSalesPersonProfile(person_09);
        salesPersonDirectory.newSalesPersonProfile(person_10);
        
        personDirectory.addNewPerson(person_06);
        personDirectory.addNewPerson(person_07);
        personDirectory.addNewPerson(person_08);
        personDirectory.addNewPerson(person_09);
        personDirectory.addNewPerson(person_10);
        /* ---------------------------------------------------------------------------------------- */
        Product product_01 = new Product("Mobile", 500, 1500, 1000);
        Product product_02 = new Product("HeadPhone",100, 200, 150);
        Product product_03 = new Product("Charger",50, 150, 100);
        
        Product product_04 = new Product("Shirt", 50, 150, 100);
        Product product_05 = new Product("Pant", 75, 125, 100);
        Product product_06 = new Product("Shoe", 80, 140, 110);
        
        Order order_01 = new Order();
        order_01.newOrderItem(product_01, 1200, 1);
        order_01.newOrderItem(product_02, 175, 1);
        order_01.newOrderItem(product_03, 140, 1);
        MarketChannelAssignment mca_01 = new MarketChannelAssignment("Teenagers");
        order_01.setMca(mca_01);
        SalesPersonProfile salesPerson_01 = new SalesPersonProfile(person_06);
        order_01.setSalesperson(salesPerson_01);
        masterOrderList.newOrder(order_01);
        
        Order order_02 = new Order();
        order_02.newOrderItem(product_04, 130,1);
        order_02.newOrderItem(product_05, 130, 1);
        order_02.newOrderItem(product_06, 130, 1);
        MarketChannelAssignment mca_02 = new MarketChannelAssignment("Seniors");
        order_02.setMca(mca_02);
        SalesPersonProfile salesPerson_02 = new SalesPersonProfile(person_07);
        order_02.setSalesperson(salesPerson_02);
        masterOrderList.newOrder(order_02);
        
        Person person_01 = new Person("1", "Virat Kohli");
        personDirectory.addNewPerson(person_01);
        
        CustomerProfile customer_01 = customerDirectory.newCustomerProfile(person_01);
        
        customer_01.addCustomerOrder(order_01);
        customer_01.addCustomerOrder(order_02);
        /* ---------------------------------------------------------------------------------------- */
        Product product_07 = new Product("Bat", 100, 150, 125);
        Product product_08 = new Product("Ball", 125, 175, 150);
        
        Order order_03 = new Order();
        order_03.newOrderItem(product_07, 110, 1);
        order_03.newOrderItem(product_08, 140, 1);
        MarketChannelAssignment mca_03 = new MarketChannelAssignment("Teenagers");
        order_03.setMca(mca_03);
        SalesPersonProfile salesPerson_03 = new SalesPersonProfile(person_08);
        order_03.setSalesperson(salesPerson_03);
        masterOrderList.newOrder(order_03);
        
        Person person_02 = new Person("2", "Rohit Sharma");
        personDirectory.addNewPerson(person_02);
        
        CustomerProfile customer_02 = customerDirectory.newCustomerProfile(person_02);
        
        customer_02.addCustomerOrder(order_03);
        /* ---------------------------------------------------------------------------------------- */
        Product product_09 = new Product("Pen", 10, 15, 12);
        Product product_10 = new Product("Paper", 12, 17, 15);
        Product product_11 = new Product("Chips", 5, 8, 6);
        Product product_12 = new Product("Juice", 15, 20, 17);
        Product product_13 = new Product("Chocolate", 16, 21, 18);
        
        Order order_04 = new Order();
        order_04.newOrderItem(product_09, 11, 1);
        order_04.newOrderItem(product_10, 14, 1);
        MarketChannelAssignment mca_04 = new MarketChannelAssignment("College Undergrads");
        order_04.setMca(mca_04);
        SalesPersonProfile salesPerson_04 = new SalesPersonProfile(person_09);
        order_04.setSalesperson(salesPerson_04);
        masterOrderList.newOrder(order_04);
        
        Order order_05 = new Order();
        order_05.newOrderItem(product_11, 7, 2);
        order_05.newOrderItem(product_12, 19, 3);
        order_05.newOrderItem(product_13, 20, 5);
        MarketChannelAssignment mca_05 = new MarketChannelAssignment("Teenagers");
        order_05.setMca(mca_05);
        SalesPersonProfile salesPerson_05 = new SalesPersonProfile(person_10);
        order_05.setSalesperson(salesPerson_05);
        masterOrderList.newOrder(order_05);
        
        Person person_03 = new Person("3", "Sachin Tendulkar");
        personDirectory.addNewPerson(person_03);
        
        CustomerProfile customer_03 = customerDirectory.newCustomerProfile(person_03);
        
        customer_03.addCustomerOrder(order_04);
        customer_03.addCustomerOrder(order_05);
        /* ---------------------------------------------------------------------------------------- */
        Product product_14 = new Product("Pen", 10, 15, 12);
        Product product_15 = new Product("Paper", 12, 17, 15);
        Product product_16 = new Product("Chips", 5, 8, 6);
        Product product_17 = new Product("Juice", 15, 20, 17);
        Product product_18 = new Product("Chocolate", 16, 21, 18);
        Product product_19 = new Product("Table", 170, 220, 190); 
        Product product_20 = new Product("Chair", 185, 235, 205);
        Product product_21 = new Product("Desk", 180, 230, 200);
        
        Order order_06 = new Order();
        order_06.newOrderItem(product_14, 13, 1);
        order_06.newOrderItem(product_15, 16, 1);
        MarketChannelAssignment mca_06 = new MarketChannelAssignment("College Undergrads");
        order_06.setMca(mca_06);
        SalesPersonProfile salesPerson_06 = new SalesPersonProfile(person_06);
        order_06.setSalesperson(salesPerson_01);
        masterOrderList.newOrder(order_06);
        
        Order order_07 = new Order();
        order_07.newOrderItem(product_16, 7, 2);
        order_07.newOrderItem(product_17, 19, 3);
        order_07.newOrderItem(product_18, 20, 5);
        MarketChannelAssignment mca_07 = new MarketChannelAssignment("Teenagers");
        order_07.setMca(mca_07);
        SalesPersonProfile salesPerson_07 = new SalesPersonProfile(person_07);
        order_07.setSalesperson(salesPerson_07);
        masterOrderList.newOrder(order_07);
        
        Order order_08 = new Order();
        order_08.newOrderItem(product_19, 210, 5);
        order_08.newOrderItem(product_20, 230, 7);
        order_08.newOrderItem(product_21, 220, 4);
        MarketChannelAssignment mca_08 = new MarketChannelAssignment("Seniors");
        order_08.setMca(mca_08);
        SalesPersonProfile salesPerson_08 = new SalesPersonProfile(person_08);
        order_08.setSalesperson(salesPerson_08);
        masterOrderList.newOrder(order_08);
        
        Person person_04 = new Person("4", "MS Dhoni");
        personDirectory.addNewPerson(person_04);
        
        CustomerProfile customer_04 = customerDirectory.newCustomerProfile(person_04);
        
        customer_04.addCustomerOrder(order_06);
        customer_04.addCustomerOrder(order_07);
        customer_04.addCustomerOrder(order_08);
        /* ---------------------------------------------------------------------------------------- */
        Product product_22 = new Product("Body Wash", 10, 15, 12);
        Product product_23 = new Product("Face Wash", 12, 17, 15);
        Product product_24 = new Product("Mobile", 5, 8, 6);
        Product product_25 = new Product("Charger", 15, 20, 17);
        Product product_26 = new Product("Screen Guard", 16, 21, 18);
        Product product_27 = new Product("Touch Screen Laptop", 170, 220, 190); 
        Product product_28 = new Product("Laptop Charger", 185, 235, 205);
        Product product_29 = new Product("Keyboard and Mouse", 180, 230, 200);
        Product product_30 = new Product("Bat", 185, 235, 205);
        Product product_31 = new Product("Helmet", 190, 240, 210);
        Product product_32 = new Product("Pads", 195, 245, 215);
        Product product_33 = new Product("Dining Table", 200, 250, 220);
        Product product_34 = new Product("Laptop Chair", 205, 255, 225);
        Product product_35 = new Product("Bed", 210, 260, 230);
        
        Order order_09 = new Order();
        order_09.newOrderItem(product_22, 13, 1);
        order_09.newOrderItem(product_23, 16, 1);
        MarketChannelAssignment mca_09 = new MarketChannelAssignment("Teenagers");
        order_09.setMca(mca_09);
        SalesPersonProfile salesPerson_09 = new SalesPersonProfile(person_09);
        order_09.setSalesperson(salesPerson_09);
        masterOrderList.newOrder(order_09);
        
        Order order_10 = new Order();
        order_10.newOrderItem(product_24, 7, 2);
        order_10.newOrderItem(product_25, 19, 3);
        order_10.newOrderItem(product_26, 20, 5);
        MarketChannelAssignment mca_10 = new MarketChannelAssignment("Seniors");
        order_10.setMca(mca_10);
        SalesPersonProfile salesPerson_10 = new SalesPersonProfile(person_08);
        order_10.setSalesperson(salesPerson_10);
        masterOrderList.newOrder(order_10);
        
        Order order_11 = new Order();
        order_11.newOrderItem(product_27, 210, 5);
        order_11.newOrderItem(product_28, 230, 7);
        order_11.newOrderItem(product_29, 220, 4);
        MarketChannelAssignment mca_11 = new MarketChannelAssignment("Teenagers");
        order_11.setMca(mca_11);
        SalesPersonProfile salesPerson_11 = new SalesPersonProfile(person_06);
        order_11.setSalesperson(salesPerson_11);
        masterOrderList.newOrder(order_11);
        
        Order order_12 = new Order();
        order_12.newOrderItem(product_30, 220, 3);
        order_12.newOrderItem(product_31, 227, 4);
        order_12.newOrderItem(product_32, 240, 2);
        MarketChannelAssignment mca_12 = new MarketChannelAssignment("Teenagers");
        order_12.setMca(mca_12);
        SalesPersonProfile salesPerson_12 = new SalesPersonProfile(person_07);
        order_12.setSalesperson(salesPerson_12);
        masterOrderList.newOrder(order_12);
        
        Order order_13 = new Order();
        order_13.newOrderItem(product_33, 245, 7);
        order_13.newOrderItem(product_34, 250, 5);
        order_13.newOrderItem(product_35, 255, 9);
        MarketChannelAssignment mca_13 = new MarketChannelAssignment("Seniors");
        order_13.setMca(mca_13);
        SalesPersonProfile salesPerson_13 = new SalesPersonProfile(person_08);
        order_13.setSalesperson(salesPerson_13);
        masterOrderList.newOrder(order_13);
        
        Person person_05 = new Person("5", "Yuvraj Singh");
        personDirectory.addNewPerson(person_05);
        
        CustomerProfile customer_05 = customerDirectory.newCustomerProfile(person_05);
        
        customer_05.addCustomerOrder(order_09);
        customer_05.addCustomerOrder(order_10);
        customer_05.addCustomerOrder(order_11);
        customer_05.addCustomerOrder(order_12);
        customer_05.addCustomerOrder(order_13);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_01 = new SolutionOffer("Teenagers", 1500, 650, 1850, 1250);
        
        solutionOffer_01.addProduct(product_01);
        solutionOffer_01.addProduct(product_02);
        solutionOffer_01.addProduct(product_03);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_01);
        
        SolutionOrder solutionOrder_01 = new SolutionOrder("Electronics New Year Offer 2023", solutionOffer_01);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_01);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_02 = new SolutionOffer("Teenagers", 350, 205, 415, 310);
        
        solutionOffer_02.addProduct(product_04);
        solutionOffer_02.addProduct(product_05);
        solutionOffer_02.addProduct(product_06);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_02);
        
        SolutionOrder solutionOrder_02 = new SolutionOrder("Clothes Black Friday Offer 2023", solutionOffer_02);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_02);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_03 = new SolutionOffer("Teenagers", 300, 225, 325, 275);
        
        solutionOffer_03.addProduct(product_07);
        solutionOffer_03.addProduct(product_08);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_03);
        
        SolutionOrder solutionOrder_03 = new SolutionOrder("Clothes Black Friday Offer 2023", solutionOffer_03);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_03);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_04 = new SolutionOffer("Teenagers", 25, 22, 32, 27);
        
        solutionOffer_04.addProduct(product_09);
        solutionOffer_04.addProduct(product_10);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_04);
        
        SolutionOrder solutionOrder_04 = new SolutionOrder("Stationary Thank Giving Sale 2023", solutionOffer_04);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_04);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_05 = new SolutionOffer("Seniors", 45, 36, 49, 41);
        
        solutionOffer_05.addProduct(product_11);
        solutionOffer_05.addProduct(product_12);
        solutionOffer_05.addProduct(product_13);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_05);
        
        SolutionOrder solutionOrder_05 = new SolutionOrder("Snacks New Year Sale 2023", solutionOffer_05);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_05);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_06 = new SolutionOffer("Seniors", 30, 22, 32, 27);
        
        solutionOffer_06.addProduct(product_14);
        solutionOffer_06.addProduct(product_15);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_06);
        
        SolutionOrder solutionOrder_06 = new SolutionOrder("Stationary New Year Sale 2023", solutionOffer_06);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_06);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_07 = new SolutionOffer("Seniors", 45, 36, 49, 41);
        
        solutionOffer_07.addProduct(product_16);
        solutionOffer_07.addProduct(product_17);
        solutionOffer_07.addProduct(product_18);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_07);
        
        SolutionOrder solutionOrder_07 = new SolutionOrder("Snacks Christmas Sale 2023", solutionOffer_07);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_07);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_08 = new SolutionOffer("Seniors", 540, 535, 685, 595);
        
        solutionOffer_08.addProduct(product_19);
        solutionOffer_08.addProduct(product_20);
        solutionOffer_08.addProduct(product_21);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_08);
        
        SolutionOrder solutionOrder_08 = new SolutionOrder("Furniture Christmas Sale 2023", solutionOffer_08);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_08);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_09 = new SolutionOffer("College Undergrads", 30, 22, 32, 27);
        
        solutionOffer_09.addProduct(product_22);
        solutionOffer_09.addProduct(product_23);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_09);
        
        SolutionOrder solutionOrder_09 = new SolutionOrder("Lotions Christmas Sale 2023", solutionOffer_09);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_09);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_10 = new SolutionOffer("College Undergrads", 43, 36, 49, 41);
        
        solutionOffer_10.addProduct(product_24);
        solutionOffer_10.addProduct(product_25);
        solutionOffer_10.addProduct(product_26);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_10);
        
        SolutionOrder solutionOrder_10 = new SolutionOrder("Electronics Christmas Sale 2023", solutionOffer_10);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_10);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_11 = new SolutionOffer("College Undergrads", 640, 535, 685, 595);
        
        solutionOffer_11.addProduct(product_27);
        solutionOffer_11.addProduct(product_28);
        solutionOffer_11.addProduct(product_29);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_11);
        
        SolutionOrder solutionOrder_11 = new SolutionOrder("Electronics Thanks Giving Sale 2023", solutionOffer_11);
        
        masterSolutionOrderList.addSolutionOrder(solutionOrder_11);
        /* ---------------------------------------------------------------------------------------- */
        SolutionOffer solutionOffer_12 = new SolutionOffer("College Undergrads", 600, 570, 720, 630);
        
        solutionOffer_12.addProduct(product_30);
        solutionOffer_12.addProduct(product_31);
        solutionOffer_12.addProduct(product_32);
        
        solutionOfferCatalog.addSolutionOffer(solutionOffer_12);
        
        SolutionOrder solutionOrder_12 = new SolutionOrder("Electronics Thanks Giving Sale 2023", solutionOffer_12);
        
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
        productCatalog.newProduct(product_01);
        productCatalog.newProduct(product_02);
        productCatalog.newProduct(product_03);
        productCatalog.newProduct(product_04);
        productCatalog.newProduct(product_05);
        productCatalog.newProduct(product_06);
        productCatalog.newProduct(product_07);
        productCatalog.newProduct(product_08);
        productCatalog.newProduct(product_09);
        productCatalog.newProduct(product_10);
        productCatalog.newProduct(product_11);
        productCatalog.newProduct(product_12);
        productCatalog.newProduct(product_13);
        productCatalog.newProduct(product_14);
        productCatalog.newProduct(product_15);
        productCatalog.newProduct(product_16);
        productCatalog.newProduct(product_17);
        productCatalog.newProduct(product_18);
        productCatalog.newProduct(product_19);
        productCatalog.newProduct(product_20);
        productCatalog.newProduct(product_21);
        productCatalog.newProduct(product_22);
        productCatalog.newProduct(product_23);
        productCatalog.newProduct(product_24);
        productCatalog.newProduct(product_25);
        productCatalog.newProduct(product_26);
        productCatalog.newProduct(product_27);
        productCatalog.newProduct(product_28);
        productCatalog.newProduct(product_29);
        productCatalog.newProduct(product_30);
        productCatalog.newProduct(product_31);
        productCatalog.newProduct(product_32);
        productCatalog.newProduct(product_33);
        productCatalog.newProduct(product_34);
        productCatalog.newProduct(product_35);
        /* ---------------------------------------------------------------------------------------- */
        /* Delete Till Here*/
        return business;
    }
    
}
