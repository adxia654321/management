package com.practise.utils;



public class CurrentHolder { // no usages

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>(); // 3 usages

    public static void setCurrentId(Integer employeeId) { // no usages

        CURRENT_LOCAL.set(employeeId);
    }

    public static Integer getCurrentId() { // no usages

        return CURRENT_LOCAL.get();
    }

    public static void remove() { // no usages

        CURRENT_LOCAL.remove();
    }

}