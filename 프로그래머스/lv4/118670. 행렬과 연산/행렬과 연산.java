import java.util.LinkedList;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int row  = rc.length;
        int column = rc[0].length;
        LinkedList<Integer> right = new LinkedList<>();
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<LinkedList<Integer>> center = new LinkedList<>();
        for (int i = 0 ; i < row ; i++){
            LinkedList<Integer> r = new LinkedList<>();
            for (int j = 1 ; j < column - 1; j++){
                r.add(rc[i][j]);
            }
            center.add(r);
            left.add(rc[i][0]);
            right.add(rc[i][column-1]);
        }
        for (String op : operations){
            if (op.equals("ShiftRow")){
                int l = left.removeLast();
                int r = right.removeLast();
                left.addFirst(l);
                right.addFirst(r);
                LinkedList<Integer> lst = center.removeLast();
                center.addFirst(lst);
            }
            else if (op.equals("Rotate")){
                center.get(0).addFirst(left.removeFirst());
                right.addFirst(center.get(0).removeLast());
                center.getLast().addLast(right.removeLast());
                left.addLast(center.getLast().removeFirst());
            }
        }
        for (int i = 0 ; i < row ; i++){
            rc[i][0] = left.removeFirst();
            rc[i][column-1] = right.removeFirst();
            LinkedList<Integer> curr = center.removeFirst();
            for (int j = 1 ; j < column -1  ;j++){
                rc[i][j] = curr.removeFirst();
            }
        }
        return rc;
    }
}