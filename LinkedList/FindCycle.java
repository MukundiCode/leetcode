/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//can use tortoise and hair algo
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;
        Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        map.put(head, 1);
        ListNode next = head.next;
        while(next != null){
            if (map.containsKey(next)){
                return true;
            }
            map.put(next,1);
            next = next.next;
        }
        return false;
        
    }
}