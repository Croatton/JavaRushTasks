package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public static void main(String[] args) {

    }

    public A getOriginalObject(ObjectInputStream objectStream) {
        Object ret = null;
        try {
            ret = objectStream.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (ret instanceof A) return (A) ret;
            else return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
