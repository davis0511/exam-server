package com.augmentum.exam.exception;

import java.util.HashMap;
import java.util.Map;

public class ParamException extends Exception {

    private static final long serialVersionUID = 1L;
    Map<String, String> errorFileds = new HashMap<String, String>();

    public Map<String, String> getErrorFileds() {
        return errorFileds;
    }
    public void addErrorFiled(String filedName, String message) {
        errorFileds.put(filedName, message);
    }
    public boolean isErrorFiled() {
        return !errorFileds.isEmpty();
    }
}
