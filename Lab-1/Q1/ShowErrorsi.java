/*
Subject code : CSEB5133 / CSEB534 Java Programming
  Section      : 01A
  Student name : Muhammad Izzat Fikri Bin Zurilan
  Student ID no: SW01082295
  Question no  : 1 (i)
 */

public class ShowErrorsi {
    public static void main(String[] args) {
        C c = new C(5);
    }
}

class C {
    public C (int value){
        this.value = value;
        System.out.println(value);
    }
    private int value;
}


