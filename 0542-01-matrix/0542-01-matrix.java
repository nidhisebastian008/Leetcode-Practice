class Solution {
    public int[][] updateMatrix(int[][] a) {
          
        int n=a.length;
        int m=a[0].length;
        boolean[][]vis = new boolean[n][m];
        LinkedList<Integer> q= new LinkedList<>();
        int[][]dir={{0,1},{0,-1},{1,0},{-1,0}};
        for( int i=0;i<n;i++)
        {
            for( int j=0;j<m;j++)
            {
                if(a[i][j]==0)
                {
                    q.addLast(i*m+j);
                }
            }
        }
        while(q.size()!=0)
        {
            int size=q.size();
            while(size-->0)
            {
                int rval=q.removeFirst();
                int r=rval/m;
                int c=rval%m;
                for( int d=0;d<dir.length;d++)
                {
                    int newr=r+dir[d][0];
                    int newc=c+dir[d][1];
                    if(newr>=0&&newc>=0&&newr<n&&newc<m&&!vis[newr][newc]&&a[newr][newc]==1)
                    {
                        vis[newr][newc]=true;
                     a[newr][newc]=a[r][c]+1;
                        q.addLast(newr*m+newc);
                    }
                    
                }
                
                
            }
            // lvl++;
        }
        return a;

  
    }
}