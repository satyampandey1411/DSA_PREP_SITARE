import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--){
            int ele = nums2[i];
            while (!s.isEmpty() && s.peek() < ele) {
                s.pop();
            }
            if(!s.isEmpty()){
                map.put(ele, s.peek());
            }
            s.push(ele);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else {
                res[i] = -1;
            }
        }
        return res;
    }
}
