package com.mycompany.ewalletproject.threads;
import com.mycompany.ewalletproject.App;
import java.sql.*;

public class DeleteTablesThread extends Thread{

  @Override
  public void run(){
      try {
          this.deleteTables();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  public void deleteTables()throws SQLException{
    String[] deleteStatements = new String[]{"{CALL DELETE_CASH}","{CALL DELETE_NOTES}","{CALL DELETE_CREDITCARDS}",
        "{CALL DELETE_DEBITCARDS}","{CALL DELETE_PERSONALCARDS}"};
        for (String statement:deleteStatements){
            CallableStatement statementCall = App.getConnection().prepareCall(statement);
            statementCall.execute();
        }
  }
}
