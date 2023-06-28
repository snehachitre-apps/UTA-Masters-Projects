import math
from scipy import stats



if __name__=='__main__':
    
    values=[23.65, 20.34, 18.92, 21.01, 24.61, 18.05, 23.42, 15.76,20.44, 22.07, 15.68, 27.82, 15.24, 24.28, 21.55]
    z=0.995 # z value for 99% confidance
    alpha=(1-z)
    samples_count=len(values)
    
    mean=sum(values)/len(values)
    print "mean",mean
    var=0
    for i in values:
        var+=(i-mean)**2
    
    var=var/(len(values)-1)
    sd=math.sqrt(var)
    
    t=stats.t.ppf(0.995,len(values)-1)  #t value
    #print t
    e=t*(sd/math.sqrt(len(values)))
    
    c1=mean-e
    c2=mean+e
    
    print "We are ", int(z*100),"%  confidant that the mean of the random variable is in the interval [ ",c1,",",c2,"]"
    
    
    
    
    