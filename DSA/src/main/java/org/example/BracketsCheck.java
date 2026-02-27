package org.example;

import java.util.Stack;

public class BracketsCheck {

    public static void main(String[] args) {
        //check given snippet is valid;
        String snippet = "(( a * )(a + b))";
        System.out.println("This snippet is valid :"+ isValidSnippet(snippet));
    }

    public static boolean isValidSnippet(String exp){
        Stack<Character> stack = new Stack<>();
        for(char c:exp.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == '}' || c == ']' || c == ')'){
                Character current;
                if(stack.isEmpty()){
                    return false;
                }
                current = stack.pop();
                if(current == '{' && c != '}'
                  || current == '[' && c != ']'
                  || current == '(' && c != ')'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
