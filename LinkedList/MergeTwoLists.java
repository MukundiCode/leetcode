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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode ans;

        if (list1.val < list2.val){
            ans =  new ListNode(list1.val);
            list1 = list1.next;
        } else {
            ans =   new ListNode(list2.val);
            list2 = list2.next; 
        }
        ListNode head = ans;

        while (true){
            if (list1 == null){
                ans.next = list2;
                break;
            }
            if (list2 == null){
                ans.next = list1;
                break;
            }
            if (list1.val < list2.val){
                ans.next =  new ListNode(list1.val);
                list1 = list1.next;
            } else {
                ans.next =   new ListNode(list2.val);
                list2 = list2.next; 
            }
            ans = ans.next;
        }

        return head;
    }

}