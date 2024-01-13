package Parentheses;

public class Node<Item>{
    private Item Item;
    private Node<Item> next;
    /** Constructor **/
    public Node(Item item){
        this.Item = item;
        next = null;
    }
    /** Accessors **/
    public Item getItem() {
        return Item;
    }

    public Node<Item> getNext() {
        return next;
    }

    /** Setters **/
    public void setItem(Item item) {
        Item = item;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }
}