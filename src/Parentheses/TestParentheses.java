package Parentheses;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestParentheses {
    public static void main(String[] args) throws Exception {
        /*** Test Stack ***/
        // Create a BUnionFindferedReader to read from the input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter something: ");
        // Read a line of input from the user
        try {
            String userInput = reader.readLine();
            System.out.println("You entered: " + userInput + "\nResult : " + StackParentheses.isBalanced(userInput));
        }catch (IOException e){
            e.printStackTrace();
        }
        /*** Test Queue ***/
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        }
    }
