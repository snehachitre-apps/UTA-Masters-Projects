import time,datetime,os
import picamera
import os
import math, operator
import sys
from PIL import Image
import numpy as np
from skimage import data, color, io, exposure, img_as_float
from twilio.rest import TwilioRestClient 
sys.modules['Image'] = Image
from PIL import ImageChops
import boto3
from boto3.session import Session


s3 = boto3.resource('s3')
s3c = boto3.client('s3')


filename=''


todaystr=''
today = datetime.date.today()
todaystr = today.strftime('%d_%b_%Y')
print todaystr
try:
    os.makedirs('/home/pi/Images/'+todaystr+'/Changed')
    os.makedirs('/home/pi/Images/'+todaystr+'/S3')
   # print "path detected"
except OSError:
    pass



#Function to calculate entropy
def calculate_entropy(img):
    w,h = img.size #widhth and height
    a = np.array(img.convert('RGB')).reshape((w*h,3))  #Reshaping and cnverting to RGB for calculation
    h,e = np.histogramdd(a, bins=(16,)*3, range=((0,256),)*3) #height, edges calculation
    prob = h/np.sum(h) #probablity Pi
    prob = prob[prob>0] #omitting probability 0.0
    return -np.sum(prob*np.log2(prob))  #formula for entropy

def capture(counter,template):


    time.sleep(5)
    i=1
    path='/home/pi/Images/'+todaystr+'/'
    
	
	
    	
   
    for i in range(1):
        filename='image'+str(counter)+'.jpg'
	time.sleep(2)
        print 'Captured image '+filename
	   # if i==5:
	    #    break
	path='/home/pi/Images/'+todaystr+'/'
       	camera.capture('/home/pi/Images/'+todaystr+'/'+filename)
	counter=counter+1
       
	comparefile=path+filename
        #print comparefile
	    
    img1=Image.open(comparefile).convert("L")
        
    img=ImageChops.difference(template,img1)
    entropy = calculate_entropy(img)
    
    print "Entropy of difference: ",entropy
 
 

    if entropy>=1.10:
        print "change detected"
        img1.save('/home/pi/Images/'+todaystr+'/S3/'+filename)
        time.sleep(2)
        #s3.Object('raspberrypics', filename).upload_file('/home/pi/Images/'+todaystr+'/S3/'+filename)
        data = open('/home/pi/Images/'+todaystr+'/S3/'+filename, 'rb')
        #s3.Object(bucket,filename).put(Body=data)
        s3.Bucket('raspberrypics').put_object(Key=filename, Body=data)
        ACCOUNT_SID = "AC4030a422a7278c4bc47307a1f7c68e1d" 
	AUTH_TOKEN = "8130859cbc5a324898ef2af9ba3434af" 
 
	client = TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN) 
        picpath="https://s3-us-west-2.amazonaws.com/raspberrypics/"+filename
        #print "i was here"
        client.messages.create(to="+16824725436", from_="+16826220653",body="Someone was there! Have a look:http://ec2-54-213-249-61.us-west-2.compute.amazonaws.com/",) 
        img.save('/home/pi/Images/'+todaystr+'/Changed/'+'test_difference_'+str(counter)+'.jpg')
     
	    
    count=counter
     
    return count



	
if __name__ == "__main__":
    counter=1
    buffer=[]
    camera= picamera.PiCamera()
    camera.start_preview()
    camera.vflip=True
    firstiter=False
    #i=1
    print "Warming up the camera"
    camera.capture('/home/pi/Images/'+todaystr+'/warmup.jpg')
    time.sleep(2)
    print "Captured Template Image"
    camera.capture('/home/pi/Images/'+todaystr+'/template.jpg')
    path='/home/pi/Images/'+todaystr+'/'
    templatefilename=path+'template.jpg'
    template=Image.open(templatefilename).convert("L")


    while True:
        time.sleep(0.1)
        count=capture(counter,template)
        counter=count
    
    camera.stop_preview()
	        
		
        
