//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 12:49:43 PM EST 
//


package xml.us.patent.application.v40_040415;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended"
})
@XmlRootElement(name = "us-publication-filing-type")
public class UsPublicationFilingType {

    @XmlElements({
        @XmlElement(name = "us-original-publication-voluntary", required = true, type = UsOriginalPublicationVoluntary.class),
        @XmlElement(name = "us-original-publication-redacted", required = true, type = UsOriginalPublicationRedacted.class),
        @XmlElement(name = "us-original-publication-amended", required = true, type = UsOriginalPublicationAmended.class),
        @XmlElement(name = "us-republication-corrected", required = true, type = UsRepublicationCorrected.class),
        @XmlElement(name = "us-republication-redacted", required = true, type = UsRepublicationRedacted.class),
        @XmlElement(name = "us-republication-amended", required = true, type = UsRepublicationAmended.class)
    })
    protected List<Object> usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended;

    /**
     * Gets the value of the usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsOriginalPublicationVoluntary }
     * {@link UsOriginalPublicationRedacted }
     * {@link UsOriginalPublicationAmended }
     * {@link UsRepublicationCorrected }
     * {@link UsRepublicationRedacted }
     * {@link UsRepublicationAmended }
     * 
     * 
     */
    public List<Object> getUsOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended() {
        if (usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended == null) {
            usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended = new ArrayList<Object>();
        }
        return this.usOriginalPublicationVoluntaryOrUsOriginalPublicationRedactedOrUsOriginalPublicationAmendedOrUsRepublicationCorrectedOrUsRepublicationRedactedOrUsRepublicationAmended;
    }

}
