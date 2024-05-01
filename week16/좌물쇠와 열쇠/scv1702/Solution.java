class Solution {
    public int[][] rotate(int[][] a) {
        return rotate(a, 0);
    }
    
    public int[][] rotate(int[][] a, int s) {
        int n = a.length;
        
        if (s >= (n / 2)) {
            return a;
        }
        
        int m = n - 2 * s;
        int[] b = new int[4 * m - 4];
        int idx = 0;
        
        for (int j = s; j < s + m; j++) {
            b[idx++] = a[s][j];
        }
        
        for (int i = s + 1; i < s + m; i++) {
            b[idx++] = a[i][s + m - 1];
        }
        
        for (int j = s + m - 2; j >= s; j--) {
            b[idx++] = a[s + m - 1][j];
        }
        
        for (int i = s + m - 2; i > s; i--) {
            b[idx++] = a[i][s];
        }
        
        idx = b.length - m + 1;
        
        for (int j = s; j < s + m; j++) {
            a[s][j] = b[idx];
            idx = (idx + 1) % b.length;
        }
        
        for (int i = s + 1; i < s + m; i++) {
            a[i][s + m - 1] = b[idx];
            idx = (idx + 1) % b.length;
        }
        
        for (int j = s + m - 2; j >= s; j--) {
            a[s + m - 1][j] = b[idx];
            idx = (idx + 1) % b.length;
        }
        
        for (int i = s + m - 2; i > s; i--) {
            a[i][s] = b[idx]; 
            idx = (idx + 1) % b.length;
        }
        
        return rotate(a, s + 1);
    }
    
    public boolean validate(int[][] key, int[][] lock, int n, int m, int k, int r, int c) {
        for (int i = 0; i < n && i + r < k; i++) {
            for (int j = 0; j < n && j + c < k; j++) {
                lock[i + r][j + c] += key[i][j];
            }
        }
        
        boolean result = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (lock[n - 1 + i][n - 1 + j] != 1) {
                    result = false;
                    break;
                }
            }
        }
        
        for (int i = 0; i < n && i + r < k; i++) {
            for (int j = 0; j < n && j + c < k; j++) {
                lock[i + r][j + c] -= key[i][j];
            }
        }
        
        return result;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int n = key.length;
        int m = lock.length;
        int k = 2 * (n - 1) + m;
        int[][] a = new int[k][k];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                a[i + n - 1][j + n - 1] = lock[i][j];
            }
        }
        
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (validate(key, a, n, m, k, i, j)) {
                        return true;
                    }
                }
            }
            key = rotate(key);
        }

        return false;
    }
}