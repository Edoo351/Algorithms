package HashTabels;
import java.util.*;
class WordFreuqncy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

    }
}

class FirstUniqeCHar{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                System.out.println(c);
            }
        }
    }
}

class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        HashSet<Integer> FindDuplicates = new HashSet<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
           if (FindDuplicates.contains(nums[i])){
               found = true;
               break;
           }
           FindDuplicates.add(nums[i]);
        }
        System.out.println(found);
    }
}

class CountChars{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
    }
}

class Anagrams{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String m = sc.nextLine();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : m.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (map.equals(map2)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}


class UniqueElements{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
       ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums){
            if (map.get(num) == 1){
                list.add(num);
            }
        }
        System.out.println("Unique: " + list);
    }
}

class CommonElementsIntwoARrays{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num1 = {1,2,3};
        int[] num2 = {4,5,3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i], map.getOrDefault(num1[i], 0) + 1);
        }
        for (int i = 0; i < num2.length; i++) {
            map.put(num2[i], map.getOrDefault(num2[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : num1) {
            if (map.get(num) > 1) {
                list.add(num);
            }
        }
        System.out.println("Common: " + list);
    }
}

class RemoveDuplicates{
    public static void main(String[] args) {
        int[] num1 = {1,2,2,3};
        HashSet<Integer> map = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : num1) {
           if (!map.contains(num)) {
               map.add(num);
               list.add(num);
           }
        }
        System.out.println("Remove: " + list);

    }
}


class WordLength{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, List<String>> map = new HashMap<>();
        String[] words = s.split(" ");
        for (String word : words) {
            int length = word.length();
            map.putIfAbsent(length, new ArrayList<>());
            map.get(length).add(word);
        }
        System.out.println(map);
    }
}


class TwoSums {

    // WRITE THE TWOSUM MEHTOD HERE //
    //                              //
    //                              //
    //                              //
    //                              //
    //////////////////////////////////



    public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int complement = target - num;
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(num, i);
            }
            return new int[]{};
    }

    private static String formatResult(int[] result) {
        return result.length == 0 ? "[]" : Arrays.toString(result);
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm twoSum() returns the indices");
        System.out.println("of two numbers in the array that add up to target.");
        System.out.println();

        // Test 1: Basic pair
        System.out.println("Test 1: Basic Pair");
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Expected: Indices of 2 and 7 (any valid order)");
        System.out.println("Actual: " + formatResult(twoSum(nums1, target1)));
        System.out.println();

        // Test 2: Multiple pairs exist
        System.out.println("Test 2: Multiple Pairs");
        int[] nums2 = {1, 3, 2, 4, 6};
        int target2 = 5;
        System.out.println("Expected: Any valid pair summing to 5");
        System.out.println("Actual: " + formatResult(twoSum(nums2, target2)));
        System.out.println();

        // Test 3: Negative numbers
        System.out.println("Test 3: Negative Numbers");
        int[] nums3 = {-3, 4, 3, 90};
        int target3 = 0;
        System.out.println("Expected: Indices of -3 and 3");
        System.out.println("Actual: " + formatResult(twoSum(nums3, target3)));
        System.out.println();

        // Test 4: Duplicates used twice
        System.out.println("Test 4: Duplicates Used Twice");
        int[] nums4 = {3, 3};
        int target4 = 6;
        System.out.println("Expected: Indices of both 3's");
        System.out.println("Actual: " + formatResult(twoSum(nums4, target4)));
        System.out.println();

        // Test 5: No solution
        System.out.println("Test 5: No Solution");
        int[] nums5 = {1, 2, 3};
        int target5 = 10;
        System.out.println("Expected: []");
        System.out.println("Actual: " + formatResult(twoSum(nums5, target5)));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm twoSum() returns the indices
            of two numbers in the array that add up to target.

            Test 1: Basic Pair
            Expected: Indices of 2 and 7 (any valid order)
            Actual: [0, 1] (or valid indices for 2,7)

            Test 2: Multiple Pairs
            Expected: Any valid pair summing to 5
            Actual: [1, 2] (or valid indices)

            Test 3: Negative Numbers
            Expected: Indices of -3 and 3
            Actual: [0, 2] (or valid indices)

            Test 4: Duplicates Used Twice
            Expected: Indices of both 3's
            Actual: [0, 1]

            Test 5: No Solution
            Expected: []
            Actual: []
        */

    }

}


class SubarraySum{

    // WRITE SUBARAYSUM METHOD HERE //
    //                              //
    //                              //
    //                              //
    //                              //
    //////////////////////////////////


public static int[] subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0,-1);
    int currentSum=0;
    for (int i = 0; i < nums.length; i++) {
       currentSum+=nums[i];
       if (map.containsKey(currentSum-k)) {
           return new int[]{map.get(currentSum-k)+1, i};
       }
       map.put(nums[i], i);
    }
    return new int[]{};
}


    private static String formatResult(int[] result) {
        return result.length == 0 ? "[]" : Arrays.toString(result);
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm subarraySum() returns");
        System.out.println("the start and end indices of a subarray");
        System.out.println("that sums to the target, or [] if none exists.");
        System.out.println();

        // Test 1: Basic subarray
        System.out.println("Test 1: Basic Subarray");
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        System.out.println("Expected: Indices of subarray summing to 9");
        System.out.println("Actual: " + formatResult(subarraySum(nums1, target1)));
        System.out.println();

        // Test 2: Multiple possible subarrays
        System.out.println("Test 2: Multiple Possible Subarrays");
        int[] nums2 = {1, 2, 2, 3, 1};
        int target2 = 5;
        System.out.println("Expected: Any valid subarray summing to 5");
        System.out.println("Actual: " + formatResult(subarraySum(nums2, target2)));
        System.out.println();

        // Test 3: Includes negative numbers
        System.out.println("Test 3: Handles Negative Numbers");
        int[] nums3 = {3, 4, -7, 5, 1};
        int target3 = 5;
        System.out.println("Expected: Any valid subarray summing to 5");
        System.out.println("Actual: " + formatResult(subarraySum(nums3, target3)));
        System.out.println();

        // Test 4: Entire array is the subarray
        System.out.println("Test 4: Entire Array Matches");
        int[] nums4 = {2, 2, 2, 2};
        int target4 = 8;
        System.out.println("Expected: Indices for full array [0,3]");
        System.out.println("Actual: " + formatResult(subarraySum(nums4, target4)));
        System.out.println();

        // Test 5: No subarray found
        System.out.println("Test 5: No Subarray Found");
        int[] nums5 = {1, 1, 1};
        int target5 = 10;
        System.out.println("Expected: []");
        System.out.println("Actual: " + formatResult(subarraySum(nums5, target5)));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm subarraySum() returns
            the start and end indices of a subarray
            that sums to the target, or [] if none exists.

            Test 1: Basic Subarray
            Expected: Indices of subarray summing to 9
            Actual: [1, 3] (or valid subarray indices)

            Test 2: Multiple Possible Subarrays
            Expected: Any valid subarray summing to 5
            Actual: [0, 2] (or other valid indices)

            Test 3: Handles Negative Numbers
            Expected: Any valid subarray summing to 5
            Actual: [3, 4] (or other valid indices)

            Test 4: Entire Array Matches
            Expected: [0, 3]
            Actual: [0, 3]

            Test 5: No Subarray Found
            Expected: []
            Actual: []
        */

    }

}


class UniqueChars {
    public static boolean hasUniqueChars(String string){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            set.add(string.charAt(i));
        }
        return set.size() == string.length();
    }
    // WRITE HASUNIQUECHARS METHOD HERE //
    //                                  //
    //                                  //
    //                                  //
    //                                  //
    //////////////////////////////////////




    public static void main(String[] args) {
        System.out.println("These tests confirm hasUniqueChars() returns");
        System.out.println("true if all characters are unique and false");
        System.out.println("if any character repeats.");
        System.out.println();

        // Test 1: All unique characters
        System.out.println("Test 1: All Unique Characters");
        String input1 = "abcdef";
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasUniqueChars(input1));
        System.out.println();

        // Test 2: Repeating characters
        System.out.println("Test 2: Repeating Characters");
        String input2 = "hello";
        System.out.println("Expected: false");
        System.out.println("Actual: " + hasUniqueChars(input2));
        System.out.println();

        // Test 3: Empty string
        System.out.println("Test 3: Empty String");
        String input3 = "";
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasUniqueChars(input3));
        System.out.println();

        // Test 4: Single character
        System.out.println("Test 4: Single Character");
        String input4 = "x";
        System.out.println("Expected: true");
        System.out.println("Actual: " + hasUniqueChars(input4));
        System.out.println();

        // Test 5: Case sensitivity and symbols
        System.out.println("Test 5: Case Sensitivity and Symbols");
        String input5 = "AbC!@";
        String input6 = "AaA";
        System.out.println("Expected (AbC!@): true");
        System.out.println("Actual: " + hasUniqueChars(input5));
        System.out.println("Expected (AaA): false");
        System.out.println("Actual: " + hasUniqueChars(input6));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm hasUniqueChars() returns
            true if all characters are unique and false
            if any character repeats.

            Test 1: All Unique Characters
            Expected: true
            Actual: true

            Test 2: Repeating Characters
            Expected: false
            Actual: false

            Test 3: Empty String
            Expected: true
            Actual: true

            Test 4: Single Character
            Expected: true
            Actual: true

            Test 5: Case Sensitivity and Symbols
            Expected (AbC!@): true
            Actual: true
            Expected (AaA): false
            Actual: false
        */

    }

}



class findPairse {

    // WRITE FINDPAIRS METHOD HERE //
    //                             //
    //                             //
    //                             //
    //                             //
    /////////////////////////////////

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        Set<Integer> set = new HashSet<>();
        List<int[]> pairs = new ArrayList<>();

        for (int num: arr1) {
            set.add(num);
        }

        for (int num: arr2) {
            int complement = target - num;
            if (set.contains(complement)) {
                pairs.add(new int[]{complement,num});
            }
        }
        return pairs;
    }



    private static String formatPairs(List<int[]> pairs) {
        List<String> formatted = new ArrayList<>();
        for (int[] pair : pairs) {
            formatted.add(Arrays.toString(pair));
        }
        return formatted.toString();
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm findPairs() finds all");
        System.out.println("pairs from two arrays whose sum equals the target.");
        System.out.println();

        // Test 1: Single pair (actually multiple results summing to same target)
        System.out.println("Test 1: Find Pairs Summing to Target");
        int[] arr1a = {1, 2, 3};
        int[] arr2a = {4, 5, 6};
        int target1 = 7;
        System.out.println("Expected: Pairs like [1,6], [2,5], [3,4]");
        System.out.println("Actual: " + formatPairs(findPairs(arr1a, arr2a, target1)));
        System.out.println();

        // Test 2: No pairs exist
        System.out.println("Test 2: No Pairs");
        int[] arr1b = {1, 2};
        int[] arr2b = {7, 8};
        int target2 = 20;
        System.out.println("Expected: []");
        System.out.println("Actual: " + formatPairs(findPairs(arr1b, arr2b, target2)));
        System.out.println();

        // Test 3: Multiple valid pairs
        System.out.println("Test 3: Multiple Valid Pairs");
        int[] arr1c = {2, 4, 6};
        int[] arr2c = {1, 3, 5};
        int target3 = 7;
        System.out.println("Expected: Pairs like [2,5], [4,3], [6,1]");
        System.out.println("Actual: " + formatPairs(findPairs(arr1c, arr2c, target3)));
        System.out.println();

        // Test 4: Handles negatives
        System.out.println("Test 4: Handles Negative Numbers");
        int[] arr1d = {-1, -2, 3};
        int[] arr2d = {1, 4, -3};
        int target4 = 1;
        System.out.println("Expected: Pairs that sum to 1 (any valid ones)");
        System.out.println("Actual: " + formatPairs(findPairs(arr1d, arr2d, target4)));
        System.out.println();

        // Test 5: Both arrays empty
        System.out.println("Test 5: Empty Arrays");
        int[] arr1e = {};
        int[] arr2e = {};
        int target5 = 5;
        System.out.println("Expected: []");
        System.out.println("Actual: " + formatPairs(findPairs(arr1e, arr2e, target5)));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm findPairs() finds all
            pairs from two arrays whose sum equals the target.

            Test 1: Find Pairs Summing to Target
            Expected: Pairs like [1,6], [2,5], [3,4]
            Actual: [[1,6], [2,5], [3,4]]

            Test 2: No Pairs
            Expected: []
            Actual: []

            Test 3: Multiple Valid Pairs
            Expected: [[2,5], [4,3], [6,1]]
            Actual: [[2,5], [4,3], [6,1]]

            Test 4: Handles Negative Numbers
            Expected: Pairs summing to 1 (any valid)
            Actual: [[...valid pairs...]]

            Test 5: Empty Arrays
            Expected: []
            Actual: []
        */

    }

}


class Main {

    // WRITE LONGESTCONSECUTIVESEQUENCE METOHOD HERE //
    //                                               //
    //                                               //
    //                                               //
    //                                               //
    ///////////////////////////////////////////////////


    public static int longestConsecutiveSequence(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current = current + 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        System.out.println("These tests confirm longestConsecutiveSequence()");
        System.out.println("returns the correct length of the longest");
        System.out.println("sequence of consecutive numbers.");
        System.out.println();

        // Test 1: Typical case
        System.out.println("Test 1: Typical Sequence");
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Expected: 4 (sequence 1-4)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums1));
        System.out.println();

        // Test 2: No consecutive numbers
        System.out.println("Test 2: No Consecutive Numbers");
        int[] nums2 = {10, 30, 50};
        System.out.println("Expected: 1 (each stands alone)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums2));
        System.out.println();

        // Test 3: All numbers consecutive
        System.out.println("Test 3: All Numbers Consecutive");
        int[] nums3 = {5, 6, 7, 8, 9};
        System.out.println("Expected: 5 (sequence 5-9)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums3));
        System.out.println();

        // Test 4: Includes negatives
        System.out.println("Test 4: Handles Negatives");
        int[] nums4 = {-1, -2, -3, 0, 1};
        System.out.println("Expected: 5 (sequence -3 to 1)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums4));
        System.out.println();

        // Test 5: Empty array
        System.out.println("Test 5: Empty Array");
        int[] nums5 = {};
        System.out.println("Expected: 0");
        System.out.println("Actual: " + longestConsecutiveSequence(nums5));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm longestConsecutiveSequence()
            returns the correct length of the longest
            sequence of consecutive numbers.

            Test 1: Typical Sequence
            Expected: 4 (sequence 1-4)
            Actual: 4

            Test 2: No Consecutive Numbers
            Expected: 1 (each stands alone)
            Actual: 1

            Test 3: All Numbers Consecutive
            Expected: 5 (sequence 5-9)
            Actual: 5

            Test 4: Handles Negatives
            Expected: 5 (sequence -3 to 1)
            Actual: 5

            Test 5: Empty Array
            Expected: 0
            Actual: 0
        */

    }

}

