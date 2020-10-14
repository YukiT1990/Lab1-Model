package lab1;

public class Driver {
    public static void main(String[] args) {
        Model m1 = new Model("Susan", "Smith", 70, 120, true, false);

        m1.printDetails();
        m1.displayModelDetails();

        Model m2 = new Model("Tiger", "Woods", 72, 190, true, false);

        m2.printDetails();
        m2.displayModelDetails();
    }
}
