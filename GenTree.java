
public class GenTree<T> {


    private T root;

    public GenTree(){

    }

    //getter
    public T getRoot(){
        return root;
    }

 
    //setter
    public void setRoot(T root){
        this.root=root;
    }
    
    //isEmpty
    public boolean isEmpty(){
        if (root==null){
            return true;
        }
        return false; 
    }
    

   
}
