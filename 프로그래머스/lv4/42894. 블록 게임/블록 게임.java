class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int a = board.length;
        while (true){
            int cnt = 0;
            for (int c = 0 ; c < a ;c++){
                for (int r = 0 ; r < a ; r++){
                    if (board[r][c] == 0 || board[r][c] == -1)
                        board[r][c] = -1;
                    else
                        break;
                }
            }
            for (int i = 0 ; i < a ; i++){
                for (int j = 0 ; j < a ; j++){
                    if (check(i, j, board, 2, 3)){
                        cnt++;
                        for (int r = 0 ; r < 2 ; r++){
                            for (int c = 0 ; c < 3 ;c++)
                                board[i+r][j+c] = 0;
                        }
                    }
                    else if (check(i, j, board, 3,2)){
                        cnt++;
                        for (int r = 0 ; r < 3 ; r++){
                            for (int c = 0 ; c < 2 ;c++)
                                board[i+r][j+c] = 0;
                        }
                    }
                }
            }
            answer += cnt;
            if (cnt == 0)
                break;
        }
        return answer;
    }
    public boolean check(int i, int j, int[][] board, int m, int n){
        int blackCnt = 0;
        int colorCnt = 0;
        int color = 0;
        for (int r = 0 ; r < m ; r++){
            for (int c = 0 ; c < n ; c++){
                if (i + r >= board.length || j+c >= board.length)
                    return false;
                if (board[i+r][j+c] == -1)
                    blackCnt++;
                else if (board[i+r][j+c] != 0){
                    if (colorCnt == 0) {
                        color = board[i+r][j+c];
                        colorCnt++;
                    }
                    else{
                        if (board[i+r][j+c] == color)
                            colorCnt++;
                    }
                }
            }
        }
        if (blackCnt == 2 && colorCnt == 4)
            return true;
        else
            return false;
    }
}