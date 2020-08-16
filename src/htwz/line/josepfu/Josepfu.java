package htwz.line.josepfu;
/**
* @author: wy
* @createDate: 2020/3/7/007 10:44
* @descption  约瑟夫问题（单项环形链表实现）
* @version: 1.0.0
*/
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.addBody(5);
        c.showBody();
        /**
         * 答案：2->4->1->5->3
         */
        c.countBody(1, 2, 5);
    }
}

class CircleSingleLinkedList {

    //创建一个first节点，当前没有编号
    private Body first = null;

    /**
     * 创建指定长度的约瑟夫环行链表
     * @param nums
     */
    public void addBody(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不能小于1");
            return ;
        }
        Body curBody = null;
        for (int i = 1; i <= nums; i++) {
            Body newBody = new Body(i);
            if (i == 1) {
                first = newBody;
                first.setNext(first);
                curBody = first;
            } else {
                curBody.setNext(newBody);
                newBody.setNext(first);
                curBody = newBody;
            }
        }
    }

    public void showBody() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        Body curBody = first;
        while(true) {
            System.out.printf("当前小孩的编号%d\n", curBody.getNo());
            if (curBody.getNext() == first) {
                break;
            }
            curBody = curBody.getNext();
        }
    }

    /**
     * 根据用户的输入，计算小孩出圈的顺序
     * startNo 从下表为startNo的小孩开始数
     * countNum 每数countNum下就开始将改小孩出圈，
     * nums 总的小孩数
     */
    public void countBody(int startNo, int countNum, int nums) {
        if (first == null) {
            System.out.println("没有小孩");
            return;
        }
        if (startNo < 1 || startNo > nums) {
            System.out.println("阐述输入有误");
        }
        Body helper = first;
        while(true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //小孩的小标是从一开始
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true) {
            if (helper == first) {
                System.out.printf("圈中的最后一个人是%d\n", helper.getNo());
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时候first指向的节点，就是要出圈的小孩
            System.out.printf("出圈的小孩%d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }


}

//创建一个Boy类，表示一个节点
class Body {

    private Integer no;

    private Body next;

    public Body(Integer no) {

        this.no = no;
    }


    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Body getNext() {
        return next;
    }

    public void setNext(Body next) {
        this.next = next;
    }
}
