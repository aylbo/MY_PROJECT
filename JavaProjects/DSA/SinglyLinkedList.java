import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    // Do not add new instance variables or modify existing ones.

    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    //Do not add a constructor.

    /**
     * Adds the element to the front of the list.
     * Method should run in O(1) time.
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     * Method should run in O(1) time.
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if (tail == null) {
            // If the list is empty
            head = newNode;
            tail = newNode;
        } else {
            // Add the new node to the end of the list
            tail.setNext(newNode);
            tail = newNode; // Update the tail
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     * Method should run in O(1) time.
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedData = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return removedData;
    }

    /**
     * Removes and returns the last data of the list.
     * Method should run in O(n) time.
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (head == null) {
            throw new NoSuchElementException("List is empty"); 
        } else if (head.getNext() == null) {
            T removedData = head.getData(); 
            head = null;
            tail = null;
            size--; 
            return removedData; 
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            T removedData = current.getNext().getData();
            current.setNext(null);
            tail = current;
            size--; // 
            return removedData;
        }
    }

    /**
     * Returns the head node of the list.
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}