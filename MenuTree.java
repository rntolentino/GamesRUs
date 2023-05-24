import java.util.ArrayList;
public class MenuTree extends GenTree<InvNode> {
    
    public MenuTree (){
        super();
    }


    public String toStringRec(InvNode root, int num_tab){
        if (root==null){
            return "Empty ";
        }
        String result= "\n";
        for (int i =0 ; i <= num_tab; i++){
            result+= "\t";
        }
        result +=  root.getName() + " ";
        
        
        if (root.getPrice()!=0){
            result += "$" + root.getPrice();
        }
        for (int i =0 ; i < root.getChildren().size(); i++){
            InvNode oneN = root.getChildren().get(i);
            result +=  toStringRec(oneN, num_tab+1);
            
        }
        
        return result;
    }

    public String toString(){
        return toStringRec(getRoot(),0);
    }

    //toString for children of given node 
    public String toChild(InvNode node){
        ArrayList<InvNode> children = node.getChildren();
        String stringOfArray="";
        for(int i = 0; i< children.size(); i++){
            stringOfArray += "\n" + i + ". "+ children.get(i).getName() + " " +children.get(i).getPrice() + "\n";
        }
        return stringOfArray;
    }

    //Setter
    public void setRootName(String data){
        getRoot().setName(data);
    }
   
    //Adds nodes to the tree
    public void addNode(InvNode parent , String data, double price){
        InvNode newNode = new InvNode(data , price);
        parent.getChildren().add(newNode);
    }

    //Removes node from tree
    public void removeNode(InvNode parent,int index ){
        parent.getChildren().remove(index);
    }

    //Move to node in tree
    public InvNode move (InvNode parent, int index){
        ArrayList<InvNode> list= parent.getChildren();
        InvNode moved2node = list.get(index);
        return moved2node;
    }
}
