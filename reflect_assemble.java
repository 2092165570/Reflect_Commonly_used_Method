package com.yijianwan.vital;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect_assemble {

    // 调用类的方法  Call Method
    public static void nun1(String Packet_Class_route , String Method_Name) {
        try {
            Class<?> cls = Class.forName(Packet_Class_route); // 加载类  Loading Class
            try {
                Object obj = cls.newInstance();  // 实例对象  Instance Object
                try {
                    Method method = cls.getMethod("Main");  // Passed in method name
                    method.setAccessible(true); // 取消调用时检测 加快运行效率  Cancel reflection detection _ run faster
                    try {
                        method.invoke(obj);  // 调用方法  Call Method
                    } catch (IllegalAccessException e) {

                    } catch (IllegalArgumentException e) {

                    } catch (InvocationTargetException e) {}
                } catch (NoSuchMethodException e) {

                } catch (SecurityException e) {

                }
            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {

            }

        } catch (ClassNotFoundException e) {

        }
    }

    // 提取变量值  Extracting variable values
    public static Object nun2(String Packet_Class_route , String Variable_Name) {
        try {
            Class<?> cls = Class.forName(Packet_Class_route);// 加载类  Loading Class
            try {
                Object obj = cls.newInstance();// 实例对象  Instance Object
                try {
                    Field field = cls.getField(Variable_Name);//传入变量名  Passed in variable name
                    return field.get(obj);  // 得到变量值  Obtain the value of a variable
                } catch (NoSuchFieldException e) {}
            } catch (InstantiationException e) {
                
            } catch (IllegalAccessException e) {
                
            }
        } catch (ClassNotFoundException e) {
            
        }
        return null;
    }

    // 设置变量值  Set Variable Value
    public static void nun3(String Packet_Class_route , String Variable_Name , String SetVal) {
        try {
            Class<?> cls = Class.forName(Packet_Class_route);// 加载类  Loading Class
            try {
                Object obj = cls.newInstance();// 实例对象   Instance Object
                try {
                    Field field = cls.getField(Variable_Name); // 传入变量名  Passed in variable name
                    field.set(obj , SetVal); // 设置变量值   Set Variable Value
                } catch (NoSuchFieldException e) {

                }
            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {

            }
        } catch (ClassNotFoundException e) {

        }
    }
}
