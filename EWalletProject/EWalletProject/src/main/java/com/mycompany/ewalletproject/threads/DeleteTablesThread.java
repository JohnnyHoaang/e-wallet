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
    String[] deleteStatements = new String[]{"EXECUTE DELETE_CASH","EXECUTE DELETE_NOTES","EXECUTE DELETE_CREDITCARDS",
        "EXECUTE DELETE_DEBITCARDS","EXECUTE PERSONAL_CARDS"};
        for (String statement:deleteStatements){
            CallableStatement statementCall = App.getConnection().prepareCall(statement);
            statementCall.execute();
        }
  }
}
