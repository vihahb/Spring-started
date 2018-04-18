package com.springstarted.started.exception;

public class ExceptionDefineRuntime extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ExceptionDefineRuntime(String resourceName, String message, String fieldName, Object fieldValue) {
        super(String.format("%s %s %s : '%s'", resourceName, message, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "ExceptionDefineRuntime{" +
                ", resourceName='" + resourceName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue=" + fieldValue +
                '}';
    }
}
