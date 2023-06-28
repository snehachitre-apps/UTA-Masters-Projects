import math
from scipy import stats
 
if __name__=='__main__':

    values=[23.65, 20.34, 18.92, 21.01, 24.61, 18.05, 23.42, 15.76,20.44, 22.07, 15.68, 27.82, 15.24, 24.28, 21.55]
    N=len(values)
    ret=0.0500
   
    z=0.975
    alpha=(1-z)
    #samples_count=len(values)
    
    mean=sum(values)/len(values)
    print "mean",mean
    var=0
    
    for i in values:
        var+=(i-mean)**2
    
    var=var/(len(values)-1)
    sd=math.sqrt(var)
    
    tval=stats.t.ppf(0.975,N-1)  #t value
    #rel_e=0
    print "tval",tval
    e=(tval*sd/mean*math.sqrt(len(values)))
    print e
    rel_e=e/mean
    print rel_e
    count=1
    if rel_e > ret:
        
        N=int(math.pow((tval*sd/mean*ret),2)*1.1)
        count+=1
        
    print "Number of simulations ",count

   
 
            
    
        
        
    
    
    
   # print "required number of simulations: ",n
    
    
   