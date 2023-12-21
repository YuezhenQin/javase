package JVM;

import org.openjdk.jol.info.ClassLayout;


public class TestObject {
    public static void main(String[] args) {
        //一个空实例占据的内存空间大小: header(12)+body(0)+autofill(4)=16
        Object obj = new Object();
        System.out.println("New object:" + ClassLayout.parseInstance(obj).toPrintable());

        Hero hero = new Hero();
        System.out.println("New hero:" + ClassLayout.parseInstance(hero).toPrintable());
        hero.setInt(1);
        System.out.println("After assignment:" + ClassLayout.parseInstance(hero).toPrintable());
    }


    static class Hero {
        private boolean flag;
        private byte b;
        private short s;
        private int i;
        private long l;
        private float f;
        private double d;

        private String str;

        public void setInt(int i) {
            this.i = i;
        }
    }
}

