package ru.example.java.parsing.xml.parser;

import ru.example.java.parsing.xml.CurrencyXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class CurrencyXmlParser {
    public CurrencyXml toObject(String xml){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyXml.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (CurrencyXml) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public String toXml(CurrencyXml obj){
        try (Writer writer = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(CurrencyXml.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
