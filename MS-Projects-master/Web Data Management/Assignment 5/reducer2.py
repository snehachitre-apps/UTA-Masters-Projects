#!/usr/bin/env python
#Student Name: Sneha Chitre
#student id: 1001244953

from operator import itemgetter
import sys

current_fn = None
current_count = 0
word = None
N=0

wlist=[]
clist=[]
# input comes from STDIN
for line in sys.stdin:
    # remove leading and trailing whitespace
    line = line.strip()

    # parse the input we got from mapper.py
    filename, wordcount = line.split('\t', 1)
    wordcount=wordcount.split('&')
    w=wordcount[0]
    count=wordcount[1]
    # convert count (currently a string) to int
    try:
        count = int(count)
    except ValueError:
        # co unt was not a number, so silently
        # ignore/discard this line
        continue

    if current_fn == filename :
        current_count += count
	wlist.append(w)
	clist.append(count)
		        #
        # tab-delimited; the trivial word count is 1
        #filepath = os.environ["map_input_file"]
        #filename = os.path.split(filepath)[-1]
        #try:
#       input_file = os.environ['mapreduce_map_input_file']
        #except KeyError:
   # wf=wordscount[0].split('&')


    else:
        if current_fn:
	    for w in range(len(wlist)):
		wf=str(wlist[w])+'&'+str(current_fn)
		cC=str(clist[w])+'&'+str(current_count)
		print "%s\t%s" % (wf,cC)	
		
		
            # write result to STDOUT
        current_count =0
        current_fn = filename
	wlist=[]
	clist=[]
	current_count+=count
	wlist.append(w)
	clist.append(count)
	
# do not forget to output the last word if needed!
if current_fn == filename:
    for w in range(len(wlist)):
	wf=str(wlist[w])+'&'+str(current_fn)
	cC=str(clist[w])+'&'+str(current_count)
	print "%s\t%s" % (wf,cC)


   
