
package GenerateClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for conversation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="conversation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userA" type="{}user"/>
 *         &lt;element name="userB" type="{}user"/>
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversation", propOrder = {
    "userA",
    "userB",
    "text"
})
public class Conversation {

    @XmlElement(required = true)
    protected User userA;
    @XmlElement(required = true)
    protected User userB;
    @XmlElement(required = true)
    protected String text;

    /**
     * Gets the value of the userA property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserA() {
        return userA;
    }

    /**
     * Sets the value of the userA property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserA(User value) {
        this.userA = value;
    }

    /**
     * Gets the value of the userB property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUserB() {
        return userB;
    }

    /**
     * Sets the value of the userB property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUserB(User value) {
        this.userB = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
