import GenerateClasses.ConversationList;
import GenerateClasses.UserList;
import GenerateClasses.WordList;
import utils.DatabaseManager;
import utils.XmlManager;

public class Main {
    public static void main(String[] args) {

        DatabaseManager databaseManager = new DatabaseManager();
        XmlManager xmlManager = new XmlManager();

        //Из БД в XML
        ConversationList conversationList = databaseManager.selectConversation();
        UserList userList = databaseManager.selectUsers();
        WordList wordList = databaseManager.selectWords();

        xmlManager.marsh(conversationList);
        xmlManager.marsh(userList);
        xmlManager.marsh(wordList);

        //Чистка базы
        databaseManager.clearDatabase();

        //Из XML в БД
        WordList wordList2 = new WordList();
        UserList userList2 = new UserList();
        ConversationList conversationList2 = new ConversationList();

        Object unmarsh = xmlManager.unmarsh(wordList2);
        Object unmarsh2 = xmlManager.unmarsh(userList2);
        Object unmarsh3 = xmlManager.unmarsh(conversationList2);

        databaseManager.insertConversations(unmarsh3);
        databaseManager.insertUsers(unmarsh2);
        databaseManager.insertWords(unmarsh);

    }
}
