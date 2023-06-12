public class BinarySearch {

	//classic binary search, return target index, or -1
	public static int searchTarget(int[] num, int target) {
		int left = 0, right = num.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (num[mid] == target) return mid;
			else if (num[mid] > target) {
				right = mid - 1;
			} else if (num[mid] < target) {
				left = left + 1;
			}
		}
		return -1;
	}

	//find insertion index, return target index, or index for insertion
	public static int searchInsertion(int[] num, int target) {
		int left = 0, right = num.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (num[mid] >= target) {
				//check first bound
				if (mid == 0 || num[mid - 1] < target) {
					//mid need to >= target and mid-1 < target
					return mid;
				} else {
					right = right - 1;
				}
			} else if (num[mid] < target) {
				left = left + 1;
			}
		}
		//target > all the numbers in array, so return last index +1
		return num.length;
	}

	//search left bound, if exists, return leftmost index of target
	// else, return the insert position.
	public static int leftBound(int[] num, int target) {
		int left = 0, right = num.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (num[mid] == target) {
				right = mid - 1;
			} else if (num[mid] > target) {
				right = mid - 1;
			} else if (num[mid] < target) {
				left = mid + 1;
			}

		}

		if (left >= num.length) return num.length;
		return left;
	}

	//search right bound, if exists, return leftmost index of target
	//or
	public static int rightBound(int[] num, int target) {
		int left = 0, right = num.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
//			System.out.println(" left: " + left + " mid: " + mid + " right: " + right);
			if (num[mid] == target) {
				left = mid + 1;
			} else if (num[mid] > target) {
				right = mid - 1;
			} else if (num[mid] < target) {
				left = mid + 1;
			}

		}

		if (right < 0) return -1;
		if (num[right] != target) return -1;
		return right;
	}

}
