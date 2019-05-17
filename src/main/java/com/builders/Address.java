package com.builders;

public class Address {

    private final String street1;
    private final int no;
    private final String street2;
    private final String province;
    private final String country;
    private final int mailBox;

    public static class Builder{
        private String street1;
        private int no;
        private String street2 = "";
        private String province = "";
        private String country;
        private int mailBox = 0;

        public Builder(String street1,int no,String country){
            this.street1 = street1;
            this.no= no;
            this.country = country;
        }

        public Builder street2(String street2){
            this.street2 = street2;
            return this;
        }

        public Builder province(String province){
            this.province = province;
            return this;
        }

        public Builder mailBox(int mailBox){
            this.mailBox = mailBox;
            return this;
        }

        public Address build(){

            return new Address(this);
        }
    }
        private Address(Builder builder){
            this.street1 = builder.street1;
            this.no = builder.no;
            this.street2 = builder.street2;
            this.province = builder.province;
            this.mailBox = builder.mailBox;
            this.country = builder.country;

    }

    @Override
    public String toString(){
        return "Street1 "+this.street1
                + " No "+this.no
                + " Street2 : "+ this.street2
                + " MailBox : "+this.mailBox
                + " Province : "+this.province
                + " Country : "+this.country;
    }

}
