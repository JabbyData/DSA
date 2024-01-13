package Parentheses;

public class Stack<Item>{
    private int size;
    private Node<Item> first;
    /** Setters **/
    public boolean isEmpty() {return size == 0;}
    public int getSize() {return size;}
    public void push(Item newHead){
        Node<Item> oldFirst = this.first;
        this.first = new Node<>(newHead);
        first.setNext(oldFirst);
        size++;
    }
    public Item pop(){
        Item item = first.getItem();
        first = (first.getNext());
        size--;
        return item;
    }

    public Item take() throws Exception{
        if (isEmpty()){throw new Exception("stack is empty");}
        else{
            return first.getItem();
        }
    }
    /** op in O(1) **/
}
