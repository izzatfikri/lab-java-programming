/*
Subject code : CSEB5133 / CSEB534 Java Programming
  Section      : 01A
  Student name : Muhammad Izzat Fikri Bin Zurilan
  Student ID no: SW01082295
  Question no  : 1 (ii)
 */

public class ShowErrorsii {
    public static void main(String[] args) {
        C c = new C(5);
        System.out.println(c.getValue());
    }
}

class C {
    public C (int value){
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
