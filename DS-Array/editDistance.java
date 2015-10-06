/**
 * Created by deepti on 10/6/15.
 */
public class editDistance {
    public static void main(String[] args){
        String w1 = "which";
        String w2 = "wich";
        int[][] dist = findEditDistance(w1,w2);
        for(int i=0;i< w1.length();i++){
            for(int j=0;j< w2.length();j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int[][] findEditDistance(String w1,String w2){
        int[][] dist = new int[w1.length()+1][w2.length()+1];
        for(int i=0;i<w1.length();i++){
            dist[i][0] = i;
        }
        for(int j=0;j<w2.length();j++){
            dist[0][j] = j;
        }
        char[] c1s = w1.toLowerCase().toCharArray();
        char[] c2s = w2.toLowerCase().toCharArray();
        for(int i=0;i<c1s.length;i++){
            for(int j=0;j<c2s.length;j++){
                if(c1s[i] == c2s[j]){
                    dist[i+1][j+1] = dist[i][j];
                }
                else{
                    int replace = dist[i][j]+1;
                    int insert= dist[i][j+1]+1;
                    int delete = dist[i+1][j]+1;
                    int min = replace > insert ? insert : replace;
                    min = min >delete ? delete : min;
                    dist[i+1][j+1] = min;
                }
            }
        }
        return dist;
    }
}
