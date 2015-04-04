package org.jivesoftware.smack.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DbCreater
{
  public static void main( String args[] )
  {
//    Connection c = null;
//    Statement stmt = null;
    try {

    	JdbcPooledConnectionSource connectionSource =
    			new JdbcPooledConnectionSource("jdbc:sqlite:smack-core/src/main/resources/org.jivesoftware.smack.db/clientStorage");
    	
    	
    	TableUtils.createTableIfNotExists(connectionSource, Message.class);
    	
    	TableUtils.createTableIfNotExists(connectionSource, Conversation.class);
    	
    	TableUtils.createTableIfNotExists(connectionSource, Identity.class);
    	

    	MessageDAO messageDAO = DaoManager.createDao(connectionSource, Message.class);
    	
    	Dao<Conversation, String> conversationDAO = DaoManager.createDao(connectionSource, Conversation.class);

    	Dao<Identity, String> identityDAO = DaoManager.createDao(connectionSource, Identity.class);
    	
    	messageDAO.test();

//    	Message message = new Message();
//    	message.setChatThreadId(2);
//    	message.setmId(2);
//    	message.setmText("Got it man");
//
//    	messageDAO.create(message);

    			
    			
//      Class.forName("org.sqlite.JDBC");
//      c = DriverManager.getConnection("jdbc:sqlite:smack-core/src/main/resources/org.jivesoftware.smack.db/clientStorage");
//      System.out.println("Opened database successfully");
//
//      stmt = c.createStatement();
      
//      String sql = "CREATE TABLE DEPARTMENT("+
//    		   "ID INT PRIMARY KEY      NOT NULL,"+
//    		   "DEPT           CHAR(50) NOT NULL,"+
//    		   "EMP_ID         INT      NOT NULL)";
//      stmt.executeUpdate(sql);
      
      
      
//      String sql = "CREATE TABLE identity " +
//              "(ID INT PRIMARY KEY     NOT NULL," +
//              " NAME           TEXT    NOT NULL, " + 
//              " Type            INT     , " + 
//              " identifier      CHAR(50), " + 
//              " status         CHAR(50)," +
//              " Image         text," +
//              " UniqueN         BOOLEAN," +
//              " Blocked         BOOLEAN)" ; 
// stmt.executeUpdate(sql);
 
 
 
 
//      String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//              "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
// stmt.executeUpdate(sql);
//
// sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//       "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );"; 
// stmt.executeUpdate(sql);
//
// sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//       "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
// stmt.executeUpdate(sql);
//
// sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
//       "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
// stmt.executeUpdate(sql);
 
//      stmt.close();
//      c.close();
    } catch ( Exception e ) {
    	System.out.println(e.getMessage());
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}