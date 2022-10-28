import java.util.*;
import java.io.*;
public class Main{
    public static int[] prev;
    public static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        prev = new int[L+1];
        Arrays.fill(prev, -1);
        count = new int[L+1];
        for (int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (merge(a,b)){
                sb.append("LADICA\n");
            }
            else
                sb.append("SMECE\n");
        }
        System.out.print(sb);
    }
    public static int find(int a){
        if (prev[a] < 0)
            return a;
        return prev[a] = find(prev[a]);
    }
    public static boolean merge(int a, int b){
        a = find(a);
        b = find(b);
        if (prev[a] + prev[b] >= count[a] + count[b])
            return false;
        if (a == b){
            count[a] -= 1;
            return true;
        }
        prev[b] += prev[a];
        count[b] += count[a] - 1;
        prev[a] = b;
        return true;
    }
}