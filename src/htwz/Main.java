package htwz;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        String s = "weqeqwdf123";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            System.out.println(b);
        }
        System.out.println(bytes.length);
        for (int i = 0; i < 4; i++) {
            Main.A a = new Main.A();
            a.setA(0);
            new Thread(new TicketDemo(a)).start();
        }
    }

    public static class A{
        private Integer a;

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getA() {
            return a;
        }

    }

}

class TicketDemo implements Runnable {

    private Main.A a;



    public TicketDemo(Main.A a) {
        this.a = a;
    }


    public void run() {
        int i = 0;
        while(i++ < 10) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.setA(a.getA() + 1);
        }
        System.out.println(a.getA());
    }

}
