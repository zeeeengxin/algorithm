package leetcode;
import sun.text.normalizer.Trie;

import java.util.*;

public class LC212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = createTrie(words);
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // printAllWords(root);

                dfs(i, j, board, res, root, root, cur);
                // System.out.println("----next round----");
            }
        }
        // System.out.print(res);
        return res;
    }
    private void printAllWords(TrieNode root) {
        StringBuilder sb = new StringBuilder();
        printHelper(root, sb);
    }
    private void printHelper(TrieNode cur, StringBuilder sb) {
        if (cur.isWord) {
            System.out.println(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                char child = (char)('a' + i);
                sb.append(child);
                printHelper(cur.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    private void dfs(int row, int col, char[][] board, List<String> res, TrieNode root, TrieNode cur, StringBuilder sb) {
        char ch = board[row][col];

        if (board[row][col] == '#' || cur.children[ch - 'a'] == null) {
            return;
        }
        sb.append(ch);
        cur = cur.children[ch - 'a'];
        if (cur.isWord) {
            res.add(sb.toString());
            deleteWord(root, sb.toString());
            // System.out.println("found word " + sb.toString());
        }
        board[row][col] = '#';
        if (row < board.length - 1) {
            dfs(row + 1, col, board, res, root, cur, sb);
        }
        if (row > 0) {
            dfs(row - 1, col, board, res, root, cur, sb);
        }
        if (col > 0) {
            dfs(row, col - 1, board, res, root, cur, sb);
        }
        if (col < board[0].length - 1) {
            dfs(row, col + 1, board, res, root, cur, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        board[row][col] = ch;
    }
    private void deleteWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                return;
            }
            cur = cur.children[i];
        }
        cur.isWord = false;
//        for (TrieNode child : cur.children) {
//            if (child != null) {
//                return;
//            }
//        }
        while (cur != null && !cur.isWord) {
            for (TrieNode child : cur.children) {
                if (child != null) {
                    return;
                }
            }
            TrieNode p = cur.parent;
            if (p != null) {
                p.children[cur.index] = null;

            }
            cur = p;
        }
    }
    private void insertWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode(cur, i);
            }
            cur = cur.children[i];
        }
        cur.isWord = true;
    }
    private TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode(null, 0);
        for (String word : words) {
            insertWord(root, word);
        }
        return root;
    }
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode parent;
        int index;
        TrieNode(TrieNode p, int i) {
            parent = p;
            index = i;
        }
    }
}
