package ru.example.java.parsing.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@XmlRootElement(name = "ValCurs")
public final class CurrencyXml {
    private String date;
    private List<CurrencyDetailsXml> valutes;

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "Valute")
    public List<CurrencyDetailsXml> getValutes() {
        return valutes;
    }

    public void setValutes(List<CurrencyDetailsXml> valutes) {
        this.valutes = valutes;
    }


    //    public Optional<CurrencyDetailsXml> findByCode(String code) {
//        return Optional.ofNullable(valutes.get(code));
//    }
}
