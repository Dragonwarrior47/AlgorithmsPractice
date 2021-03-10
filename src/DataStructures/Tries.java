package DataStructures;

public class Tries {

    static final int ALPHABET_SIZE = 26;
    static TrieNode root;
    static class TrieNode{
        TrieNode [] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
            for ( int i = 0; i< ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    static void  insert(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level<length; level++){
            index = key.charAt(level) - 'a';
            if ( pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;

    }

    static boolean search(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for ( level = 0; level < length; level++){
            index = key.charAt(level) - 'a';
            if ( pCrawl.children[index] == null){
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    static void printTrie(){
        TrieNode pCrawl = root;
        for (int i =0; i < 7; i++){
            System.out.println("Printing level="+i);
            for (int j = 0; j < 26; j++){
                if (pCrawl.children[j] != null){
                    System.out.println((char)(j + 'a'));
                    pCrawl = pCrawl.children[j];
                }
            }
        }
    }


    public static void main(String args[]){
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
//        printTrie();

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
