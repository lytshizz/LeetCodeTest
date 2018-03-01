package com.yst.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author Administrator
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		TwoSum twoSum = new TwoSum();
		int arr[] = twoSum.twoSum(nums, target);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	
	/**
	 * 方法一：直接通过冒泡进行遍历查看，时间复杂度为o（n^2），不建议使用
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSums(int[] nums, int target) {
		int[] arr = new int[2];        
		int size = nums.length;
		boolean flag = false;
		int sum = 0;
		for(int i = 0; i < size && !flag; i++) {
			for(int j = i+1; j <size; j++) {
				sum = nums[i] + nums[j];               
				if(sum == target) {
					arr[0] = i;
					arr[1] = j;
					flag = true;
				}
			}
		}
		return arr;
	}
	
	/** 
	 * 方法二：使用map进行判断，此方法的时间复杂度为o(nlogn),推荐使用
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int arr[] = new int[2];
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				arr[0] = map.get(target - nums[i]);
				arr[1] = i;
				break;
			}
			else {
				map.put(nums[i], i);
			}
		}
		return arr;
	}
}
