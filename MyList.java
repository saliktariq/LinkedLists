public class MyList<T>
{
    private Element<T> head;
    
    public MyList(){
    }
    
    private Element<T> copy(Element<? extends T> current){
        if(current == null){
            return null;
        }
        Element<T> copyOfNext = copy(current.getNext());
        return new Element<>(current.getData(),copyOfNext);
    }
    
    public MyList(MyList<? extends T> other){
        this.head = copy(other.head);
    }
    
    public boolean isEmpty(){
        
        return head == null;
    }
    
    public int size(){
        if(isEmpty()){
            return 0;
        }
        
        return head.size();
    }
    
    public boolean contains(T value){
        return !isEmpty() && head.contains(value);
    }
    
    public String toString(){
        return "[" + toStringContents(head) + "]";
    }
    
    public static String toStringContents(Element<?> head){
        if(head == null){
        return "";}
        
        if(head.getNext() == null){
        return head.toString();
        }
        return head.toString() + "," + toStringContents(head.getNext());
    }
    
    public T get(int index){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return head.get(index);
    }
    
    public void set(int index, T value){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        head.set(index,value);
    }
    
    public void clear(){
        head = null;
    }
    
    public void add(int index, T value){
        if(index ==0){
            head = new Element<>(value, head);
        } else if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        else {
            head.add(index,value);
        }
    }
    
    public T remove(int index){
        if(isEmpty()){throw new IndexOutOfBoundsException();}
        
        if(index == 0){
            T result = head.getData();
            head = head.getNext();
            return result;
        }
        
        return head.remove(index);
    }
    
}
