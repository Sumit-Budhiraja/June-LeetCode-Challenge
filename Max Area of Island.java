class Solution {
    boolean visited[][];//to keep track of already visited islands
    public int maxAreaOfIsland(int[][] grid) {
        int max_area=0;
        int row=grid.length;
        int column=grid[0].length;
        visited=new boolean[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                max_area=Math.max(max_area,area(i,j,grid));
            }
        }
        return max_area;
    }
    public int area(int i,int j,int[][] grid)
    {
        //if incase the row,col is out of bound or if it is already vistied or if it is not a island just return 0
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0 || visited[i][j])
        {
            return 0;
        }
            visited[i][j]=true;
            return (1 + area(i-1,j,grid)+area(i,j-1,grid)+area(i+1,j,grid)+area(i,j+1,grid));
    }
}