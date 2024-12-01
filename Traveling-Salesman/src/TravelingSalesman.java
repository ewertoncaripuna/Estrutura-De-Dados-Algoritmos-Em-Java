import java.util.ArrayList;
import java.util.List;

    public class TravelingSalesman {

        private static int calculateDistance(int[][] distanceMatrix, List<Integer> route) {
            int totalDistance = 0;
            for (int i = 0; i < route.size() - 1; i++) {
                totalDistance += distanceMatrix[route.get(i)][route.get(i + 1)];
            }
            totalDistance += distanceMatrix[route.get(route.size() - 1)][route.get(0)];
            return totalDistance;
        }

        public static void tspBruteForce(int[][] distanceMatrix) {
            int n = distanceMatrix.length;
            List<Integer> cities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cities.add(i);
            }

            List<Integer> bestRoute = null;
            int shortestDistance = Integer.MAX_VALUE;

            do {
                int currentDistance = calculateDistance(distanceMatrix, cities);
                if (currentDistance < shortestDistance) {
                    shortestDistance = currentDistance;
                    bestRoute = new ArrayList<>(cities);
                }
            } while (Collections.nextPermutation(cities));

            System.out.println("Best route: " + bestRoute);
            System.out.println("Shortest distance: " + shortestDistance);
        }

        public static void main(String[] args) {
            int[][] distanceMatrix = {
                    {0, 10, 15, 20},
                    {10, 0, 35, 25},
                    {15, 35, 0, 30},
                    {20, 25, 30, 0}
            };

            tspBruteForce(distanceMatrix);
        }
    }


