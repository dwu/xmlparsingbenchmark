package com.example.xmlparsingbenchmark.util;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XmlGenerator {

    private DocumentBuilder db;

    public XmlGenerator() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
    }

    private String documentToString(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString();
        } catch (TransformerException ex) {
            Logger.getLogger(XmlGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String generateFlatXmlDocument(long numberOfChildElements) {
        Document doc = db.newDocument();

        Element root = doc.createElement("rootelement");
        doc.appendChild(root);

        for (long i = 0; i < numberOfChildElements; i++) {
            Element el = doc.createElement("child");
            root.appendChild(el);

            Text textNode = doc.createTextNode(String.format("Child %d", i));
            el.appendChild(textNode);
        }

        return documentToString(doc);
    }

        public String generateNestedXmlDocument(long numberOfLevels, long numberOfChildElementsPerLevel) {
        Document doc = db.newDocument();

        Element root = doc.createElement("rootelement");
        doc.appendChild(root);

        Element currentParent = root;
        for (long level=0; level<numberOfLevels; level++) {
            Element newParent = doc.createElement("parent");
            currentParent.appendChild(newParent);
            currentParent = newParent;
            
            for (long child=0; child<numberOfChildElementsPerLevel; child++) {
                Element el = doc.createElement("child");
                currentParent.appendChild(el);

                Text textNode = doc.createTextNode(String.format("Child %d", child));
                el.appendChild(textNode);
            }
        }
        return documentToString(doc);
    }

}
