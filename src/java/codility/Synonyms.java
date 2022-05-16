package java.codility;

import java.util.ArrayList;
import java.util.HashSet;

/*
Synonyms
In this task, your job will be to write a program that can decide whether two words are synonyms or not. You will get a synonym dictionary describing pairs of synonymous words. Afterwards, you will answer several queries asking whether given two words are synonyms or not.

Use the following rules to decide:

If the pair of words is declared synonymous in the input, then they are synonyms.

Being synonyms doesn’t depend on order, e.g. if big is a synonym for large then large is a synonym for big.

We can derive the synonymous relationship indirectly: if big is a synonym for large and large is a synonym for huge then big is a synonym for huge.

If two words differ only by case, they are synonyms, e.g. same is a synonym for both SAmE, SAME and also same (itself).

If none of the above rules can be used to decide whether two words are synonyms, then they are not.

Note, that the input size (see below) is quite low. Therefore, you don’t need to produce the most effective algorithm possible - sure, it’s nice if you do so, but far more important is, that your code is correct, and you deliver it on time.

Input
Input starts with a number of test cases T (0 ≤ T ≤ 100). Each test case begins with a line containing a single number N (0 ≤ N ≤ 100) — the length of a synonym dictionary. On each of the following N lines, there is exactly one pair of synonyms separated by a single space. Next line contains a single number Q (0 ≤ Q ≤ 100) — number of queries. Each of the following lines contains a pair of query words separated by a single space.

Each word consists only of English alphabet letters ([a-zA-Z]) and is at most 20 characters long.

Output
For each pair of query words output either string synonyms or different.

Sample input
2
4
big large
large huge
small little
apple banana
6
same same
big huge
huge big
apple peach
big tall
peach PEACH
5
wood FORest
meadoW PrAirIe
WOOD Lumber
lumber forest
lumber forest
2
wood LUMBER
mEADOw fire
Sample output
synonyms
synonyms
synonyms
different
different
synonyms
synonyms
different
Explanation of the sample problem
In the first test-case there are 6 queries:

Words are the same.

Words are derived synonyms.

Symmetric to 2nd query.

No rule can be used to derive the synonym pair.

No rule can be used to derive the synonym pair, even though they are synonyms in English.

Words differ only in case.

2nd test case:

Defined as synonyms by 3rd rule. The case does not matter.

Different.

Example test file
For internal testing, you can download the example from above as a file:

example input

example output

Bigger test file
This is still only an example for you to test internally, don’t submit this.

bigger example input

bigger example output

Your Goal
Solve the problem for this input file and upload both the output file and all your source files.
In case you cannot download the file, enable third party cookies on your browser.

Last updated 2019-06-20 16:00:31 UTC
 */

public class Synonyms {

    public static boolean[] solution(String[][] dictionary, String[][] problems) {

        boolean[] result = new boolean[problems.length];

        // Special cases
        if (dictionary.length == 0) return result;
        if (problems.length == 0) return result;

        // All to lower case.
        for (int i = 0; i < dictionary.length; i++) {
            dictionary[i][0] = dictionary[i][0].toLowerCase();
            dictionary[i][1] = dictionary[i][1].toLowerCase();
        }
        for (int i = 0; i < problems.length; i++) {
            problems[i][0] = problems[i][0].toLowerCase();
            problems[i][1] = problems[i][1].toLowerCase();
        }

        // Build dictionary
        ArrayList<HashSet<String>> hashSetList = new ArrayList<>();

        // Add first
        HashSet<String> firstHashSet = new HashSet<>();
        firstHashSet.add(dictionary[0][0]);
        firstHashSet.add(dictionary[0][1]);
        hashSetList.add(firstHashSet);

        for (int iD = 1; iD < dictionary.length; iD++) {

            boolean found = false;
            int iCombineTo = -1;
            ArrayList<Integer> remove = new ArrayList<>();

            for (int iHS = 0; iHS < hashSetList.size(); iHS++) {

                HashSet<String> actual = hashSetList.get(iHS);

                if (!found) {

                    if (actual.contains(dictionary[iD][0]) || actual.contains(dictionary[iD][1])) {
                        actual.add(dictionary[iD][0]);
                        actual.add(dictionary[iD][1]);
                        found = true;
                        iCombineTo = iHS;
                    }

                } else {
                    if (actual.contains(dictionary[iD][0]) || actual.contains(dictionary[iD][1])) {

                        for (String str : actual) hashSetList.get(iCombineTo).add(str);
                        remove.add(iHS);
                    }
                }

            } // all hashSets

            // Remove duplicates
            if (remove.size() > 0) {
                for (int k = remove.size() - 1; k >= 0; k--) {
                    hashSetList.remove(remove.get(k).intValue());
                }
            }

            // If new Synonyms, then add.
            if (!found) {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(dictionary[iD][0]);
                hashSet.add(dictionary[iD][1]);
                hashSetList.add(hashSet);
            }
        }

        // Solve problems
        for (int i = 0; i < result.length; i++) {

            if (problems[i][0].equals(problems[i][1])) {
                result[i] = true;
            } else {
                for (HashSet<String> actual : hashSetList) {
                    if (actual.contains(problems[i][0])) {
                        if (actual.contains(problems[i][1])) {
                            result[i] = true;
                        }
                        break;
                    }
                }
            }
        }
        return result;
    }
}