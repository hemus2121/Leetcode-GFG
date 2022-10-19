class MyStack {
    Queue <Integer> q ;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // add current element as such 
        q.add(x);
          // take out all element from Q and add back to end of Q except current element i.e. qsize -1
        for (int i =0;i< q.size()-1;i++){
            q.add(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */