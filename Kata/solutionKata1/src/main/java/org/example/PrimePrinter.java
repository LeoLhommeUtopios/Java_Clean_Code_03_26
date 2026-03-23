package org.example;

import com.sun.security.auth.NTNumericCredential;

public class PrimePrinter {
    public static void main(String[] args) {

		final int MAX_PRIMES = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        final int MAX_PRIME_FACTOR = 30;

        int[] primes = generatePrimes(MAX_PRIMES,MAX_PRIME_FACTOR);
        printPrimes(primes,ROWS_PER_PAGE,COLUMNS_PER_PAGE,MAX_PRIMES);
	}

    private static int[] generatePrimes (int maxPrimes,int maxPrimeFactors){
        int[] primes = new int[maxPrimes+1];
        int[] multiples = new int[maxPrimeFactors+1];
        int primeOrder = 2;
        int square = 9;
        int primeCount = 1;
        int currentNumber = 1;
        primes[1] = 2;

        while(primeCount<maxPrimes){
            currentNumber = generateNextPrime(currentNumber,primes,multiples,primeOrder,square);
            primeCount++;
            primes[primeCount]=currentNumber;
        }
        return primes;
    }


    private static int generateNextPrime(int currentNumber,int[] primes, int[] multiples,int primeOrder,int square){
        boolean isPrime;
        do{
            currentNumber += 2;
            square = updateMultiples(currentNumber,primes,multiples,primeOrder,square);
            isPrime = isPrime(primeOrder,multiples,primes,currentNumber);
        }while (!isPrime);
        return currentNumber;
    }


    private static  int updateMultiples (int currentNumber,int[] primes,int[] multiples,int primeOrder,int square){
        if( currentNumber== square) {
            primeOrder ++;
            square=primes[primeOrder]*primes[primeOrder];
            multiples[primeOrder-1]=currentNumber;
        }
        return square;
    }

    private static boolean isPrime (int primeOrder,int[] primes,int[] multiples,int currentNumber){
        boolean isPrime =true;
        int numberCandidate = 2;
        while (numberCandidate < primeOrder && isPrime) {
            while (multiples[numberCandidate]<currentNumber)
                multiples[numberCandidate] += primes[numberCandidate] + primes[numberCandidate];
            if (multiples[numberCandidate] == currentNumber)
                isPrime=false;
            numberCandidate++;
        }
        return isPrime;
    }

    private static void printHeaderPage(int pageNumber, int maxprimes){
        System.out.println("The first : "+maxprimes+" Prime Numbers === Page "+pageNumber);
        System.out.println();
    }

    private static void printPrimes(int[] primes,int rowsPerPages,int columnsPerPages,int maxPrimes) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= maxPrimes) {
            printHeaderPage(pageNumber, maxPrimes);

            for (int rowOffset = pageOffset; rowOffset <= pageOffset + rowsPerPages; rowOffset++) {
                for (int column = 0; column <= columnsPerPages; column++) {
                    int index = rowOffset + column * rowsPerPages;
                    if (index <= maxPrimes)
                        System.out.printf("%10d", primes[index]);
                    System.out.println();
                }
                pageNumber++;
                pageOffset += rowsPerPages * columnsPerPages;
            }
        }
    }
}