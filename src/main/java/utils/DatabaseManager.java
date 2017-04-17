package utils;

import GenerateClasses.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final Logger logger = Logger.getLogger(DatabaseManager.class);

    /**
     * Соединение с БД
     * @return Connection
     */
    public Connection initConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.fatal("Отсутствует драйвер базы данных");
        }
        try {

            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root", "123456");
            logger.info("Соедиение с базой данных установлено");
        } catch (SQLException e) {
            logger.fatal("Не удалось установить соединение с базой данных");
        }
        return connection;
    }

    /**
     * Выполняет запрос, для получения списка users
     * @return users
     */
    public UserList selectUsers(){
        Connection connection = initConnection();
        UserList setUsers = new UserList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select users.id_user, nickname," +
                    " users.name, surname, users.password, word, translate , isAdmin  from users\n" +
                    "left join binding on users.id_user=binding.id_user\n" +
                    "left join dictionary on binding.id_word=dictionary.id_word");

            int oldid = -1;
            User user = null;
            User.Words words = null;
            while (resultSet.next()){
                int id = resultSet.getInt("id_user");
                String nickname = resultSet.getString("nickname");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String password = resultSet.getString("password");
                String word = resultSet.getString("word");
                String translate = resultSet.getString("translate");
                String isAdminS=resultSet.getString("isAdmin");
                boolean isAdmin=false;
                if(isAdminS.charAt(0)=='Y')
                    isAdmin = true;

                if(id != oldid){
                    user = new User(id,nickname,name,surname,password,isAdmin);
                    words = new User.Words();
                    user.setWords(words);
                    User.Words.Word myword = new User.Words.Word();
                    myword.setOriginalWord(word);
                    myword.setTranslate(translate);
                    words.getWord().add(myword);
                    setUsers.getUser().add(user);
                    oldid = id;
                } else {
                    User.Words.Word myword = new User.Words.Word();
                    myword.setOriginalWord(word);
                    myword.setTranslate(translate);
                    words.getWord().add(myword);
                }
            }
        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        } finally {
            return setUsers;
        }
    }

    /**
     * Выполняет запрос, для получения списка conversations
     * @return conversations
     */
    public ConversationList selectConversation(){
        Connection connection = initConnection();
        ConversationList conversationList = new ConversationList();
        UserList userList = selectUsers();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from conversations\n" +
                    "join users on conversations.id_userA = users.id_user\n" +
                    "union \n" +
                    "select * from conversations\n" +
                    "join users on conversations.id_userB = users.id_user order by conversation");

            int idOldA = -1;
            int idOldB = -1;
            while (resultSet.next()){
                int id_userA = resultSet.getInt("id_userA");
                int id_userB = resultSet.getInt("id_userB");
                String conversation = resultSet.getString("conversation");

                if(id_userA!=idOldA || id_userB!=idOldB){
                    Conversation conv = new Conversation();
                    conv.setText(conversation);
                    conv.setUserA(userList.getUser().get(id_userA-1));
                    conv.setUserB(userList.getUser().get(id_userB-1));
                    idOldA = id_userA;
                    idOldB = id_userB;
                    conversationList.getConversation().add(conv);
                }
            }
        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        } finally {
            return conversationList;
        }
    }

    /**
     * Выполняет запрос, для получения списка слов
     * @return words
     */
    public WordList selectWords(){
        Connection connection = initConnection();
        WordList wordList = new WordList();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from dictionary");
            while (resultSet.next()){
                int id = resultSet.getInt("id_word");
                String word = resultSet.getString("word");
                String translate = resultSet.getString("translate");
                Word word1 = new Word();
                word1.setId(id);
                word1.setOriginalWord(word);
                word1.setTranslate(translate);
                wordList.getWord().add(word1);
            }
        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        } finally {
            return wordList;
        }
    }

    /**
     * Добавление words в БД
     * @param object words
     */
    public void insertWords(Object object){
        Connection connection = initConnection();
        WordList wordList = (WordList) object;

        List<String> doplist = new ArrayList<String>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from dictionary");

            while (resultSet.next()){
                String originalWord = resultSet.getString("word");
                doplist.add(originalWord);
            }

        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into dictionary(word, translate) " +
                            "values (?,?) ");
            for (Word word:wordList.getWord()) {
                preparedStatement.setString(1,word.getOriginalWord());
                preparedStatement.setString(2,word.getTranslate());
                if(doplist.contains(word.getOriginalWord()))
                    continue;
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        }
    }

    private List<String> doplistWords = new ArrayList<String>();

    /**
     * Добавление users в БД
     * @param object users
     */
    public void insertUsers(Object object){
        Connection connection = initConnection();
        UserList userList = (UserList) object;

        List<String> doplist = new ArrayList<String>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()){
                String nickname = resultSet.getString("nickname");
                doplist.add(nickname);
            }

        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        }

        for(User myuser:userList.getUser()) {
            if(doplist.contains(myuser.getNickname()))
                continue;
            List<User.Words.Word> wordList;
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("insert into users(nickname, name, surname, password, isAdmin) " +
                                "values (?,?,?,?,?) ");
                PreparedStatement preparedStatement2 =
                        connection.prepareStatement("insert into dictionary(word, translate)" +
                                "values (?, ?)");

                preparedStatement.setString(1, myuser.getNickname());
                preparedStatement.setString(2, myuser.getName());
                preparedStatement.setString(3, myuser.getSurname());
                preparedStatement.setString(4, myuser.getPassword());

                wordList = myuser.getWords().getWord();
                for (User.Words.Word word : wordList) {
                    preparedStatement2.setString(1, word.getOriginalWord());
                    if(word.getOriginalWord()==null || doplistWords.contains(word.getOriginalWord()))
                        continue;
                    preparedStatement2.setString(2, word.getTranslate());
                    preparedStatement2.executeUpdate();
                    doplistWords.add(word.getOriginalWord());
                }

                char c;
                if (myuser.isIsAdmin()) {
                    c = 'Y';
                } else {
                    c = 'N';
                }

                preparedStatement.setString(5, String.valueOf(c));
                preparedStatement.executeUpdate();


                //Запрос полсе вставки в users и dictionary
                Integer id_user = null;
                PreparedStatement preparedStatement3 =
                        connection.prepareStatement("select * from users " +
                                "where nickname = ?");
                preparedStatement3.setString(1, myuser.getNickname());
                ResultSet resultSet3 = preparedStatement3.executeQuery();
                while (resultSet3.next()) {
                    id_user = resultSet3.getInt("id_user");
                }

                ResultSet resultSet4 = null;
                for (User.Words.Word word : wordList) {
                    String originalWord = word.getOriginalWord();
                    PreparedStatement preparedStatement4 =
                            connection.prepareStatement("select * from dictionary " +
                                    "where word = ?");
                    preparedStatement4.setString(1, originalWord);
                    resultSet4 = preparedStatement4.executeQuery();

                    //Вставка в таблицу binding
                    while (resultSet4.next()) {
                        PreparedStatement preparedStatement5 =
                                connection.prepareStatement("insert into binding(id_user, id_word)" +
                                        "values (?, ?)");
                        preparedStatement5.setInt(1, id_user);
                        preparedStatement5.setInt(2, resultSet4.getInt("id_word"));
                        preparedStatement5.executeUpdate();
                    }
                }

            } catch (SQLException e) {
                logger.error("Ошибка при выполении запроса: " + e.getMessage());
            }
        }
    }

    /**
     * Добавление conversations в БД
     * @param object conversations
     */
    public void insertConversations(Object object){
        Connection connection = initConnection();
        ConversationList conversationList = (ConversationList) object;
        ArrayList<User> userArrayList = new ArrayList<User>();
        for(Conversation conversation:conversationList.getConversation()) {
            User userA = conversation.getUserA();
            User userB = conversation.getUserB();
            UserList userList = new UserList();
            if(!userArrayList.contains(userA))
                userList.getUser().add(userA);
            if(!userArrayList.contains(userB))
                userList.getUser().add(userB);
            userArrayList.add(userA);
            userArrayList.add(userB);
            insertUsers(userList);

            //Запрос после вставки в users,dictionary и binding
            try {
                Integer id_userA = null;
                Integer id_userB = null;
                PreparedStatement preparedStatement1 =
                        connection.prepareStatement("select * from users " +
                                "where nickname = ?");
                preparedStatement1.setString(1, userA.getNickname());
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    id_userA = resultSet1.getInt("id_user");
                }

                PreparedStatement preparedStatement2 =
                        connection.prepareStatement("select * from users " +
                                "where nickname = ?");
                preparedStatement2.setString(1, userB.getNickname());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    id_userB = resultSet2.getInt("id_user");
                }

                PreparedStatement preparedStatement3 =
                        connection.prepareStatement("insert into conversations(id_userA, id_userB, conversation)" +
                                "values (?, ?, ?)");

                if (id_userA < id_userB) {
                    preparedStatement3.setInt(1, id_userA);
                    preparedStatement3.setInt(2, id_userB);
                }

                if (id_userA > id_userB) {
                    preparedStatement3.setInt(2, id_userA);
                    preparedStatement3.setInt(1, id_userB);
                }

                preparedStatement3.setString(3, conversation.getText());
                preparedStatement3.executeUpdate();
            } catch (SQLException e) {
                logger.error("Ошибка при выполении запроса: " + e.getMessage());
            }
        }
        doplistWords = new ArrayList<String>();
    }

    /**
     * Чистит БД
     */
    public void clearDatabase(){
        Connection connection = initConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeQuery("truncate table binding");
            statement.executeQuery("truncate table conversations");
            statement.executeQuery("SET FOREIGN_KEY_CHECKS = 0");
            statement.executeQuery("truncate table dictionary");
            statement.executeQuery("truncate table users");
            statement.executeQuery("SET FOREIGN_KEY_CHECKS = 1");
        } catch (SQLException e) {
            logger.error("Ошибка при выполении запроса: " + e.getMessage());
        }
    }
}
