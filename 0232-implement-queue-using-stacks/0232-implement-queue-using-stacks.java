class MyQueue {
    
    Stack <Integer> ist = null;
    Stack <Integer> ost = null;

    public MyQueue() {
        ist = new Stack();
        ost = new Stack();
    }
    
    public void push(int x) {
        ist.push(x);
    }
    
    public int pop() {
        // push all element from input stack to output stack if that is empty
        if (ost.isEmpty()){
            while (!ist.isEmpty()){
                ost.push(ist.pop());
            }
        }
        return ost.pop();
    }
    
    public int peek() {
        // push all element from input stack to output stack if that is empty
        if (ost.isEmpty()){
            while (!ist.isEmpty()){
                ost.push(ist.pop());
            }
        }
        return ost.peek();
        
    }
    
    public boolean empty() {
        return ist.isEmpty() && ost.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */