class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, cols, diag1, diag2, ans);

        return ans;
    }

    private void backtrack(int row, int n, char[][] board,
                           boolean[] cols,
                           boolean[] diag1,
                           boolean[] diag2,
                           List<List<String>> ans) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {

            int diagIdx1 = row - c + n;
            int diagIdx2 = row + c;

            if (cols[c] || diag1[diagIdx1] || diag2[diagIdx2]) {
                continue;
            }

            cols[c] = true;
            diag1[diagIdx1] = true;
            diag2[diagIdx2] = true;
            board[row][c] = 'Q';

            backtrack(row + 1, n, board, cols, diag1, diag2, ans);

            board[row][c] = '.';
            cols[c] = false;
            diag1[diagIdx1] = false;
            diag2[diagIdx2] = false;
        }
    }
}