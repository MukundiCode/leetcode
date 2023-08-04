/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //can have 2 pointers, one slow one fast, offset by n or something
import java.util.*;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> nodes = new ArrayList<ListNode>();

        ListNode next = head;

        while (next != null){
            nodes.add(next);
            next = next.next;
        }

        ListNode toRemove = nodes.get(nodes.size() - n);

        // traverse and remove

        ListNode next2 = head;
        ListNode prev = null;

        while (next2 != null){
            if (next2 == toRemove){
                if (prev == null){
                    head = next2.next;
                } else {
                    prev.next = next2.next;
                }
                break;
            }
            prev = next2;
            next2 = next2.next;
        }
        
        return head;
    }
}