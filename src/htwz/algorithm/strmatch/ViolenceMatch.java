package htwz.algorithm.strmatch;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/10 20:08
 * @Version V1.0.0
 **/
public class ViolenceMatch {

    public static void main(String[] args) {
        String s1 = "ababc";
        String s2 = "abc";
        int i = violenceMatch(s1, s2);
        System.out.println(i);
    }

    /**
     * 暴力匹配算法
     * @param str1
     * @param str2
     * @return
     */
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1Len = s1.length;
        int s2Len = s2.length;
        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        }
        return -1;
    }
}
