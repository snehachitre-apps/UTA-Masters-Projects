// Student Name  Sneha Chitre
// Student ID    1001244953 

package xpath;

import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

class XPATH {

    static void print ( Node e ) {
	if (e instanceof Text){
	    System.out.print(((Text) e).getData());
		System.out.println();
	}
	else {
	    NodeList c = e.getChildNodes();
	    System.out.print("<"+e.getNodeName());
	    NamedNodeMap attributes = e.getAttributes();
	    for (int i = 0; i < attributes.getLength(); i++)
		System.out.print(" "+attributes.item(i).getNodeName()
				 +"=\""+attributes.item(i).getNodeValue()+"\"");
	    System.out.print(">");
	    for (int k = 0; k < c.getLength(); k++)
		print(c.item(k));
	    System.out.print("</"+e.getNodeName()+">");
	    
	}
    }

    static void eval ( String query, String document ) throws Exception {
	XPathFactory xpathFactory = XPathFactory.newInstance();
	XPath xpath = xpathFactory.newXPath();
	InputSource inputSource = new InputSource(document);
	NodeList result = (NodeList) xpath.evaluate(query,inputSource,XPathConstants.NODESET);
	System.out.println("XPath query: "+query);
	for (int i = 0; i < result.getLength(); i++)
	    print(result.item(i));
		
		
	System.out.println();
    }

    public static void main ( String[] args ) throws Exception {
	
    //Query 1: Print the titles of all articles whose one of the authors is David Maier.
    eval("//title[following-sibling::authors/author[text()='David Maier']]/text()","SigmodRecord.xml");
    
    //Query 2: Print the titles of all articles whose first author is David Maier.
    eval("//title[following-sibling::authors/author[text()='David Maier'][@position='00']]/text()","SigmodRecord.xml");
    
    //Query 3: Print the titles of all articles whose authors include David Maier and Stanley B. Zdonik.
    eval("//title[following-sibling::authors[descendant::text()='David Maier'][descendant::text()='Stanley B. Zdonik']]/text()","SigmodRecord.xml");
   
    //Query 4: Print the titles of all articles in volume 19/number 2.
    eval("//issue[descendant::volume[text()='19']][descendant::number[text()='2']]/articles/article/title/text() ","SigmodRecord.xml");
    
    //Query 5: Print the titles and the init/end pages of all articles in volume 19/number 2 whose authors include Jim Gray
    //Note: output contains Title , InitPage and End Page in mentioned order.
    eval("//issue[descendant::volume[text()='19']][descendant::number[text()='2']]/articles/article/title[following-sibling::authors/author[text()='Jim Gray']]/text() | //issue[descendant::volume[text()='19']][descendant::number[text()='2']]/articles/article/initPage[following-sibling::authors/author[text()='Jim Gray']]/text() |  //issue[descendant::volume[text()='19']][descendant::number[text()='2']]/articles/article/endPage[following-sibling::authors/author[text()='Jim Gray']]/text() ","SigmodRecord.xml");
    
    //Query 6: Print the volume and number of all articles whose authors include David Maier.
    //Note: output contains Volume and Number in mentioned order, one below another.
    eval("//volume[following-sibling::articles/article/authors/author[text()='David Maier']]/text() | //number[following-sibling::articles/article/authors/author[text()='David Maier']]/text()","SigmodRecord.xml");
    
    }
}
