package 算法思想.分治算法;

/**
 * @ClassName: 将有序数组转换为二叉搜索树
 * @Description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * @Author jiaoxiangyu
 * @Date 2021/8/18
 * @Version 1.0
 * @Since JDK1.8
 */
public class 将有序数组转换为二叉搜索树 {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    public static TreeNode generateTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateTree(nums, left, mid - 1);
        root.right = generateTree(nums, mid + 1, right);

        return root;
    }

    public static void printTre(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+" ");
            printTre(root.left);
            printTre(root.right);
        }
    }


    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        TreeNode treeNode = 将有序数组转换为二叉搜索树.sortedArrayToBST(nums);
        将有序数组转换为二叉搜索树.printTre(treeNode);
    }
}
