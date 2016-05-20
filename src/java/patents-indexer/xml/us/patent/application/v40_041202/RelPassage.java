//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 12:47:21 PM EST 
//


package xml.us.patent.application.v40_041202;

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
    "textOrPassageOrCategoryOrRelClaims"
})
@XmlRootElement(name = "rel-passage")
public class RelPassage {

    @XmlElements({
        @XmlElement(name = "text", required = true, type = Text.class),
        @XmlElement(name = "passage", required = true, type = Passage.class),
        @XmlElement(name = "category", required = true, type = Category.class),
        @XmlElement(name = "rel-claims", required = true, type = RelClaims.class)
    })
    protected List<Object> textOrPassageOrCategoryOrRelClaims;

    /**
     * Gets the value of the textOrPassageOrCategoryOrRelClaims property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textOrPassageOrCategoryOrRelClaims property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextOrPassageOrCategoryOrRelClaims().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Text }
     * {@link Passage }
     * {@link Category }
     * {@link RelClaims }
     * 
     * 
     */
    public List<Object> getTextOrPassageOrCategoryOrRelClaims() {
        if (textOrPassageOrCategoryOrRelClaims == null) {
            textOrPassageOrCategoryOrRelClaims = new ArrayList<Object>();
        }
        return this.textOrPassageOrCategoryOrRelClaims;
    }

}