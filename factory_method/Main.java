package factory_method;
import factory_method.framework.*;
import factory_method.idcard.*;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("本田");
        Product card2 = factory.create("小林");
        Product card3 = factory.create("永野");
        card1.use();
        card2.use();
        card3.use();
    }
}
