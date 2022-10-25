import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static ArrayList<Integer> arr;
    public int solution(int distance, int[] rocks, int n) {
        int start = 0;
        int answer = 0;
        int end = distance;
        Arrays.sort(rocks);
        while (start < end){
            int mid = (start + end)/2;
            int num = getNum(rocks, mid, distance);
            if (num <= n){
                answer = mid;
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return answer;
    }
    public int getNum(int[] rocks, int mid, int end){
        int start = 0;
        int sum = 0;
        arr = new ArrayList<>();
        for (int rock : rocks){
            if (rock < start + mid){
                sum++;
            }
            else {
                start = rock;
                arr.add(start);
            }
        }
        if (end - start < mid)
            sum++;
        return sum;
    }
}