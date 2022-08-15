package htwz.leetcode.dubbleLinked;

/**
 * @author wangyu
 * @since 2022/8/16 6:38
 */
public class Solution2296 {

  public static void main(String[] args) {

  }

  private StringBuilder sb = new StringBuilder();

  private int cursor = 0;

  public void addText(String text) {
    sb.insert(cursor, text);
    cursor += text.length();
  }

  public int deleteText(int k) {
    if (cursor <= k) {
      int oldCursor = cursor;
      sb.replace(0, oldCursor, "");
      cursor = 0;
      return oldCursor;
    } else {
      sb.replace(cursor -k, cursor, "");
      cursor -= k;
      return k;
    }
  }

  public String cursorLeft(int k) {
    if (cursor >= k) {
      cursor -= k;
      return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
    } else {
      cursor = 0;
      return "";
    }
  }

  public String cursorRight(int k) {
    int len = sb.length();
    if (cursor + k <= len) {
      cursor += k;
    } else {
      cursor = len;
    }
    return cursor >= 10 ? sb.substring(cursor - 10, cursor) : sb.substring(0, cursor);
  }

}
