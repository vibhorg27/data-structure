package com.bridgelabz.datastructures.stackandqueue;

class CircularTourGreedy {
    public static int findStartingPoint(int[] fuel, int[] distance) {
        int total = 0;
        int current = 0;
        int start = 0;

        for (int i = 0; i < fuel.length; i++) {
            int netFuel = fuel[i] - distance[i];
            total += netFuel;
            current += netFuel;

            // If surplus becomes negative, reset startIndex
            if (current < 0) {
                start = i + 1;
                current = 0; // Reset for the next potential start
            }
        }

        // If totalSurplus is negative, no valid start exists
        return (total >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] fuel = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int ans = findStartingPoint(fuel, distance);
        System.out.println("Start from petrol pump index: " + ans);
    }
}

