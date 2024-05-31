class Node{
    static int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList extends Node {


    LinkedList() {
        super(data);
    }

    private Node head;

    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("The given position is out of range.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("The given position is out of range.");
            return;
        }

        current.next = current.next.next;
    }

    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("The given node is null or it does not have a next node.");
            return;
        }

        prevNode.next = prevNode.next.next;
    }

    public boolean searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node getHead() {
        return head;
    }
}

class Stack extends Node {
    Stack(int data) {
        super(data);
    }

    private Node top;
    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        int data = top.data;
        top = top.next;
        return data;
    }
    
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void displayStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.insertAtPos(25, 3);
        list.displayList();

        list.deleteAtPosition(2);
        list.displayList();

        Node head = list.getHead();
        list.deleteAfterNode(head);
        list.displayList();

        boolean found = list.searchNode(25);
        System.out.println("Node 25 found: " + found);

        found = list.searchNode(20);
        System.out.println("Node 20 found: " + found);

        Stack stack = new Stack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        stack.displayStack();

        System.out.println("Popped element: " + stack.pop());
        stack.displayStack();

        System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
