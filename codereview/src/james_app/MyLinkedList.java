package james_app;

public class MyLinkedList<E> implements  MyList <E>{

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;

        }
    }
    private Node<E> last;
    private Node<E> first;

    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    public boolean add(E e) {
        Node<E> result = new Node<>(e,last,null);
        if (last == null) {
            first = result;
        }
        else {
            last.next = result ;
        }
        last = result;
        size++;
        return true;

    }

    @Override
    public E get(int index) {
        if (!isValidIndex(index)) {
            return null;
        }
        //mit diesem wird durch die liste gegangen
        Node<E> status = first;
        for (int i = 0; i < index; i++) {
            status = status.next;
        }

        return status.data;

    }


    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;

    }
}
