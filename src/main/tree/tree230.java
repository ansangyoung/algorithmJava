// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 230. Kth Smallest Element in a BST
package main.tree;

import java.util.ArrayList;
import java.util.Collections;

// Definition for a binary tree node.
class TreeNode {
    int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public void treeSearch(TreeNode root, ArrayList<Integer> list) {
    	if(root == null) return;
		treeSearch(root.left, list);
		list.add(root.val);
		treeSearch(root.right, list);
	}
	
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        treeSearch(root, list);
        res = list.get(k - 1);
System.out.println("res:" + res);
		return res;
    }
}

public class tree230 {
	public static void main(String[] args) {
		TreeNode root= new TreeNode(3);
		//root = [3, 1, 4, null, 2]
		root.left = new TreeNode(1);
		root.left.left = null;
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		
		int k = 1;
		Solution soultion = new Solution();
		soultion.kthSmallest(root, k); // 1
		
		
		root = null;
		root= new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		
		k = 3;
		soultion.kthSmallest(root, k); // 3
	}
}
