package com.gl.ser;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSepration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a list of numbers separated by commas: ");
        String input = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .filter(NumberSepration::isOdd)
            .collect(Collectors.toList());

        int sumOfSquares = numbers.stream()
            .map(NumberSepration::square)
            .mapToInt(Integer::intValue)
            .sum();
        
        System.out.println("ODD NUMBERS : " + numbers);
        System.out.println("SQUARES : " + numbers.stream().map(NumberSepration::square).collect(Collectors.toList()));
        System.out.println("SUM : " + sumOfSquares);
       

        scanner.close();
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static int square(int number) {
        return number * number;
    }
}

