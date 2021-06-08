class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, 0, n-1, inorder, 0, n - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int l, int r, int[] inorder, int a, int b){
        if(l > r) return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = a; // index of root in inorder array
        while(i <= b && inorder[i] != preorder[l]) i++;
        root.left = buildTree(preorder, l + 1, l + i - a , inorder, a, i-1);
        root.right = buildTree(preorder, l + i - a + 1 , r, inorder, i+1, b);
        return root;
    }
}
