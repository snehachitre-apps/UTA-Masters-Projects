#!/usr/bin/env python
#Student Name: Sneha Chitre
#student id: 1001244953

from operator import itemgetter
import sys

dccount=0
current_count = 0
word = None
N=0
current_word=None
filelist=[]
nlist=[]
Nlist=[]
# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    word, fncount = line.split('\t', 1)
    fncount =fncount.split('&')
    filename=fncount[0]
    n=fncount[1]
    N=fncount[2]
    dccount=fncount[3]
	
    # convert count (currently a string) to int
    try:
        dccount = int(dccount)
    except ValueError:
        # co unt was not a number, so silently
        # ignore/discard this line
        continue

    if current_word == word :
        current_count += dccount
	filelist.append(filename)
	nlist.append(n)
	Nlist.append(N)		        #
        # tab-delimited; the trivial word count is 1
        #filepath = os.environ["map_input_file"]
        #filename = os.path.split(filepath)[-1]
        #try:
#       input_file = os.environ['mapreduce_map_input_file']
        #except KeyError:
   # wf=wordscount[0].split('&')


    else:
        if current_word:
	    for f in range(len(filelist)):
		wf=str(current_word)+'&'+str(filelist[f])
		cC=str(nlist[f])+'&'+str(Nlist[f])+'&'+str(current_count)
		print "%s\t%s" % (wf,cC)	
		
		
            # write result to STDOUT
        current_count =0
        current_word = word
	filelist=[]
        nlist=[]
        Nlist=[]
	current_count+=dccount
	filelist.append(filename)
	nlist.append(n)
	Nlist.append(N)
	
# do not forget to output the last word if needed!
if current_word == word:
    for f in range(len(filelist)):
	wf=str(current_word)+'&'+str(filelist[f])
	cC=str(nlist[f])+'&'+str(Nlist[f])+'&'+str(current_count)
	print "%s\t%s" % (wf,cC)


   
