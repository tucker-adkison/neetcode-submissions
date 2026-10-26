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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        return mergeAllNodes(lists);
    }
    
    public ListNode mergeAllNodes(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode[] nodes;
        int index = 0;

        if (lists.length % 2 == 1) {
            nodes = new ListNode[lists.length / 2 + 1];
        } else {
            nodes = new ListNode[lists.length / 2];
        }

        int i = 0;
        while(i < lists.length - 1) {
            ListNode one = lists[i];
            ListNode two = lists[i+1];

            if (one == null && two == null) {
                i += 2;
                continue;
            } else if (one == null) {
                nodes[index] = two;
            } else if (two == null) {
                nodes[index] = one;
            } else {
                nodes[index] = mergeLists(one, two);
            }
            
            index++;
            i = i + 2;
        }

        if (lists.length % 2 == 1) {
            nodes[index] = lists[lists.length - 1];
        }

        // for(ListNode node : nodes) {
        //     ListNode head = node;
        //     while(head.next != null) {
        //         System.out.print(head.val + "->");
        //         head = head.next;
        //     }

        //     System.out.print(head.val + "\n");
        // }

        return mergeAllNodes(nodes);
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        if (list1.val < list2.val) {
            head = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
            
        ListNode curr = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode temp = new ListNode(list2.val);
                curr.next = temp;
                curr = temp;
                list2 = list2.next;
            } else if (list2 == null) {
                ListNode temp = new ListNode(list1.val);
                curr.next = temp;
                curr = temp;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    ListNode temp = new ListNode(list1.val);
                    curr.next = temp;
                    curr = temp;
                    list1 = list1.next;
                } else {
                    ListNode temp = new ListNode(list2.val);
                    curr.next = temp;
                    curr = temp;
                    list2 = list2.next;
                }
            }
        }

        return head;
    }
}
