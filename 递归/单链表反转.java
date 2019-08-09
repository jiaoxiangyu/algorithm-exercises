
public class 单链表反转 {
    public static void reverse(Node node,Node pre){
        if (node == null ) {
            return;
        }
        Node next=node.getNext();
        node.setNext(pre);
        reverse(next,node);
    }

    public static void printNode(Node head) {
        while (head!=null){
            System.out.print(head.getValue()+" ");
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        Node n3 = new Node(3, null);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        //printNode(n1);
        reverse(n1,null);
        printNode(n3);
    }
}

class Node{
    private int value;
    private Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}