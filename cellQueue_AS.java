
/**
 * Stores cells for percolate checking
 *
 * Alex Schwartz
 * j8 12/20/21
 */
public class cellQueue_AS
{
    private int[] OAR;
    private int[] OAC;
    private int[] contains; //to ensure cells don't repeat
    private int length;
    private int location;
    private int n;
    public cellQueue_AS(int capacity){
        n = capacity;
        OAR = new int[n*n];
        OAC = new int[n*n];
        contains = new int[n*n];
        length = 0; location = 0;
    }

    public void addAdjacent(int r, int c){
        if (r - 1 >= 0) add(r - 1, c);
        if (c + 1 < n)  add(r, c + 1);
        if (c - 1 >= 0) add(r, c - 1);
        if (r + 1 < n)  add(r + 1, c);
    }

    public void addBelow(int r, int c){
        if (r + 1 < n)  add(r + 1, c);
    }

    //contains is just an empty list
    public void add(int r, int c){
        if (!contains(r * n + c)){
            OAR[length] = r;
            OAC[length] = c; 
            contains[location] = r * n + c;
            length++;
            location++;
        }
    }

    public void remove(){
        length--;
    }
    
    public int readOAR(int i){
        return OAR[i];
    }

    public int readOAC(int i){
        return OAC[i];
    }

    public int length(){
        return length;
    }

    private boolean contains (int value){ //N^2
        for (int i = 0; i < location; i++){
            if(contains[i] == value) return true;
        }
        return false;
    }
}
