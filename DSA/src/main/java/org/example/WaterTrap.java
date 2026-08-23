package org.example;

public class WaterTrap {

    public static void main(String[] args) {
        int []buildingHeights = new int[]{0,1,0,0,0,0,0,0,0,0};
        System.out.println("Total water trapped units : "+ calculateWaterTrapped3(buildingHeights));
    }

    public static int calculateWaterTrappedUnits(int []arr){

        if(arr.length != 0){
            int i = 0,j=1,waterTrapped = 0;
            for(int b=0; b<arr.length-1; b++){
                waterTrapped += Math.min(arr[i],arr[j]);
                i++;
                j++;
            }
            return waterTrapped;
        }
        return 0;
    }

    public static int calculateWaterTrappedUnits2(int []height){

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }


    public static int calculateWaterTrapped3(int []height){
        int waterTrapped = 0;
        if(height.length > 0){
            int leftMax = 0,rightMax = 0;
            int left = 0,right = height.length-1;
          while(left < right) {
              if(height[left] <= height[right]) {
                  if (height[left] >= leftMax) {
                      leftMax = height[left];
                  } else {
                      waterTrapped += leftMax - height[left];
                  }
                  left++;
              }else {
                  if (height[right] >= rightMax) {
                      rightMax = height[right];
                  } else {
                      waterTrapped += rightMax - height[right];
                  }
                  right--;
              }
          }
        }
        return waterTrapped ;
    }
}
