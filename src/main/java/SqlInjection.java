import java.sql.*;
import javax.servlet.http.HttpServletRequest;

public class SqlInjection {
    public static ResultSet doQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }

    /* for demo, rename function */
    /* 9/12/2025 - no change for main branch test */
    /* 02/03/2026 - rename for test - addl comment to main*/
    /* 
    public static ResultSet doQuery_demo_02032026(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }
    */


     /* 02/03/2026 - rename for test - addl comment to main
       AI Insights - recommended fix example: as PR 2/4/26 */
     public static ResultSet doQuery_demo_02032026(HttpServletRequest request, Connection connection) throws SQLException {
         String customerName = request.getParameter("customerName");
         String query = "SELECT account_balance FROM user_data WHERE user_name = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, customerName);
         ResultSet results = preparedStatement.executeQuery();
         return(results);
    }
    /* ccaisip - end of recommended fix */
}
