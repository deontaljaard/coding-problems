package hackerrank;

public class A {
    A other;
    void fun() {
        A a =new A();
        A b = new A();
        a.other = b;
        b.other = a;
    }
}
