class MyCalendar {

    TreeMap<Integer,Integer> treeMap;
    public MyCalendar() {
        treeMap = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Map.Entry <Integer, Integer> beforeEnd = treeMap.lowerEntry(end);
        if (beforeEnd !=null && beforeEnd.getValue() > start) return false;
        treeMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */