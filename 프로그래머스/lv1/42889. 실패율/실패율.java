import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Pair[] per = new Pair[N];
        int[] stageNum = new int[N+1];
        float[] tot = new float[N];
        Arrays.sort(stages);
        for (int t : stages){
            stageNum[t-1]++;
        }
        for (int i = 0 ; i < N ; i++){
            for (int j = i ; j <= N ; j++)
                tot[i] += stageNum[j];
        }
        for (int i = 0 ; i < N; i++){
            per[i] = new Pair(stageNum[i]/tot[i], i + 1);
        }
        Arrays.sort(per);
        for (int i = 0 ; i < N ; i++)
            answer[i] = per[i].idx;
        return answer;
    }
}
class Pair implements Comparable<Pair>{
    public float per;
    public int idx;
    Pair(float per, int idx){
        this.per = per;
        this.idx = idx;
    }
    @Override
    public int compareTo(Pair other){
        if (this.per > other.per)
            return -1;
        else if (this.per < other.per)
            return 1;
        else
            return 0;
    }
}