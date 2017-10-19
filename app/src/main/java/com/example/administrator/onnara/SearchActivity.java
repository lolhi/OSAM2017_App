package com.example.administrator.onnara;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/*
 * Search Class
 *
 * 기능
 * 1. 검색아이콘 클릭시
 *    1-1. 해당 부대명을 찾아 listview 에 출력 시킨다.
 *    1-2. 리스트 뷰 아이템 선택시 해당 부대의 정보를 joinActvity로 넘겨준다.
 *
 */

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener{

    ListView unit_ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        unit_ListView = (ListView)findViewById(R.id.unit_listView);

        unit_ListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Object vo = (Object)parent.getAdapter().getItem(position);
        Intent intent = new Intent();

        intent.putExtra("unit_name",vo.toString());
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default


        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        ArrayList<String> unit_ArrList = new ArrayList<String>();
        Dao dao = new Dao(getApplicationContext());

        unit_ArrList = dao.getUnitNameList(query);

        ArrayAdapter<String> unit_Arradap= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,unit_ArrList);
        unit_ListView.setAdapter(unit_Arradap);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

}
