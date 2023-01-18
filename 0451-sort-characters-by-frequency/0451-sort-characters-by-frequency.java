class Solution {
    public String frequencySort(String s) {
        
        Map <Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }
        
        List<Character> charList = new ArrayList (countMap.keySet());
        //sort character keys according to frequency
        Collections.sort(charList, (a, b) -> countMap.get(b) - countMap.get(a));
        
        // generating output
        StringBuilder sb = new StringBuilder();
        for (char c : charList){
            int freq = countMap.get(c);
            for (int i=0;i< freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}