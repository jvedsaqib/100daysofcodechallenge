import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
        while (sc.hasNext()) {
            String input=sc.next();
        
		Stack<Character> stack = new Stack<>();
            int len = input.length();
            for(int i=0; i<input.length(); i++)
            {
                // {}()
                // ch = 
                // stack = { }
                char ch = input.charAt(i);
                if(stack.isEmpty())
                {
                    stack.push(ch);
                }else if(stack.peek() == '{' && ch == '}' || stack.peek() == '(' && ch == ')' || stack.peek() == '[' && ch == ']')
                {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
            if(stack.isEmpty())
            {
                System.out.println("true");
            }else{
                System.out.println("false");
            }
		
	}
    }}



