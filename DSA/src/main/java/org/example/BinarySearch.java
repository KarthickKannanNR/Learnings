package org.example;

public class BinarySearch {

    public static void main(String[] args) {
        int arr1[] = new int[]{1,5,7,9,15,22,27,31,45,49,53,65,72};
        int arr2[] = new int[]{72,65,53,49,45,31,27,22,15,9,7,5,1};
        System.out.println(binarySearchAscArray(arr1, 1));
        System.out.println(binarySearchDscArray(arr2, 5));

        System.out.println(recursiveBinarySearch(arr1, 65, 0, arr1.length-1));
    }

    public static boolean binarySearchAscArray(int arr[], int target){
        int left = 0,right = arr.length -1, mid = arr.length/2;

        while(left <= right){
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid -1;

            mid = (left + right)/2;
        }
        return false;
    }

    public static boolean binarySearchDscArray(int arr[], int target){
        int left = 0,right = arr.length -1, mid = arr.length/2;

        while(left <= right){
            if(arr[mid] == target)
                return true;
            else if(arr[mid] < target)
                right = mid -1;
            else
                left = mid + 1;

            mid = (left + right)/2;
        }
        return false;
    }

    public static boolean recursiveBinarySearch(int [] arr,int target, int left, int right){
        int mid = (left+ right)/2;
        if(left > right)
            return false;
        if(arr[mid] == target){
            return true;
        }
        if(arr[mid] < target){
            return recursiveBinarySearch(arr, target, mid+1, right);
        }else{
            return recursiveBinarySearch(arr, target, left, right-1);
        }
    }
}
