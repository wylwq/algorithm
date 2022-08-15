package htwz.leetcode.dubbleLinked;

/**
 * 2296. 设计一个文本编辑器
 *
 * 请你设计一个带光标的文本编辑器，它可以实现以下功能：
 *
 * 添加：在光标所在处添加文本。
 * 删除：在光标所在处删除文本（模拟键盘的删除键）。
 * 移动：将光标往左或者往右移动。
 * 当删除文本时，只有光标左边的字符会被删除。光标会留在文本内，也就是说任意时候 0 <= cursor.position <= currentText.length 都成立。
 *
 * 请你实现 TextEditor 类：
 *
 * TextEditor() 用空文本初始化对象。
 * void addText(string text) 将 text 添加到光标所在位置。添加完后光标在 text 的右边。
 * int deleteText(int k) 删除光标左边 k 个字符。返回实际删除的字符数目。
 * string cursorLeft(int k) 将光标向左移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 * string cursorRight(int k) 将光标向右移动 k 次。返回移动后光标左边 min(10, len) 个字符，其中 len 是光标左边的字符数目。
 *
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
