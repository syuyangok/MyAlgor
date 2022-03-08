package com.yuyang.leetcode.tree;
//leetcode 106.
//Construct Binary Tree from Postorder and Inorder Traversal
//keypoint, find the left tree index in postorder array.
public class BuildTreeInPost {

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        return build(postorder, 0, postorder.length-1,
                inorder, 0, inorder.length-1);

    }

    public TreeNode build(int[] postorder, int postStart, int postEnd,
                          int[] inorder,  int inStart,  int inEnd ){

        //base case
        if (postStart > postEnd){
            return null;
        }

        //root is the last value of postorder array.
        int rootValue = postorder[postEnd];
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
        root.left = build(postorder, postStart , postStart+leftSize-1,
                inorder, inStart, rootIndex-1 );//using leftsize to find child index
        root.right = build(postorder, postStart+leftSize, postEnd-1 ,
                inorder, rootIndex+1, inEnd );

        return root;
    }
}
