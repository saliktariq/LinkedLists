public class Element<T>
{
    private T data;
    private Element<T> next;
    
    public Element(T data, Element<T> next){
        this.data = data;
        this. next = next;
    }
    
    public Element(T data){
        this(data,null);
    }
    
    public T getData(){
        return this.data;
    }
    
    public Element<T> getNext(){
        return this.next;
    }
    
    public String toString(){
        return data.toString();
        
    }
    
    public int size(){
        if (next == null){
            return 1;
        }
        return next.size() + 1; 
    }
    
    public static boolean areEqual(Object x, Object y){
        if( x== null){
            return (y==null);
        }
        return x.equals(y);
        
    }
    
    public boolean contains(T value){
        if(areEqual(data,value)){
            return true;
        }
        return (next != null) && next.contains(value);
    }
    
    public T get(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(index == 0){
            return data;
        }
        if (next == null){
            throw new IndexOutOfBoundsException();
        }
        return next.get(index -1);
        
    }
    
    public void set(int index, T newData){
        
        if(index <0){
            throw new IndexOutOfBoundsException();
        }
        
        
        if(index == 0){
            this.data = newData;
        }
        else if(next == null){
            throw new IndexOutOfBoundsException();
        }
        else {
            next.set(index-1,newData);
        }
    }
    
    public void add(int index, T newData){
        if(index <= 0){
            throw new IndexOutOfBoundsException();
        }
        if(index == 1){
            next = new Element<>(newData, next);
        } else if(next == null){
            throw new IndexOutOfBoundsException();
        }
        else {
            next.add(index -1, newData);
        }
    }
    
    public T remove(int index){
        if(index <= 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(index == 1){
            T result = next.data;
            next = next.next;
            return result;
        }
        return next.remove(index -1);
    }
}
