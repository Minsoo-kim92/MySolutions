package newStack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String msg = "13 DUP 4 POP 5 DUP + DUP + -";
			
			String[] splitMsg = msg.split(" ");
			MyStack ms = new MyStack();
			for(int i=0; i<splitMsg.length; i++) {
				ms.message(splitMsg[i]);
			}
			
	}

}


class MyStack{
	int index;
	int[] stack;
	
	public MyStack() {
		stack = new int[2000];
		index = -1;
	}
	
	public void message(String s) {
		if(s.equals("DUP")) {
			push(peak());
		}else if(s.equals("POP")) {
			pop();
		}else if(s.equals("+")) {
			push(pop() + pop());
		}else if(s.equals("-")) {
			push(pop() - pop());
		}else
			push(s);
	}
	public void push(int value) {
		stack[++index] = value;
	}
	public void push(String s) {
		stack[++index] = Integer.parseInt(s);
	}
	public int peak() {
		return stack[index];
	}
	public int pop() {
		return stack[index--];
	}
}