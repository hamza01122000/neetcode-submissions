class Solution {

    Map<Integer, List<int[]>> map = new LinkedHashMap<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] puz = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(puz[i], '.');
        }
        dfs(0, 0, puz, n, res);

        return res;
    }

    public void dfs(int row, int col, char[][] puz, int n, List<List<String>> res) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (puz[i][j] == '#') {
                        sb.append('.');
                    } else {
                        sb.append(puz[i][j]);
                    }
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            // 1. Only execute if cell is safe
            if (puz[row][i] != '#') {
                puz[row][i] = 'Q';
                markIndex(row, i, n, puz);
                
                // Recurse to next row
                dfs(row + 1, i, puz, n, res);

                // --- BACKTRACKING ---
                // 2. We undo the moves directly inside this 'if' block
                List<int[]> pairsForQueen = map.get(row);

                if (pairsForQueen != null) {
                    for (int[] pair : pairsForQueen) {
                        puz[pair[0]][pair[1]] = '.';
                    }
                    map.remove(row);
                }

                // 3. Remove the Queen itself unconditionally
                puz[row][i] = '.';
            }
        }
    }

    public void markIndex(int i, int j, int n, char[][] puz) {
        int index = i;
        int row = i;
        int col = j;
        
        // For 1st Diagonal (Down-Left)
        while (i + 1 < n && j - 1 >= 0) {
            if (puz[i + 1][j - 1] != '#') {
                puz[i + 1][j - 1] = '#';
                // Renamed 'k' to 'key' to prevent variable shadowing errors
                map.computeIfAbsent(index, key -> new ArrayList<>()).add(new int[]{i + 1, j - 1});
            }
            i++;
            j--;
        }

        int k = row;
        int z = col;

        // for 2nd Diagonal (Down-Right)
        while (k + 1 < n && z + 1 < n) {
            if (puz[k + 1][z + 1] != '#') {
                puz[k + 1][z + 1] = '#';
                map.computeIfAbsent(index, key -> new ArrayList<>()).add(new int[]{k + 1, z + 1});
            }
            k++;
            z++;
        }

        int l = row;
        int m = col;

        // For Downward Row (Straight down)
        while (l + 1 < n) {
            if (puz[l + 1][m] != '#') {
                puz[l + 1][m] = '#';
                map.computeIfAbsent(index, key -> new ArrayList<>()).add(new int[]{l + 1, m});
            }
            l++;
        }
    }
}