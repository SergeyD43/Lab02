package utils;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlManager {

    private static final Logger logger = Logger.getLogger(XmlManager.class);

    /**
     * Маршаллинг объекта в XML файл
     * @param object экспортируемый объект
     */
    public void marsh(Object object){
        try {
            File file = new File(object.getClass().getSimpleName() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, file);

            logger.info("Объект сохранен в файл: " + object.getClass().getSimpleName() + ".xml");
        } catch (JAXBException e) {
            logger.error("Не удалось экспортировать файл: " +
                    object.getClass().getSimpleName() + ".xml" + ":" + e.getMessage());
        }
    }

    /**
     * Анмаршаллинг
     * @param object импортируемый объект
     * @return Object
     */
    public Object unmarsh(Object object){
        try {
            File file = new File(object.getClass().getSimpleName() + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = jaxbUnmarshaller.unmarshal(file);
            logger.info("Объект загружен из файла: " + object.getClass().getSimpleName() + ".xml");
        } catch (JAXBException e) {
            logger.error("Не удалось импортировать файл: " +
                    object.getClass().getSimpleName() + ".xml" + ":" + e.getMessage());
        } finally {
            return object;
        }
    }
}
