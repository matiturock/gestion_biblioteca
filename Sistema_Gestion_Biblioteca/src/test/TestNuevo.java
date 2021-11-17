package test;

import java.time.LocalDate;

public class TestNuevo {
    public static void main(String[] args) {
        // LocalDate date = null;
        // System.out.println(date);

        String str = "Nombre,null";
        String[] strArr = str.split(",");

        if (strArr[1].equals("null"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
