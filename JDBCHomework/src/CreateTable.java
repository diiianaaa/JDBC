

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Random;

public class CreateTable {

    private final static String url = "jdbc:postgresql://localhost/MYDATABASE";
    private final static String user = "postgres";
    private final static String password = "1q2w3e";

    private static final String createTableSQL = "CREATE TABLE person " +
        "(ID INT PRIMARY KEY ," +
        " NAME TEXT, " +
        " EMAIL VARCHAR(50), " +
        " PHONE VARCHAR)";
    
  

    public static void main(String[] argv) throws SQLException {
    	
    	
    	CreateTable createTableExample = new CreateTable();
        createTableExample.createTable();
        
 
        final String empInsertSql = "INSERT INTO person (id, name, email,phone) VALUES(?,?,?,?)";
        try (
                // set up the connection in another function. This is just for example
                Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = con.prepareStatement(empInsertSql)
            
              	
                		
        ) {  
                Random rnd = new Random();
                String firstname = "Diana";
                String lastname = "Platica";
                
                Random objGenerator = new Random();
                for (int iCount = 0; iCount< 10; iCount++){
                  int randomNumber = objGenerator.nextInt(100);

              String result = null;
                
                for (int i = 0; i < 1000; i++)   {
                 
                	
        result = Character.toString(firstname.charAt(0)); // First char
        if (lastname.length() > 8)
          result += lastname.substring(0, 8);
        else
          result += lastname;
        result += Integer.toString(rnd.nextInt(99));
        
        
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i1 = 0; i1 < targetStringLength; i1++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

            pstmt.setString(2, generatedString );
            pstmt.setString(3,generatedString + "@yahoo.com");
                // replace with your data setup
                pstmt.setInt(1, i);
         
               
                Random rd= new Random();
            	int rdNum;
            	
            	String m[]=new String[10];
            	
            	for(int i1=0;i1<10;i1++)
            		{rdNum=rd.nextInt(10);
            	
            	m[i1]=Integer.toString(rdNum);
                pstmt.setString(4, m[0]+m[1]+m[2]+m[3]+m[4]+m[5]+m[6]+m[7]+m[8]+m[9]);}
           
                pstmt.addBatch();
                pstmt.clearParameters();
               
            }
                
                Connection connection = DriverManager.getConnection(url, user, password);

                Statement stmt = connection.createStatement();
                System.out.println("Creating statement...");
                
                stmt = connection.createStatement();
              
                String sql = "SELECT id, name FROM person";
                  ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                   //Retrieve by column name
                   int id  = rs.getInt("id");
                   
                   String name= rs.getString("name");
            

                   //Display values
                   System.out.println("ID: " + id);
                  
                   System.out.println("Name: " + name);
                 
                }
                rs.close();
                
                
                //First SQL UPDATE Query to update record.
                  String query1 =  "Update person Set name='Thomas' Where id = '1'";

                  System.out.println("After update:");
                  
                  int count = stmt.executeUpdate(query1);
                  System.out.println("Number of rows updated by executing query1 =  " + count);

          
            int[] results = pstmt.executeBatch();
            // loop to check the result of each record
            for (int k = 0; k < results.length; k++) {
                // if it is a minus value, then the execution failed for that record
                if (results[k] <= 0) {
                    // if it failed for this record do something
                }
            }
         
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
   
        
 
       


    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        
        try (Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();) {

            statement.execute(createTableSQL);
        } catch (SQLException e) {

            printSQLException(e);
        }
        
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
              
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}