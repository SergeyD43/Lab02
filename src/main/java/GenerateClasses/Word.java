
package GenerateClasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for word complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="word">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="originalWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="translate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "word", propOrder = {
    "id",
    "originalWord",
    "translate"
})
public class Word {

    protected int id;
    @XmlElement(required = true)
    protected String originalWord;
    @XmlElement(required = true)
    protected String translate;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the originalWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalWord() {
        return originalWord;
    }

    /**
     * Sets the value of the originalWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalWord(String value) {
        this.originalWord = value;
    }

    /**
     * Gets the value of the translate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranslate() {
        return translate;
    }

    /**
     * Sets the value of the translate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranslate(String value) {
        this.translate = value;
    }

}
