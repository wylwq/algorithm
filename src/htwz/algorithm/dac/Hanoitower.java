package htwz.algorithm.dac;

/**
 * @Description:
 * @Author wangy
 * @Date 2020/8/9 9:35
 * @Version V1.0.0
 **/
public class Hanoitower {

    public static void main(String[] args) {
        hanoitower(2, 'A', 'B', 'C');
    }

    //汉诺塔的移动方法 分治算法
    public static void hanoitower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果我们有n >= 2 情况，我们总是可以看做是两个盘 1. 最下面的一个盘，2上面的所有盘
            //1 先把最上面的所有盘A->B， 移动到c会使用到c
            hanoitower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //把B塔上的所有盘从B->C,移动过程中会用到a
            hanoitower(num - 1, b, a, c);
        }
    }
}
