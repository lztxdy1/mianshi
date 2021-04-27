package test;

public class AutouNBoxingTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;      //3将自动装箱成integer类型
        int c = 3;
        System.out.println(a == b);   //false  a和b没有引用同一个对象
        System.out.println(a == c);   //true   a自动拆箱成int类型再和c比较

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


        System.out.println("--------------------------------");
        Integer a1 = new Integer(40);
        Integer b1 = new Integer(40);

        Integer a2 = 40;
        Integer b2 = 40;
        System.out.println(a1 == b1);
        System.out.println(a2 == b2);
        System.out.println(a2 == b1);
    }
}
