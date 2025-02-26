/*
Subject code : CSEB5133 / CSEB534 Java Programming
  Section      : 01A
  Student name : Muhammad Izzat Fikri Bin Zurilan
  Student ID no: SW01082295
  Question no  : 1 (iii)
 */

public class ShowErrorsiii {
    public static void main(String[] args) {
        C c = new C();
        c.setValue(5);
        System.out.println(c.getValue());
    }
}

class C {

    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
