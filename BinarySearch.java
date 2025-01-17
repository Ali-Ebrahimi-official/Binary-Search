package com.aliebrahimi;

/*
    This is a Custom (My Very First Attempt To Implement My self-Designed) Binary-Search Program Considered for
        Ascending Arrays
*/


import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args){

        int[] ascendingArray = {
                1, 4, 16, 19, 129, 211, 345, 400, 543, 618,
                711,
                894, 901, 923, 1001, 2007, 2225, 3003, 3223, 3777
        };



        // conversion to List for using indexOf() (without having to use built in binary search)
        List<Integer> assendingArrayList = arrayList(ascendingArray);


        // =========================== Array CUSTOM Binary Search Methods Test ===============================


        // testing findByBinarySearch()
        System.out.println("\n+++++++++++++++++++++++ TESTING : findByBinarySearch() +++++++++\n");
        for (int element : ascendingArray){

            System.out.println("checked                         : "
                    + element + " in index : [" + assendingArrayList.indexOf(element) + "]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("found by : findByBinarySearch() : "
                    + element + " in index : [" + findByBinarySearch(ascendingArray, element) +"]\n"
                    + "\n=======================================================================\n");

        }


        // testing recursiveBinarySearch()
        System.out.println("\n++++++++++++++++++++ TESTING : recursiveBinarySearch() +++++++++\n");
        for (int element : ascendingArray){

            System.out.println("checked                            : "
                    + element + " in index : [" + assendingArrayList.indexOf(element) + "]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("found by : recursiveBinarySearch() : "
                    + element + " in index : ["
                    + recursiveBinarySearch(ascendingArray, ascendingArray.length, 10, element) +"]\n"
                    + "\n=======================================================================\n");

        }



        // =================================== Ascending Array not in array test ======================================
        int notInArray = 6;


        // findByBinarySearch() item not in array test
        notInArrayFBBSCheck(ascendingArray, notInArray);

        // recursiveBinarySearch() item not in array test
        notInArrayRBSCheck(ascendingArray, notInArray);



    }


    private static int findByBinarySearch(int[] array, int item){

        int length = array.length;
        int lastMiddleInArr = (int) Math.floor(length / 2.0);

        while (length > 0){


            int localMiddle = (int) Math.floor(length / 2.0);


            if (item == array[lastMiddleInArr]){
                return lastMiddleInArr;

            } else if (item < array[lastMiddleInArr] && (length % 2 == 0)){
                length = length - localMiddle;

            } else {
                length = length - (localMiddle + 1);

            }


            localMiddle = (int) Math.floor(length / 2.0);


            if (item > array[lastMiddleInArr]) {
                lastMiddleInArr = lastMiddleInArr + localMiddle + 1;
            } else if (item < array[lastMiddleInArr]){

                lastMiddleInArr = length % 2 == 0 ?
                        lastMiddleInArr - localMiddle
                        :
                        lastMiddleInArr - localMiddle - 1;

            }
        }

        return -1;
    }

    private static int recursiveBinarySearch(int[] array, int length, int arrayMiddleIndex, int item){

        int lastMiddleInArr = arrayMiddleIndex;

        int localMiddle = (int) Math.floor(length / 2.0);


        if (item == array[lastMiddleInArr]){
            return lastMiddleInArr;

        } else if (item < array[lastMiddleInArr] && (length % 2 == 0)){
            length = length - localMiddle;

        } else {
            length = length - (localMiddle + 1);

        }


        localMiddle = (int) Math.floor(length / 2.0);


        if (item > array[lastMiddleInArr]) {
            lastMiddleInArr = lastMiddleInArr + localMiddle + 1;
        } else if (item < array[lastMiddleInArr]){

            lastMiddleInArr = length % 2 == 0 ?
                    lastMiddleInArr - localMiddle
                    :
                    lastMiddleInArr - localMiddle - 1;

        }

        if (length > 0){
            return recursiveBinarySearch(array, length, lastMiddleInArr, item);
        } else {
            return -1;
        }


    }


    private static void notInArrayFBBSCheck(int[] array, int notInArray){

        System.out.println("+ testing the not in array result form findByBinarySearch()");
        System.out.println("-> found by : findByBinarySearch() : index of "
                + notInArray + " is : ["+ findByBinarySearch(array, notInArray) + "]\n\n");


    }

    private static void notInArrayRBSCheck(int[] array, int notInArray){

        System.out.println("+ testing the not in array result form recursiveBinarySearch()");
        System.out.println("-> found by : recursiveBinarySearch() : index of "
                + notInArray + " is : ["
                + recursiveBinarySearch(array, array.length, 10, notInArray) + "]\n\n");
    }


    private static List<Integer> arrayList(int[] array){

        List<Integer> arrayList = new ArrayList<>();
        for (int el : array){

            arrayList.add(el);
        }

        return arrayList;
    }



}

















