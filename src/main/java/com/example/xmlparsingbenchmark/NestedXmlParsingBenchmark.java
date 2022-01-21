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

public class NestedXmlParsingBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        public String nested11;
        public String nested110;
        public String nested1100;
        public String nested101;
        public String nested1010;
        public String nested10100;
        public String nested1001;
        public String nested10010;
        public String nested100100;

        public DocumentBuilder db;

        @Setup(Level.Trial)
        public void doSetup() {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                XmlGenerator g = new XmlGenerator();

                nested11 = g.generateNestedXmlDocument(1, 1);
                nested110 = g.generateNestedXmlDocument(1, 10);
                nested1100 = g.generateNestedXmlDocument(1, 100);
                nested101 = g.generateNestedXmlDocument(10, 1);
                nested1010 = g.generateNestedXmlDocument(10, 10);
                nested10100 = g.generateNestedXmlDocument(10, 100);
                nested1001 = g.generateNestedXmlDocument(100, 1);
                nested10010 = g.generateNestedXmlDocument(100, 10);
                nested100100 = g.generateNestedXmlDocument(100, 100);

            } catch (ParserConfigurationException ex) {
                Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested11(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested11)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested110(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested110)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested1100(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested1100)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // -----
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested101(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested101)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested1010(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested1010)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested10100(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested10100)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // -----
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested1001(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested1001)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested10010(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested10010)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testNested100100(BenchmarkState state, Blackhole blackhole) {
        try {
            Document doc = state.db.parse(new InputSource(new StringReader(state.nested100100)));
            blackhole.consume(doc);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(NestedXmlParsingBenchmark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}