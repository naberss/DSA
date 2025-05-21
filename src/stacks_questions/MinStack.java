package stacks_questions;

class MinStack {

    private int [] values;
    private int head;

    public MinStack() {
        values = new int[10];
        head = -1;
    }

    public void push(int val) {
        if(this.head == this.values.length-1){
         resize();
        }
        this.values[head+1] = val;
        this.head++;
    }

    public void pop() {
        if(head==-1){
            throw new IllegalArgumentException("Stack is empty");
        } else {
            this.head--;
        }

    }

    public int top() {
        if(this.head==-1){
            throw new IllegalArgumentException("Stack is empty");
        } else {
            return this.values[head];
        }
    }

    public int getMin() {
        if(this.head == -1){
            throw new IllegalArgumentException("Stack is empty");
        } else {
            var min = this.values[0];
            for(int i = 0; i <= this.head; i++){
               if(this.values[i] < min){
                   min = this.values[i];
               }
            }
            return min;
        }
    }

    private void resize(){
        var oldArray = this.values;
        var newArray = new int[oldArray.length*2];
        for(int  i = 0; i < oldArray.length;i++){
            newArray[i] = oldArray[i];
        }
        this.values = newArray;
    }
}