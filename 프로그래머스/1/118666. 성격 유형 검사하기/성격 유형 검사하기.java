class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = new int[4];
        
        for(int i=0;i<survey.length;i++){
            int ind = check_status(survey[i]);
            int sc = cal(choices[i]);
            
            if (survey[i].equals("TR") || survey[i].equals("FC") || survey[i].equals("MJ") || survey[i].equals("NA")) {
                sc *= -1;
            }
            
            score[ind]+= sc;
        }
        
        answer+= score[0]<=0 ? "R" : "T";
        answer+= score[1]<=0 ? "C" : "F";
        answer+= score[2]<=0 ? "J" : "M";
        answer+= score[3]<=0 ? "A" : "N";
        
        return answer;
    }
    
    public int check_status(String surv){
        if(surv.equals("RT") || surv.equals("TR")) return 0;
        else if(surv.equals("CF") || surv.equals("FC")) return 1;
        else if(surv.equals("JM") || surv.equals("MJ")) return 2;
        else if(surv.equals("AN") || surv.equals("NA")) return 3;
        return 0;
    }
    
    public int cal(int choice) {
        switch (choice) {
            case 1: return -3;
            case 2: return -2;
            case 3: return -1;
            case 5: return 1;
            case 6: return 2;
            case 7: return 3;
            default:return 0;
        }
    }
    
}