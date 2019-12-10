public class ComplexTest {
    public static void main(String[] args) {
        Complex complex =  new Complex(2.3, 3.5);
        complex.print();
        System.out.println("+");
        System.out.println("1 + i");
        complex.add(new Complex(1, 1));
        System.out.println("=");
        complex.print();
        System.out.println();
        Complex complex1 = new Complex(2, 2);
        System.out.println("Absolutbelopp = " + complex1.getAbs2());
        complex1.print();
        System.out.println("*");
        System.out.println("2.1 - 2.2i");
        complex1.mul(new Complex(2.1, -2.2));
        System.out.println("=");
        complex1.print();

    }
}
