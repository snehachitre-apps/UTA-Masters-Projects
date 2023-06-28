//Student Name  Sneha Chitre
//Student ID    1001244953

package xslt;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;


class XSLT {
    public static void main ( String argv[] ) throws Exception {
	File stylesheet = new File("SigmodRecordTable.xsl");
	File xmlfile  = new File("SigmodRecord.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document document = db.parse(xmlfile);
	StreamSource stylesource = new StreamSource(stylesheet);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesource);
	DOMSource source = new DOMSource(document);
	PrintStream ps=new PrintStream(new FileOutputStream("SigmodRecordNew.html"));
	
	StreamResult result = new StreamResult(ps);
	//StreamResult result = new StreamResult(System.out);
	transformer.transform(source,result);
    }
}
