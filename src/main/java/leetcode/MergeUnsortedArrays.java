package leetcode;

import java.util.Arrays;

public class MergeUnsortedArrays {
    public static void main(String[] args) {
        MergeUnsortedArrays merge = new MergeUnsortedArrays();
        merge.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        if (nums1.length != m) {
            impose(nums1, nums2);
        } else {
            impose(nums2, nums1);
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * Adds array2 in array1
     *
     * @param a1
     * @param a2
     */
    private void impose(int[] a1, int[] a2) {

        int i = 0;
        while (a1[i] != 0) {
            i++;
        }
        for (int x : a2) {
            a1[i++] = x;
        }
    }

    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int l = arr[i-1];
            int r = arr[i];

        }
    }
}
