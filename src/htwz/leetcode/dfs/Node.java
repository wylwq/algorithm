package htwz.leetcode.dfs;

import java.util.List;

/**
 * @author wangyu
 * @since 2023/1/29 20:34
 */
public class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int val) {
    this.val = val;
  }

  public Node(int val, List<Node> children) {
    this.val = val;
    this.children = children;
  }
};
