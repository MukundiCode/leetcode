class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int back = 1;
        int front = 1;

        // for (int i = 0; i < nums.length; i++){
        //     int z = nums.length - 1 - i;
        //     if (i == 0){
        //         ans[i] = back;
        //     }
        //     else{
        //         back *= nums[i-1];
        //         ans[i] = back;
        //     }
        //     if (z < nums.length -1){
        //         front *= nums[z+1];
        //         System.out.println(i + " " + z + " " + back + " "+ front);
        //         ans[z] *= front;
        //     }
        // } 

        //first pass
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                ans[i] = back;
            }
            else{
                back *= nums[i-1];
                ans[i] = back;
            }
        } 
        //second pass
        for (int i = nums.length-1; i >=0; i-=1){
            if (i == nums.length -1){
                continue;
            }
            else {
                front *= nums[i+1];
                ans[i] *= front;
            }
        }
        return ans;
    }
}