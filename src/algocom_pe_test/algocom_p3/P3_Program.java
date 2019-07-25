/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algocom_pe_test.algocom_p3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Antoine Salcedo
 */
public class P3_Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Building[] B = new Building[8];
        B[0] = new Building(1, 11, 5);
        B[1] = new Building(2, 6, 7);
        B[2] = new Building(3, 13, 9);
        B[3] = new Building(12, 7, 16);
        B[4] = new Building(14, 3, 25);
        B[5] = new Building(19, 18, 22);
        B[6] = new Building(23, 13, 29);
        B[7] = new Building(24, 4, 28);
        skyline(B);

        int[] A = {7, 8, 9, 4, 3, 2, 1};
        mergesort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println("");
        Pt[] p = new Pt[5];
        p[0] = new Pt(0,0);
        p[1] = new Pt(0,1);
        p[2] = new Pt(100,45);
        p[3] = new Pt(2,3);
        p[4] = new Pt(9,9);
        closestPair(p);
    }

    public static class Building {

        public int left;  //the left X-coordinate
        public int right; //the right X-coordinate
        public int height; //the height

        public Building(int left, int height, int right) {
            this.height = height;
            this.left = left;
            this.right = right;
        }

		public Building() {
			// TODO Auto-generated constructor stub
		}
    }

    private static class SkylinePoint {

        public SkylinePoint(int left, int height) {
            this.x = left;
            this.y = height;
        }

        public SkylinePoint() {
        }

        public int x;
        public int y;

    }

    public static void skyline(Building[] B) {
        List<SkylinePoint> skylinePoints;

        skylinePoints = getSkylines(B, 0, B.length - 1);

        skylinePoints.forEach((sp) -> {
            System.out.print(sp.x + " " + sp.y + " ");
        });
        System.out.println();
    }

    private static List<SkylinePoint> getSkylines(Building[] B, int lhs, int rhs) {

        List<SkylinePoint> skyLinePointList = new ArrayList<>();
        if (lhs < rhs) {
            int mid = (lhs + rhs) / 2;
            List<SkylinePoint> leftSkylinePointList = getSkylines(B, lhs, mid);
            List<SkylinePoint> rightSkylinePointList = getSkylines(B, mid + 1, rhs);
            return mergeSkylines(leftSkylinePointList, rightSkylinePointList);
        } //divide single building into 2 skyline point (1 building has 2 skyline point)
        else if (lhs == rhs) {
            SkylinePoint s1 = new SkylinePoint(B[lhs].left, B[lhs].height);
            SkylinePoint s2 = new SkylinePoint(B[lhs].right, 0);
            skyLinePointList.add(s1);
            skyLinePointList.add(s2);
        }

        return skyLinePointList;
    }

    private static List<SkylinePoint> mergeSkylines(List<SkylinePoint> leftSkylinePointList,
            List<SkylinePoint> rightSkylinePointList) {

        List<SkylinePoint> mergedSkylinePoints = new ArrayList<>();
        int leftHeight = 0; //
        int rightHeight = 0;
        int n = leftSkylinePointList.size();
        int m = rightSkylinePointList.size();

        int i = 0; //index of left skyline points
        int j = 0; //index of right skyline points 

        //left and right hand side of the list of skyline points are not empty.
        while (i < n && j < m) {
            SkylinePoint newSkylinePoint = new SkylinePoint();

            //compare the left x coordinate strip of a building between the leftskylinePoint and rightSkylinePoint
            if (leftSkylinePointList.get(i).x < rightSkylinePointList.get(j).x) {

                newSkylinePoint.x = leftSkylinePointList.get(i).x;
                leftHeight = leftSkylinePointList.get(i).y;
                newSkylinePoint.y = Math.max(leftHeight, rightHeight);
                i++;
            } else {
                newSkylinePoint.x = rightSkylinePointList.get(j).x;
                rightHeight = rightSkylinePointList.get(j).y;
                newSkylinePoint.y = Math.max(leftHeight, rightHeight);
                j++;
            }

            addNewSkylinePoint(mergedSkylinePoints, newSkylinePoint);
        }

        //add remaining strips that were not used.
        while (i < n) {
            mergedSkylinePoints.add(leftSkylinePointList.get(i));
            i++;
        }

        while (j < m) {
            mergedSkylinePoints.add(rightSkylinePointList.get(j));
            j++;
        }

        return mergedSkylinePoints;
    }

    //check previous element and dont add unecessary skyline points (when new x or height is same as the recently added skyline point's x or height.)
    private static void addNewSkylinePoint(List<SkylinePoint> mergedSkylinePoints,
            SkylinePoint newSkylinePoint) {
        int n = mergedSkylinePoints.size();

        if (n > 0) {
            if (mergedSkylinePoints.get(n - 1).y == newSkylinePoint.y) {
                return;
            } else if (mergedSkylinePoints.get(n - 1).x == newSkylinePoint.x) {
                mergedSkylinePoints.get(n - 1).y = Math.max(mergedSkylinePoints.get(n - 1).y, newSkylinePoint.y);
                return;
            }
        }
        //safetly add new skyline point.
        mergedSkylinePoints.add(newSkylinePoint);
    }

    public static void mergesort(int[] A) {
        if (A == null) {
            return;
        }

        if (A.length > 1) {
            int mid = A.length / 2;

            // Split left part 
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = A[i];
            }

            // Split right part 
            int[] right = new int[A.length - mid];
            for (int i = mid; i < A.length; i++) {
                right[i - mid] = A[i];
            }
            mergesort(left);
            mergesort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays 
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements 
            while (i < left.length) {
                A[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                A[k] = right[j];
                j++;
                k++;
            }
        }
    }

    public static class Pt {

        public int x;  //X-coordinate
        public int y; // Y-coordinate

        public Pt(int x, int y) {
            this.x = x;
            this.y = y;
        }

		public Pt() {
			// TODO Auto-generated constructor stub
		}
    }

    private static class Point {

        private int x;
        private int y;
        public static Comparator<Point> xComparator = (Point p1, Point p2) -> (p1.getX() < p2.getX() ? -1 : (p1.getX() == p2.getX() ? 0 : 1));
        public static Comparator<Point> yComparator = (Point p1, Point p2) -> (p1.getY() < p2.getY() ? -1 : (p1.getY() == p2.getY() ? 0 : 1));

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void closestPair(Pt[] P) {

        List<Point> pointX = new ArrayList<>(); //Points sorted in x.
        List<Point> pointY = new ArrayList<>(); //Points sorted in y.
        for (Pt P1 : P) {
            Point p = new Point();
            p.setX(P1.x);
            p.setY(P1.y);
            pointX.add(p);
            pointY.add(p);
        }

        Collections.sort(pointX, Point.xComparator);
        Collections.sort(pointY, Point.yComparator);
        double distance = findClosestPair(pointX, pointY, P.length - 1);
        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.println("Smallest distance: " + df.format(distance));
        
    }

    private static double findClosestPair(List<Point> pointX, List<Point> pointY, int size) {

        if (size <= 3) {
            return doBruteForce(pointX, size);
        }

        int mid = size / 2;
        Point midPoint = pointX.get(mid);

        List<Point> PYL = new ArrayList<>();
        List<Point> PYR = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            if (pointY.get(i).getX() <= midPoint.getX()) {
                PYL.add(pointY.get(i));
            } else {
                PYR.add(pointY.get(i));
            }

        }

        double distanceLeft = findClosestPair(pointX, PYL, mid);
        double distanceRight = findClosestPair(pointX, PYL, mid);

        //Find the smallest distance between the left and right.
        double distance = Math.min(distanceLeft, distanceRight);

        //Optimized combined step
        List<Point> rectangle;
        rectangle = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            //If true, there's a case of Delta(SL,SR)
            if (Math.abs(pointY.get(i).getX() - midPoint.x) < distance) {
                rectangle.add(pointY.get(i));
            }

        }

        //
        return Math.min(distance, rectangleClosest(rectangle, distance));
    }

    private static double rectangleClosest(List<Point> rectangle, double distance) {

        int size = rectangle.size();
        double min = distance;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                double smallestDistance = calculateDistance(rectangle.get(j), rectangle.get(i));

                if (smallestDistance < min) {
                    min = smallestDistance;
                }

                if (rectangle.get(j).getY() - rectangle.get(i).getY() < min) {
                    break;
                }
            }
        }

        return min;
    }

    private static double doBruteForce(List<Point> pointX, int size) {

        double min = Double.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                double smallestDistance = calculateDistance(pointX.get(i), pointX.get(j));
                if (smallestDistance < min) {
                    min = smallestDistance;
                }
            }
        }

        return min;
    }

    //Euclidean Distance formula
    private static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
                + (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
    }

}
