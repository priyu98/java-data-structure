package ArrayDemo;
/*
 * 三种简单排序的复杂度都是O(N^2)
 * 但冒泡排序>选择排序>插入排序
 */
public class Sort {
	static void bubbleSort(int[] arr) {
		int len=arr.length;
		for(int i=0;i<len-1;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	static void selectSort(int[] arr) {
		int len=arr.length;
		int min;
		for(int i=0;i<len-1;i++) {
			min=i;
			for(int j=i+1;j<len;j++) {
				if(arr[j]<arr[min]) {
					int temp=arr[j];
					arr[j]=arr[min];
					arr[min]=temp;
					min=j;
				}
			}
		}
	}
	
	static void insertSort(int[] arr) {
		int len=arr.length;
		int temp;
		for(int i=1;i<len;i++) {
			temp=arr[i];
			int j;
			for(j=i;j>0;j--) {
				if(arr[j-1]>temp) {
					arr[j]=arr[j-1];
				}
				else
					break;
			}
			arr[j]=temp;
		}
	}
	
	/*
	 * 没事写个快速排序
	 * O(NlogN)
	 */
	static void quickSort(int[] a,int left,int right) {
		int i, j, t, temp;
		if(left > right)
			return;
	    temp = a[left]; //temp中存的就是基准数
	    i = left;
	    j = right;
	    while(i != j) { //顺序很重要，要先从右边开始找
	    	while(a[j] >= temp && i < j)
	    		j--;
	    	while(a[i] <= temp && i < j)//再找右边的
	    		i++;       
	    	if(i < j)//交换两个数在数组中的位置
	    	{
	    		t = a[i];
	    		a[i] = a[j];
	    		a[j] = t;
	    	}
	    }
	    //最终将基准数归位
	    a[left] = a[i];
	    a[i] = temp;
	    quickSort(a,left, i-1);//继续处理左边的，这里是一个递归的过程
	    quickSort(a,i+1, right);//继续处理右边的 ，这里是一个递归的过程

	}
	
	public static void main(String[] args) {
		int[] arr1= {5,4,9,1,7,6,2,3,8};
		
		System.out.println("bubbleSort: ");
		bubbleSort(arr1);
		for(int i:arr1) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int[] arr2= {2,4,6,1,3,8,9,5,7};
		System.out.println("selectSort: ");
		selectSort(arr2);
		for(int i:arr2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int[] arr3= {2,4,6,1,3,8,9,5,7};
		System.out.println("insertSort: ");
		insertSort(arr3);
		for(int i:arr3) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		int[] arr4= {2,4,6,1,3,8,9,5,7,5};
		System.out.println("quicktSort: ");
		quickSort(arr4,0,9);
		for(int i:arr4) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
