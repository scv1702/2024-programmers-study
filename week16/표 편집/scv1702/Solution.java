import java.util.*;

class Node {
    int num;
    Node prev;
    Node next;
    
    public Node(int num, Node prev, Node next) {
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
    
    @Override
    public String toString() {
        return String.format("%d -> ", num);
    }
    
    public static Node foward(Node curr, int step) {
        for (int i = 0; i < step; i++) {
            if (curr == null) throw new RuntimeException("foward error");
            curr = curr.next;
        }
        return curr;
    }
    
    public static Node backward(Node curr, int step) {
        for (int i = 0; i < step; i++) {
            if (curr == null) throw new RuntimeException("backward error");
            curr = curr.prev;
        }
        return curr;
    }
}

class Solution {

    public String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        int[] table = new int[n];
        ArrayDeque<Node> deleted = new ArrayDeque<>();
        
        Node head = new Node(0, null, null);
        Node prev = head;
        
        for (int i = 1; i < n; i++) {
            Node node = new Node(i, prev, null);
            prev.next = node;
            prev = node;
        }
        
        Node curr = Node.foward(head, k);
        
        for (String c : cmd) {
            char opcode = c.charAt(0);
            if (opcode == 'C') {
                deleted.offerFirst(curr);
                if (curr.prev == null) {
                    head = head.next;
                    head.prev = null;
                } else {
                    curr.prev.next = curr.next;
                }
                if (curr.next == null) {
                    curr = curr.prev;
                    curr.next = null;
                } else {
                    curr.next.prev = curr.prev;
                    curr = curr.next;
                }
            } else if (opcode == 'Z') {
                Node recovered = deleted.pollFirst();
                if (recovered.prev == null) {
                    head = recovered;
                } else {
                    recovered.prev.next = recovered;
                }
                if (recovered.next != null) {
                    recovered.next.prev = recovered;
                }
            } else {
                String[] splited = c.split(" ");
                opcode = splited[0].charAt(0);
                int operand = Integer.parseInt(splited[1]);
                if (opcode == 'D') {
                    curr = Node.foward(curr, operand);
                } else {
                    curr = Node.backward(curr, operand);
                }
            }
        }
        
        while (head != null) {
            table[head.num] = 1;
            head = head.next;
        }
        
        for (int i = 0; i < n; i++) {
            if (table[i] > 0) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}