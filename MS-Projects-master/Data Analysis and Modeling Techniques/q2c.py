import math
import random
import pylab

def GenerateRandomNumber():
    a=random.random()   #store a uniformly generated number between 0.0 and 1.0 in a
    x=-(math.log(1-a)/0.27)
    #print 'x is ', x
    return x

if __name__=='__main__':
    
    values20=list()
    values60=list()
    values150=list()
    
    variance20=0
    variance60=0
    variance150=0
    skewness20=0
    skewness60=0
    skewness150=0
    
    #GenerateRandomNumber()
    for i in range(20):
        app=GenerateRandomNumber()
        values20.append(app)
        
    mean20=sum(values20)/len(values20) 
    for i in values20:
        variance20 += (i-mean20) ** 2
        skewness20 += (i-mean20) ** 3   
    variance20=variance20/(len(values20)-1)
    
    skewness20=(skewness20/(math.sqrt(variance20))**3)/len(values20)
    
    print 'mean of 20 samples',mean20 
    print 'variance of 20 samples',variance20 
    print 'skewness of 20 samples',skewness20
    pylab.subplot(311)
    pylab.title("20 Samples")
    pylab.hist(values20,bins=50)
    pylab.show()
    
    #generating for 60 samples
    for j in range(60):
        app1=GenerateRandomNumber()
        values60.append(app1)
        
   
    mean60=sum(values60)/len(values60) 
    for i in values60:
        variance60 += (i-mean60) ** 2
        skewness60 += (i-mean60) ** 3  
    variance60=variance60/(len(values60)-1)
    skewness60=(skewness60/(math.sqrt(variance60))**3)/len(values60)
    
    print 'mean of 60 samples',mean60 
    print 'variance of 60 samples',variance60 
    print 'skewness of 60 samples',skewness60
    pylab.subplot(312)
    pylab.title("60 Samples")
    pylab.hist(values60,bins=50)
    pylab.show()
    
    #generating for 1800 samples
    for k in range(150):
        app2=GenerateRandomNumber()
        values150.append(app2)

    mean150=sum(values150)/len(values150)
    for i in values150:
        variance150 += (i-mean150) ** 2
        skewness150 += (i-mean150) ** 3 
    
    variance150=variance150/(len(values150)-1)
    skewness150=(skewness150/(math.sqrt(variance150))**3)/len(values150)
    
    print 'mean of 150 samples',mean150 
    print 'variance of 150 samples',variance150 
    print 'skewness of 150 samples',skewness150
    pylab.subplot(313)
    pylab.title("150 Samples")
    pylab.hist(values150,bins=50)
    pylab.show()
    
    
    
  
    
    
    
    
