package htwz.leetcode.bsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 911. 在线选举
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 * 实现 TopVotedCandidate 类：
 * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 *
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 *
 * @author wangyu
 * @since 2022/5/9 20:34
 */
public class Solution911 {

    private List<int[]> list = new ArrayList<>();

    // 该方法统计，t 时刻候选人当选的情况
    public Solution911(int[] persons, int[] times) {
        //key:person, value:
        Map<Integer, Integer> map = new HashMap<>();
        int ticket = 0;
        for (int i = 0; i < times.length; i++) {
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (map.get(persons[i]) >= ticket) {
                list.add(new int[]{times[i], persons[i]});
                ticket = map.get(persons[i]);
            }
        }
    }

    //t 时刻 获取到选票最多的候选人
    public int q(int t) {
        int ans = 0, l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (list.get(mid)[0] <= t) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return list.get(ans)[1];
    }

}
