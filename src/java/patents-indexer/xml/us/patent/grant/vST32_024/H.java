//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.10 at 12:46:59 AM EST 
//


package xml.us.patent.grant.vST32_024;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stext"
})
@XmlRootElement(name = "H")
public class H {

    @XmlAttribute(name = "LVL")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lvl;
    @XmlAttribute(name = "ALIGN")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String align;
    @XmlElement(name = "STEXT", required = true)
    protected List<STEXT> stext;

    /**
     * Gets the value of the lvl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLVL() {
        return lvl;
    }

    /**
     * Sets the value of the lvl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLVL(String value) {
        this.lvl = value;
    }

    /**
     * Gets the value of the align property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALIGN() {
        if (align == null) {
            return "LEFT";
        } else {
            return align;
        }
    }

    /**
     * Sets the value of the align property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALIGN(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the stext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSTEXT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link STEXT }
     * 
     * 
     */
    public List<STEXT> getSTEXT() {
        if (stext == null) {
            stext = new ArrayList<STEXT>();
        }
        return this.stext;
    }

}