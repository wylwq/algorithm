package htwz.leetcode.tridtree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 17.15. 最长单词
 *
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，
 * 返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 *
 *
 * @author wangyu
 * @since 2022/8/27 23:55
 */
public class Solution1715 {

  public static void main(String[] args) {
    String[] words = {"ttaaaa","pp","tpa","kpaqkt","tktpqq","aqppatp"};
    System.out.println(longestWord(words));
  }

  public static String longestWord(String[] words) {
    Set<String> set = new HashSet<>();
    for (String word : words) {
      set.add(word);
    }
    Arrays.sort(words, (a, b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      }
      return b.length() - a.length();
    });
    for (String word : words) {
      char[] cs = word.toCharArray();
      if (cur(cs, 0, set)) {
        return word;
      }
    }
    return "";
  }

  private static boolean cur(char[] cs, int index, Set<String> set) {
    if (index == cs.length) {
      return true;
    }
    for (int i = index; i < cs.length; i++) {
      if (set.contains(new String(cs, index, i - index + 1))) {
        //除去元素自身
        if (index == 0 && i == cs.length - 1) {
          return false;
        }
        if (cur(cs, i + 1, set)) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   * 字典树
   */
  public static String longestWordV2(String[] words) {
    Node root = new Node();
    for (String word : words) {
      root.add(word);
    }
    Arrays.sort(words, (a, b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      }
      return b.length() - a.length();
    });
    for (String word : words) {
      char[] cs = word.toCharArray();
      if (curV2(cs, 0, root, 0) > 1) {
        return word;
      }
    }
    return "";
  }

  private static int curV2(char[] cs, int index, Node root, int size) {
    if (cs.length == index) {
      return size;
    }
    for (int i = 0; i < cs.length; i++) {
      Node node = root.node[cs[i]];
      if (node == null) {
        return 0;
      }
      if (node.end) {
        int ans = curV2(cs, i, root, size + 1);
        if (ans != 0) {
          return ans;
        }
      }
    }
    return 0;
  }


}

class Node {
  Node[] node;

  boolean end = false;

  public Node() {
    node = new Node[26];
    end = false;
  }

  public Node[] getNode() {
    return node;
  }

  public void setNode(Node[] node) {
    this.node = node;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }

  public void add(String word) {
    Node node = this;
    char[] chars = word.toCharArray();
    for (char c : chars) {
      int index = c - 'a';
      if (node.node[index] == null) {
        node.node[index] = new Node();
      }
      node = node.node[index];
    }
    node.end = true;
  }
}
