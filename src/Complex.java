public class Complex {

    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }


    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * Ta reda på talets absolutbelopp i kvadrat
     */
    public double getAbs2() {
        return Math.pow(Math.hypot(re, im), 2);
    }

    /**
     * Adderar det komplexa talet c till detta tal
     */
    public void add(Complex c) {
        re += c.getRe();
        im += c.getIm();
    }

    /**
     * Multiplicerar detta tal med det komplexa talet c
     */
    public void mul(Complex c) {
        re = re * c.getRe() - im * c.getIm();
        im = re * c.getIm() + im * c.getRe();
    }

    public void print() {
        System.out.println(re + " + " + im + "i");
    }

}
