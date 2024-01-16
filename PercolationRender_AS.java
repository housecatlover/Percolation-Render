
/**
 * Renders a percolation with STD draw
 *
 * @Alex Schwartz
 * j8 12/20/21
 */
public class PercolationRender_AS
{
    public static void render(boolean[][] grid){
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        int n = grid.length;
        boolean border = true;
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setXscale(0.0, n);
        StdDraw.setYscale(0.0, n);
        StdDraw.setPenRadius((double) .5/n);
        // if (n < 20) StdDraw.setPenRadius((double) n/1000);
        // else if (n < 101) StdDraw.setPenRadius((double) n/10000);
        // else {StdDraw.setPenRadius((double) n/10000);
            // StdDraw.setCanvasSize(1000,1000);
        // }
        StdDraw.setPenColor(StdDraw.BLACK);
        if (border){
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    StdDraw.square((double) c + .5, (double) n - r - .5, .5);

                    if (!grid[r][c])
                        StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
                }
            }
        }
        else{
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    if (!grid[r][c])
                        StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
                }
            }
        }

        StdDraw.show();
    }
    
    public static void render(boolean[][] grid, int[] IDlist){
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        int n = grid.length;
        StdDraw.setXscale(0.0, n);
        StdDraw.setYscale(0.0, n);
        if (n > 100)
            StdDraw.setCanvasSize(1000,1000);
            int ID; int listPos = -1; //varibles for maneuvering IDlist
            double rgbn = 255/n; //from out of n to out of 255 for rgb
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                listPos ++;
                ID = IDlist[listPos];
                if (!grid[r][c])//if closed
                    StdDraw.setPenColor(0,0,0); //black 
                /** else if (ID == n*n)// if connected to bottom
                    StdDraw.setPenColor(130, 98, 29); //brown
                else if (ID == 1) //if connected to top
                    StdDraw.setPenColor(0, 0, 255);//blue
                */else
                    StdDraw.setPenColor(100, (int) ((ID/n)*rgbn), (int)((ID%n)*rgbn));//purple gradient by pos
                //this needs to be based on the row and col of the ID though

                StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
            }
        }
        StdDraw.show();
    }
    
    public static void render(boolean[][] grid, int[] parent, int[] sizeList){
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        int n = grid.length;
        StdDraw.setXscale(0.0, n);
        StdDraw.setYscale(0.0, n);
        if (n > 100)
            StdDraw.setCanvasSize(1000,1000);
            int ID; //double size; 
            int listPos = -1; //varibles for maneuvering IDlist
            double rgbn = 255/n; //from out of n to out of 255 for rgb
        for (int r = 0; r < n; r++){
            for (int c = 0; c < n; c++){
                listPos ++;
                ID = parent[listPos]; //group has the same ID
                //size = sizeList[ID] / (n * n); //size of the group / total possible size
                if (!grid[r][c])//if closed
                    StdDraw.setPenColor(0,0,0); //black 
                /** else if (ID == n*n)// if connected to bottom
                    StdDraw.setPenColor(130, 98, 29); //brown
                else if (ID == 1) //if connected to top
                    StdDraw.setPenColor(0, 0, 255);//blue
                */else{
                    StdDraw.setPenColor(100, (int) ((ID/n)*rgbn), (int)((ID%n)*rgbn));//green blue gradient by parent, doesn't require size
                    //StdDraw.setPenColor((int)(100 * size) + 100, (int) ((ID/n)*rgbn), (int)((ID%n)*rgbn));//green blue gradient by parent and size
                }
                //this needs to be based on the row and col of the ID though

                StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
            }
        }
        StdDraw.show();
    }


    public static void render(boolean[][] grid, boolean[][] percGrid){
        StdDraw.enableDoubleBuffering();

        StdDraw.clear();
        int n = grid.length;
        boolean border = false;
        StdDraw.setXscale(0.0, n);
        StdDraw.setYscale(0.0, n);
        if (n < 20) StdDraw.setPenRadius((double) n/1000);
        else if (n < 200) StdDraw.setPenRadius((double) n/10000);
        else border = false;
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setPenColor(StdDraw.BLACK);
        if (border){
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.square((double) c + .5, (double) n - r - .5, .5);
                    if (percGrid[r][c]) 
                        StdDraw.setPenColor(StdDraw.BLUE);  
                    else if (grid[r][c])
                        StdDraw.setPenColor(StdDraw.WHITE);   
                    StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
                }
            }
        }
        else{
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){

                    if (percGrid[r][c]) 
                        StdDraw.setPenColor(StdDraw.BLUE);  
                    else if (grid[r][c])
                        StdDraw.setPenColor(StdDraw.WHITE);  
                    else 
                        StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .5);
                }
            }
        }

        StdDraw.show();
    }

    public static void renderNew(int r, int c, int n){
        StdDraw.filledSquare((double) c + .5, (double) n - r - .5, .4);
        StdDraw.show();
    }
}
