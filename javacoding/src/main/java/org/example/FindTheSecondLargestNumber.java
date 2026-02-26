package org.example;

public class FindTheSecondLargestNumber {
    public static void main(String[] args) {
        System.out.println(secondhighest(new int[]{15, 24, 1, 4, 65}));
    }

    public static Integer secondhighest(int[] input) {

        if (input == null || input.length < 2) {
            return null;
        }
        Integer largest = null;
        Integer secondLargest = null;
        for (int num : input) {
            if (largest == null || num > largest) {
                if (largest != null && num != largest) {
                    secondLargest = largest;
                }
                largest = num;
            } else if (num != largest && (secondLargest == null || num > secondLargest)) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}
