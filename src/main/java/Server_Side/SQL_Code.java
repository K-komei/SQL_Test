package Server_Side;

//SQL文のコード生成クラス

class SQL_Code implements SQL_Send_Code{

    //SQL定型文
    private String table_name = "";
    String result ="";

    //操作するテーブル名をコンストラクタにて代入
    private SQL_Code(String table_name){
        this.table_name = table_name;
    }

    // SQLコードの生成メソッド
    @Override
    public String SELECT_CALL(){
     return result;
    }

    @Override
    public String INSERT_CALL() {
        return result;
    }

}
