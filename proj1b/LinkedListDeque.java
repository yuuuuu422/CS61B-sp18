public class LinkedListDeque<T> implements Deque<T> {
    private final Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public class Node {
        private T item;
        private Node pre;
        private Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        public Node() {
            this.item = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(T n) {
        Node newNode = new Node(n, sentinel, sentinel.next);
        sentinel.next.pre = newNode;
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addLast(T n) {
        Node newNode = new Node(n, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node tmpNode = new Node();
        tmpNode.item = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return tmpNode.item;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node tmpNode = new Node();
        tmpNode.item = sentinel.pre.item;

        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;

        size--;
        return tmpNode.item;
    }
    @Override
    public int size() {
        return size;
    }

    /**
     * sentinel->1->2->3 size = 3
     * 0  1  2
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    @Override
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item + " ");
            ptr = ptr.next;
        }
    }
}
