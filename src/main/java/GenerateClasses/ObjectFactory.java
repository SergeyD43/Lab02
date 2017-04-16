
package GenerateClasses;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the GenerateClasses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: GenerateClasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link User.Words }
     * 
     */
    public User.Words createUserWords() {
        return new User.Words();
    }

    /**
     * Create an instance of {@link WordList }
     * 
     */
    public WordList createWordList() {
        return new WordList();
    }

    /**
     * Create an instance of {@link GenerateClasses.Word }
     * 
     */
    public GenerateClasses.Word createWord() {
        return new GenerateClasses.Word();
    }

    /**
     * Create an instance of {@link User.Words.Word }
     * 
     */
    public User.Words.Word createUserWordsWord() {
        return new User.Words.Word();
    }

}
