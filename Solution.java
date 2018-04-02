package leetcode447;
// 447. Number of Boomerangs
// 时间复杂度： O(n^2)
// 空间复杂度： O(n)
import java.util.HashMap;
public class Solution {
	public int numberOfBoomerangs(int[][] points){
		int result = 0;
		for (int i =0; i < points.length; i++){
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = 0; j < points.length; j++){
				if (j != i){
					int dis = dis(points[i],points[j]);
					if (map.containsKey(dis)){
						map.put(dis, map.get(dis) + 1);
					}else {
						map.put(dis, 1);
					}
				}
			}
			
			for (Integer dis : map.keySet()){
				result += map.get(dis) *(map.get(dis) -1);
			}
		}
		
		return result;
	}
	private int dis(int[] pa, int pb[]){
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
               (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println((new Solution()).numberOfBoomerangs(points));
    }
}