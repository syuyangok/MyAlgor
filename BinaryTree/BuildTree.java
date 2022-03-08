package com.yuyang.leetcode.tree;
//leetcode 105.
//Construct Binary Tree from Preorder and Inorder Traversal
//keypoint, find the left tree index in preorder array.
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);

    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder,  int inStart,  int inEnd ){

        //base case
        if (preStart > preEnd){
            return null;
        }

        //root is the first value of preorder array.
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        //using rootValue to find root index in inorder array
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }

        //find leftChild size
        //inorder array, all items on the left of root are in left tree
        int leftSize = rootIndex - inStart;

        //find left/right child
        root.left = build(preorder, preStart+1 , preStart+leftSize,
                inorder, inStart, rootIndex-1 );//using leftsize to find child index
        root.right = build(preorder, preStart+leftSize+1, preEnd ,
                inorder, rootIndex+1, inEnd );

        return root;
    }
}
