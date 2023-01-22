class Pair{
    String data ;
    int count;
    Pair(String data, int count){
        this.data = data;
        this.count = count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>();
        for (String word: wordList){
            wordSet.add(word);
        }
        
        Queue <Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        //remove from set beginWord
        wordSet.remove (beginWord);
        
        while (!q.isEmpty()){
            
            Pair tmp = q.poll();
            String word = tmp.data;
            int steps = tmp.count;
            
            if (word.equals(endWord)) return steps;
            
           
            for (int i=0;i< word.length();i++){
                for (char c ='a';c <= 'z';c++){
                    
                    char [] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=c;
                    String replaceWord = String.valueOf(replacedCharArray);
                    
                    //check if new word is found in set
                    if (wordSet.contains(replaceWord)){
                        //remove from set
                        wordSet.remove(replaceWord);
                        q.add(new Pair(replaceWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}