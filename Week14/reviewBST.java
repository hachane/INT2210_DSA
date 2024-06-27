package Week14;

public class reviewBST {
    node root;

    public static void main(String[] args) {
        reviewBST tree = new reviewBST();

        /* Let us create following reviewBST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.root = tree.insert(tree.root, 4);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 1);


        System.out.print("Original reviewBST: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete a Leaf Node: 20");
        tree.root = tree.delNode(tree.root, 9);
        System.out.print("Modified reviewBST tree after deleting Leaf Node:\n");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete Node with single child: 70");
        tree.root = tree.delNode(tree.root, 6);
        System.out.print("Modified reviewBST tree after deleting single child Node:\n");
        tree.inorder(tree.root);

//        System.out.println("\n\nDelete Node with both child: 50");
//        tree.root = tree.delNode(tree.root, 50);
//        System.out.print("Modified reviewBST tree after deleting both child Node:\n");
//        tree.inorder(tree.root);
    }

    node insert(node head, int data) {
        node tmp = head;
        node markedB4Insert = null;
        while (tmp != null) {
            markedB4Insert = tmp;
            if (data < tmp.data) tmp = tmp.left;
            else tmp = tmp.right;
        }
        if (markedB4Insert == null) {
            head = new node(data);
            return head;
        } else if (data < markedB4Insert.data) {
            markedB4Insert.left = new node(data);
        } else markedB4Insert.right = new node(data);
        return head;
    }

    node delNode(node root, int key) {
        if (root == null) return root;
        if (root.data > key) {
            root.left = delNode(root.left, key);
            return root;
        } else if (root.data < key) {
            root.right = delNode(root.right, key);
            return root;
        }
        // We reach here when root is the Node
        // to be deleted.
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) return root.left;
        else {
            node markedb4delete = root;
            node biggestLeft = root.left;
            while (biggestLeft.right != null) {
                markedb4delete = biggestLeft;
                biggestLeft = biggestLeft.right;
            }
            if (markedb4delete != root) markedb4delete.right = biggestLeft.left;
            else markedb4delete.left = biggestLeft.left;
            root.data = biggestLeft.data;
            return root;
        }
    }

    void inorder(node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    private class node {
        node left;
        node right;
        int data;

        public node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}
