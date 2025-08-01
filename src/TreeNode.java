import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
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

      static TreeNode buildTree(Integer[] values) {
          if (values == null || values.length == 0 || values[0] == null) return null;

          TreeNode root = new TreeNode(values[0]);
          Queue<TreeNode> queue = new LinkedList<>();
          queue.add(root);

          int i = 1;
          while (i < values.length) {
              TreeNode current = queue.poll();
              if (i < values.length && values[i] != null) {
                  current.left = new TreeNode(values[i]);
                  queue.add(current.left);
              }
              i++;
              if (i < values.length && values[i] != null) {
                  current.right = new TreeNode(values[i]);
                  queue.add(current.right);
              }
              i++;
          }
          return root;
      }
}
