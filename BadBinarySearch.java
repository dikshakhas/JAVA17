public class BadBinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Midpoint calculation is incorrect
            int mid = (left + right) / 2;  // This can cause integer overflow

            // Missing bounds check - accessing arr[mid] could lead to an exception
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 5;

        int result = binarySearch(arr, target);
        System.out.println("Element
