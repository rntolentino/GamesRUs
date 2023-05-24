public class Menu {

    public static void createMenu(MenuTree tree){
        InvNode root = new InvNode("options", 0.0);
        tree.setRoot(root);
        tree.addNode(root, "Accessories ", 0.0);
        tree.addNode(root, "Games",  0.0);
        tree.addNode(root, "Consoles ",  0.0);
        tree.addNode(root, "Toys  ", 0.0);

        //Adds to toys category 
        InvNode toys = tree.move(root, 3);
        tree.addNode(toys, "Mario Plushie ", 15.00);
        tree.addNode(toys, "Lilo & Stitch Funko Pop ", 12.00);
        tree.addNode(toys, "Amiibo Figurine ", 20.00);
        tree.addNode(toys, "Luigi Plushie ", 15.00);

        //Adds to games category 
        InvNode games = tree.move(root, 1);
        tree.addNode(games, "MineCraft XBox ", 40.0);
        tree.addNode(games, "Call of Duty XBox ",50.0);
        tree.addNode(games, "Mortal Kombat XBox ", 20.0);
        tree.addNode(games, "Grand Theft Auto IV Xbox ", 60.0);
        tree.addNode(games, "MineCraft Dungeons Switch ", 30.0);
        tree.addNode(games, "Call of Duty Switch ",35.0);
        tree.addNode(games, "Mortal Kombat Switch ", 20.0);
        tree.addNode(games, "Grand Theft Auto Trilogy Switch ", 40.0);
        tree.addNode(games, "Hogwarts Legacy PS",69.0);
        tree.addNode(games, "Stray PS ", 20.0);
        tree.addNode(games, "The Last of US PS ", 40.0);
        
        //Adds to consoles category 
        InvNode consoles = tree.move(root, 2 );
        tree.addNode(consoles, "Playstation 5 ", 500.0);
        tree.addNode(consoles, "Playstation 5 Refurbished ", 300.0);
        tree.addNode(consoles, "Xbox One ",350.0);
        tree.addNode(consoles, "Xbox 360 Refurbished ",150.0);
        tree.addNode(consoles, "Nintendo Switch Lite Purple ", 200.0);
        tree.addNode(consoles, "Nintendo Switch Lite Yellow ", 200.0);
        tree.addNode(consoles, "Nintendo Swtich OLED ", 400.0);

        //Creates categories in accessories
        InvNode accessories = tree.move(root, 0);
        tree.addNode(accessories, "Nintendo  ", 0);
        tree.addNode(accessories, "XBox ", 0);
        tree.addNode(accessories, "PS ", 0);
        tree.addNode(accessories, "General Accessories ", 0);

        //Adds to the categroies of accessories
        InvNode nintendo = tree.move(accessories, 0);
        tree.addNode(nintendo, "Purple Kuromi Nintendo Switch Case ", 40.00);
        tree.addNode(nintendo, "Animal Crossing Nintendo Switch Case ", 30.00);
        tree.addNode(nintendo, "Simple Sage Green Nintendo Switch Case ", 20.00);
        tree.addNode(nintendo, "Nintendo Switch Dock Set ", 80.00);
        tree.addNode(nintendo, "Nintendo Switch USB-C Charger ", 30.00);

        InvNode xbox = tree.move(accessories, 1);
        tree.addNode(xbox, "XBOX Wireless Controller ", 50.00);
        tree.addNode(xbox, "XBOX Wireless Gaming HeadSet ", 70.00);
        tree.addNode(xbox, "XBOX Wired Gaming HeadSet ", 40.00);
        tree.addNode(xbox, "XBOX Wired Controller ", 50.00);
        tree.addNode(xbox, "XBOX Travel Case ", 55.00);

        InvNode PS = tree.move(accessories, 2);
        tree.addNode(PS, "PS Wireless Controller ", 50.00);
        tree.addNode(PS, "PS Wired Controller ", 30.00);
        tree.addNode(PS, "PS White Wired Headset ", 60.00);
        tree.addNode(PS, "PS White and Blue Wireless Headset ", 80.00);

        InvNode gen = tree.move(accessories, 3);
        tree.addNode(gen, "Hello Kitty Charm ", 12.00);
        tree.addNode(gen, "Tom Nook Charm ", 12.00);
        tree.addNode(gen, "Universal Chager ", 40.00);
        tree.addNode(gen, "Mini Projector ", 80.00);
        

    }



    
}
