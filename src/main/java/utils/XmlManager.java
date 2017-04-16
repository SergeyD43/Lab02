package utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlManager {
    public void marsh(Object object){
        try {
            File file = new File(object.getClass().getSimpleName() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Object unmarsh(Object object){
        try {

            File file = new File(object.getClass().getSimpleName() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            return object;
        }
    }
}
