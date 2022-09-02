package com.github.linrongbin16.solution2;

import java.util.Objects;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode e13 = new ListNode(3);
        ListNode e14 = new ListNode(4, e13);
        ListNode e12 = new ListNode(2, e14);
        ListNode e24 = new ListNode(4);
        ListNode e26 = new ListNode(6, e24);
        ListNode e25 = new ListNode(5, e26);
        ListNode r1 = s.addTwoNumbers(e12, e25);
        printResult(r1, "r1");

        ListNode e30 = new ListNode(0);
        ListNode e40 = new ListNode(0);
        ListNode r2 = s.addTwoNumbers(e30, e40);
        printResult(r2, "r2");

        ListNode e519 = new ListNode(9);
        ListNode e529 = new ListNode(9, e519);
        ListNode e539 = new ListNode(9, e529);
        ListNode e549 = new ListNode(9, e539);
        ListNode e559 = new ListNode(9, e549);
        ListNode e569 = new ListNode(9, e559);
        ListNode e579 = new ListNode(9, e569);
        ListNode e619 = new ListNode(9);
        ListNode e629 = new ListNode(9, e619);
        ListNode e639 = new ListNode(9, e629);
        ListNode e649 = new ListNode(9, e639);
        ListNode r3 = s.addTwoNumbers(e579, e649);
        printResult(r3, "r3");
    }

    static void printResult(ListNode result, String msg) {
        if (Objects.nonNull(msg) && msg.strip().length() > 0) {
            System.out.print(String.format("%s: ", msg));
        }
        if (Objects.isNull(result)) {
            System.out.println("null");
        } else {
            while (Objects.nonNull(result)) {
                System.out.print(String.format("%d ", result.val));
                result = result.next;
            }
            System.out.println();
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int save = 0;
        ListNode head = null;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            head = new ListNode((save + l1.val + l2.val) % 10, head);
            save = (save + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (Objects.nonNull(l1)) {
            head = new ListNode((save + l1.val) % 10, head);
            save = (save + l1.val) / 10;
            l1 = l1.next;
        }
        while (Objects.nonNull(l2)) {
            head = new ListNode((save + l2.val) % 10, head);
            save = (save + l2.val) / 10;
            l2 = l2.next;
        }
        if (save > 0) {
            head = new ListNode(save, head);
        }
        ListNode result = null;
        while (Objects.nonNull(head)) {
            ListNode tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }
        return result;
    }
}