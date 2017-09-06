public class StackClass implements IStackClass {
	
	private List<sObject> stack1;
    public StackClass(){
        stack1 = new List<sObject>();
    }
    
    public void push(sObject item){
        stack1.add(item);
    }
    
    public sObject pop(){
        if(!stack1.isEmpty())
            return stack1.remove(size()-1);
        else 
            return null;
    }
    
    public boolean isEmpty(){
        return (stack1.size()==0);
    }
    
    public sObject top(){
        if(!stack1.isEmpty())
            return stack1.get(size()-1);
        else 
            return null;
    }
    
    public Integer size() {
        return stack1.size();
        }
    
}