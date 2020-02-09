package solutions.Problem39CombinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> combinationsList = subCombinationSum(candidates, candidates.length - 1, target);
//
//        return combinationsList == null ? new ArrayList<>() : combinationsList;

        if (candidates == null) return null;
        Arrays.sort(candidates);
        List<List<Integer>> combinationsList = new LinkedList<>();
        backTrack(combinationsList, new LinkedList<>(), candidates, 0, target);

        return combinationsList;
    }

    private void backTrack(List<List<Integer>> combinationsList, LinkedList<Integer> oneCombinationList, int[] candidates, int startIndex, int remain) {
        // 若remain=0，则oneCombinationList中为完整答案（因为oneCombinationList是动态的，故不能直接添加进去）
        if (remain == 0) {
            combinationsList.add(new LinkedList<>(oneCombinationList));
        } else {//尝试将每一个candidate添加进临时答案进行递归探索，探索后将其从临时答案中移除，以便下一个candidate探索。
            //若探索成功，则会在其递归调用的方法中添加进最终答案，此处不用操心。

            //尝试每个candidate
            for (int i = startIndex; i < candidates.length; i++) {
                //由于数列是递增的，故更大的数便不用考虑
                if (candidates[i] > remain) break;
                //candidate添加进临时答案进行递归探索
                oneCombinationList.add(candidates[i]);
                backTrack(combinationsList, oneCombinationList, candidates, i, remain - candidates[i]);
                //探索后将其从临时答案中移除，以便下一个candidate探索
                oneCombinationList.removeLast();
            }
        }
    }

    //将大的问题拆分成小的问题
    //拆分成前0~endIdex个备选参数组成sum的问题
//    private List<List<Integer>> subCombinationSum(int[] candidates, int endIndex, int target) {
//        int maxCount = target / candidates[endIndex];
//        if (endIndex == 0) {
//            if (maxCount * candidates[endIndex] == target) {
//                List<List<Integer>> oneCombinationList = new LinkedList<>();
//                oneCombinationList.add(new LinkedList<>());
//                for (int i = 0; i < maxCount; i++) {
//                    oneCombinationList.get(0).add(candidates[endIndex]);
//                }
//                return oneCombinationList;
//            }
//            return null;
//        } else {
//            List<List<Integer>> combinationsList = null;
//            for (int i = 0; i <= maxCount; i++) {
//                List<List<Integer>> subCombinationsList = subCombinationSum(candidates, endIndex - 1, target);
//                if (subCombinationsList != null) {
//                    for (List<Integer> oneCombination : subCombinationsList) {
//                        for (int k = 0; k < i; k++) {
//                            oneCombination.add(candidates[endIndex]);
//                        }
//                    }
//                    if (combinationsList == null) {
//                        combinationsList = subCombinationsList;
//                    } else {
//                        combinationsList.addAll(subCombinationsList);
//                    }
//                }
//
//                target -= candidates[endIndex];
//            }
//            return combinationsList;
//        }
//    }
}
