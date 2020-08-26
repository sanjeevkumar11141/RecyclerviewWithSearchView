package com.sanju007.recyclerviewusingsearchviewsk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareList();
    }

    List<String> stringList = new ArrayList<>();
    SearchView searchView;
    RecyclerView idProofImageRecyclerView;
    public void prepareList(){
        searchView = findViewById(R.id.searchView);
        idProofImageRecyclerView = findViewById(R.id.idProofImageRecyclerView);


        stringList.add("Add");
        stringList.add("BAd");
        stringList.add("Sad");
        stringList.add("mad");
        stringList.add("retn");
        stringList.add("pant");
        stringList.add("Sanju");
        stringList.add("Arun");
        stringList.add("sonu");
        stringList.add("Akki");
        stringList.add("Nimmki");
        stringList.add("Papa");
        stringList.add("Mummmy");
        stringList.add("Pooja");
        stringList.add("sachin");
        stringList.add("seema");
        stringList.add("shiv");
        stringList.add("balaesh");
        setList();
    }


    public void setList() {

        TextAdapter adapter = new TextAdapter(this, stringList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(this, llm.getOrientation());
        idProofImageRecyclerView.addItemDecoration(mDividerItemDecoration);


        idProofImageRecyclerView.setLayoutManager(llm);
        idProofImageRecyclerView.setAdapter(adapter);

        setUpSearchView(adapter);
    }


    public void setUpSearchView(final TextAdapter adapter ){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.filter(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s);
                return true;
            }
        });
    }
}
