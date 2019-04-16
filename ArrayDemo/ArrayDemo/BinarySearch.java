package ArrayDemo;
/*
 * 对于对于递增有序数组的二分查找
 * 对于数组
 * 线性查找复杂度O(N)
 * 二分查找复杂度O(logN)
 * 无序数组的插入复杂度O(1),删除O(N)
 * 有序数组的插入复杂度O(N),删除O(N)
 * 
 */
public class BinarySearch {
	static int find(int searchkey,int[] arr) {   
		int left=0;
		int right=arr.length-1;
		int mid;
		
		while(true) {
			mid=(left+right)/2;
			if(left>right) {
				return -1;     //can't find
			}
			else if(arr[mid]==searchkey) {
				return mid;     //find it
			}
			else {
				if(arr[mid]>searchkey) {
					right=mid-1;
				}
				else
					left=mid+1;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5,6,7,8,9};
		System.out.println(find(3,arr));
	}
}
