//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.10 at 12:46:59 AM EST 
//


package xml.us.patent.grant.vST32_024;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sdobi",
    "sdoab",
    "sdode",
    "sdocl",
    "sdodr",
    "sdocr"
})
@XmlRootElement(name = "PATDOC")
public class PATDOC {

    @XmlAttribute(name = "CY")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String cy;
    @XmlAttribute(name = "DNUM")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String dnum;
    @XmlAttribute(name = "DATE")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String date;
    @XmlAttribute(name = "FILE")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String file;
    @XmlAttribute(name = "KIND")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kind;
    @XmlAttribute(name = "STATUS")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String status;
    @XmlAttribute(name = "DTD")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dtd;
    @XmlElement(name = "SDOBI", required = true)
    protected SDOBI sdobi;
    @XmlElement(name = "SDOAB")
    protected SDOAB sdoab;
    @XmlElement(name = "SDODE", required = true)
    protected SDODE sdode;
    @XmlElement(name = "SDOCL", required = true)
    protected SDOCL sdocl;
    @XmlElement(name = "SDODR")
    protected SDODR sdodr;
    @XmlElement(name = "SDOCR")
    protected SDOCR sdocr;

    /**
     * Gets the value of the cy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCY() {
        return cy;
    }

    /**
     * Sets the value of the cy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCY(String value) {
        this.cy = value;
    }

    /**
     * Gets the value of the dnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNUM() {
        return dnum;
    }

    /**
     * Sets the value of the dnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNUM(String value) {
        this.dnum = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATE() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATE(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILE() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILE(String value) {
        this.file = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKIND() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKIND(String value) {
        this.kind = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the dtd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTD() {
        return dtd;
    }

    /**
     * Sets the value of the dtd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTD(String value) {
        this.dtd = value;
    }

    /**
     * Gets the value of the sdobi property.
     * 
     * @return
     *     possible object is
     *     {@link SDOBI }
     *     
     */
    public SDOBI getSDOBI() {
        return sdobi;
    }

    /**
     * Sets the value of the sdobi property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDOBI }
     *     
     */
    public void setSDOBI(SDOBI value) {
        this.sdobi = value;
    }

    /**
     * Gets the value of the sdoab property.
     * 
     * @return
     *     possible object is
     *     {@link SDOAB }
     *     
     */
    public SDOAB getSDOAB() {
        return sdoab;
    }

    /**
     * Sets the value of the sdoab property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDOAB }
     *     
     */
    public void setSDOAB(SDOAB value) {
        this.sdoab = value;
    }

    /**
     * Gets the value of the sdode property.
     * 
     * @return
     *     possible object is
     *     {@link SDODE }
     *     
     */
    public SDODE getSDODE() {
        return sdode;
    }

    /**
     * Sets the value of the sdode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDODE }
     *     
     */
    public void setSDODE(SDODE value) {
        this.sdode = value;
    }

    /**
     * Gets the value of the sdocl property.
     * 
     * @return
     *     possible object is
     *     {@link SDOCL }
     *     
     */
    public SDOCL getSDOCL() {
        return sdocl;
    }

    /**
     * Sets the value of the sdocl property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDOCL }
     *     
     */
    public void setSDOCL(SDOCL value) {
        this.sdocl = value;
    }

    /**
     * Gets the value of the sdodr property.
     * 
     * @return
     *     possible object is
     *     {@link SDODR }
     *     
     */
    public SDODR getSDODR() {
        return sdodr;
    }

    /**
     * Sets the value of the sdodr property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDODR }
     *     
     */
    public void setSDODR(SDODR value) {
        this.sdodr = value;
    }

    /**
     * Gets the value of the sdocr property.
     * 
     * @return
     *     possible object is
     *     {@link SDOCR }
     *     
     */
    public SDOCR getSDOCR() {
        return sdocr;
    }

    /**
     * Sets the value of the sdocr property.
     * 
     * @param value
     *     allowed object is
     *     {@link SDOCR }
     *     
     */
    public void setSDOCR(SDOCR value) {
        this.sdocr = value;
    }

}