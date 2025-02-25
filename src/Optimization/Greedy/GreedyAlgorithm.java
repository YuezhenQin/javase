package Optimization.Greedy;

import java.util.Arrays;

public class GreedyAlgorithm {
    //Solution2126. Destroying asteroids
    public boolean canBeDestroyed(int mass, int[] asteroids) {
        long newMass = mass;
        Arrays.sort(asteroids); // choosing the smallest remaining asteroid at every step
        for (int asteroid: asteroids) {
            if (newMass >= asteroid) {
                newMass += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }
}
