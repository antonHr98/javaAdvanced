import java.util.*;

public class Task05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        if (input.length()%2==0) {
            for (int i = 0; i < input.length()/2; i++) {
                if (input.charAt(i) =='(' ||input.charAt(i)== '[' ||input.charAt(i)== '{'){
                    queue.offer(input.charAt(i));
                }else{
                    break;
                }
            }
            for (int i=input.length()/2;i<input.length();i++){
                if (input.charAt(i)==')'){
                    stack.push('(');
                }else if (input.charAt(i)==']'){
                    stack.push('[');
                }else if (input.charAt(i)=='}'){
                    stack.push('{');
                }else {
                    break;
                }
            }
        }else {
            System.out.println("NO");
        }
       List<Character> stackList = new ArrayList<>();
       List<Character> queueList = new ArrayList<>();
       while(!stack.isEmpty()){
           stackList.add(stack.pop());
       }
       while(!queue.isEmpty()){
           queueList.add(queue.pop());
       }
       if (stackList.equals(queueList)){
           System.out.println("YES");
       }else{
           System.out.println("NO");
       }
       scanner.close();
    }
}
