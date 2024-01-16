/**
 * Simulates an array for perculation checking
 *
 * Alex Schwartz
 * j8 1/13/22
 */
public class Percolation_AS
{

    public static int[] mainSlow(int n){
        Percolation_AS percolat = new Percolation_AS(n);

        QuickFindUF segments = new QuickFindUF(n*n+1);

        //PercolationRender_AS.render(percolat.viewGrid());
        //StdDraw.setPenColor(StdDraw.WHITE); //allows rendering

        int row = 0; int col = 0; boolean found; boolean percolates = false;
        while (!percolates){
            found = false; 
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }

            percolat.open(row, col);

            int i = row * n + col;
            if (row == n - 1)//if it connects to the bottom just connect to the last point
                segments.union(i, n * n);
            else if (percolat.isOpen(row + 1, col))
                segments.union(i, i + n);
            if (row == 0)
                segments.union(i, 0); //if its on the top connect it to the first point
            else if(percolat.isOpen(row - 1, col))//if adjacent & open conect
                segments.union(i, i - n);
            if (col - 1 > -1 && percolat.isOpen(row, col - 1))
                segments.union(i, i - 1);
            if (col + 1 < n && percolat.isOpen(row, col + 1))
                segments.union(i, i + 1);

            //append each adjacent tile

            //unionfind add row, col & join to all adjacent blocks
            //suppose it should be reoptimized to only check new points, but that would
            //have to institute unionfind to include all blocks simultaniously
            //the current algorithm is the fastest way to check for a boolean answer
            //but this current test is very inefficient

            //PercolationRender_AS.renderNew(row, col, n);//just render, no solving

            //I would like to add a wait for the animation on smaller n
            if (segments.connected(0, n * n)) //if the top left is connected to the 
                percolates = true; //last point (the bottom row)
            PercolationRender_AS.render(percolat.viewGrid(), segments.IDlist());
            if (n < 20) StdDraw.pause(500);
            else if (n < 40) StdDraw.pause(10);
        }
        percolat.percAnimation();
        //also solves again to add colors (no shortcuts for full grid)
        return segments.IDlist();
    }
    
public static double main(int n){
        Percolation_AS percolat = new Percolation_AS(n);

        QuickFindUF segments = new QuickFindUF(n*n+1);

        //PercolationRender_AS.render(percolat.viewGrid());
        //StdDraw.setPenColor(StdDraw.WHITE); //allows rendering

        int row = 0; int col = 0; boolean found; boolean percolates = false;
        while (!percolates){
            found = false; 
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }

            percolat.open(row, col);

            //int i = OA.length(); //copied out of context
            int i = row * n + col;
            if (row == n - 1)//if it connects to the bottom just connect to the last point
                segments.union(i, n * n);
            else if (percolat.isOpen(row + 1, col))
                segments.union(i, i + n);
            if (row == 0)
                segments.union(i, 0); //if its on the top connect it to the first point
            else if(percolat.isOpen(row - 1, col))//if adjacent & open conect
                segments.union(i, i - n);
            if (col - 1 > -1 && percolat.isOpen(row, col - 1))
                segments.union(i, i - 1);
            if (col + 1 < n && percolat.isOpen(row, col + 1))
                segments.union(i, i + 1);

            //append each adjacent tile

            //unionfind add row, col & join to all adjacent blocks
            //suppose it should be reoptimized to only check new points, but that would
            //have to institute unionfind to include all blocks simultaniously
            //the current algorithm is the fastest way to check for a boolean answer
            //but this current test is very inefficient

            //PercolationRender_AS.renderNew(row, col, n);//just render, no solving

            //I would like to add a wait for the animation on smaller n
            if (segments.connected(0, n * n)) //if the top left is connected to the 
                percolates = true; //last point (the bottom row)
        }
        //percolat.percAnimation();
        //also solves again to add colors (no shortcuts for full grid)
        return (double) percolat.numberOfOpenSites()/(n*n);
    }
    
    public static double weightedMainSlow(int n){
        Percolation_AS percolat = new Percolation_AS(n);

        WeightedQuickUnionUF segments = new WeightedQuickUnionUF(n*n+1);

        //PercolationRender_AS.render(percolat.viewGrid());
        //StdDraw.setPenColor(StdDraw.WHITE); //allows rendering

        int row = 0; int col = 0; boolean found; boolean percolates = false;
        while (!percolates){
            found = false; 
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }

            percolat.open(row, col);

            int i = row * n + col;
            if (row == n - 1)//if it connects to the bottom just connect to the last point
                segments.union(i, n * n);
            else if (percolat.isOpen(row + 1, col))
                segments.union(i, i + n);
            if (row == 0)
                segments.union(i, 0); //if its on the top connect it to the first point
            else if(percolat.isOpen(row - 1, col))//if adjacent & open conect
                segments.union(i, i - n);
            if (col - 1 > -1 && percolat.isOpen(row, col - 1))
                segments.union(i, i - 1);
            if (col + 1 < n && percolat.isOpen(row, col + 1))
                segments.union(i, i + 1);

            //append each adjacent tile

            //unionfind add row, col & join to all adjacent blocks
            //suppose it should be reoptimized to only check new points, but that would
            //have to institute unionfind to include all blocks simultaniously
            //the current algorithm is the fastest way to check for a boolean answer
            //but this current test is very inefficient

            //PercolationRender_AS.renderNew(row, col, n);//just render, no solving

            //I would like to add a wait for the animation on smaller n
            if (segments.connected(0, n * n)) //if the top left is connected to the 
                percolates = true; //last point (the bottom row)
            PercolationRender_AS.render(percolat.viewGrid(), segments.getParent(), segments.getSize());
            if (n < 20) StdDraw.pause(500);
            else if (n < 40) StdDraw.pause(10);
        }
        //percolat.percAnimation();
        //also solves again to add colors (no shortcuts for full grid)
        return (double) percolat.numberOfOpenSites()/(n*n);
    }
    
    public static double weightedMain(int n){
        Percolation_AS percolat = new Percolation_AS(n);

        WeightedQuickUnionUF segments = new WeightedQuickUnionUF(n*n+1);

        //PercolationRender_AS.render(percolat.viewGrid());
        //StdDraw.setPenColor(StdDraw.WHITE); //allows rendering

        int row = 0; int col = 0; boolean found; boolean percolates = false;
        while (!percolates){ //the whole thing is here, the rest is picking spaces
            found = false; 
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }

            percolat.open(row, col);

            //int i = OA.length(); //copied out of context
            int i = row * n + col;
            if (row == n - 1)//if it connects to the bottom just connect to the last point
                segments.union(i, n * n);
            else if (percolat.isOpen(row + 1, col))
                segments.union(i, i + n);
            if (row == 0)
                segments.union(i, 0); //if its on the top connect it to the first point
            else if(percolat.isOpen(row - 1, col))//if adjacent & open conect
                segments.union(i, i - n);
            if (col - 1 > -1 && percolat.isOpen(row, col - 1))
                segments.union(i, i - 1);
            if (col + 1 < n && percolat.isOpen(row, col + 1))
                segments.union(i, i + 1);

            //append each adjacent tile

            //unionfind add row, col & join to all adjacent blocks
            //suppose it should be reoptimized to only check new points, but that would
            //have to institute unionfind to include all blocks simultaniously
            //the current algorithm is the fastest way to check for a boolean answer
            //but this current test is very inefficient

            //PercolationRender_AS.renderNew(row, col, n);//just render, no solving

            //I would like to add a wait for the animation on smaller n
            if (segments.connected(0, n * n)) //if the top left is connected to the 
                percolates = true; //last point (the bottom row)
        }
        //percolat.percAnimation();
        //also solves again to add colors (no shortcuts for full grid)
        return (double) percolat.numberOfOpenSites()/(n*n);
    }

    public static double mainAnimatedFast(int n){
        Percolation_AS percolat = new Percolation_AS(n);

        QuickFindUF segments = new QuickFindUF(n*n+1);
        for (int i = 0; i < n; i++){//the first row is all connected to the top
            if(percolat.isOpen(0,i))
                segments.union(0, i); //connecting all open in top row to 0
        }

        PercolationRender_AS.render(percolat.viewGrid());
        StdDraw.setPenColor(StdDraw.WHITE); //allows rendering

        int row = 0; int col = 0; boolean found; boolean percolates = false;
        while (!percolates){ //the whole thing is here, the rest is picking spaces
            found = false; 
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }

            percolat.open(row, col);

            //int i = OA.length(); //copied out of context
            int i = row * n + col;
            if (row == n - 1)//if it connects to the bottom just connect to the last point
                segments.union(i, n * n);
            else if (percolat.isOpen(row + 1, col))
                segments.union(i, i + n);
            if (row == 0)
                segments.union(i, 0); //if its on the top connect it to the first point
            else if(percolat.isOpen(row - 1, col))//if adjacent & open conect
                segments.union(i, i - n);
            if (col - 1 > -1 && percolat.isOpen(row, col - 1))
                segments.union(i, i - 1);
            if (col + 1 < n && percolat.isOpen(row, col + 1))
                segments.union(i, i + 1);

            //append each adjacent tile

            //unionfind add row, col & join to all adjacent blocks
            //suppose it should be reoptimized to only check new points, but that would
            //have to institute unionfind to include all blocks simultaniously
            //the current algorithm is the fastest way to check for a boolean answer
            //but this current test is very inefficient

            PercolationRender_AS.renderNew(row, col, n);//just render, no solving

            //I would like to add a wait for the animation on smaller n
            if (segments.connected(0, n * n)) //if the top left is connected to the 
                percolates = true; //last point (the bottom row)
        }
        percolat.percAnimation();
        //also solves again to add colors (no shortcuts for full grid)
        return (double) percolat.numberOfOpenSites()/(n*n);
    }

    public static int mainProb(int n, double p){
        Percolation_AS percolat = new Percolation_AS(n);
        int row = 0; int col = 0; boolean found;
        for (int i = 0; i < n * n * p; i++){
            found = false;
            while(!found){
                row = (int) (Math.random() * (n));
                col = (int) (Math.random() * (n));
                if (percolat.isFull(row, col)) found = true;
            }
            percolat.open(row, col);
        }
        percolat.percAnimation();
        //percolat.percAnimationFast();
        //System.out.println(percolat.percolates());
        //also solves again to add colors (no shortcuts for full grid)
        return percolat.numberOfOpenSites();
    }

    private boolean[][] grid;
    private int count = 0;
    private int n;
    public Percolation_AS(int N){
        grid = new boolean[N][N]; 
        n = N;
    }

    public void open(int row, int col){
        grid[row][col] = true;
        count++;
    }

    public boolean isOpen(int row, int col){
        return grid[row][col];
    }

    public boolean isFull(int row, int col){
        return !grid[row][col];
    }

    public int numberOfOpenSites(){
        return count; 
    }

    public boolean percolates(){
        cellQueue_AS OA = new cellQueue_AS(n); //a list of coords that doesn't allow repeats

        for (int i = 0; i < n; i++){//the first row is all connected to the top
            if (grid[0][i]){
                OA.addBelow(0, i);
            }
        }

        int cell, row, col;
        int i = OA.length();
        while (i > 0){
            i = OA.length();
            row = OA.readOAR(i);
            col = OA.readOAC(i);
            if(grid[row][col]){//if its open
                if (row == n - 1) return true; //if on bottom row
                OA.addAdjacent(row, col);
                //append each adjacent tile
            }
            OA.remove();
        }

        return false;
    }

    public boolean[][] percolatesView(){
        cellQueue_AS OA = new cellQueue_AS(n); //a list of coords that doesn't allow repeats
        boolean[][] percGrid = new boolean[n][n];

        for (int i = 0; i < n; i++){//the first row is all connected to the top
            OA.add(0, i);
        }

        int cell, row, col;
        int i = OA.length();
        while (i > 0){
            i = OA.length();
            row = OA.readOAR(i);
            col = OA.readOAC(i);
            if(grid[row][col]){//if its open
                percGrid[row][col] = true;
                OA.addAdjacent(row, col);
                //append each adjacent tile
            }
            OA.remove();
        }
        return percGrid;
    }

    public void percAnimation(){
        cellQueue_AS OA = new cellQueue_AS(n); //a list of coords that doesn't allow repeats

        for (int i = 0; i < n; i++){//the first row is all connected to the top
            OA.add(0, i);
        }
        PercolationRender_AS.render(grid);
        StdDraw.setPenColor(StdDraw.BLUE);
        int cell, row, col;
        int i = OA.length();
        while (i > 0){
            i = OA.length();
            row = OA.readOAR(i);
            col = OA.readOAC(i);
            if(grid[row][col]){//if its open
                if (row == n - 1) return;
                PercolationRender_AS.renderNew(row, col, n);
                //StdDraw.pause(0);
                OA.addAdjacent(row, col);
            }
            OA.remove();
        }
    }

    public void percAnimationFast(){
        StdDraw.setCanvasSize(800, 800);
        cellQueue_AS OA = new cellQueue_AS(n); //a list of coords that doesn't allow repeats
        boolean[][] percGrid = new boolean[n][n];

        for (int i = 0; i < n; i++){//the first row is all connected to the top
            OA.add(0, i);
            percGrid[0][i] = true;
        }
        PercolationRender_AS.render(grid, percGrid);
        StdDraw.setPenColor(StdDraw.BLUE);
        int cell, row, col;
        int i = OA.length();
        while (i > 0){
            i = OA.length();
            row = OA.readOAR(i);
            col = OA.readOAC(i);
            if(grid[row][col]){//if its open
                percGrid[row][col] = true;
                if (row == n - 1) break;
                //StdDraw.pause(0);
                OA.addAdjacent(row, col);
            }
            OA.remove();
        }

        PercolationRender_AS.render(grid, percGrid);
    }

    public boolean[][] viewGrid(){
        return grid;
    }

}
