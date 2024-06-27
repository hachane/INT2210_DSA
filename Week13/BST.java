// Java program to implement optimized delete in reviewBST.
package Week13;

class Node {
    int key;
    Node left, right;

    // A utility function to create a new reviewBST node
    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BST {
    Node root;

    // Driver Code
    public static void main(String[] args) {
        BST tree = new BST();

		/* Let us create following reviewBST
				50
			/	 \
			30	 70
			/ \ / \
		20 40 60 80 */
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);

        System.out.print("Original reviewBST: ");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete a Leaf Node: 20");
        tree.root = tree.deleteNode(tree.root, 20);
        System.out.print("Modified reviewBST tree after deleting Leaf Node:\n");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete Node with single child: 70");
        tree.root = tree.deleteNode(tree.root, 70);
        System.out.print("Modified reviewBST tree after deleting single child Node:\n");
        tree.inorder(tree.root);

        System.out.println("\n\nDelete Node with both child: 50");
        tree.root = tree.deleteNode(tree.root, 50);
        System.out.print("Modified reviewBST tree after deleting both child Node:\n");
        tree.inorder(tree.root);
    }

    // A utility function to do inorder traversal of reviewBST
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    /* A utility function to insertionSort a new node with given key in
     * reviewBST */
    Node insert(Node node, int key) {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        /* return the (unchanged) node pointer */
        return node;
    }

    /* Given a binary search tree and a key, this function
    deletes the key and returns the new root */
    Node deleteNode(Node root, int key) {
        // Base case
        if (root == null)
            return root;

        // Recursive calls for ancestors of
        // node to be deleted
        if (root.key > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        // If both children exist
        else {

            Node succParent = root;

            // Find successor
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Delete successor. Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            root.key = succ.key;

            // Delete Successor and return root
            return root;
        }
    }
}
