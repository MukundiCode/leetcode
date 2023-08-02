class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;

        if (height.length == 2){
            return getArea(height, 0, 1);
        } 

        while (end > start){
            int water = getArea(height, start, end);
            max = (water > max) ? water : max;

            if (height[start] < height[end]){
                start++;
            } else{
                end-=1;
            }
        }
        return max;
        
    }

    public static int getArea(int[] nums, int posX, int posY){
        int h = (nums[posX] < nums[posY]) ? nums[posX] : nums[posY];
        int w = posY - posX;
        return h*w;
    }
}