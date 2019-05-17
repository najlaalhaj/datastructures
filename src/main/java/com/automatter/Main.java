package com.automatter;


public class Main {
  public static void main(String[] args) {

    FullName myFullName = new FullNameBuilder()
            .firstName("Nagla")
            .fatherName("Mohamed")
            .grandFatherName("ElhagHamad")
            .fatherGrandFatherName("MohamedAhmed")
            .marriageName("Werme")
            .build();

    Address myAddress = new AddressBuilder()
            .Street("Östervägen")
            .no(11)
            .city("Spånga")
            .postCode(16346)
            .country("Sweden")
            .build();

    System.out.println("My full name is :"+ myFullName);
    System.out.println("My address is :"+myAddress);
  }
}
