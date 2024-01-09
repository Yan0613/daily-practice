class Solution
{
public
    int findMinArrowShots(int[][] points)
    {
        Arrays.sort(points, (a, b)->Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++)
        {
            // 两个气球没有重叠部分
            if (points[i][0] > points[i - 1][1])
            {
                count++;
            }
            else
            {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}