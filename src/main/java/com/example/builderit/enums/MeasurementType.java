package com.example.builderit.enums;

public enum MeasurementType {
  m2("m2"),kg("kg"),tn("ton"),l("litre"),m("meter"),unit("unit"),m3("m3"), oneHundredSquareMeters("100m2");
  private String code;
  MeasurementType(String code){
    this.code=code;
  }

  public String getCode(){
    return code;
  }

}
