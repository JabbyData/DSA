package Parentheses;

public class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    public boolean isEmpty(){return size == 0;}
    public int getSize(){return size;}
    public void enqueue(Item item){
        /* insert an elt at the end of the queue */
        Node<Item> newLast = new Node<>(item);
        if (isEmpty()){first=last=newLast;}
        last.setNext(newLast);
        last = newLast;
        size++;
    }
    public Item dequeue() throws Exception {
        /* pop first elt in the queue */
        if (isEmpty()) {
            throw new Exception("empty list");
        } else {
            Item item = first.getItem();
            first = first.getNext();
            size--;
            return item;}
    }
    /** op in O(1) **/
}
