package com.company;

public class PrimeNumbersIn2DArray {

    public static boolean checkIfPrime(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[][] findPrimesInRange(int[][] arrayOfPrimes) {

        arrayOfPrimes = new int[10][100];
        int numberToCheck = 2;
        int columnIndexOfArray = 0;

        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 100 && numberToCheck < ((rowIndex + 1) * 100); columnIndex++) {
                if (checkIfPrime(numberToCheck)) {
                    arrayOfPrimes[rowIndex][columnIndexOfArray] = numberToCheck;
                    columnIndexOfArray++;
                }
                numberToCheck++;
            }
            columnIndexOfArray = 0;
        }

        return arrayOfPrimes;
    }

    public static void main(String[] args) {

        int twoDArrayOfPrimes[][] = {};
        twoDArrayOfPrimes = findPrimesInRange(twoDArrayOfPrimes);

        for (int rowIndex = 0; rowIndex < twoDArrayOfPrimes.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < twoDArrayOfPrimes[rowIndex].length; columnIndex++) {
                if (twoDArrayOfPrimes[rowIndex][columnIndex] != 0) {
                    System.out.print(twoDArrayOfPrimes[rowIndex][columnIndex] + " ");
                }
            }
            System.out.println();
        }
    }

}

