//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.09 at 05:13:01 PM EST 
//


package xml.us.patent.grant.vST32_025xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "omc",
    "str",
    "city",
    "cnty",
    "state",
    "ctry",
    "pcode",
    "ead",
    "tel",
    "fax"
})
@XmlRootElement(name = "ADR")
public class ADR {

    @XmlElement(name = "OMC")
    protected OMC omc;
    @XmlElement(name = "STR")
    protected List<STR> str;
    @XmlElement(name = "CITY")
    protected CITY city;
    @XmlElement(name = "CNTY")
    protected CNTY cnty;
    @XmlElement(name = "STATE")
    protected STATE state;
    @XmlElement(name = "CTRY")
    protected CTRY ctry;
    @XmlElement(name = "PCODE")
    protected PCODE pcode;
    @XmlElement(name = "EAD")
    protected List<EAD> ead;
    @XmlElement(name = "TEL")
    protected List<TEL> tel;
    @XmlElement(name = "FAX")
    protected List<FAX> fax;

    /**
     * Gets the value of the omc property.
     * 
     * @return
     *     possible object is
     *     {@link OMC }
     *     
     */
    public OMC getOMC() {
        return omc;
    }

    /**
     * Sets the value of the omc property.
     * 
     * @param value
     *     allowed object is
     *     {@link OMC }
     *     
     */
    public void setOMC(OMC value) {
        this.omc = value;
    }

    /**
     * Gets the value of the str property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the str property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STR }
     * 
     * 
     */
    public List<STR> getSTR() {
        if (str == null) {
            str = new ArrayList<STR>();
        }
        return this.str;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link CITY }
     *     
     */
    public CITY getCITY() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link CITY }
     *     
     */
    public void setCITY(CITY value) {
        this.city = value;
    }

    /**
     * Gets the value of the cnty property.
     * 
     * @return
     *     possible object is
     *     {@link CNTY }
     *     
     */
    public CNTY getCNTY() {
        return cnty;
    }

    /**
     * Sets the value of the cnty property.
     * 
     * @param value
     *     allowed object is
     *     {@link CNTY }
     *     
     */
    public void setCNTY(CNTY value) {
        this.cnty = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link STATE }
     *     
     */
    public STATE getSTATE() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link STATE }
     *     
     */
    public void setSTATE(STATE value) {
        this.state = value;
    }

    /**
     * Gets the value of the ctry property.
     * 
     * @return
     *     possible object is
     *     {@link CTRY }
     *     
     */
    public CTRY getCTRY() {
        return ctry;
    }

    /**
     * Sets the value of the ctry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CTRY }
     *     
     */
    public void setCTRY(CTRY value) {
        this.ctry = value;
    }

    /**
     * Gets the value of the pcode property.
     * 
     * @return
     *     possible object is
     *     {@link PCODE }
     *     
     */
    public PCODE getPCODE() {
        return pcode;
    }

    /**
     * Sets the value of the pcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PCODE }
     *     
     */
    public void setPCODE(PCODE value) {
        this.pcode = value;
    }

    /**
     * Gets the value of the ead property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ead property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEAD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EAD }
     * 
     * 
     */
    public List<EAD> getEAD() {
        if (ead == null) {
            ead = new ArrayList<EAD>();
        }
        return this.ead;
    }

    /**
     * Gets the value of the tel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTEL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEL }
     * 
     * 
     */
    public List<TEL> getTEL() {
        if (tel == null) {
            tel = new ArrayList<TEL>();
        }
        return this.tel;
    }

    /**
     * Gets the value of the fax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFAX().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FAX }
     * 
     * 
     */
    public List<FAX> getFAX() {
        if (fax == null) {
            fax = new ArrayList<FAX>();
        }
        return this.fax;
    }

}
