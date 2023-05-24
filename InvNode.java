import java.util.ArrayList;

public class InvNode {
    private String name;
    private double price;
    private ArrayList<InvNode> children;

    //constructor of node and children
    public InvNode (String name ,double price) {
        this.name = name; 
        this.price = price;
        children = new ArrayList<InvNode>();
    }
    
    //Setters
    public void setName (String name){
        this.name=name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Getters
    public String getName(){
        return name;

    }

    public double getPrice() {
        return price;
    }

    

    public ArrayList<InvNode> getChildren(){
        return children;
    }
    //toString
    public String toString(){
        return "\t" + getName() + getPrice()  ;
    }
    

    
}
