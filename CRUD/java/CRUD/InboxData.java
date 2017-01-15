package CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class InboxData {


    private final Connection dbConnection = new DBConnection().getConnection();
    private Statement st = dbConnection.createStatement();


    public List<User> getAllUsers() {

        return mails;
    }
    List<User> mails = new ArrayList<User>();

    public InboxData() throws SQLException {
        initData();
        List<User> mailscopy=mails;
    }

    public void updateUser(User user) throws SQLException {
        st = dbConnection.createStatement();
        String sqlQuery = "update test.user set age = " + user.getAge() +
                " ,name = '" + user.getName() + "',isAdmin = "+user.getStatus()+" where id = " + user.getId() + ";";
       st.execute(sqlQuery);

    }
    public void removeAllUsers() throws SQLException {
        st = dbConnection.createStatement();
        String sqlQuery = "DELETE FROM test.user";
        st.execute(sqlQuery);

    }
    public void createUser(User user) throws SQLException {
        st = dbConnection.createStatement();
        String sqlQuery = "insert into  test.user (name,age,isAdmin) values ( '" + user.getName() + "'," + user.getAge() + "" +
                "," + user.getStatus() + ")";
        st.executeUpdate(sqlQuery);

    }

    public void removeUser(User user) throws SQLException {
        st = dbConnection.createStatement();
        String sqlQuery = "DELETE FROM test.user  WHERE id = " + user.getId();
        st.execute(sqlQuery);
    }


    private void initData() throws SQLException {

        if (!mails.isEmpty())
            mails.clear();
        String query = "select * from test.user";
        ResultSet resultSet = st.executeQuery(query);
        while (resultSet.next()) {

            User mail = new User();
            mail.setStatus(String.valueOf(resultSet.getBoolean("isAdmin")));
            mail.setAge(resultSet.getInt("age"));
            mail.setId(resultSet.getInt("id"));
            mail.setTimeCreared(resultSet.getDate("createdDate"));
            mail.setName(resultSet.getString("name"));
            mails.add(mail);

        }
    }

    public void revertDeletedMails() {
        try {
            initData();
        } catch (SQLException e) {

        }
    }

    public void deleteAllMails() {
        mails.clear();
    }

    public void addMails(Collection<User> c) {
        mails.addAll(c);
    }

    public List<User> getMails() {
        return mails;
    }

    public void deleteMail(User m) {


        mails.remove(m);
    }

    public int getSize() {
        return mails.size();
    }


    public List<User> getAllFoods() {
        return new ArrayList<User>(getAllUsers());
    }

    public List<User> getFilterFoods(Filter Filter) {

        List<User> somefoods = new ArrayList<User>();
        String idt = Filter.getId().toLowerCase();
        String namet = Filter.getName().toLowerCase();
        String aget = Filter.getAge().toLowerCase();
        String statust = Filter.getStatus().toLowerCase();
        String dateDayt = Filter.getDateDay().toLowerCase();
        String dateMontht = Filter.getDateMounth().toLowerCase();
        String dateYeart = Filter.getDateYear().toLowerCase();
        for (Iterator<User> i = mails.iterator(); i.hasNext(); ) {
            User tmp = i.next();

            if (
                    String.valueOf(tmp.getId()).toLowerCase().contains(idt) &&
                            tmp.getName().toLowerCase().contains(namet) &&
                            String.valueOf(tmp.getAge()).toLowerCase().contains(aget) &&
                            String.valueOf(tmp.getStatus()).toLowerCase().contains(statust) &&
            String.valueOf(tmp.getTimeCreared().toString().substring(8)).toLowerCase().contains(dateDayt)&&
            String.valueOf(tmp.getTimeCreared().toString().substring(5,7)).toLowerCase().contains(dateMontht)&&
            String.valueOf(tmp.getTimeCreared().toString().substring(0,4)).toLowerCase().contains(dateYeart))



            {

                somefoods.add(tmp);
            }
        }
        return somefoods;
    }

    public void create10RandomUsers() throws SQLException {
        st = dbConnection.createStatement();

        for (int i = 0; i < 10; i++) {
            boolean isAdmin = false;
            if(Math.random()>0.5){
                isAdmin = true;
            }
            int age = (int) (Math.random()*100);

            char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int j = 0; j < Math.random()*20; j++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            String output = sb.toString();


        String sqlQuery = "insert into  test.user (name,age,isAdmin) values ( '" +
                output + "'," + age + "" +
                "," + isAdmin + ")";
        st.executeUpdate(sqlQuery);
        }
    }
}
