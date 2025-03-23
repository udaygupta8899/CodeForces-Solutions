
/**
 * ⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 * ⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 * =================================================================
 *  ╔╦╗╔═╗╔╦╗╔═╗╦  ╔═╗╔╦╗╔═╗  ╔╗ ╦ ╦  ╦ ╦╔╦╗╔═╗╦ ╦
 *   ║ ║╣ ║║║╠═╝║  ╠═╣ ║ ║╣   ╠╩╗╚╦╝  ║ ║ ║║╠═╣╚╦╝
 *   ╩ ╚═╝╩ ╩╩  ╩═╝╩ ╩ ╩ ╚═╝  ╚═╝ ╩   ╚═╝═╩╝╩ ╩ ╩ 
 * =================================================================
 *     ║ Github: github.com/udaygupta8899                      ║
 *     ║ Codeforces: codeforces.com/profile/udaygupta8899      ║
 *     ║ "Built for efficiency, powered by passion"            ║
 *     ║ Time Complexity Matters!                              ║
 *     ║ Keep Coding, Keep Growing!                            ║
 * =================================================================
 * @author Uday
 * @category Competitive Programming
 */

import java.io.*;
import java.util.*;

public class Main {
    // ----- Configuration Flags & Constants -----
    static final boolean STRESS_MODE = true;    // Set to true for stress testing.
    static final boolean DEBUG = true;            // Enable debug prints during stress testing.
    static final int MAX_TESTS = 10000;           // Maximum iterations for stress testing.
    static final long TIMEOUT_NANO = 2_00_000_000;   // Timeout for a single test (in nanoseconds)

    // ----- Global Utilities -----
    static final Random random = new Random();
    static final int MOD = 1000000007;

    // ----- Main Entry Point -----
    public static void main(String[] args) throws IOException {
        if (STRESS_MODE) {
            runStressTests();
        } else {
            FastReader sc = new FastReader(new InputStreamReader(System.in));
            StringBuilder ans = new StringBuilder();
            int t = sc.nextInt();
            while (t-- > 0) {
                solve(sc, ans);
            }
            print(ans);
        }
    }

    // ----- Optimized (Primary) Solution -----
    static void solve(FastReader sc, StringBuilder ans) {
        int n = sc.nextInt();
        int[] a = sc.readIntArray(n);
        int[] b = sc.readIntArray(n);
        
        long sum = sum(a);
        // long sum = 0;
        // for(int i=0;i<n;i++){
        //     sum += Math.abs(a[i]);
        // }
        ans.append(sum).append("\n");
    }

    // ----- Brute-force (Reference) Solution -----
    static void bruteSolve(FastReader sc, StringBuilder ans) {
        int n = sc.nextInt();
        int[] a = sc.readIntArray(n);
        int[] b = sc.readIntArray(n);
        
        long sum = 0;
        for (int x : a) {
            sum += x;
        }
        ans.append(sum).append("\n");
    }

    // ----- Wrapper Methods for Stress Testing -----
    static String runOptimized(String input) throws IOException {
        FastReader sc = new FastReader(new StringReader(input));
        StringBuilder ans = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc, ans);
        }
        return ans.toString().trim();
    }

    static String runBrute(String input) throws IOException {
        FastReader sc = new FastReader(new StringReader(input));
        StringBuilder ans = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            bruteSolve(sc, ans);
        }
        return ans.toString().trim();
    }

    // ----- Advanced Stress Test Method -----
    static void runStressTests() throws IOException {
        int testCount = 0;
        while (testCount < MAX_TESTS) {
            testCount++;
            String testCase = generateTestCase();

            long startOptimized = System.nanoTime();
            String optResult = runOptimized(testCase);
            long timeOptimized = System.nanoTime() - startOptimized;

            long startBrute = System.nanoTime();
            String bruteResult = runBrute(testCase);
            long timeBrute = System.nanoTime() - startBrute;

            if (!optResult.equals(bruteResult)) {
                print("Test #" + testCount + " FAILED!");
                print("Test case input:");
                print(testCase);
                print("Optimized output (" + timeOptimized + " ns):");
                print(optResult);
                print("Brute-force output (" + timeBrute + " ns):");
                print(bruteResult);
                return;
            }

            if (timeOptimized > TIMEOUT_NANO) {
                print("Test #" + testCount + " exceeded time limit (" + timeOptimized + " ns).");
                print("Test case:");
                print(testCase);
                break;
            }

            if (DEBUG && testCount % 1000 == 0) {
                print(testCount + " tests passed. Last test: " + timeOptimized + " ns (optimized), " + timeBrute + " ns (brute).");
            }
        }
        print("All " + testCount + " tests passed successfully!");
    }

    // ----- Test Case Generator ----- //
    static String generateTestCase() {
        StringBuilder sb = new StringBuilder();
        // Example: generate between 1 and 5 test cases.
        int t = random.nextInt(5) + 1;
        sb.append(t).append("\n");
        for (int i = 0; i < t; i++) {
            // For each test case, generate an integer n (size of arrays).
            int n = random.nextInt(10) + 1;
            sb.append(n).append("\n");

            // Generate first array.
            for (int j = 0; j < n; j++) {
                sb.append(random.nextInt(100) - 50).append(" ");
            }
            sb.append("\n");

            // Generate second array.
            for (int j = 0; j < n; j++) {
                sb.append(random.nextInt(100) + 1).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    // ----- Utility Functions -----

    // Sum of an integer array.
    static long sum(int[] arr) {
        long s = 0;
        for (int x : arr) {
            s += x;
        }
        return s;
    }

    // Binary Search: Lower Bound – first index where arr[index] >= key.
    static int lowerBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Binary Search: Upper Bound – first index where arr[index] > key.
    static int upperBound(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= key) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Greatest Common Divisor.
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Least Common Multiple.
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // Check if a number is prime.
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Ruffle (randomly shuffle) the array then sort.
    static void ruffleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        Arrays.sort(arr);
    }

    // Fast modular exponentiation.
    static long modExp(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    // ----- Utility Print Function -----
    static void print(Object res) {
        PrintWriter out = new PrintWriter(System.out);
        out.println(res);
        out.flush();
    }

    // ----- Fast I/O Implementation -----
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        // Constructor for a given Reader.
        public FastReader(Reader reader) {
            br = new BufferedReader(reader);
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }

        // Read an array of integers.
        int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        // Read an array of longs.
        long[] readLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}

class Pair {
    int index;
    int val;

    Pair(int _index, int _val) {
        this.index = _index;
        this.val = _val;
    }
}
