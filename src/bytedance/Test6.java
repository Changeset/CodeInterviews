package bytedance;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:30 2018/5/12
 * @ ModifiedBy:
 */

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:38 2018/4/4
 * @ ModifiedBy:
 */
public class Test6 {
    public  TrieNode root;
    static class dic {
        int m;
        int n;
        List<String> word;
        List<String> prefix;
        dic() {
            m = 0;
            n = 0;
            word = new ArrayList<>();
            prefix = new ArrayList<>();
        }
    }
    Test6() { root = new TrieNode(""); }
    class TrieNode {
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode() { }
        TrieNode(String word) {
            this.word = word;
        }
    }

    /** Initialize your data structure here. */


    /** Inserts a word into the trie. */
    private  void insert(String word) {
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = pNode.children.get(word.charAt(i));
            if (next != null) {
                pNode = next;
            } else {
                pNode.children.put(word.charAt(i), new TrieNode(word.substring(0, i+1)));
                pNode = pNode.children.get(word.charAt(i));
            }
        }
        pNode.children.put('\0', new TrieNode(""));
    }

    /** Returns if the word is in the trie. */
    public  boolean search(String word) {
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = pNode.children.get(word.charAt(i));
            if (next != null) {
                pNode = next;
            } else return false;
        }
        if (pNode.children.get('\0') == null) return false;
        return true;
    }

    private static void getResult(dic d) {
        Test6 t = new Test6();
        int m, n;
        m = d.m;
        n = d.n;
        List<String> word = d.word;
        List<String> prefix = d.prefix;
        for (String s : word) {
            t.insert(s);
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            String s = prefix.get(i);
            for (int j = 1; j < s.length(); j++) {
                String pre = s.substring(0, j);
                if (t.search(pre)) {
                    flag = true;
                }
            }
            if (flag) System.out.println(1);
            else System.out.println(-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<dic> input = new LinkedList<>();
        while (sc.hasNext()) {
            dic d = new dic();
            d.m = sc.nextInt();
            d.n = sc.nextInt();
            List<String> word = new ArrayList<>();
            List<String> prefix = new ArrayList<>();
            for (int i = 0; i < d.m; i++) {
                String s = sc.next();
                word.add(s);
            }
            for (int i = 0; i < d.n; i++) {
                String s = sc.next();
                prefix.add(s);
            }
            d.word = word;
            d.prefix = prefix;
            input.add(d);
        }
        for (dic d : input) {
            getResult(d);
            System.out.println();
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */