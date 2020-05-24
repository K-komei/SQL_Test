package Server_Side;
//SQL作成用インターフェース
interface SQL_Send_Code {
//各種キーワードフィールド
    String sel_code = "SELECT";
    String ins_code = "INSERT";
    String into_code = "INTO";
    String val_code = "VALUE";
    String del_code = "DELETE";
    String whe_code = "WHERE";
    String frm_code = "FROM";
    String wild_code = "*";
    String sp = " ";
    String end = ";";
//SQL文作成用メソッド
    String SELECT_CALL();
    String SELECT_CALL(String[] get_col);
    String INSERT_CALL(String[] add_items);
    String DEL_CALL(String[] condition_code);
    String UPDATE_CALL(String[] condition_code);


}
