
import random


def GenerateRandomNumber():
    a=random.random()   #store a uniformly generated number between 0.0 and 1.0 in a
   
    x=46/((1-a)**(1/1.45))  
    
    print 'packet size is ', x
    return x

if __name__=='__main__':
    GenerateRandomNumber()
    
