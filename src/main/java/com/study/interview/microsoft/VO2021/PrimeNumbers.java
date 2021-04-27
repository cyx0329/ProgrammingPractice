package com.study.interview.microsoft.VO2021;

public class PrimeNumbers {
    // Check for number prime or not
    static boolean isPrime(int n)
    {

        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

        //Every even integer greater than 2 can be expressed as the sum of two primes.
            //Two is the only even Prime number.
            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // Any odd integer greater than 5 can be expressed as a sum of an odd prime (all primes other than 2 are odd)
        // and an even semiprime. A semiprime number is a product of two prime numbers.
        // This is called Lemoine’s conjecture.
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args)
    {
        if (isPrime(19))
            System.out.println("true");

        else
            System.out.println("false");
    }

    /*
    How we check whether a number is Prime or not?

Naive solution.
A naive solution is to iterate through all numbers from 2 to n-1 and for every number check if it divides n. If we find any number that divides, we return false.

     */
}
