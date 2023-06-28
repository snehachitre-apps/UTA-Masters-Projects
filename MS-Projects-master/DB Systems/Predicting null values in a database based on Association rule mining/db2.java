/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fahadf
 */
import java.util.*;
import java.io.*;
import java.lang.*;
public class db2
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
	String temp[];
	String line1;
	int m=0,n=0;
        double msupport=0,mconf=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        System.out.println("Enter name of input file");
        filename=in.readLine();
        System.out.println("Enter the min confidence:");
        mconf=Double.parseDouble(in.readLine());
	File file = new File(filename);
	BufferedReader br = new BufferedReader(new FileReader(file));
//Find the number of rows and columns
	while((line1=br.readLine())!=null)
		{
			m++;
			temp=line1.split(",");
			n=(temp.length);
		}
	br.close();
        
        String [][] arrayValues = new String [m][n];
        String [][] confarray = new String[m][2];
        String [] nullValues=new String[n];
        String [] nullPossible = new String[m];
        String [] rowValues=new String[n];
        int i,j,k,z,nulrow=9999,nulcol = 9999,totcount=0,count2=0,tempcount=0;
        double support=0,conf=0,tempconf,xyz;
        String finalnull="no value"; 
	BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
	String line;
	int row = 0;
	int col = 0;
 
	//read each line of text file
	while((line = bufRdr.readLine()) != null && row <= m)
		{	
			for(String retval:line.split(",",-1))
				{      
               				if("".equals(retval))
          					arrayValues[row][col]=null;
                  			else
						arrayValues[row][col] = retval;
                			col++;
        			}
		col = 0;
		row++;
		}
        bufRdr.close();

        complete:for(z=0;z<m;z++)
        	{   
            
            		nulrow=0;
            		nulcol = 0;
                        totcount=0;
                        count2=0;
                        support=0;
                        conf=0;
                        tempconf=0;
                        xyz=0;
                        finalnull="no value";
                        //finding the first null value
                         find_null:for(i=0;i<m;i++)
                                   {
                                       for(j=0;j<n;j++)
                                       {
                                            if(arrayValues[i][j]==null)
                                            {
                                                nulrow=i;
                                                nulcol=j;
                                                break find_null;
                                            }
                                       }
                                   }
                        if (nulrow==0 && nulcol==0)
                        break complete;
            
        //storing values from null containing row
                        for (i=0;i<n;i++)
                        {
                            if(arrayValues[nulrow][i]!=null)
                                {
                                    nullValues[i]=arrayValues[nulrow][i];
                                }
                        }             
               //comparing the nullvalues to find other such combinations in given file
                        k=0;
                        for (i=0;i<m;i++)
                        {    
                            for (j=0;j<n;j++)
                            {
                                if(arrayValues[i][j]!=null && j!=nulcol)
                                {
                                    rowValues[j]=arrayValues[i][j];
                                }
                            }   
                            for (j=0;j<n;j++)
                            {  
                                if(nullValues[j]!=null && rowValues[j]!=null && rowValues[j].equals(nullValues[j]))
                                tempcount=tempcount+1;
                            }
                            if(n<=3)
                            {
                                if (tempcount==n-1)
                                {   
                                    nullPossible[k]=arrayValues[i][nulcol];
                                    totcount=totcount+1;
                                    k=k+1;
                                }
                            }
                            else 
                                if(n>=4)
                                {
                                    if (tempcount>=n-2)
                                    {   
                                        nullPossible[k]=arrayValues[i][nulcol];
                                        totcount=totcount+1;
                                        k=k+1;
                                    }
                                }
                            for(j=0;j<n;j++)
                            rowValues[j]=null;
                            tempcount=0;
                        } 
                        //System.out.println("Totcount "+totcount);
                        support=(double)totcount/(double)m;
                       //System.out.println("Support "+support);
               
               /*System.out.println(support);
                System.out.println(totcount);
               for (j=0;j<m;j++)
               {
               System.out.println(nullPossible[j]);
               }*/
                        for(i=0;i<totcount;i++)
                        {   
                            count2=0;
                            for(j=0;j<=totcount;j++)
                            {    
                                if(nullPossible[i]!=null && nullPossible[i].equals(nullPossible[j]))
                                {
                                    count2=count2+1;                        
                                }
                            }
                            //System.out.println("count2 "+count2);
                            tempconf=(double)count2/(double)m;
                            //System.out.println("tempconf"+tempconf);
                            xyz=tempconf/support;
                            //System.out.println(xyz);
                            if(xyz>conf)
                            {
                                conf=xyz;
                                finalnull=nullPossible[i];
                            } 
                        }
               
               /*System.out.println(finalnull);
               System.out.println(support);
               System.out.println(totcount);
                    for(i=0;i<10;i++)
                   System.out.println(nullPossible[i]);*/
                      System.out.println("Confidence" +conf);
                        if (conf>=mconf)
                        arrayValues[nulrow][nulcol]=finalnull;
                      else 
                          arrayValues[nulrow][nulcol]=null;
             
                }
            
       
        
        File fileout=new File("out.csv");
        FileWriter f=new FileWriter(fileout);
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(arrayValues[i][j]==null)
                    f.write("null");
                else
                    f.write(arrayValues[i][j].toString());
                f.write(",");
            }
            f.write("\n");
        }
        f.close();
        
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.print(arrayValues[i][j]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
       
               
    }
}
      

        
        
        

    

