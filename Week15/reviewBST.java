package Week15;

public class reviewBST {
    node root;

    public static void main(String[] args) {
        reviewBST tmp = new reviewBST();
        tmp.root = tmp.insert(tmp.root, 10);
        tmp.insert(tmp.root, 11);
        tmp.insert(tmp.root, 12);
        tmp.insert(tmp.root, 9);
        tmp.insert(tmp.root, 7);
        tmp.inorder(tmp.root);
        tmp.del(tmp.root, 10);
        tmp.inorder(tmp.root);
    }

    node insert(node root, int k) {
        if (root == null) {
            return new node(k);
        }
        node tmp = root;
        node marked = null;
        while (tmp != null && tmp.key != k) {
            marked = tmp;
            if (tmp.key > k) tmp = tmp.left;
            else if (tmp.key < k) tmp = tmp.right;
        }
        if (tmp == null) {
            if (marked.key > k) {
                marked.left = new node(k);
            } else if (marked.key < k) {
                marked.right = new node(k);
            }
            return root;
        } else {
            return root;
        }
    }

    node del(node root, int k) {
        if (root == null) return root;
        if (root.key > k) return del(root.left, k);
        else if (root.key < k) return del(root.right, k);

        node tmp = root;
        if (root.left != null && root.right == null) return root.left;
        else if (root.right != null && root.left == null) return root.right;
        else if (root.right != null && root.left != null) {
            node biggestLeft = root;
            node marked = null;
            while (biggestLeft.right != null) {
                marked = biggestLeft;
                biggestLeft = biggestLeft.right;
            }
//            if (biggestLeft.left == null) {
//                marked.right = null;
//                return root;
//            }
//            else if (biggestLeft.left != null) {
//                marked.right = biggestLeft.left;
//                return root;
//            }
            if (marked == root) marked.left = biggestLeft.left;
            else marked.right = biggestLeft.left;
            root.key = biggestLeft.key;
            return root;
        }
        return root;
    }

    void inorder(node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }

    class node {
        int key, height;
        node left, right;

        node(int k) {
            this.key = k;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }
}
