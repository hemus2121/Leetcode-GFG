class Solution {
    public String simplifyPath(String path) {
        if (path==null ) return null;
        Stack<String> stack = new Stack<>();
        // Split the input
        String [] data= path.split ("/");
        for (String s : data){
            if (s.equalsIgnoreCase(".") || s.equalsIgnoreCase(""))
                continue;
            else if (s.equalsIgnoreCase("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else stack.push(s);
        }

        // Final Step - Alternative way of appending final result
        //List<String> list = new ArrayList(stack);
        // return "/" + String.join("/", list);

        // Final Step - this to avoid TLE since it was happening for too larger input
        String res="";
        while (!stack.isEmpty()){
            String res1 = "/"+stack.pop();
            res = res1 +res;
        }
        return res==""? "/":res;
        
    }
}