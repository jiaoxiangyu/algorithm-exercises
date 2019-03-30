package 排序;

import java.util.Arrays;

/**
 * 合并排序算法(也叫归并排序)是用分治策略实现对N个元素进行排序的算法。
 * 其基本思想是：
 * 将待排序元素分成大小大致相同 的两个子集合，分别 对两个子集合进行排序，
 * 最终将排好序的子集合合并成所要求的排好序的集合。
 */

public class 合并排序 {

	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			sort(nums, low, mid);
			// 右边
			sort(nums, mid + 1, high);
			// 左右归并
			merge(nums, low, mid, high);
			System.out.println(Arrays.toString(nums));
		}
		return nums;
	}

	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
		
		
	}

	// 归并排序的实现
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
