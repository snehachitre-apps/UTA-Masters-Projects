(: Student ID    1001244953 :)
(: Student Name  Sneha Chitre :)

let $xmldoc :=doc('SigmodRecordNew.xml')
let $v:=count( distinct-values($xmldoc//volume))
let $nl := "&#10;"

return concat($nl,'There are total   ',$v,' DISTINCT Volumes in SigmodRecord',$nl,'And total ',count($xmldoc//volume),' Volume issues in SigmodRecord - NOT DISTINCT',$nl)
