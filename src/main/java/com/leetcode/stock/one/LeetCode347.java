package com.leetcode.stock.one;

import java.util.*;

/**
 *
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Mr.F
 * @since 2019/9/17 16:28
 **/
public class LeetCode347 {

    public static void main(String[] args) {
        LeetCode347 obj = new LeetCode347();
        obj.topKFrequent(new int[]{1,1,4,4,1,2,2,3,3,3,4,4}, 2);
    }

    // 借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
    //维护一个元素数目为 k 的最小堆
    //每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
    //如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
    //最终，堆中的 k 个元素即为前 k 个高频元素
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用哈希字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 初始化优先队列 出现次数少 先删掉
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        // 依次将元素放入优先队列 如果超过k 根据规则 将出现次数少的删除掉
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList<>();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }

    // 首先依旧使用哈希表统计频率，统计完成后，创建一个数组，将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标即可。
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
       List<Integer>[] list = new List[nums.length + 1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }


        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }



}
