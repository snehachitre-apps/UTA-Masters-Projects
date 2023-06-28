#Name: Sneha S Chitre
#ID:  1001244953
#Lab number 3


from flask import Flask,render_template,request, redirect, url_for,session,flash
import requests
import boto3
from boto3.session import Session
import botocore
import os
urls=[]
url=""
s3=boto3.resource('s3')
client=boto3.client('s3')
#s3.create_bucket(Bucket='snehachitrebucket2',CreateBucketConfiguration={'LocationConstraint': 'us-west-2'})
filename=""
bucket = s3.Bucket('raspberrypics')
#exists = True

app = Flask(__name__)


uname=""
password=""
valid=False
lines=""

def Authenticate(username,password):
    error = None
    valid = False
    print "1"
    logindetails = os.path.join(os.path.dirname(__file__), 'logindet.txt')
    with open(logindetails, 'r') as login:
        for entry in login:
            print "2"
            value = entry.split(',')
            if username.lower() == value[0].lower():
                if password.strip() == value[1].strip():
                    valid = True
                    break

    return valid


@app.route("/",methods=['GET','POST'])
def index():
    print "index"
    return render_template("Login.html")

@app.route("/login",methods=['GET','POST'])
def login():

    if request.method == 'POST':
        username=request.form['username']
        password=request.form['password']
        print username
        valid=Authenticate(username,password)

        print valid
        if valid==False:
            error = 'Invalid Credentials. Please try again.'
        else:
            uname=username
            return render_template("ImageUploadTool.html",username=username)
    return render_template('Login.html', error=error)






@app.route('/upload_file', methods=['GET','POST'])
def upload_file():
    if request.method == 'POST':
        if 'logout'in request.form:
            Message="Logged out"
            return render_template("Login.html")

        msg=[]
        urls=[]

        k=0
        filename = request.files['file'].filename
        print filename


        #print "i am "+uname
        file1=request.files['file']
        contents=file1.read()
        print s3
        folderpath=filename
        #folderpath=username + "/" + filename
        print folderpath
        s3.Object('raspberrypics',filename).put(Body=contents)
        #s3.Bucket(bucket).put_object(Key=str(folderpath), Body=contents)
        Message="File is uploaded"
        #response=client.list_objects(Bucket=bucket)
        #print response

        #return redirect("Success.html",Message=Message)
        # for f in response['Contents']:
        #     names=f['Key']
        #     url="https://s3-us-west-2.amazonaws.com/raspberrypics/"+names
        #     urls.append([])
        #     urls[k].append(url)
        #     urls[k].append(names)
        #     k=k+1

        return render_template("ImageUploadTool.html",Message=Message)


@app.route('/files', methods=['GET','POST'])
def files():
    print "0"
    msg=[]
    urls=[]
    k=0
    if request.method == 'POST':



        if 'list' in request.form:


            print "2"
            response=client.list_objects(Bucket='raspberrypics')
            print response

            for f in response['Contents']:
                print "3"
                names=f['Key']

                # if str(".txt") in names:
                #     N=15
                #     f=open(names)
                #     for i in range(N):
                #         line=f.next().strip()
                #         lines.join(line)
                #     url=lines
                #     f.close()

                #print url
                size=f['Size']*1.0/1024/1024
                lm=f['LastModified']
                print size
                url="https://s3-us-west-2.amazonaws.com/raspberrypics/"+names
                urls.append([])
                urls[k].append(url)
                urls[k].append(names)
                urls[k].append(lm)
                #urls[k].append(size)
                k=k+1
                print "4"

            # print 'delete'
            # filename = request.form['FileName']
            # print filename
            # response = client.delete_object(Bucket='raspberrypics',Key=filename)
            # print 'file deleted'


            print 'delete'
            filename = request.form['FileName']
            print filename
            if filename:
                print "i am in delete code"
                response = client.delete_object(Bucket='raspberrypics',Key=filename)
                print 'file deleted'

            return render_template("ImageUploadTool.html",msg=urls)


#        return render_template("ImageUploadTool.html")



        if 'DeleteAll' in request.form:
            for key in bucket.objects.all():
                key.delete()

        return render_template("ImageUploadTool.html",msg=urls)

        

#        return render_template("ImageUploadTool.html")





    return render_template("ImageUploadTool.html",Message=Message)

@app.route('/logout',methods=['GET','POST'])
def logout():
    #session.pop('username', None)
    return render_template("Login.html")






if __name__ == '__main__':
    app.run(debug=True)
    #app.run()