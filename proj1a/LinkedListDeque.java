/**
 *  @author Theoyu
 */
public class LinkedListDeque<T> {
    public class Node{
        private T item;
        private Node pre;
        private Node next;

        public Node(T item,Node pre,Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
        public Node(){
            this.item=null;
        }
    }
    private final Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel= new Node();
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(T n){
        Node newNode = new Node(n,sentinel,sentinel.next);
        sentinel.next.pre=newNode;
        sentinel.next=newNode;
        size++;
    }

    public void addLast(T n){
        Node newNode = new Node(n,sentinel.pre,sentinel);
        sentinel.pre.next=newNode;
        sentinel.pre=newNode;
        size++;
    }

    public T removeFirst(){
        if (size==0)
            return null;
        Node tmpNode = new Node();
        tmpNode.item=sentinel.next.item;
        sentinel.next.pre=sentinel;
        sentinel.next.next=sentinel.next;
        size--;
        return tmpNode.item;
    }
    public T removeLast(){
        if (size==0){
            return null;
        }
        Node tmpNode = new Node();
        tmpNode.item=sentinel.pre.item;
        sentinel.next.pre=sentinel;
        sentinel.next.next=sentinel.next;
        size--;
        return tmpNode.item;
    }

    public int size(){
        return size;
    }
/**
 * sentinel->1->2->3 size = 3
 *           0  1  2
 */
    public T get(int index){
        if (index>=size){
            return null;
        }
        Node ptr= sentinel;
        for(int i=0;i<=index;i++){
            ptr=ptr.next;
        }
        return ptr.item;
    }
    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public T getRecursive(int index){
        if (index>=size){
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }
    public void printDeque(){
        Node ptr = sentinel.next;
        while (ptr!=sentinel){
            System.out.println(ptr.item+" ");
            ptr=ptr.next;
        }
    }
}
