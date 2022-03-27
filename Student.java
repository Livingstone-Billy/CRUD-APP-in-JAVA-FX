package com.example.main;

import javafx.beans.property.SimpleStringProperty;

public class Student {
    private SimpleStringProperty fieldName;
    private  SimpleStringProperty fieldValue;

    public Student(String field_name, String field_value){
        this.fieldName = new SimpleStringProperty(field_name);
        this.fieldValue = new SimpleStringProperty(field_value);
    }

    public SimpleStringProperty fieldNameProperty() {
        return fieldName;
    }

    public SimpleStringProperty fieldValueProperty() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName.get();
    }

    public String getFieldValue(){
        return fieldValue.get();
    }

    public void setFieldName(String fieldName) {
        this.fieldName.set(fieldName);
    }

    public void setFieldValue(String fieldValue){
        this.fieldValue.set(fieldValue);
    }

}