package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]){
            case "-c" : synchronized (allPeople){
                create(args);}
                break;
            case "-d": synchronized (allPeople){
                delete(args);}
                break;
            case "-i" : synchronized (allPeople){
                show(args);}
                break;
            case "-u" : synchronized (allPeople){
                update(args);}
                break;
        }
    }
    public static void create(String[] args) throws ParseException {
        if ((args.length - 1) % 3 != 0) return;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i = i + 3)
        {
            if ((args[i+1].equals("м"))) { allPeople.add(Person.createMale(args[i], format.parse(args[i+2]))); System.out.println(allPeople.size() - 1);}
            if ((args[i+1].equals("ж"))) { allPeople.add(Person.createFemale(args[i], format.parse(args[i+2]))); System.out.println(allPeople.size() - 1);}
        }
    }
    public static void delete(String[] args){
        for (int i = 1;i < args.length;i++){
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
        }
    }
    public static void show (String[] args){
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sexy= "";
        for (int i = 1; i < args.length; i++)
        {
            if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE) {sexy = "м";}
            if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.FEMALE) {sexy = "ж";}
            System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " + sexy + " " + format.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
        }
    }
    public static void update(String[] args) throws ParseException {
        if ((args.length - 1) % 4 != 0) return;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Sex sex = null;
        for (int i = 1; i < args.length; i = i + 4)
        {
            if ((args[i+2].equals("м"))) {sex = Sex.MALE;}
            if ((args[i+2].equals("ж"))) {sex = Sex.FEMALE;}
            allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
            allPeople.get(Integer.parseInt(args[i])).setSex(sex);
            allPeople.get(Integer.parseInt(args[i])).setBirthDay(format.parse(args[i+3]));
        }
    }
}
