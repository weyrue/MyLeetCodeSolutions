package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem11ContainerWithMostWater {
    public int maxArea(int[] height) {
//        for (int laterIndex = 1; laterIndex < height.length; laterIndex++) {
//            for (int formerIndex = 0; formerIndex < laterIndex; formerIndex++) {
//                int areaHeight = height[laterIndex] > height[formerIndex] ? height[formerIndex] : height[laterIndex];
//                int area_tmp = areaHeight * (laterIndex - formerIndex);
//                if (area_tmp > maxArea) maxArea = area_tmp;
//            }
//        }

        return maxArea2(height);
    }

    private int maxArea2(int[] height) {
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

            if (listSize > 1) {
                int tmpArea = (height_xList_Map.get(h).get(listSize - 1) - height_xList_Map.get(h).get(0)) * h;
                if (tmpArea > maxArea) maxArea = tmpArea;
            }

            for (int x : height_xList_Map.get(h)) {
                if (x >= xMax) {
                    int tmpArea = (x - xMin) * h;
                    if (tmpArea > maxArea) maxArea = tmpArea;
                }

                if (x <= xMin) {
                    int tmpArea = (xMax - x) * h;
                    if (tmpArea > maxArea) maxArea = tmpArea;
                }
            }
        }

        return maxArea;
    }
}
