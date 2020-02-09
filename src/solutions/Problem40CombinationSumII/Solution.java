package solutions.Problem40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new LinkedList<>();
        backTrack(resultList, new LinkedList<>(), candidates, 0, target);

        return resultList;
    }

    private void backTrack(List<List<Integer>> resultList, LinkedList<Integer> oneCombinationList, int[] candidates, int startIndex, int remain) {
        if (remain == 0) {
            resultList.add(new ArrayList<>(oneCombinationList));
        } else {
            for (int i = startIndex; i < candidates.length; i++) {
                if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
                if (candidates[i] > remain) break;
                oneCombinationList.add(candidates[i]);
                backTrack(resultList, oneCombinationList, candidates, i + 1, remain - candidates[i]);
                oneCombinationList.removeLast();
            }
        }
    }
}
