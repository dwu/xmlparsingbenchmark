package com.example.xmlparsingbenchmark;

import com.example.xmlparsingbenchmark.util.XmlGenerator;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@State(Scope.Benchmark)
public class FlatXmlParsingBenchmark {

    @Param({ "1", "10", "100", "1000", "10000" })
    public int numElements;
    
    public String xml;
    
    public DocumentBuilder db;

    @Setup(Level.Trial)
    public void doSetup() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            XmlGenerator g = new XmlGenerator();

            xml = g.generateFlatXmlDocument(numElements);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat(Blackhole blackhole) {
        try {
            Document doc = db.parse(new InputSource(new StringReader(xml)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
