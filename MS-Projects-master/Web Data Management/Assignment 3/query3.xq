(: Student ID    1001244953 :)
(: Student Name  Sneha Chitre :)

let $xmldoc :=doc('SigmodRecordNew.xml')/SigmodRecord/issue/articles
let $auth:=$xmldoc/article/authors[author='Leonidas Fegaras']
let $s:=sum(count($auth))
let $nl := "&#10;"
return concat($nl,'Number of articles where Leonidas Fegaras is an author is ',$s,$nl)