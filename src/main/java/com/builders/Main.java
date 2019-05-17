package com.builders;

public class Main {

    public static void main(String[] args) {
        MyName.Builder name = new MyName.Builder("Nagla","Werme");
        MyName myNmae = name.fatherName("Mohamed")
                .grandFatherName("ElhagHamad")
                .fatherGrandFatherName("MohamedAhmed")
                .build();

        System.out.println("My full Name is :"+myNmae);

        Address.Builder address = new Address.Builder("Östervägen",11,"Sweden");
        Address myAddress = address.province("Stockholm")
                .mailBox(16346)
                .build();
        System.out.println("My address is "+myAddress);
    }
}
