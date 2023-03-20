class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List <String>  path = new ArrayList<>();
        checkPalinPart(0, s, path, result);
        return result;
    }
    
    void checkPalinPart(int index, String s, List<String> path, List<List<String>> res){
        // base case
        if ( index == s.length()){
            res.add(new ArrayList(path));
            return;
        }
        
        //iterate for each characters of given length
       for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                checkPalinPart(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}