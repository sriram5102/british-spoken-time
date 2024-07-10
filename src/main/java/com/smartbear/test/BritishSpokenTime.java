package com.smartbear.test;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class BritishSpokenTime {
    final static String[] hourArray =  {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve"};

    final static String[] minuteArray =  {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",
            "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", "thirty four"};

    public static void main(String[] args) {
        if(args.length==0) {
            System.err.println("Please enter proper time format");
            System.exit(1);
        }
        try {
            String result = convertTimeToBST(args[0]);
            System.out.println(result);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     public static String convertTimeToBST(String time) throws Exception{
        int[] timeInHourMinute = getTimeInHourAndMinute(time);
        int hour = timeInHourMinute[0];
        int minute = timeInHourMinute[1];
         if("12:00".equalsIgnoreCase(time))
             return "noon";
         else if("00:00".equalsIgnoreCase(time))
             return "midnight";
         else if(minute == 0)
            return String.format("%s o'clock",hourArray[hour]);
         else if(minute == 15)
             return String.format("quarter past %s",hourArray[hour]);
         else if(minute == 30)
            return String.format("half past %s",hourArray[hour]);
         else if(minute == 45)
            return String.format("quarter to %s",hourArray[hour+1]);
         else if(minute>=1 && minute<=25)
            return String.format("%s past %s",minuteArray[minute], hourArray[hour]);
         else if(minute>=26 && minute<=34)
             return String.format("%s %s",hourArray[hour], minuteArray[minute]);
         else if(minute>=35 && minute<=59)
             return String.format("%s to %s",minuteArray[60-minute], hourArray[hour+1]);
         else
             throw new Exception("Invalid Date Time Format");
     }
     public static int[] getTimeInHourAndMinute(String time) throws Exception {
        try{
            int[] hourAndMinuteArray = new int[2];
            LocalTime givenTime =LocalTime.parse(time);
            hourAndMinuteArray[0] =  givenTime.getHour();
            hourAndMinuteArray[1] = givenTime.getMinute();
            if(hourAndMinuteArray[0]>12) {
                throw new Exception("Invalid Time Format.");
            } else if (hourAndMinuteArray[0]==12 && hourAndMinuteArray[1]>0) {
                throw new Exception("Invalid Time Format.");
            }
            return hourAndMinuteArray;
        } catch (DateTimeParseException|NullPointerException e) {
            throw new Exception("Invalid Time Format.");
        }
     }
}
