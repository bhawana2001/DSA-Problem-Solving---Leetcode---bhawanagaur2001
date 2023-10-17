import java.util.*;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph=buildGraph(equations,values);
        double[] res=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String dividend=queries.get(i).get(0);
            String divisor=queries.get(i).get(1);
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                res[i]=-1.0;
            }else{
                HashSet<String> vis=new HashSet<>();
                double[] ans={-1.0};
                double temp=1.0;
                dfs(dividend,divisor,graph,vis,ans,temp);
                res[i]=ans[0];
            }
        }
        return res;
    }
    public HashMap<String,HashMap<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        HashMap<String,HashMap<String,Double>> graph=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String dividend=equations.get(i).get(0);
            String divisor=equations.get(i).get(1);
            double value=values[i];
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            graph.get(dividend).put(divisor,value);
            graph.get(divisor).put(dividend,1.0/value);
        }
        return graph;
    }
    public void dfs(String node,String des,HashMap<String,HashMap<String,Double>> graph,   HashSet<String> vis,double[] ans,double temp){
        if(vis.contains(node))
            return;
        vis.add(node);
        if(node.equals(des)){
            ans[0]=temp;
            return;
        }
        for(Map.Entry<String,Double> map:graph.get(node).entrySet()){
            String neigh=map.getKey();
            double val=map.getValue();
            dfs(neigh,des,graph,vis,ans,temp*val);
        }
    }
}