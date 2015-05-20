import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.InputMismatchException;

import java.util.Stack;

public class Solution {
    private Stack <Integer> stack;
    public Solution() 
    {
        stack = new Stack<Integer>();
    }

    public static void main(String[] args) {
        String stdin=null;
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
		BufferedReader br = 
                      new BufferedReader(new InputStreamReader(System.in));
 
		String input;
 
		while((input=br.readLine())!=null){
			if(stdin!=null){
            stdin+=","+input;
            }else{
                stdin=input;
            }
		}
        
 
	}catch(IOException io){
		io.printStackTrace();
	}
       String [] info = stdin.split(",");
       String [] deep = new String[info.length * 2] ;
        
     int k = 2;
     for (int i = 0; i<=info.length-1;i++){
         String [] temp=info[i].split(" ");
         if(deep[0]==null){
         deep[i]=temp[0];
         deep[i+1]=temp[1];
         }else{
            
             deep[k]=temp[0];
             deep[k+1]=temp[1];
             k+=2;
         
         
         }
      
        
        
     }
          
        
        int [] data = new int [deep.length];
        int x = 0;
        while(x<data.length){
            data[x]=Integer.parseInt(deep[x]);
            x++;
        }
        
        int number_of_nodes = Integer.parseInt(deep[0]);
        
        if((number_of_nodes%2)!= 0){
            System.out.println(0);
        }
        
        
        int [][] matrix = new int [info.length+1][info.length+1];
        
        x=2;
        while (x <data.length-1){
            matrix[data[x]][data[x+1]]=1;
            matrix[data[x+1]][data[x]]=1;
            x+=2;
            
        }
        
       
          
        Solution s = new Solution();
        s.dfs(matrix,1);
       
        
        
       
      
        
        
       
       
       
  }
    
 
    public  void dfs(int adjacency_matrix[][], int source)
    {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int pre=1, post=0, cuts=0;
 
        int visited[] = new int[number_of_nodes + 1];	
        int postNum[] = new int[number_of_nodes+1];
        int preNum[] = new int[number_of_nodes +1];
        int element = source;		
        int i = source;		
        //System.out.print(element + "\t");		
        visited[source] = 1;	
        preNum[1]=1;
        stack.push(source);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element;	
           
	    while (i <= number_of_nodes)
	    {
     	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
	        {       
                   stack.push(i);
                    preNum[stack.peek()]= pre +1;
                   pre++;
                   visited[i] = 1;
                    
                   
                    element = i;
                    i = 1;
                    //System.out.print(element + "\t");
                    
	            continue;
                }
           
                i++;
	    } 
            post = pre +1;
            pre = post ;
            
            
            
            postNum[stack.peek()]= post;
            int magic = (((postNum[stack.peek()]-preNum[stack.peek()])-1)/2);
            //System.out.println(magic);
            if(magic%2 == 1){
                cuts++;
            }
            stack.pop();
            
        }	
        
       /* for(int k =0; k<postNum.length;k++){
            System.out.println(preNum[k]+","+postNum[k]);
        } */
        System.out.println(cuts-1);
    }
    
    
    }