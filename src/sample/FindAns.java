package sample;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class FindAns {

    Connection connection;
    /* ADD YOUR CODE HERE */
    public FindAns () {
        connection = SqliteConnection.Connector();
        if(connection==null) System.exit(1);
    }

    public boolean isDbConnected() {
        try{
            return !connection.isClosed();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String returnAns(String q) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String query="SELECT ANS FROM CHATLOGTBL WHERE QUES=?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,q);
            resultSet = preparedStatement.executeQuery();
            //s += preparedStatement.executeQuery();
            if(resultSet.next())
                return resultSet.getString("ANS");
            else
                return "not found";
        }catch(Exception e) {
            return "failed at fA Class";
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
    }

}
