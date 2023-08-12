class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        Queue<Pair> qu = new LinkedList<>();
        List<Pair> visited = new ArrayList<>();
        final int ref = image[sr][sc];
        final int m = image.length;
        final int n = image[0].length;

        qu.add(new Pair(sr,sc));

        while (!qu.isEmpty()){
            Pair p = qu.remove();

            if (!visited.contains(p)){
                image[p.sr][p.sc] = color;

                Arrays.asList( new Pair(p.sr + 1, p.sc), new Pair(p.sr-1, p.sc), new Pair(p.sr, p.sc-1), new Pair(p.sr, p.sc+1) ).stream()
                                .filter(pair -> isValidNeighbour(pair.sr, pair.sc, m, n))
                                .filter( pair -> image[pair.sr][pair.sc] == ref)
                                .forEach( pair -> qu.add(pair));
                visited.add(p);
            }
        }

        return image;
    }

    public static boolean isValidNeighbour(int sr, int sc, int m, int n){
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) return false;
        return true;
    }
}

class Pair{
    int sr, sc;

    public Pair(int sr, int sc){
        this.sr = sr;
        this.sc = sc;
    }

    @Override
    public boolean equals(Object o){
        return sr == ((Pair) o).sr && sc == ((Pair) o).sc;
    }

    @Override
    public String toString(){
        return "{sr: " + sr + " sc: "+ sc +"}";
    }
}