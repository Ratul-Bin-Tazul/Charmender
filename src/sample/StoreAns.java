package sample;


import java.sql.*;

public class StoreAns {

    public static Connection connection;

//    public StoreAns() {
//         connection = SqliteConnection.Connector();
//         if(connection==null)
//             System.exit(1);
//    }
//
//    public boolean isDbConnected() {
//        try{
//            return !connection.isClosed();
//        }catch(Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static void saveAns(String ques,String ans)  {
//        PreparedStatement preparedStatement=null;
//        String query = "INSERT INTO CHATLOGTBL(QUES,ANS) VALUES(?,?)";
//        try {
//            preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1,ques);
//            preparedStatement.setString(2,ans);
//            preparedStatement.executeUpdate();
//
//        }catch (Exception e) {
//
//            //System.out.println(e);
//            System.out.println("Failed at StoreAns Class");
//        }
//    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\Database\\CHATLOG.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the table
     *
     */
    public boolean insert(String ques, String ans) {
        String sql = "INSERT INTO CHATLOGTBL(QUES,ANS) VALUES(?,?)";

        try {
            Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql) ;
            pstmt.setString(1, ques);
            pstmt.setString(2, ans);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
}
}
