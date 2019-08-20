/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algocom_pe_test.algocom_p4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Gung Ho
 */
public class P4_Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] input = {"4 5", "4 5 3 5", "3 5 2 6 4"};
        String[] input2 = {"6 7", "7 2 1 8 2 3", "9 11 2 1 3 4 8"};
        String[] input3 = {"2 3", "2 2", "6 5 4"};
        P4_Program.assignTable(input3);
        int[] time = {1, 2, 3};
        int[] fine = {1, 2, 3};
        int[] time2 = {3, 1, 2, 5};
        int[] fine2 = {4, 1000, 2, 5};
        P4_Program.shoemaker(time2, fine2);
        int[] floors = {5, 7, -2, 6, 9, -3};
        int[] floors2 = {8, 11, -9, 2, 5, 18, 17, -15, 4};
        P4_Program.design(floors2);
    }

    public static void assignTable(String[] input) {
        List<Team> teams;
        List<Table> tables;
        int trueOrFalse = 1;
        String[] secondInput = input[1].split(" ");
        String[] thirdInput = input[2].split(" ");
        int secondInputSize = secondInput.length;
        int thirdInputSize = thirdInput.length;
        int[] teamSizes = new int[secondInputSize];
        int[] tableCapacities = new int[thirdInputSize];
        teams = new ArrayList<>();
        tables = new ArrayList<>();
        for (int i = 0; i < secondInputSize; i++) {
            teamSizes[i] = Integer.parseInt(secondInput[i]);
        }
        for (int i = 0; i < thirdInputSize; i++) {
            tableCapacities[i] = Integer.parseInt(thirdInput[i]);
        }
        for (int i = 0; i < teamSizes.length; i++) {
            Team team = new Team();
            team.setName(i + 1);
            team.setSize(teamSizes[i]);
            teams.add(team);
        }
        for (int i = 0; i < tableCapacities.length; i++) {
            Table table = new Table();
            table.setIndex(i + 1);
            table.setCapacity(tableCapacities[i]);
            tables.add(table);
        }
        Collections.sort(tables, Table.capacityComparator);
        for (Team team : teams) {
            if (team.getSize() <= tables.size()) {
                int index = 0;
                while (team.getSize() > 0 && index < tables.size()) {
                    Table table = tables.get(index);
                    if (table.getCapacity() > 0) {
                        team.addTable(table.getIndex());
                        team.setSize(team.getSize() - 1);
                        table.setCapacity(table.getCapacity() - 1);
                    }
                    index++;
                }
            } else {
                trueOrFalse = 0;
                break;
            }
        }
        for (Team team : teams) {
            if (team.getSize() != 0) {
                trueOrFalse = 0;
                break;
            }
        }
        System.out.println(trueOrFalse);
        if (trueOrFalse == 1) {
            teams.forEach((team) -> {
                team.getAssignedTable().forEach((i) -> {
                    System.out.print(i + " ");
                });
                System.out.println("");
            });
        }
    }

    public static void shoemaker(int[] jobTime, int[] fine) {
        int[][] tempArray = new int[jobTime.length][];
        int temp;
        for (int i = 0; i < jobTime.length; i++) {
            temp = jobTime[i];
            tempArray[i] = new int[]{1 * fine[i] / temp, i + 1};
        }
        Arrays.sort(tempArray, (int[] first, int[] second) -> {
            if (first[0] != second[0]) {
                return second[0] < first[0] ? -1 : 1;
            }
            return (first[1] + "").compareTo(second[1] + "");
        });
        for (int i = 0; i < jobTime.length; i++) {
            System.out.print((int) tempArray[i][1] + (i < jobTime.length - 1 ? " " : ""));
        }
        System.out.println("");
    }

    public static void design(int[] floors) {
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();

        for (int floor : floors) {
            if (floor < 0) {
                red.add(floor);
            } else {
                blue.add(floor);
            }
        }
        Collections.sort(blue, Collections.reverseOrder());
        Collections.sort(red);
        if (blue.get(0) > Math.abs(red.get(0))) {
            createDesign(blue, red);
        } else {
            createDesign(red, blue);
        }

    }

    private static void createDesign(List<Integer> a, List<Integer> b) {
        List<Integer> building = new ArrayList<>();
        building.add(a.get(0));
        int min = Math.abs(a.get(0));
        boolean alternate = true;
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (alternate) {
                if (min > Math.abs(b.get(j))) {
                    min = Math.abs(b.get(j));
                    building.add(b.get(j));
                    alternate = !alternate;
                    i++;
                } else {
                    j++;
                }
            } else {
                if (min > Math.abs(a.get(i))) {
                    min = Math.abs(a.get(i));
                    building.add(a.get(i));
                    alternate = !alternate;
                    j++;
                } else {
                    i++;
                }
            }
        }
        System.out.println(building.size());
    }

    private static class Table {

        private int index;
        private int capacity;

        public Table() {
        }

        private static Comparator<Table> capacityComparator = (Table t1, Table t2) -> (t2.getCapacity() < t1.getCapacity() ? -1 : (t2.getCapacity() == t1.getCapacity() ? 0 : 1)) // TODO Auto-generated method stub
                ;

        /**
         * @return the name
         */
        public int getIndex() {
            return index;
        }

        /**
         * @param name the name to set
         */
        public void setIndex(int name) {
            this.index = name;
        }

        /**
         * @return the capacity
         */
        public int getCapacity() {
            return capacity;
        }

        /**
         * @param capacity the capacity to set
         */
        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        /**
         * @return the capacityComparator
         */
    }

    private static class Team {

        private int name;
        private int size;
        private List<Integer> assignedTable = new ArrayList<>();

        public Team() {
            assignedTable = new ArrayList<>();
        }

        public void addTable(int tableName) {
            this.getAssignedTable().add(tableName);
        }

        public static void printElements(List<Team> teams) {
            teams.forEach((t) -> {
                System.out.print("Team " + t.getName() + ": " + t.getSize() + " ");
            });
            System.out.println();
        }

        /**
         * @return the name
         */
        public int getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(int name) {
            this.name = name;
        }

        /**
         * @return the size
         */
        public int getSize() {
            return size;
        }

        /**
         * @param size the size to set
         */
        public void setSize(int size) {
            this.size = size;
        }

        /**
         * @return the tableAssigned
         */
        public List<Integer> getAssignedTable() {
            return assignedTable;
        }

        /**
         * @param tableAssigned the tableAssigned to set
         */
        public void setAssignedTable(List<Integer> tableAssigned) {
            this.assignedTable = tableAssigned;
        }
    }
}
