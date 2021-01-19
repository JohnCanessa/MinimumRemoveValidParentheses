import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * LeetCode 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveValidParentheses {


    /**
     * Method of interest.
     * o No close parenthesis before open parenthesis.
     * o Open and close parentesis must balance (+1 and -1).
     * Runtime complexity: O(n)
     * 
     * Runtime: 8 ms, faster than 97.33% of Java online submissions.
     * Memory Usage: 40 MB, less than 39.11% of Java online submissions.
     */
    static String minRemoveToMakeValid(String s) {

        // **** sanity check(s) ****
        if (s == null)
            return null;
        if (s.equals(""))
            return "";

        // **** initialization ****
        StringBuilder out   = new StringBuilder();
        int pc              = 0;
        char[] chArr        = s.toCharArray();

        // **** traverse string right to left <- O(n) ****
        for (int i = chArr.length - 1; i >= 0; i--) {

            // **** for ease of use ****
            char ch = chArr[i];

            // **** count parenthesis ****
            if (ch == ')')
                pc++;
            else if (ch == '(') {

                // **** update count or remove parenthesis ****
                if (pc == 0) {

                    // **** remove this parenthesis ****
                    chArr[i] = 'X';
                } else  {

                    // **** count this parenthesis ****
                    pc--;
                }
            }
        }

        // **** check if parenthesis are NOT balanced ****
        if (pc != 0) {

            // **** no parenthesis counted yet ****
            pc = 0;

            // **** traverse string left to right -> O(n) ****
            for (int i = 0; i < chArr.length; i++) {

                // **** for ease of use ****
                char ch = chArr[i];

                // **** count parenthesis ****
                if (ch == '(')
                    pc++;
                else if (ch == ')') {

                    // **** update count OR remove parenthesis ****
                    if (pc == 0) {

                        // **** remove this parenthesis ****
                        chArr[i] = 'X';
                    } else {

                        // **** count this parenthesis ****
                        pc--;
                    }
                }
            }
        }

        // **** build string to return O(n) ****
        for (char ch : chArr) {
            if (ch != 'X')
                out.append(ch);
        }

        // **** return output string ****
        return out.toString();
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
       
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read input string ****
        String s = br.readLine().trim();

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<<      s ==>" + s + "<==");

        // **** call method of interest and display output ****
        System.out.println("main <<< output ==>" + minRemoveToMakeValid(s) + "<==");
    }
}