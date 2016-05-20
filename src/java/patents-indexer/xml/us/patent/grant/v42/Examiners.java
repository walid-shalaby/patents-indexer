//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 01:02:26 PM EST 
//


package xml.us.patent.grant.v42;

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
    "primaryExaminer",
    "assistantExaminer",
    "authorizedOfficer"
})
@XmlRootElement(name = "examiners")
public class Examiners {

    @XmlElement(name = "primary-examiner")
    protected PrimaryExaminer primaryExaminer;
    @XmlElement(name = "assistant-examiner")
    protected AssistantExaminer assistantExaminer;
    @XmlElement(name = "authorized-officer")
    protected AuthorizedOfficer authorizedOfficer;

    /**
     * Gets the value of the primaryExaminer property.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryExaminer }
     *     
     */
    public PrimaryExaminer getPrimaryExaminer() {
        return primaryExaminer;
    }

    /**
     * Sets the value of the primaryExaminer property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryExaminer }
     *     
     */
    public void setPrimaryExaminer(PrimaryExaminer value) {
        this.primaryExaminer = value;
    }

    /**
     * Gets the value of the assistantExaminer property.
     * 
     * @return
     *     possible object is
     *     {@link AssistantExaminer }
     *     
     */
    public AssistantExaminer getAssistantExaminer() {
        return assistantExaminer;
    }

    /**
     * Sets the value of the assistantExaminer property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssistantExaminer }
     *     
     */
    public void setAssistantExaminer(AssistantExaminer value) {
        this.assistantExaminer = value;
    }

    /**
     * Gets the value of the authorizedOfficer property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizedOfficer }
     *     
     */
    public AuthorizedOfficer getAuthorizedOfficer() {
        return authorizedOfficer;
    }

    /**
     * Sets the value of the authorizedOfficer property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizedOfficer }
     *     
     */
    public void setAuthorizedOfficer(AuthorizedOfficer value) {
        this.authorizedOfficer = value;
    }

}