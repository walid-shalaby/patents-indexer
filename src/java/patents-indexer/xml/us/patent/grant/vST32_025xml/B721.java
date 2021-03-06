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
    "partyus",
    "legalrepresentative"
})
@XmlRootElement(name = "B721")
public class B721 {

    @XmlElement(name = "PARTY-US", required = true)
    protected PARTYUS partyus;
    @XmlElement(name = "LEGAL-REPRESENTATIVE")
    protected List<LEGALREPRESENTATIVE> legalrepresentative;

    /**
     * Gets the value of the partyus property.
     * 
     * @return
     *     possible object is
     *     {@link PARTYUS }
     *     
     */
    public PARTYUS getPARTYUS() {
        return partyus;
    }

    /**
     * Sets the value of the partyus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PARTYUS }
     *     
     */
    public void setPARTYUS(PARTYUS value) {
        this.partyus = value;
    }

    /**
     * Gets the value of the legalrepresentative property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalrepresentative property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLEGALREPRESENTATIVE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LEGALREPRESENTATIVE }
     * 
     * 
     */
    public List<LEGALREPRESENTATIVE> getLEGALREPRESENTATIVE() {
        if (legalrepresentative == null) {
            legalrepresentative = new ArrayList<LEGALREPRESENTATIVE>();
        }
        return this.legalrepresentative;
    }

}
