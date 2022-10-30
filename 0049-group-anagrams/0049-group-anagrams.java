class Solution {
    
    String sortValue(String value){
        char [] charArr = value.toCharArray();
        Arrays.sort(charArr);
        return new String (charArr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //stores the grou of anagrams
        Map <String, List<String>> hm = new HashMap();
        for (int i =0;i< strs.length;i++){
            String inputValue = strs[i];
            String sortedValue = sortValue(inputValue);
            
            //check that sorted value is present as key in HM
            // if present add the actual string value to existing list
            if (hm.containsKey(sortedValue)){
                hm.get(sortedValue).add(strs[i]);
            }else {
                hm.put(sortedValue, new LinkedList<String>());
                hm.get(sortedValue).add(strs[i]);
            }
        }
        
        //iterate over the map the get values
        List<List<String>> resultList = new ArrayList();
        for ( Map.Entry<String, List<String>> mapEntry: hm.entrySet()){
            resultList.add((List<String>) mapEntry.getValue());
        }
        //return resultList;
       
        return new ArrayList(hm.values());
        
    }
}