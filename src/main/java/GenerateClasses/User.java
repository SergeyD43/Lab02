
package GenerateClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="words">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="word" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="originalWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="translate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "id",
    "nickname",
    "name",
    "surname",
    "password",
    "words",
    "isAdmin"
})
@XmlRootElement(name = "user")
public class User {

    protected int id;
    @XmlElement(required = true)
    protected String nickname;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String surname;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected User.Words words;
    protected boolean isAdmin;

    public User() {
    }

    public User(int id, String nickname, String name, String surname, String password, boolean isAdmin) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

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
     * Gets the value of the nickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the words property.
     * 
     * @return
     *     possible object is
     *     {@link User.Words }
     *     
     */
    public User.Words getWords() {
        return words;
    }

    /**
     * Sets the value of the words property.
     * 
     * @param value
     *     allowed object is
     *     {@link User.Words }
     *     
     */
    public void setWords(User.Words value) {
        this.words = value;
    }

    /**
     * Gets the value of the isAdmin property.
     * 
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets the value of the isAdmin property.
     * 
     */
    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="word" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="originalWord" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="translate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "word"
    })
    public static class Words {

        @XmlElement(required = true)
        protected List<User.Words.Word> word;

        /**
         * Gets the value of the word property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the word property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWord().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link User.Words.Word }
         * 
         * 
         */
        public List<User.Words.Word> getWord() {
            if (word == null) {
                word = new ArrayList<User.Words.Word>();
            }
            return this.word;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
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
        @XmlType(name = "", propOrder = {
            "originalWord",
            "translate"
        })
        public static class Word {

            @XmlElement(required = true)
            protected String originalWord;
            @XmlElement(required = true)
            protected String translate;

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

    }

}
