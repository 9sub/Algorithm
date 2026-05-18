import java.util.*;

class Solution {

    static int[] parent;
    static String[] value;

    public String[] solution(String[] commands) {
        ArrayList<String> answer = new ArrayList<>();

        parent = new int[2501];
        value = new String[2501];

        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
        }

        for (String command : commands) {
            String[] tmp = command.split(" ");

            if (tmp[0].equals("UPDATE")) {
                if (tmp.length == 4) {
                    int r = Integer.parseInt(tmp[1]);
                    int c = Integer.parseInt(tmp[2]);
                    String val = tmp[3];

                    value[find((r-1)*50+c)] = val;
                } else {
                    String val1 = tmp[1];
                    String val2 = tmp[2];

                    for (int i = 1; i <= 2500; i++) {
                        if (value[find(i)] != null && value[find(i)].equals(val1)) {
                            value[find(i)] = val2;
                        }
                    }
                }
            } else if (tmp[0].equals("MERGE")) {
                int r1 = Integer.parseInt(tmp[1]);
                int c1 = Integer.parseInt(tmp[2]);
                int r2 = Integer.parseInt(tmp[3]);
                int c2 = Integer.parseInt(tmp[4]);

                int num1 = (r1-1)*50 +c1;
                int num2 = (r2-1)*50 + c2;
                
                if(value[find(num1)] == null && value[find(num2)] != null){
                    int t = num1;
                    num1 = num2;
                    num2 = t;
                }
                union(num1, num2);
                

            } else if (tmp[0].equals("UNMERGE")) {
                int r = Integer.parseInt(tmp[1]);
                int c = Integer.parseInt(tmp[2]);

                int group = find((r-1)*50 +c);
                String val = value[group];
                
                for(int i=1;i<=2500;i++)find(i) ;
                
                for(int i=1;i<=2500;i++){
                    if(find(i) == group){
                        parent[i] = i;
                        
                        if(i == (r-1)*50+c){
                            value[i] = val;
                        }else value[i] = null;
                    }
                }
                

            } else if (tmp[0].equals("PRINT")) {
                int r = Integer.parseInt(tmp[1]);
                int c = Integer.parseInt(tmp[2]);

                String v = value[find((r-1)*50+c)];
                
                if(v == null){
                    answer.add("EMPTY");
                }else answer.add(v);
            }
        }
        
        String[] fin = new String[answer.size()];
        
        for(int i=0;i<answer.size();i++){
            fin[i] = answer.get(i);
        }

        return fin;
    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        
        if(x==y) return;
        
        value[y] = null;
        parent[y] = x;
    }
    
}