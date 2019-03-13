package com.designpatterns;

public class LunchOrder {

    private final String bread;
    private final String condiment;
    private final String dressing;
    private final String meat;

    private LunchOrder(Builder builder){

        this.bread = builder.bread;
        this.condiment= builder.condiment;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiment() {
        return condiment;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    public static class Builder{
        private String bread;
        private String dressing;
        private String condiment;
        private String meat;

        public Builder(){

        }

        public LunchOrder build(){
            return new LunchOrder(this);
        }

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }

        public Builder condiment(String condiment){
            this.condiment = condiment;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing = dressing;
            return this;
        }
        public Builder meat(String meat){
            this.meat = meat;
            return this;
        }
    }
}
