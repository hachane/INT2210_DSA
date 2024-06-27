package Week14;

public class AVL {
    Node root;

    public static void main(String[] args) {
        AVL tree = new AVL();

        /* Let us create following reviewBST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.root = tree.insert(tree.root, 4);
        tree.preorder(tree.root);
        tree.insert(tree.root, 10);
        tree.preorder(tree.root);
        tree.insert(tree.root, 9);
        tree.preorder(tree.root);
        tree.insert(tree.root, 6);
        tree.preorder(tree.root);
        tree.insert(tree.root, 5);
        tree.preorder(tree.root);
        tree.insert(tree.root, 3);
        tree.preorder(tree.root);
        tree.insert(tree.root, 7);
        tree.preorder(tree.root);
        tree.insert(tree.root, 2);
        tree.preorder(tree.root);
        tree.insert(tree.root, 8);
        tree.preorder(tree.root);
        tree.insert(tree.root, 1);


        System.out.print("Original reviewBST: ");
        tree.preorder(tree.root);

        System.out.println("\n\nDelete a Leaf Node: 20");
        tree.root = tree.del(tree.root, 9);
        System.out.print("Modified reviewBST tree after deleting Leaf Node:\n");
        tree.preorder(tree.root);

        System.out.println("\n\nDelete Node with single child: 70");
        tree.root = tree.del(tree.root, 6);
        System.out.print("Modified reviewBST tree after deleting single child Node:\n");
        tree.preorder(tree.root);

//        System.out.println("\n\nDelete Node with both child: 50");
//        tree.root = tree.delNode(tree.root, 50);
//        System.out.print("Modified reviewBST tree after deleting both child Node:\n");
//        tree.inorder(tree.root);
    }

    // delete
    Node del(Node root, int data) {
        if (root == null) return root;

        if (root.val > data)
            return del(root.left, data);
        else if (root.val <= data)
            return del(root.right, data);

        // when it's root to be del
        if (root.right == null && root.left != null) return root.left;
        else if (root.right != null && root.left == null) return root.right;
        else {
            Node markedb4delete = root;
            Node biggestLeft = root.left;
            while (biggestLeft.right != null) {
                markedb4delete = biggestLeft;
                biggestLeft = biggestLeft.right;
            }
            if (markedb4delete == root) markedb4delete.left = biggestLeft.left;
            else if (markedb4delete != root) markedb4delete.right = biggestLeft.left;
            // don forget to assign
            root.val = biggestLeft.val;
            return root;
        }
    }

    // height;
    int height(Node tmp) {
        if (tmp == null) return -1;
        return tmp.ht;
    }

    int balanceCheck(Node tmp) {
        if (tmp == null) return -1;
        return height(tmp.left) - height(tmp.right);
    }

    Node move2Left(Node x) {
        Node tmp = x.right;
        x.right = x.right.left;
        tmp.left = x;

        tmp.ht = 1 + Math.max(height(tmp.left), height(tmp.right));
        x.ht = 1 + Math.max(height(x.left), height(x.right));

        return tmp;
    }

    Node move2Right(Node x) {
        Node tmp = x.left;
        x.left = x.left.right;
        tmp.right = x;

        tmp.ht = 1 + Math.max(height(tmp.left), height(tmp.right));
        x.ht = 1 + Math.max(height(x.left), height(x.right));

        return tmp;
    }

    Node insert(Node root, int data) {
        // step1: insertionSort and check
        if (root == null)
            return new Node(data);

        if (data >= root.val) root.right = insert(root.right, data);
        else if (data <= root.val) root.left = insert(root.left, data);

        // step2: update new height
        root.ht = 1 + Math.max(height(root.left), height(root.right));

        // step 3: check balance and rotate
        int balanceFactor = balanceCheck(root);

        // look at the picture and always remember that the lowest Node is the one added
        // left - left case
        if (balanceFactor > 1 && data <= root.left.val) return move2Right(root);
        // left - right case : move to left first then move to right
        if (balanceFactor > 1 && data >= root.left.val) {
            root.left = move2Left(root.left);
            return move2Right(root);
        }
        // right - right case
        if (balanceFactor < -1 && data >= root.right.val) return move2Left(root);
        // right - left case :
        if (balanceFactor < -1 && data <= root.right.val) {
            root.right = move2Right(root.right);
            return move2Left(root);
        }

        root.ht = 1 + Math.max(height(root.left), height(root.right));

        return root;
    }

    void preorder(Node root) {
        if (root == null) {
            System.out.print("\n");
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    class Node {
        int val, ht;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.ht = 0;
        }

        Node(Node tmp) {
            this.val = tmp.val;
            this.left = tmp.left;
            this.right = tmp.right;
            this.ht = tmp.ht;
        }
    }
}
