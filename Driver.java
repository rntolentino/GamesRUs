import java.util.*;

public class Driver {


    public static void message(){
        String menu = ( " \nDirectory [INPUT A NUMBER] \n \t 0. Quit \n \t 1. Add to cart \n \t 2. Cart Total  \n \t 3. Delete from cart \n \t 4. View Menu");
        String u_c = ("\nYour Choice: ");
        System.out.print(menu + u_c);
    }

    public static void welcomeMessage(){
        String menu = ("\n============ Hi! Welcome to Games R US :) ============ \nAre you the admin of the store? Enter (Yes/No) ");
        String u_c = ("\nYour Choice: ");
        System.out.print(menu + u_c);
    }

    public static void adminMessage(){
        String menu = ("\nDirectory [INPUT A NUMBER] \n \t 0. Quit \n \t 1. Add Product to menu \n \t 2. Delete from menu  \n \t 3. Change Price \n \t 4. View Menu");
        String u_c = ("\nYour Choice: ");
        System.out.print(menu + u_c);
    }

    public static boolean compare(String info){
        if (info.equals("yes")|| info.equals("no")){
            return false;
        }
        return true;
    }
    


    public static void main(String[] args) {
        MenuTree tree = new MenuTree();
        Menu.createMenu(tree);
        InvNode curr_node;
        ArrayList<InvNode> cart = new ArrayList<InvNode>();
        Double total = 0.00;
        Scanner input = new Scanner(System.in);
        boolean quit= false; 
        welcomeMessage();
        String user_choice = input.nextLine().toLowerCase(); //grab's users choice 
        
        while ( compare(user_choice)==true){
            System.out.println("ERROR NOT A VALID RESPONSE");
            welcomeMessage();
            user_choice = input.nextLine().toLowerCase();
        }

        //ADMINISTRATOR SETTING 
        while (( user_choice.equals("yes")) && (quit == false)){
          
            curr_node = tree.getRoot();
            adminMessage();
            int user_choice_admin = input.nextInt(); 
            input.nextLine();
            switch (user_choice_admin){
                case 0: //ALLOWS THE ADMIN TO LOG OUT OF ADMINISTRATOR SETTING AND ENTER THE CUSTOMER SETTING 
                    System.out.println("\nYOU HAVE LOGGED OUT OF THE ADMIN SETTING ! YOU ARE NOW IN THE CUSTOMER SETTING, FEEL FREE TO SHOP AROUND!");
                    user_choice = "no";
                    break;
                case 1: //ALLOWS ADMIN TO ADD PRODUCTS TO MENU
                    //DECIDES WHAT CATEGORY (NODE) TO MOVE TO
                    System.out.println("\n"+ "What category would you like to ADD the product to?"  + tree.toChild(curr_node) + "\nYour Input: " );
                    int choose = input.nextInt();
                    input.nextLine();
                    //CHECKS OF CHOICE IS OUT OF BOUNDS 
                    while (choose >= curr_node.getChildren().size()){
                        System.out.println("ERROR: NOT A VALID CHOICE ");
                        System.out.println("\n"+ "What category would you like to ADD the product to?" + "\n" + tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                    }
                    curr_node = tree.move(curr_node, choose);
                    //ALLOWS THE ACCESS OF GRANDCHILDREN THEN ADDS THE PRODUCT BASED ON THE USER'S INPUT 
                    if (choose == 0){
                        System.out.println("What brand would you like to ADD a product to? ");
                        System.out.println("Brands Available:  "  + tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                        //CHECKS IF INPUT IS OUT OF BOUNDS 
                        while (choose >= curr_node.getChildren().size()){
                            System.out.println("\nERROR: INPUT A VALID NUMBER");
                            System.out.println("What brand would you like to ADD a product to? ");
                            System.out.println("Brands Available:  "  + tree.toChild(curr_node) + "\nYour Input: " );
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        System.out.println("\n"+"What is the name of the PRODUCT you want to add to this category [" + curr_node.getName() + "] ?");
                        String nameP = input.nextLine();
                        System.out.println("\n"+"What is the price of the PRODUCT you want to add? ");
                        Double price = input.nextDouble();
                        tree.addNode(curr_node, nameP, price);
                        System.out.println ("\nADDED SUCCESFULLY!\n");
                    }
                    //ADDS THE PRODUCT BASED ON THE USER'S INPUT 
                    else {
                        System.out.println("\n"+"What is the name of the PRODUCT you want to add to this category [" + curr_node.getName() + "] ?");
                        String nameP = input.nextLine();
                        System.out.println("\n"+"What is the price of the PRODUCT you want to add? ");
                        Double price = input.nextDouble();
                        tree.addNode(curr_node, nameP, price);
                        System.out.println ("\nADDED SUCCESFULLY!\n");
                    }
                    break;


                case 2: // DELETE ITEMS FROM CERTAIN CATEGORY
                    //DECIDES WHAT CATEGORY (NODE) TO MOVE TO
                    System.out.println("What category would you like to DELETE from?" + "\n" + tree.toChild(curr_node) + "\nYour Input: " );
                    choose = input.nextInt();
                    input.nextLine();
                    //CHECKS IF INPUT IS OUT OF BOUNDS 
                    while (choose >= curr_node.getChildren().size()){
                        System.out.println("ERROR :NOT A VALID CHOICE ");
                        System.out.println("What category would you like to DELETE from?" + "\n" + tree.toChild(curr_node) +  "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                    }
                    curr_node = tree.move(curr_node, choose);
                    //ALLOWS THE ACCESS OF GRANDCHILDREN THEN DELETES THE PRODUCT BASED ON THE USER'S INPUT 
                    if (choose == 0){
                        System.out.println("In what brand would you like to DELETE a product from? ");
                        System.out.println( tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                        //CHECKS IF INPUT IS OUT OF BOUNDS
                        while (choose >= curr_node.getChildren().size()){
                            System.out.println("\nERROR: INPUT VALID NUMBER");
                            System.out.println("In what brand would you like to DELETE a product ? ");
                            System.out.println("Brands Available:  "  + tree.toChild(curr_node) + "\nYour Input: " );
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        //DELETES ITEM OF THIER CHOICE
                        System.out.println("What product do you want to DELETE? " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        //CHECKS IF INPUT IS OUT OF BOUNDS
                        while (choose >= curr_node.getChildren().size()){
                            System.out.println("\nERROR: INPUT A VALID NUMBER");
                            System.out.println("What product do you want to DELETE? " + tree.toChild(curr_node) + "\nYour Input: ");
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        tree.removeNode(curr_node, choose);
                        System.out.println ("\nDELETED SUCCESFULLY!\n");
                        
                    }
                    else {      //DELETES ITEM FROM MENU
                        System.out.println("What product do you want to DELETE? " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        while(choose >= curr_node.getChildren().size()){
                            System.out.println("\nERROR: INPUT A VALID NUMBER");
                            System.out.println("What product do you want to DELETE? " + tree.toChild(curr_node) + "\nYour Input: ");
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        
                        tree.removeNode(curr_node, choose);
                        System.out.println ("\nDELETED SUCCESFULLY!\n");
                    }
                    break;


                case 3: //ALLOWS THE USER TO CHANGE THE PRICE OF A PRODUCT 

                    //DECIDES WHAT CATEGORY (NODE) TO MOVE TO
                    System.out.println("What category would you like to  edit?" + "\n" + tree.toChild(curr_node) + "\nYour Input: " );
                    choose = input.nextInt();
                    input.nextLine();
                    //CHECKS IF INPUT IS OUT OF BOUNDS
                    while (choose >= curr_node.getChildren().size()){
                        System.out.println("ERROR: INPUT A VALID NUMBER ");
                        System.out.println("What category would you like to  edit?" + "\n" + tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                    }
                    curr_node = tree.move(curr_node, choose);
                    //ALLOWS THE ACCESS OF GRANDCHILDREN THEN EDITS THE PRODUCTS PRICE BASED ON THE USER'S INPUT 
                    if (choose == 0){
                        System.out.println("What brand would you like to EDIT ? ");
                        System.out.println( tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                        while (choose >= curr_node.getChildren().size()){
                            System.out.println("EERROR: INPUT A VALID NUMBER ");
                            System.out.println("What brand would you like to EDIT ? ");
                            System.out.println( tree.toChild(curr_node) + "\nYour Input: " );
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        System.out.println("What product do you want to EDIT? " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        curr_node = tree.move(curr_node, choose);
                        System.out.println("Price you want to change it to: "  + "\nYour Input: ");
                        Double price = input.nextDouble();
                        input.nextLine();
                        curr_node.setPrice(price);
                        System.out.println ("\nPRICE HAD BEEN UPDATED SUCCESFULLY!\n");
                    }
                    //IF THEIR INPUT WAS NOT ACCESSORIES THEN EDITS THE PRODUCTS PRICE BASED ON THE USER'S INPUT 
                    else {
                        System.out.println("What product do you want to EDIT? " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        //CHECKS IF INPUT IS OUT OF BOUNDS
                        while (choose >= curr_node.getChildren().size()){
                            System.out.println("ERROR: NOT A VALID CHOICE");
                            System.out.println("What product do you want to EDIT? " + tree.toChild(curr_node) + "\nYour Input: ");
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        System.out.println("Price you want to change it to: "  + "Your Input: ");
                        Double price = input.nextDouble();
                        input.nextLine();
                        curr_node.setPrice(price);
                        System.out.println ("\nPRICE HAD BEEN UPDATED SUCCESFULLY!\n");
                    }
                    break;


                case 4: //PRINTS OUT THE MENU 
                    System.out.println(tree.toString());
                    break;
                default:
                    System.out.println("\n"+"ERROR: INPUT A VALID NUMBER!\n");
                    
                
            }
        }
        
        //CUSTOMER SETTING 
        while (  user_choice.equals("no") && (quit == false) ){
            System.out.println("\nENJOY SHOPPING AROUND! TO CHECKOUT ENTER 0 !");
            curr_node = tree.getRoot();
            message();
            int user_choice_admin = input.nextInt();
            input.nextLine();
            switch (user_choice_admin){

                case 0:   //ALLOWS CUSTOMER TO QUIT
                    System.out.println("\nHere is your cart: "+  cart.toString());
                    System.out.println("Here is your total " + total);
                    System.out.println("\nThank you for shopping with GAMES R US!");
                    quit = true;
                    input.close();
                    return;


                case 1:   //ALLOWS THE CUSTOMER TO ADD PRODUCTS TO THE CART
                    System.out.println("Choose category to view "  + tree.toChild(curr_node) + "\nYour Input: " );
                    int choose = input.nextInt();
                    input.nextLine();
                    
                    while (choose >= curr_node.getChildren().size()){               //CHECKS IF INPUT IS OUT OF BOUNDS
                        System.out.println("\nERROR NOT a valid choice ");
                        System.out.println("Choose category to view "  + tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                    }
                    curr_node = tree.move(curr_node, choose);
                    // USED TO ACCESS THE GRANDCHILDREN THEN ADDS ITEMS TO CART BASED ON THE USER'S INPUT
                    if (choose == 0){
                        System.out.println("What brand would you like to view? ");
                        System.out.println("Items Available:  "  + tree.toChild(curr_node) + "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                        while (choose >= curr_node.getChildren().size()){           //CHECKS IF INPUT IS OUT OF BOUNDS
                            System.out.println("\nERROR NOT a valid choice ");
                            System.out.println("What brand would you like to view? ");
                            System.out.println("Items Available:  "  + tree.toChild(curr_node) + "\nYour Input: " );
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        System.out.println("Select the prodcut you want to add to cart: " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        while (choose >= curr_node.getChildren().size()){           //CHECKS IF INPUT IS OUT OF BOUNDS
                            System.out.println("\nERROR NOT a valid choice ");
                            System.out.println("Select the prodcut you want to add to cart: " + tree.toChild(curr_node) + "\nYour Input: ");
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);
                        
                    }
                    //ALLOWS THE CUSTOMER TO ADD TO CART
                    else if (choose <=3){ 
                        System.out.println("Select the prodcut you want to add to cart: " + tree.toChild(curr_node) + "\nYour Input: ");
                        choose = input.nextInt();
                        input.nextLine();
                        while (choose >= curr_node.getChildren().size()){           //CHECKS IF INPUT IS OUT OF BOUNDS
                            System.out.println("\nERROR: NOT a valid choice ");
                            System.out.println("Select the prodcut you want to add to cart: " + tree.toChild(curr_node) + "\nYour Input: ");
                            choose = input.nextInt();
                            input.nextLine();
                        }
                        curr_node = tree.move(curr_node, choose);

                    }
                    
                    cart.add(curr_node);
                    Double price = curr_node.getPrice();
                    total += price;
                    System.out.println("SUCCESSFULLY ADDED TO CART ");
                    break;


                case 2:     //DISPLAYS THE CART AND CART TOTAL 
                    System.out.println("Here is your cart total: " + total +  "\nHere is your cart: "+  cart.toString());
                    break;


                case 3:     //ALLOWS THE CUSTOMER TO DELETE AN ITEM FROM THEIR CART 
                    if (cart.isEmpty()){
                        System.out.println("ERROR CART IS EMPTY ");
                        break;
                    }
                    for(int i = 0; i< cart.size(); i++){
                        System.out.println( i + ". "+ cart.get(i).getName() + " " + cart.get(i).getPrice() + "\n \t");
                    }
                    System.out.println("\nChoose which one to delete  "  +  "\nYour Input: " );
                    choose = input.nextInt();
                    input.nextLine();

                    while (choose>= cart.size()){       //CHECKS IF INPUT IS OUT OF BOUNDS/ EXISTS IN THEIR CART 
                        System.out.println("\nERROR NOT a valid choice ");
                        for(int i = 0; i< cart.size(); i++){
                            System.out.println( i + ". "+ cart.get(i).getName() + " " + cart.get(i).getPrice() + "\n \t");
                        }
                        System.out.println("\nChoose which one to delete  "  +  "\nYour Input: " );
                        choose = input.nextInt();
                        input.nextLine();
                    }
                    total -= cart.get(choose).getPrice();
                    cart.remove(choose);
                    System.out.println("\nSUCCESSFULLY REMOVED ITEM"+ "\nNew Cart:"+ cart.toString());
                    break;


                case 4:     //ALLOWS CUSTOMER TO VIEW MENU 
                    System.out.println(tree.toString());
                    break;


                default:
                    System.out.println("\n"+"ERROR: INPUT A VALID NUMBER! \n");
                    
            }

        }
        input.close();

    }
    
}


