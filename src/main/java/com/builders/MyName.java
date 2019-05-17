package com.builders;

public class MyName {

    private final String firstName;
    private final String fatherName;
    private final String grandFatherName;
    private final String fatherGrandFatherName;
    private final  String marriageName;

    public static class Builder{

        private final String firstName;
        private  String fatherName = "";
        private  String grandFatherName="";
        private  String fatherGrandFatherName="";
        private final   String marriageName;

        public Builder(String firstName,String marriageName){
            this.firstName = firstName;
            this.marriageName = marriageName;
        }

        public Builder fatherName(String fatherName){
            this.fatherName= fatherName;
            return this;
        }

        public Builder grandFatherName(String grandFatherName){
            this.grandFatherName = grandFatherName;
            return this;
        }

        public Builder fatherGrandFatherName(String fatherGrandFatherNAme){
            this.fatherGrandFatherName = fatherGrandFatherNAme;
            return this;
        }

        public MyName build(){

           return new MyName(this);
        }
    }

    private MyName(Builder builder){

        this.firstName = builder.firstName;
        this.fatherName = builder.fatherName;
        this.grandFatherName = builder.grandFatherName;
        this.fatherGrandFatherName = builder.fatherGrandFatherName;
        this.marriageName = builder.marriageName;
    }

    @Override
    public String toString() {
        return this.firstName
                +" "
                +this.fatherName
                +" "
                +this.grandFatherName
                +" "
                +this.fatherGrandFatherName
                +" "
                +this.marriageName;
    }
}
