package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        ArrayList<Integer> list = new ArrayList<>();
        list.add( Integer.parseInt( reader.readLine() ) );
        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1; i < 10; i++)
        {
            list.add( Integer.parseInt( reader.readLine() ) );

            if ( list.get(i - 1).equals( list.get(i) ) )
            {
                currentStreak++;
                if (currentStreak > longestStreak)
                {
                    longestStreak = currentStreak;
                }
            } else
            {
                currentStreak = 1;
            }
        }
        System.out.println(longestStreak);
    }
}
