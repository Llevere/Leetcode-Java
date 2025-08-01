import java.util.*;



public class Main {
    public static void main(String[] args) {

    //        System.out.println(isPalindrome(6016));

    //        System.out.println(isValidParentheses("()"));
    //        System.out.println(isValidParentheses("([])"));

    // System.out.println(removeElement(new int[]{3,2,2,3}, 1));
    // System.out.println(strStr("sadbutsad", "sad"));
    // System.out.println(strStr("leetcode", "leeto"));
    // System.out.println(removeDuplicates(new int[]{0,1,1,1,2,2,3,3,4}));

    //        String[] input = {"Apple", "banana", "APPLE", "Banana", "orange", "  Orange "};
    //        String[] result = uniqueValues(input);
    //        System.out.println(Arrays.toString(result));

    // Easy
    // System.out.println(singleNumber(new int[]{2,2,1})); // 1
    // Medium
    // System.out.println(singleNumber(new int[]{2,2,3,2})); // 3

    // System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));

    // System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    // System.out.println(Arrays.toString(intersectionTwo(new int[]{1, 2, 2, 3}, new int[]{2, 2})));
    // System.out.println(thirdMax(new int[]{2,3}));
    // System.out.println(generate(5));
    // System.out.println(getRow(0));
    // System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    // moveZeroes(new int[]{0,1,0,3,12});
    // System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    //    System.out.println(islandPerimeter(new int[][]{
    //            {0, 1, 0, 0},
    //            {1, 1, 1, 0},
    //            {0, 1, 0, 0},
    //            {1, 1, 0, 0}
    //    }));

    // System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    // System.out.println(findPoisonedDuration(new int[]{1,2,4,5}, 2));

    // System.out.println(Arrays.toString(findWords(new String[]{"Alaska", "Dadq"})));
    // System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    // System.out.println(subSeqWord("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk",
    // "tnmlanowax"}));

    // System.out.println(isIsomorphic("badc", "baba"));

    // System.out.println(isAnagram("rat", "car"));

    //    Integer[] input1 = {1, 2, 3, null, 5};
    //    TreeNode root1 = TreeNode.buildTree(input1);
    //    System.out.println(binaryTreePaths(root1));

    // System.out.println(reverseString(new char[]{'h','e','l','l','o'}));
    // reverseString(new char[]{'h','e','l','l','o'});

    // System.out.println(canConstruct("aa", "aab"));
    System.out.println(firstUniqChar("leetcode"));
  }

  static int firstUniqChar(String s) {
      int[] count = new int[26]; // only lowercase letters

      // First pass: count frequencies
      for (char c : s.toCharArray()) {
          count[c - 'a']++;
      }
    System.out.println(Arrays.toString(count));
    System.out.println("---");
      // Second pass: find first unique character
      for (int i = 0; i < s.length(); i++) {
          if (count[s.charAt(i) - 'a'] == 1) {
              return i;
          }
      }

      return -1;
  }

      static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> magazineMap = new HashMap();
    for(char c : magazine.toCharArray())
    {
        magazineMap.put(c, magazineMap.getOrDefault(c, 0)+1);
    }

    for(char c : ransomNote.toCharArray())
    {
        if (magazineMap.containsKey(c)) {
            int count = magazineMap.get(c) - 1;
            if (count == 0) {
                magazineMap.remove(c);
            } else {
                magazineMap.put(c, count);
            }

        }
        else {
            return false;
        }
    }
    return true;

  }

  static void reverseString(char[] s)
  {
      System.out.println(Arrays.toString(s));
    //two pointer approach
      int i = 0, j = s.length-1;
      while (i < j)

      {
          char temp = s[i];
          s[i] = s[j];
          s[j] = temp;
          i++;
          j--;
      }
    System.out.println(Arrays.toString(s));
  }

  static void dfsTree(TreeNode node, String path, List<String> paths) {
      if (node == null) return;
      path += node.val;
      if (node.left == null && node.right == null) {
          paths.add(path);
      } else {
          dfsTree(node.left, path + "->", paths);
          dfsTree(node.right, path + "->", paths);
      }
  }
  static List<String> binaryTreePaths(TreeNode root)
  {
      List<String> paths = new ArrayList<>();
      dfsTree(root, "", paths);
      return paths;
  }

    static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> mappedCharacters = new HashMap();

        for(char c : s.toCharArray())
        {
            mappedCharacters.put(c, mappedCharacters.getOrDefault(c, 0) + 1);
        }

        boolean valid = true;
        for (char c : t.toCharArray()) {

            if (mappedCharacters.containsKey(c)) {
                int count = mappedCharacters.get(c) - 1;
                // System.out.printf("Count for char %c - %d\n", c, count);
                if (count == 0) {
                    mappedCharacters.remove(c);
                } else {
                    mappedCharacters.put(c, count);
                }

            }
            else {
                valid = false;
                break;
            }
        }
        return valid;
    }

  static boolean isIsomorphic(String s, String t) {
      int[] mapS = new int[256];
      int[] mapT = new int[256];

      for(int i=0;i<s.length();i++){
          char c1 = s.charAt(i);
          char c2 = t.charAt(i);

          if(mapS[c1] == 0 && mapT[c2] == 0){
              mapS[c1] = i + 1;
              mapT[c2] = i + 1;
          }else{
              if(mapS[c1] != mapT[c2]){
                  return false;
              }
          }
      }
      return true;
//        //Keep track of both sides.
//        // s= "badc", t = "baba". mapS will assign 'd' to 'b', making it return true.
//        // This is where mapT comes in and checks value for the key 'b' which doesn't equal 'd'
//
//    Map<Character, Character> mapS = new HashMap();
//    Map<Character, Character> mapT = new HashMap();
//    //Since both "S" string and "T" string are the same length, can just one of them for the length
//    for(int i = 0; i < s.length(); i++)
//    {
//        char cs = s.charAt(i);
//        char ct = t.charAt(i);
//       if(mapS.containsKey(cs))
//        {
//            if(!mapS.containsValue(ct))
//            {
//                return false;
//            }
//        }else mapS.put(s.charAt(i), t.charAt(i));
//
//        if (mapT.containsKey(ct)) {
//            if (mapT.get(ct) != cs) {
//                return false;
//            }
//        } else {
//            mapT.put(ct, cs);
//        }
//
//    }
//    return true;
  }

  static int arrayPairSum(int[] nums) {
      Arrays.sort(nums);
      int sum = 0;

      for (int i = 0; i < nums.length; i += 2) {
          sum += nums[i];
      }

      return sum;
  }

  static int subSeqWord(String s, String[] words)
  { int validWords = 0;
      for(String word : words)
      {
      //System.out.printf("Word %s\n",word);
         Map<Character, Integer> mappedCharacters = new HashMap();

         for(char c : s.toCharArray())
         {
             mappedCharacters.put(c, mappedCharacters.getOrDefault(c, 0) + 1);
         }

        boolean valid = true;
          for (char c : word.toCharArray()) {

            if (mappedCharacters.containsKey(c)) {
              int count = mappedCharacters.get(c) - 1;
               // System.out.printf("Count for char %c - %d\n", c, count);
              if (count == 0) {
                mappedCharacters.remove(c);
              } else {
                mappedCharacters.put(c, count);
              }

            }
            else {
                valid = false;
                break;
            }
          }
          if(valid) validWords++;
    }

    return validWords;
  }

    static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Step 1: Store (score, index) pairs
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];  // score
            scoreWithIndex[i][1] = i;         // original index
        }

        // Step 2: Sort in descending order of scores
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        // Step 3: Assign ranks
        for (int i = 0; i < n; i++) {
            int originalIndex = scoreWithIndex[i][1];
            if (i == 0) result[originalIndex] = "Gold Medal";
            else if (i == 1) result[originalIndex] = "Silver Medal";
            else if (i == 2) result[originalIndex] = "Bronze Medal";
            else result[originalIndex] = String.valueOf(i + 1);
        }

        return result;
    }

    static String[] findWords(String[] words) {
        List<String> validWords = new ArrayList<>();
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        List<Set<Character>> rowSets = new ArrayList<>();
        for (String row : rows) {
            Set<Character> charSet = new HashSet<>();
            for (char c : row.toLowerCase().toCharArray()) {
                charSet.add(c);
            }
            rowSets.add(charSet);
        }

        for(String word : words)
        {

      // Convert the word to lowercase character array
      char[] wordChars = word.toLowerCase().toCharArray();

      // Check which row contains all the characters
      for (int i = 0; i < rowSets.size(); i++) {
        Set<Character> rowSet = rowSets.get(i);
        boolean allMatch = true;

        for (char c : wordChars) {
          if (!rowSet.contains(c)) {
            allMatch = false;
            break;
          }
        }

        if (allMatch) {
            validWords.add(word);
        }
      }
    }

    return validWords.toArray(new String[0]);
  }

  static int findPoisonedDuration(int[] timeSeries, int duration) {

      if (timeSeries.length == 0 || duration == 0) return 0;

      int poisionTotalTime = 0;

      for (int i = 0; i < timeSeries.length - 1; i++) {
          int timeGap = timeSeries[i + 1] - timeSeries[i];
          poisionTotalTime += Math.min(timeGap, duration);
      }

      poisionTotalTime += duration;

      return poisionTotalTime;
  }

    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            while(i < nums.length && nums[i] == 1)
            {
                count++;
                i++;
            }
            if(count > max) max = count;
        }
        return max;
    }

    static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    perimeter += 4;
                    if (row > 0 && grid[row - 1][col] == 1) perimeter--; // top
                    if (row < grid.length - 1 && grid[row + 1][col] == 1) perimeter--; // bottom
                    if (col > 0 && grid[row][col - 1] == 1) perimeter--; // left
                    if (col < grid[0].length - 1 && grid[row][col + 1] == 1) perimeter--; // right
                }
            }
        }
        return perimeter;
    }


    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort greed factors
        Arrays.sort(s); // sort cookie sizes

        int i = 0; // pointer for children
        int j = 0; // pointer for cookies

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // Cookie satisfies this child
                i++; // move to next child
            }
            j++; // always move to next cookie
        }

        return i; // number of content children
    }

    static void moveZeroes(int[] nums) {
        //replace the index values that are not zero, in-place, then fill the rest with zeros
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

  static List<Integer> findDisappearedNumbers(int[] nums) {
      int[] result = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
          int index = nums[i] - 1;
          result[index] = nums[i];
      }

      List<Integer> missing = new ArrayList<>();
      for (int i = 0; i < result.length; i++) {
          if (result[i] == 0) {
              missing.add(i + 1);
          }
      }

      return missing;
  }

//
//    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//    }

  // Easy
  //    static int singleNumber(int[] nums) {
  //        Set<Integer> set = new HashSet<>();
  //        for (int num : nums) {
  //            if (!set.add(num)) {
  //                set.remove(num);
  //            }
  //        }
  //        return set.iterator().next();
  //    }
  //  static int singleNumber(int[] nums) {
  //      Set<Integer> set = new HashSet<>();
  //      for (int num : nums) {
  //          if (!set.add(num)) {
  //              set.remove(num);
  //          }
  //      }
  //      return set.iterator().next();
  //  }

    static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        //Default row
        pascalTriangle.add(Arrays.asList(1));
        if(rowIndex < 1) return pascalTriangle.get(0);


        /**
         *     1
         *    1 1
         *   1 2 1
         *  1 3 3 1
         * 1 4 6 4 1
         */
        for(int i = 0; i < rowIndex; i++)
        {
            List<Integer> row = new ArrayList<>(), lastRow = pascalTriangle.getLast();
            row.add(1);
            //Start at index 1 for easier list index retrieval
            for(int j = 1; j < lastRow.size(); j++)
            {
                row.add(lastRow.get(j-1) + lastRow.get(j));
            }
            //final edge
            row.add(1);
            pascalTriangle.add(row);
        }

        return pascalTriangle.getLast();
    }

    static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if(numRows < 1) return pascalTriangle;

        //Default row
        pascalTriangle.add(Arrays.asList(1));

        /**
         *     1
         *    1 1
         *   1 2 1
         *  1 3 3 1
         * 1 4 6 4 1
         */
        //Edges always = 1
        if(numRows == 1)
        {
            return pascalTriangle;
        }
        for(int i = 0; i < numRows-1; i++)
        {
            List<Integer> row = new ArrayList<>(), lastRow = pascalTriangle.getLast();
            row.add(1);
            //Start at index 1 for easier list index retrieval
            for(int j = 1; j < lastRow.size(); j++)
            {
                row.add(lastRow.get(j-1) + lastRow.get(j));
            }
            //final edge
            row.add(1);
            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    static int thirdMax(int[] nums) {
        Long max = null, secondMax = null, thirdMax = null;

        for (int num : nums) {
            long n = num;
            if ((max != null && n == max) ||
                    (secondMax != null && n == secondMax) ||
                    (thirdMax != null && n == thirdMax)) {
                continue;
            }

            if (max == null || n > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }

        return thirdMax == null ? max.intValue() : thirdMax.intValue();
    }

    static int[] intersectionTwo(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCounterMap = new HashMap<>();
        for (int num : nums1)
            numCounterMap.put(num, numCounterMap.getOrDefault(num, 0) + 1);

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (numCounterMap.containsKey(num) && numCounterMap.get(num) > 0) {
                result.add(num);
                numCounterMap.put(num, numCounterMap.get(num) - 1);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numsOneUnique = new HashSet<>();
        for (int num : nums1) numsOneUnique.add(num);

        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (numsOneUnique.contains(num)) result.add(num);
        }

        int[] resArray = new int[result.size()];
        int i = 0;
        for (int num : result) resArray[i++] = num;

        return resArray;
    }

  static boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
          if (!set.add(num)) {
              return true;
          }
      }
      return false;
  }

  static boolean containsNearbyDuplicate(int[] nums, int k) {
//        for(int i = 0; i < nums.length; i++)
//        {
//            for(int j = i+1; j < nums.length; j++)
//            {
//                if(nums[i] == nums[j] && Math.abs(i - j) <= k)
//                {
//                    return true;
//                }
//            }
//        }
//        return false;

      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
          if (map.containsKey(nums[i])) {
              int prevIndex = map.get(nums[i]);
              if (i - prevIndex <= k) {
                  return true;
              }
          }
          map.put(nums[i], i); // update latest index
      }

      return false;
  }


    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // for fast lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // base case: empty string is always segmentable

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordSet.contains(sub)) {
                    dp[i] = true;
                    break; // early stop for this i
                }
            }
        }

        return dp[s.length()];
    }
    //Remove duplicates IN-PLACE
    static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    static int removeElement(int[] nums, int val) {
        int k = 0;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val)
            {
                nums[k++] = nums[i];

            }
        }

        return k;
    }

    static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int original = x;
        float revNum = 0;

        System.out.println("Original: " + x);
        int i = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            revNum = revNum * 10 + lastDigit;
            x /= 10;

            System.out.printf("Iteration: %d\n", ++i);
            System.out.printf("Last digit: %s\n", lastDigit);
            System.out.printf("RevNum %.1f\n", revNum);
            System.out.printf("X %d\n\n", x);

        }
        return original == revNum;
    }

    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parentheses = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );

        for (char ch : s.toCharArray()) {
            if (parentheses.containsKey((ch))) {
                stack.push((parentheses.get(ch)));
            } else if (parentheses.containsValue((ch))) {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    //This was asked in the OEC interview and asked why this is more efficient than an alternative like an inner for loop
    static String[] uniqueValues(String[] arr)
    {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++)
        {
            set.add((arr[i].trim().toLowerCase()));
        }

        return set.toArray(new String[0]);
    }
}