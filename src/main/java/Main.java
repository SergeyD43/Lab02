import GenerateClasses.ConversationList;
import GenerateClasses.UserList;
import GenerateClasses.WordList;
import utils.DatabaseManager;
import utils.XmlManager;

public class Main {
    public static void main(String[] args) {

        DatabaseManager databaseManager = new DatabaseManager();
        XmlManager xmlManager = new XmlManager();

//        ConversationList conversationList = databaseManager.selectConversation();
//        UserList userList = databaseManager.selectUsers();
//        WordList wordList = databaseManager.selectWords();
//
//        xmlManager.marsh(conversationList);
//        xmlManager.marsh(userList);
//        xmlManager.marsh(wordList);
        WordList wordList = new WordList();
        Object unmarsh = xmlManager.unmarsh(wordList);
//        databaseManager.insertWords(unmarsh);


        UserList userList = new UserList();
        Object unmarsh2 = xmlManager.unmarsh(userList);
//        databaseManager.insertUsers(unmarsh2);

        ConversationList conversationList = new ConversationList();
        Object unmarsh3 = xmlManager.unmarsh(conversationList);
        databaseManager.insertConversations(unmarsh3);
    }
}
