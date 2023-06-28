(: Student ID    1001244953 :)
(: Student Name  Sneha Chitre :)

let $xmldoc :=doc('SigmodRecordNew.xml')
let $nl := "&#10;"
for $a in $xmldoc//issue
return concat($nl,'Volume ',$a/volume,',Number ',$a/number ,' has  ',count($a/articles/article),' articles',$nl)

