import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author JeffCar
 * @date 1/3/2021 - 12:05 PM
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] arr = new int[size];
        for (int i = 0; i<size; i++){
            arr[i] = stack.pop().val;
        }
        return arr;
    }

    public int[] reversePrint1(ListNode head){
        int len = 0;
        ListNode temp = head;
        while (temp!=null){
            len++;
            temp = temp.next;
        }
        int[] arr = new int[len];
        temp=head;
        while (temp!=null){
            arr[len-1] = temp.val;
            len--;
            temp = temp.next;
        }
        return arr;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}
