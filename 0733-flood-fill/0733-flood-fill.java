class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int scolor=image[sr][sc];
        if(scolor!=newColor)
            floodFillUtil(sr,sc,image,newColor,scolor);
        return image;
    }
    static int[][]dir={{0,1},{1,0},{0,-1},{-1,0}}; 
	
    static void floodFillUtil(int sr,int sc,int[][]board,int newColor,int scolor)
	{
		
		
        
        board[sr][sc]=newColor;
		for(int d=0;d<dir.length;d++)
		{
			
			int r=sr+dir[d][0];
			int c=sc+dir[d][1];
			if(isValid(r,c,board,scolor))
			{
                  
				 floodFillUtil(r, c, board,newColor,scolor);
			}
			
			
			
		}
		
        return;
		
		
	}
    static boolean isValid(int sr, int sc, int [][]board,int scolor) {
		// TODO Auto-generated method stub
		
		if(sr<0||sc<0||sr>=board.length||sc>=board[0].length||board[sr][sc]!=scolor)
		return false;
		return true;
	}
}