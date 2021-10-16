package com.company;

public class Calender {

    public static boolean isLeapYear(int yearToCheck) {

        boolean isLeapYear = false;

        if (Integer.toString(yearToCheck).length() == 4) {
            if ((yearToCheck % 4 == 0 && yearToCheck % 100 == 0) || yearToCheck % 4 == 0) {
                isLeapYear = true;
            } else {
                isLeapYear = false;
            }
        }
        return isLeapYear;

    }

    public static void generateCalender(String[][] days, int month, int year) {

        int daysOfMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int countOfDay = 1;
        String daysInWeek[] = {"S", "M", "T", "W", "Th", "F", "Sa"};

        int firstDay = dayOfWeek(1, month, year);
        int j = 0;

        if (isLeapYear(year)) {
            daysOfMonth[2] = 29;
        }
        for (int dayNumber = 0; dayNumber < 7; dayNumber++) {
            days[j][dayNumber] = daysInWeek[dayNumber];
        }

        for (int i = 1; i < 7; i++) {
            for (j = 0; j < 7; j++)
                if (firstDay >= countOfDay) {
                    days[i][j] = " ";
                    firstDay--;

                } else if (countOfDay <= daysOfMonth[month]) {
                    days[i][j] = String.valueOf(countOfDay);
                    countOfDay++;
                } else {
                    days[i][j] = " ";
                }
        }
    }

    public static void displayCalender(String[][] days, int month, int year) {

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        System.out.println(months[month - 1] + "\t" + year);

        for (int rowIndex = 0; rowIndex < 7; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 7; columnIndex++) {
                System.out.print(days[rowIndex][columnIndex] + "\t");
            }
            System.out.println();
        }
    }

    public static int dayOfWeek(int day, int month, int year) {

        int day0, month0, year0, x;

        year0 = year - (14 - month) / month;
        x = year0 + year0 / 4 - year0 / 100 + year0 / 400;
        month0 = month + 12 * ((14 - month) / 12) - 2;
        day0 = (day + x + 31 * month0 / 12) % 7;

        return day0;
    }

    public static void main(String[] args) {

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        String days[][] = new String[7][7];
        generateCalender(days, month, year);
        displayCalender(days, month, year);
    }

}


