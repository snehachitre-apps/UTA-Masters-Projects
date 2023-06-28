import random
import pylab

def GenerateRandomNumber():
    a=random.uniform(0,1)  #store a uniformly generated number between 0.0 and 1.0 in a
    return a

if __name__=='__main__':
    
    averages200_6=list()
    for i in range(200):        
        values6=list()
        
        for i in range(6):
            app=GenerateRandomNumber()
            values6.append(app)
        
        average6=sum(values6)/len(values6) 
        #print 'mean', average6
        averages200_6.append(average6)
        
    meanofaverages200_6=sum(averages200_6)/len(averages200_6)
    print 'mean of 200 averages with 6 samples per average',meanofaverages200_6
    pylab.subplot(411)
    pylab.title("200 Samples of averages with 6 samples per average")
    pylab.hist(averages200_6,bins=50)
    pylab.show()
    
    averages200_12=list()
    for i in range(200):        
        values12=list()
        
        for i in range(12):
            app=GenerateRandomNumber()
            values12.append(app)
        
        average12=sum(values12)/len(values12) 
        averages200_12.append(average12)
        
    meanofaverages200_12=sum(averages200_12)/len(averages200_12)
    print 'mean of 200 averages with 12 samples per average',meanofaverages200_12
    
    pylab.subplot(412)
    pylab.title("200 Samples of averages with 12 samples per average")
    pylab.hist(averages200_12,bins=50)
    pylab.show()
    
    
    averages200_24=list()
    for i in range(200):        
        values24=list()
        
        for i in range(24):
            app=GenerateRandomNumber()
            values24.append(app)
        
        average24=sum(values24)/len(values24) 
        averages200_24.append(average24)
        
    meanofaverages200_24=sum(averages200_24)/len(averages200_24)
    print 'mean of 200 averages with 24 samples per average',meanofaverages200_24
    pylab.subplot(413)
    pylab.title("200 Samples of averages with 24 samples per average")
    pylab.hist(averages200_24,bins=50)
    pylab.show()
    
    averages200_48=list()
    for i in range(200):        
        values48=list()
        
        for i in range(48):
            app=GenerateRandomNumber()
            values48.append(app)
        
        average48=sum(values48)/len(values48) 
        averages200_48.append(average48)
        
    meanofaverages200_48=sum(averages200_48)/len(averages200_48)
    print 'mean of 200 averages with 48 samples per average',meanofaverages200_48
    pylab.subplot(414)
    pylab.title("200 Samples of averages with 48 samples per average")
    pylab.hist(averages200_48,bins=50)
    pylab.show()
    
    
    
   
   
   