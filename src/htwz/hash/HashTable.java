package htwz.hash;

import java.util.Scanner;

/**
* @author: wy
* @createDate: 2020/3/19/019 21:31
* @descption 模拟hash表
* @version: 1.0.0
*/
public class HashTable {

    public static void main(String[] args) {
        Hash hash = new Hash();
        String key;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");
            System.out.println("findById:查找雇员");
            key = scanner.next();
            switch (key) {
                case "add":
                System.out.println("输入id");
                int id = scanner.nextInt();
                System.out.println("输入名字");
                String name = scanner.next();
                Emp emp = new Emp(id, name);
                hash.add(emp);
                break;
                case "list":
                    hash.list();
                    break;
                case "findById":
                    System.out.println("请输入要查找的id");
                    int i = scanner.nextInt();
                    hash.findById(i);
                    break;
                case "exit":
                    scanner.close();
                default:
                    break;
            }
        }
    }
}


class Hash {

    private EmpLinkList[] empLinkLists;

    private int size;

    public Hash() {
        this(3);
    }

    public Hash(int size) {
        empLinkLists = new EmpLinkList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkLists[i] = new EmpLinkList();
        }
    }

    public void add(Emp emp) {
        int empNo = hashFun(emp.id);
        empLinkLists[empNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkLists[i].list();
        }
    }

    public void findById(int id) {
        int index = hashFun(id);
        empLinkLists[index].findById(id);
    }

    /**
     * 编写散列函数,取摸
     */
    public int hashFun(int id) {
        return id%size;
    }


}

class Emp {

    public int id;

    public String name;

    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


}

class EmpLinkList {

    //头指针
    private Emp head;

    /**
     * 添加时，id自增
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp.next = curEmp;
        }
        curEmp.next = curEmp;
    }

    public void list() {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }

    public void findById(int id) {
        if (head == null) {
            System.out.println("链表为空");
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                System.out.println("找到该元素");
            }
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
    }
}
