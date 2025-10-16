public class lab_6_t2 {
    
    static int optimalSearchTree(int keys[], int freq[], int n) {
        int[][] cost = new int[n][n];
        
        // Single key trees
        for(int i = 0; i < n; i++)
            cost[i][i] = freq[i];
        
        // Trees of increasing size
        for(int len = 2; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                for(int k = i; k <= j; k++)
                    sum += freq[k];
                
                // Try each key as root
                for(int r = i; r <= j; r++) {
                    int left = (r > i) ? cost[i][r-1] : 0;
                    int right = (r < j) ? cost[r+1][j] : 0;
                    cost[i][j] = Math.min(cost[i][j], left + right + sum);
                }
            }
        }
        return cost[0][n-1];
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] keys1 = {10, 12};
        int[] freq1 = {34, 50};
        System.out.println("Test 1: " + optimalSearchTree(keys1, freq1, 2));
        
        // Test Case 2
        int[] keys2 = {10, 12, 20};
        int[] freq2 = {34, 8, 50};
        System.out.println("Test 2: " + optimalSearchTree(keys2, freq2, 3));
    }
}
