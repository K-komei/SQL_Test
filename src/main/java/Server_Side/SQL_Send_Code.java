package Server_Side;

interface SQL_Send_Code {
    final String sel_code = "SELECT";

    final String ins_code = "INSERT";
    final String into_code = "INTO";
    final String val_code = "VALUE";
    final String frm_code = "FROM";
    final String wild_code = "*";

    String SELECT_CALL();
    String INSERT_CALL();

}
