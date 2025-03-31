import java.util.*;



public class problem1 {
    // Time Complexity: O(2^n)
    // Space Complexity: O(2^n *n)

    //BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> result= new ArrayList<>();
        if (s==null || s.length()==0)
        {
            return result;
        }
        Queue<String> q= new LinkedList<>();
        q.add(s);

        HashSet<String> set= new HashSet<>();
        set.add(s);
        boolean flag=false;
        while (!q.isEmpty())
        {
            int size= q.size();
            for (int i=0;i<size;i++)
            {
                String curr=q.poll();
                if (isValid(curr))
                {
                    result.add(curr);
                    flag=true;
                }
                else {
                    if(!flag)
                    {
                        for (int k=0;k<curr.length();k++)
                        {
                            if (Character.isAlphabetic(curr.charAt(k))){
                                continue;
                            }
                            else {
                                String baby= curr.substring(0,k) + curr.substring(k+1);
                                if (!set.contains(baby))
                                {
                                    set.add(baby);
                                    q.add(baby);
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
    private  boolean isValid(String s)
    {
        int count=0;
        for (char c: s.toCharArray())
        {
            if (Character.isAlphabetic(c)){continue;}
            if (c=='('){count++;}
            else {
                count--;
            }
        }
        if (count<0){
            return false;
        }
        return count==0;
    }

    // DFS
    HashSet<String> set;
    int maxlength=0;
    List<String> result;
    public List<String> removeInvalidParentheses1(String s) {
       this.result=new ArrayList<>();
        this.set= new HashSet<>();
        if (s==null || s.length()==0)
        {
            return result;
        }
        dfs(s);
        return result;
    }
    private void dfs(String curr)
    {
        // base case
        if (curr.length()<maxlength){return;}
        if (isValid(curr))
        {
            if (curr.length()> maxlength)
            {
                maxlength= curr.length();
                result.clear();
            }
            result.add(curr);
        }
        // logic
        for(int k=0;k<curr.length();k++)
        {
            if (Character.isAlphabetic(curr.charAt(k))){continue;}
            String baby= curr.substring(0,k) + curr.substring(k+1);
            if(!set.contains(baby))
            {
                set.add(baby);
                dfs(baby);
            }
        }

    }
}
