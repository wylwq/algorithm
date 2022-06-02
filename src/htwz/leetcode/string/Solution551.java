package htwz.leetcode.string;

/**
 * 551. 学生出勤记录 I
 *
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 *
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 * @author wangyu
 * @since 2022/6/2 14:54
 */
public class Solution551 {

    public static boolean checkRecord(String s) {
        String late = "LLL";
        if (s.contains(late)) {
            return false;
        }
        int absentNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentNum++;
            }
            if (absentNum >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "PPALLP";
        boolean b = checkRecord(s);
        System.out.println(b);
    }
}
