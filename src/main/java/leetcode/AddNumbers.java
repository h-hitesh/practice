package leetcode;

public class AddNumbers {

    public static void main(String[] args) {
        int[] x = new int[]{2, 4, 3};
        int[] y = new int[]{5, 6, 4};
        ListNode l1 = create(x, 0);
        ListNode l2 = create(y, 0);
        ListNode listNode = addNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode create(int[] arr, int index) {
        if (index == arr.length) return null;
        return new ListNode(arr[index], create(arr, index + 1));
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2) {
        return compute(l1, l2, 0);
    }

    private static ListNode compute(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry, null);
            }
            return null;
        }
        int sum = carry;
        sum += (l1 == null) ? 0 : l1.val;
        sum += (l2 == null) ? 0 : l2.val;
        carry = sum / 10;
        l1 = (l1 == null) ? null : l1.next;
        l2 = (l2 == null) ? null : l2.next;
        return new ListNode(sum % 10, compute(l1, l2, carry));
    }


    static class ListNode {
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

}
