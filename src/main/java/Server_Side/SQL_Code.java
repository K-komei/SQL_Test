package Server_Side;

//SQL文のコード生成クラス

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.HashMap;

class SQL_Code implements SQL_Send_Code{
    //SQL定型文
    private String table_name = "";

    //操作するテーブル名をコンストラクタにて代入
    SQL_Code(String table_name){
        this.table_name = table_name;
    }

    // SQLコードの生成メソッド

    //抽出
    @Override
    public String SELECT_CALL(){
        StringBuilder result = new StringBuilder();
        result.append(sel_code);
        result.append(sp);
        result.append(wild_code);
        result.append(sp);
        result.append(frm_code);
        result.append(sp);
        result.append(table_name);
        result.append(sp);
        result.append(end);
    return result.toString();
    }

    @Override
    public String SELECT_CALL(String[] get_col){
        StringBuilder result = new StringBuilder();
        return result.toString();
    }


    @Override
    public String INSERT_CALL(String[] add_items) {
        StringBuilder result = new StringBuilder();

        String ins_text = "";

        for (String text:add_items){
            ins_text = ins_text + sp + "\'" + text + "\'" + ",";
        }

        StringBuilder temp_text = new StringBuilder(ins_text);
        temp_text = temp_text.deleteCharAt(temp_text.length()-1);
        String send_val = "(" + temp_text + ")";

        result.append(ins_code);
        result.append(sp);
        result.append(into_code);
        result.append(sp);
        result.append(table_name);
        result.append(sp);
        result.append(val_code);
        result.append(sp);
        result.append(send_val);
        result.append(sp);
        result.append(end);
        return result.toString();
    }

    @Override
    public String DEL_CALL(String[] condition_code) {

        StringBuilder result = new StringBuilder();
        StringBuilder condition_str = new StringBuilder();
        for (String text:condition_code) {
            condition_str.append(text);
        }

        result.append(del_code);
        result.append(sp);
        result.append(frm_code);
        result.append(sp);
        result.append(table_name);
        result.append(sp);
        result.append(whe_code);
        result.append(sp);
        result.append(condition_str);
        result.append(sp);
        result.append(end);
    return result.toString();
    }
    @Override
    public String UPDATE_CALL(String[]  condition_code){
        StringBuilder result = new StringBuilder();
        return result.toString();
    }

}
