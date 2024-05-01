import java.util.*;

class Solution {
    
    public int[] preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        _preorder(root, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void _preorder(Node root, List<Integer> res) {
        if (root == null) return ;
        res.add(root.num);
        _preorder(root.left, res);
        _preorder(root.right, res);
    }
    
    public int[] postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        _postorder(root, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void _postorder(Node root, List<Integer> res) {
        if (root == null) return ;
        _postorder(root.left, res);
        _postorder(root.right, res);
        res.add(root.num);
    }
    
    class Node {
        int num;
        int x;
        int y;
        
        Node left;
        Node right;
        
        public Node(int[] pair) {
            this.num = pair[0];
            this.x = pair[1];
            this.y = pair[2];
        }
    }
    
    public void insert(Node root, Node node) {
        if (root.x < node.x) {
            if (root.right != null) {
                insert(root.right, node);
            } else {
                root.right = node;
            }
        }
        if (root.x > node.x) {
            if (root.left != null) {
                insert(root.left, node);
            } else {
                root.left = node;
            }
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] nodes = new int[nodeinfo.length][3];
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i][0] = i + 1;
            nodes[i][1] = nodeinfo[i][0];
            nodes[i][2] = nodeinfo[i][1];
        }
        
        Arrays.sort(nodes, (n1, n2) -> n2[2] - n1[2]);
        
        Node root = new Node(nodes[0]);
        
        for (int i = 1; i < nodes.length; i++) {
            insert(root, new Node(nodes[i]));
        }

        return new int[][] { preorder(root), postorder(root) };
    }
}