package assignment2;

public class List<E extends DataInterface<E>> implements ListInterface<E> {
	
    List <E> list;
    Node current, first, last;
    private int amountElements;
    
    List(){
        current = null;
        amountElements = 0;
    }
     
    public boolean isEmpty() {
        if (amountElements == 0) {
            return true;
        } else {
            return false;
        }
    }
     
    public List<E> init() {
        amountElements = 0;
        return list;
    }
 
    public int size() {
        return amountElements;
    }
 
    public ListInterface<E> insert(E d) {
        find(d);
        if (list.isEmpty()) {
            first = current = last = new Node(d);
            amountElements ++;
        } else if (first.data.compareTo(d)==1) {
            current = new Node(d, null,first);
            first = current;
            current.next.prior = current;
            amountElements ++;
        } else if (last.data.compareTo(d)>= 0){
            current = new Node (d, last, null);
            last = current;
            current.prior.next = current;
            amountElements ++;
        } else {
            current = new Node (d, current, current.next);
            current.next.prior = current;
            current.prior.next = current;
            amountElements ++;
        }   
        return this;
    }
 
    public E retrieve() {
        if (!list.isEmpty()) {
            return current.data;
        } else {
            return null;
        }
    }
 
    public ListInterface<E> remove() {
        if (amountElements == 1) {
            current = null;
            current.next = null;
            current.prior = null;
        } else if (current.prior == null){
            current.next.prior = null;
            current = current.next;  
        } else if (current.next == null){
            current.prior.next = null;
            current = current.prior;
        } else {
            current.next.prior = current.prior;
            current.prior.next = current.next;
            current = current.next;
        }
        return this;    
    }
 
    public boolean find(E d) {
        current = first;
        for (int i = 0; i < list.size(); i++) {
            E o = current.data;
            if (d.compareTo(o) == 0) {
                return true;
            } else if (d.compareTo(o) == 1 && current.next!=null) {
                current = current.next;
            } else {
                return false;
            }
        }
        return false;
    }
 
    public boolean goToFirst() {
        if (list.isEmpty()) {
            return false;
        } else if (current.prior.equals(null)) {
            return true;
        } else {
            return false;
        }
    }
 
    public boolean goToLast() {
        if (list.isEmpty()) {
            return false;
        } else if (current.next.equals(null)) {
            return true;
        } else {
            return false;
        }
    }
 
 
    public boolean goToNext() {
        if (list.isEmpty() || list.goToLast()) {
            return false;
        } else {
            current = current.next;
            return true;
        }
    }
 
 
    public boolean goToPrevious() {
        if (list.isEmpty() || list.goToFirst()) {
            return false;
        } else {
            current = current.prior;
            return true;
        }
    }
 
 
    public List<E> clone() {
        List<E> clonedList = new List<>();
        current = first;
        for (int i = 0; i < list.size(); i++) {
            clonedList.insert(current.data);
            current = current.next;
        }
        return clonedList;
    }
     
    private class Node {
 
        E data;
        Node prior,
             next;
 
        public Node(E d) {
            this(d, null, null);
        }
 
        public Node(E data, Node prior, Node next) {
            this.data = data == null ? null : data;
            this.prior = prior;
            this.next = next;
        }
    }
    
}