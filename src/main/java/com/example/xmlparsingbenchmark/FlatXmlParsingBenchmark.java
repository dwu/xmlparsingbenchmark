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
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FlatXmlParsingBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        public String flat1;
        public String flat10;
        public String flat100;
        public String flat1000;
        public String flat10000;
        
        public DocumentBuilder db;

        @Setup(Level.Trial)
        public void doSetup() {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                XmlGenerator g = new XmlGenerator();
                
                flat1 = g.generateFlatXmlDocument(1);
                flat10 = g.generateFlatXmlDocument(10);
                flat100 = g.generateFlatXmlDocument(100);
                flat1000 = g.generateFlatXmlDocument(1000);
                flat10000 = g.generateFlatXmlDocument(10000);
                
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat1(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.flat1)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat10(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.flat10)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat100(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.flat100)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat1000(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.flat1000)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testFlat10000(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.flat10000)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(FlatXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
