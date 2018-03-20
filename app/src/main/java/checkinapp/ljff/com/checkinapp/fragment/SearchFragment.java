package checkinapp.ljff.com.checkinapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import checkinapp.ljff.com.checkinapp.R;

/**
 * Created by Phouthasak Douanglee on 3/14/2018.
 */

public class SearchFragment extends Fragment{
    private String[] items;
    private ArrayList<String> listItems;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private SearchView searchBar;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        searchBar = (SearchView) rootView.findViewById(R.id.svSearchBar);
        populateList();
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchText) {
                adapter.getFilter().filter(searchText);
                return false;
            }
        });
        return rootView;
    }

    private void populateList(){
        items = new String[]{"123", "456", "789"};
        listView = (ListView) rootView.findViewById(R.id.lvStudentList);
        adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_item, R.id.txtitem, items);
        listView.setAdapter(adapter);
    }
}
