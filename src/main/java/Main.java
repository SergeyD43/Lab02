import GenerateClasses.ConversationList;
import GenerateClasses.UserList;
import GenerateClasses.WordList;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import utils.DatabaseManager;
import utils.XmlManager;

public class Main {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        XmlManager xmlManager = new XmlManager();

        //Из БД в XML
        logger.info("Начало выгрузки базы данных");
        ConversationList conversationList = databaseManager.selectConversation();
        UserList userList = databaseManager.selectUsers();
        WordList wordList = databaseManager.selectWords();
        logger.info("Конец выгрузки базы данных");

        logger.info("Начало выгрузки объектов в XML");
        xmlManager.marsh(conversationList);
        xmlManager.marsh(userList);
        xmlManager.marsh(wordList);
        logger.info("Конец выгрузки объектов в XML");

        //Чистка базы
        logger.info("Очистка базы данных");
        databaseManager.clearDatabase();

        WordList wordList2 = new WordList();
        UserList userList2 = new UserList();
        ConversationList conversationList2 = new ConversationList();

        //Из XML в БД
        logger.info("Начало загрузки файлов");
        Object unmarsh = xmlManager.unmarsh(wordList2);
        Object unmarsh2 = xmlManager.unmarsh(userList2);
        Object unmarsh3 = xmlManager.unmarsh(conversationList2);
        logger.info("Конец загрузки файлов");
        logger.info("Начало загрузки объектов в БД");
        databaseManager.insertConversations(unmarsh3);
        databaseManager.insertUsers(unmarsh2);
        databaseManager.insertWords(unmarsh);
        logger.info("Конец загрузки объектов в БД");
    }
}
