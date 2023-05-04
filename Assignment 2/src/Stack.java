package se.kth.abahjert;

public class Stack {
    int top=2;
    int[] stack = new int[top];
    int sp = 0;

    public void push (int value){
        if(sp < top-1) {
            stack[sp] = value;
            sp++;
        }
       else {
            int[] dynStack = new int[top*2];
            for(int i = 0; i < stack.length; i++){
                dynStack[i] = stack[i];
            }
            //System.arraycopy(stack,0,dynamicArray,0,sp);
            stack = dynStack;
            top = (top*2);
            stack[sp] = value;
            sp++;

        }

    }
    public int pop () {
       if (sp < top) {
            stack[sp] = 0;
            sp--;
            return stack[sp];
        } else {
            int[] dynStack = new int[(3 * top) / 4];
            for (int i = 0; i < stack.length; i++) {
                dynStack[i] = stack[i];
            }
            stack = dynStack;
            top = (3 * top) / 4;
            stack[sp] = 0;
            sp--;
        }
        return stack[sp];
    }
    public void printStack(){
        for (int n : stack){
            System.out.println((n)+" ");
        }
    }

}

