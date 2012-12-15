package com.github.signed.pockuito;

public class SimpleBuilder {
    private String detail;

    public SimpleBuilder collectDetail(String detail){
        this.detail = detail;
        return this;
    }

    public ObjectUnderConstruction build(){
        return new ObjectUnderConstruction(detail);
    }
}
