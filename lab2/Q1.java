package lab2;

/**
 * @(#)Stack.java
 */
class Array {
	private int[] itemList = null;
	private int maxLength = -1;
	private int index = -1;

	public Array() {
		itemList = new int[maxLength];
	}
	
	public Array(int maxLength) {
		this.maxLength = maxLength;
		this.itemList = new int[this.maxLength];
		this.index=0;
	}

	public void add(int element) {
		if (this.index < this.maxLength && this.index >= 0) {
			this.itemList[this.index++] = element;
		}
	}

	public int remove() {
		if (this.index < this.maxLength && this.index >= 0) {
			this.index=this.index-1;
			return this.itemList[this.index];
		}else {
			return -1;
		}
	}

	public int[] returnArray() {
		int[] retArr=new int[this.index];
		for (int i = 0; i < this.index; ++i)
			retArr[i]=this.itemList[i];
		
		return retArr;
	}	
}

class Stack {
	private Array myArr;
	
	public Stack(int maxLength) {
        this.myArr = new Array(maxLength);
    }

	public void push(int value) {
		myArr.add(value);
	}

	public int pop() {
		return myArr.remove();
	}

	public void showStack() {
		int[] stackElements = myArr.returnArray(); // Get all current elements in the stack
        System.out.print("Stack elements (LIFO order): ");

        for (int i = stackElements.length - 1; i >= 0; i--) {
            System.out.print(stackElements[i] + " ");
        }
        System.out.println();
	}
}

public class Q1 {
	public static void q1() {
		Stack myStack = new Stack(30);

		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);

		int pop1=myStack.pop();
		if (pop1 != 40) {
			System.out.println("ERROR_01: 40 expected, but "+pop1+" received!");
			return;
		}
			
		myStack.push(4711);
		int pop2=myStack.pop();
		if (pop2 != 4711) {
			System.out.println("ERROR_02: 4711 expected, but "+pop2+" received!");
			return;
		}
		
		int pop3=myStack.pop();
		if (pop3 != 30) {
			System.out.println("ERROR_03: 30 expected, but "+pop3+" received!");
			return;
		}

		myStack.showStack();
	}
}