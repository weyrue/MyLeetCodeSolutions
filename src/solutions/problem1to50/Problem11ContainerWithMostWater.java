package solutions.problem1to50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem11ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height = {1,2};

        int ret = new Solution11().maxArea2(height);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

}

class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0, tmpArea = 0;
        int leftPointer = 0, rightPointer = height.length - 1;

        while (rightPointer > leftPointer) {
            if (height[leftPointer] < height[rightPointer]) {
                tmpArea = height[leftPointer] * (rightPointer - leftPointer);
                leftPointer++;
            } else {
                tmpArea = height[rightPointer] * (rightPointer - leftPointer);
                rightPointer--;
            }

            if (tmpArea > maxArea) maxArea = tmpArea;
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int maxHeight = 0;

        HashMap<Integer, List<Integer>> height_xList_Map = new HashMap<>();
        for (int x = 0; x < height.length; x++) {
            if (!height_xList_Map.containsKey(height[x])) height_xList_Map.put(height[x], new LinkedList<>());

            height_xList_Map.get(height[x]).add(x);
            if (height[x] > maxHeight) maxHeight = height[x];
        }

        LinkedList<Integer> hList = new LinkedList<>();
        int xMin = height.length, xMax = 0;
        for (int h = maxHeight; h > 0; h--) {
            if (!height_xList_Map.containsKey(h)) continue;
            if (h * (height.length - 1) < maxArea) break;

            hList.add(h);

            int listSize = height_xList_Map.get(h).size();
            if (height_xList_Map.get(h).get(0) < xMin) xMin = height_xList_Map.get(h).get(0);
            if (height_xList_Map.get(h).get(listSize - 1) > xMax) xMax = height_xList_Map.get(h).get(listSize - 1);

            int tmpArea = h*(xMax-xMin);

            maxArea = tmpArea>maxArea?tmpArea:maxArea;
        }

        return maxArea;
    }
}
