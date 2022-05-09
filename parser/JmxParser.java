package parser;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


class JmxParser {
    public static void main(String[] args) {
        System.out.println("Hello");

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            
            Document xmlDocument = builder.parse(new File("path/to/test.jmx"));
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//ThreadGroup/@testname | //ThreadGroup/stringProp[@name='ThreadGroup.num_threads']/text()";
            NodeList matches = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
            
            for (int i = 0; i < matches.getLength(); ) {
                System.out.println(matches.item(i).getTextContent());
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    



    }
}