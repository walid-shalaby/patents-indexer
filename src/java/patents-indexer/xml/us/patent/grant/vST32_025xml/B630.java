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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "b631OrB632OrB633"
})
@XmlRootElement(name = "B630")
public class B630 {

    @XmlAttribute(name = "INID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String inid;
    @XmlElements({
        @XmlElement(name = "B631", required = true, type = B631 .class),
        @XmlElement(name = "B632", required = true, type = B632 .class),
        @XmlElement(name = "B633", required = true, type = B633 .class)
    })
    protected List<Object> b631OrB632OrB633;

    /**
     * Gets the value of the inid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINID() {
        if (inid == null) {
            return "[63]";
        } else {
            return inid;
        }
    }

    /**
     * Sets the value of the inid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINID(String value) {
        this.inid = value;
    }

    /**
     * Gets the value of the b631OrB632OrB633 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the b631OrB632OrB633 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getB631OrB632OrB633().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link B631 }
     * {@link B632 }
     * {@link B633 }
     * 
     * 
     */
    public List<Object> getB631OrB632OrB633() {
        if (b631OrB632OrB633 == null) {
            b631OrB632OrB633 = new ArrayList<Object>();
        }
        return this.b631OrB632OrB633;
    }

}
