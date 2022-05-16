package interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

Last updated 2022-05-16
 */

public class SynonymsTask {

    public static void main(String[] args) {

        String[] input = {"big large", "large huge", "small little", "apple banana"};

        HashMap<String, Set<String>> dictionary = processInput(input);

        String[] problems = {"same same", "big huge", "huge big", "apple peach", "big tall", "peach PEACH"};

//        System.out.println(dictionary);

        printSynonymity(dictionary, problems);
    }

    private static void printSynonymity(HashMap<String, Set<String>> dictionary, String[] problems) {

        boolean[] result = new boolean[problems.length];

        if (dictionary.isEmpty()) return;
        if (problems.length == 0) return;

        for (var data : problems) {
            var pair = data.split(" ");
            var left = pair[0];
            var right = pair[1];

            if (left.equalsIgnoreCase(right)) {
                System.out.printf("%s -> synonyms \n", data);
                //System.out.printf("synonyms \n");
                continue;
            }

            var setOfSynonyms = dictionary.get(left);

            if (setOfSynonyms.stream().anyMatch(synonym ->
                    synonym.equalsIgnoreCase(right))) {
                System.out.printf("%s -> synonyms\n", data);
                //System.out.printf("synonyms \n");
                continue;
            }

            System.out.printf("%s -> different\n", data);
            //System.out.printf("different \n");
        }
    }

    private static HashMap<String, Set<String>> processInput(String[] inputs) {
        HashMap<String, Set<String>> dictionary = new HashMap<>();

        for (String input : inputs) {
            var pair = input.split(" ");
            var x = pair[0];
            var y = pair[1];

            Set<String> values = new HashSet<>();
            values.add(x);
            values.add(y);

            for (String otherInput : inputs) {
                var otherPair = otherInput.split(" ");
                var a = otherPair[0];
                var b = otherPair[1];

                if (x.equalsIgnoreCase(a) || x.equalsIgnoreCase(b) || y.equalsIgnoreCase(a) || y.equalsIgnoreCase(b)) {
                    values.add(a);
                    values.add(b);
                }
            }
            dictionary.put(x, values);
            dictionary.put(y, values);
        }

        return dictionary;
    }
}