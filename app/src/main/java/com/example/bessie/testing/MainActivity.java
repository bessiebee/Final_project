package com.example.bessie.testing;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listview;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode =0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stubList = (ViewStub) findViewById(R.id.stublist);
        stubGrid = (ViewStub) findViewById(R.id.stubgrid);

        //inflate viewstub before get view

        stubList.inflate();
        stubGrid.inflate();

        listview = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        //get list of product

        getProductList();

        //get current view mode in share reference

        SharedPreferences sharedpreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedpreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);//default is listview

        switchView();

    }

    private void switchView() {

        if(VIEW_MODE_LISTVIEW == currentViewMode) {
            //display Listview
            stubList.setVisibility(View.VISIBLE);
            //Hide gridview
            stubGrid.setVisibility(View.GONE);
        }
        else {
            //hide listview
            stubList.setVisibility(View.GONE);
            //display gridview
            stubGrid.setVisibility(View.VISIBLE);
        }

        setAdapters();
    }

    private void setAdapters() {

        if(VIEW_MODE_LISTVIEW == currentViewMode){
            listViewAdapter = new ListViewAdapter(this, R.layout.list_items, productList);
            listview.setAdapter(listViewAdapter);
        }
        else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_items, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }


    public List<Product> getProductList() {
        //psuedo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.rat,"Title 1","This description 1"));
        productList.add(new Product(R.drawable.rat,"Title 2","This description 2"));
        productList.add(new Product(R.drawable.rat,"Title 3","This description 3"));
        productList.add(new Product(R.drawable.rat,"Title 4","This description 4"));
        productList.add(new Product(R.drawable.rat,"Title 5","This description 5"));
        productList.add(new Product(R.drawable.rat,"Title 6","This description 6"));
        productList.add(new Product(R.drawable.rat,"Title 7","This description 7"));
        productList.add(new Product(R.drawable.rat,"Title 8","This description 8"));
        productList.add(new Product(R.drawable.rat,"Title 9","This description 9"));
        productList.add(new Product(R.drawable.rat,"Title 10","This description 10"));


        return productList;
    }

    
}
