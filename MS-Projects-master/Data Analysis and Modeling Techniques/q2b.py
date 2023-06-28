import random
import pylab


def GenerateRandomNumber(alpha,xm):
    a=random.random()   #store a uniformly generated number between 0.0 and 1.0 in a
    x=xm/((1-a)**(1/alpha))  

    return x


if __name__=='__main__':
    
    values400=list()
    values900=list()
    values1800=list()

    alpha=1.45
    xm=46
    print "Expected value of the population is", alpha*xm/(alpha-1)
    
    for i in range(400):
        app=GenerateRandomNumber(alpha,xm)
        values400.append(app)
        
      
    average400=sum(values400)/len(values400) 
    print 'average packet size of 400 samples',average400 
    pylab.subplot(311)
    pylab.title("400 Samples")
    pylab.hist(values400,bins=100)
    pylab.show()
    
    #generating for 900 samples
    for j in range(900):
        app1=GenerateRandomNumber(alpha,xm)
        values900.append(app1)
        
    average900=sum(values900)/len(values900) 
    print 'average packet size of 900 samples',average900 
    pylab.subplot(312)
    pylab.title("900 Samples")
    pylab.hist(values900,bins=100)
    pylab.show()
    
    #generating for 1800 samples
    for k in range(1800):
        app2=GenerateRandomNumber(alpha,xm)
        values1800.append(app2)

    average1800=sum(values1800)/len(values1800) 
    print 'average packet size of 1800 samples',average1800 
    pylab.subplot(313)
    pylab.title("1800 Samples")
    pylab.hist(values1800,bins=100)
    pylab.show()
    
   
    
  
    
    
    
    
