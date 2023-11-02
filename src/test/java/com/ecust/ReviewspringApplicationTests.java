package com.ecust;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class ReviewspringApplicationTests {

    @Test
    void contextLoads() {
        int[] nums={1,1,1};
        System.out.println(subarraySum(nums, 2));

    }
    public int subarraySum(int[] nums, int k) {
        if(nums==null&&nums.length==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            sum=+nums[i];
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            if(map.containsKey(sum-k)){
                count++;
            }
        }
        return count;
    }

}
