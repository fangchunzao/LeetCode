package com.leetcode.stock.one;

/**
 * 1013. 将数组分成和相等的三个部分
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode1013 {

    public static void main(String[] args) {
        LeetCode1013 obj = new LeetCode1013();
        System.out.println(obj.canThreePartsEqualSum(new int[]{0}));
    }

    // 双指针
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) return false;
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }
        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while(left + 1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if(leftSum != sum/3){
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if(rightSum != sum/3){
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }


    // 回溯 穷举 超出时间限制
    public boolean canThreePartsEqualSum1(int[] A) {
        if (A == null || A.length < 3) return false;
        return canThreePartsEqualSum1(A, 0,0,0);
    }


    public boolean canThreePartsEqualSum1(int[] A, int count, int index, int sum) {
        if (count == 3 && index == A.length)
            return true;
        if (count == 3 && index < A.length)
            return false;

        int tempSum = 0;
        for (int i = index;i < A.length; i++) {
            tempSum += A[i];
            // 第一回
            if (count == 0) {
                sum = tempSum;

            }
            // 判断
            if (sum == tempSum) {
                boolean flag = canThreePartsEqualSum1(A, count + 1, i + 1, sum);
                if (flag) return true;
            }
        }
        return false;
    }




}
