package list.listtemplates.IndexedLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FastScrollIndexListView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FastScrollIndexListView extends Fragment implements  View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
List<SimpleDTOType1> simpleDTOType1List;
    Map<String, Integer> mapIndex;
    String[] sections;
View fastScrollView = null;
    ListView fastScrollList;
    public FastScrollIndexListView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FastScrollListView.
     */
    // TODO: Rename and change types and number of parameters
    public static FastScrollIndexListView newInstance(String param1, String param2) {
        FastScrollIndexListView fragment = new FastScrollIndexListView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        simpleDTOType1List = Collections.EMPTY_LIST;
        simpleDTOType1List =   ListUtils.getData();
        if(simpleDTOType1List.size()>0){
            mapIndex =     getIndexList(simpleDTOType1List);
             if(mapIndex!=null && mapIndex.size()>0){
                 sections =     getSections(mapIndex);
             }
        }

        fastScrollView =  inflater.inflate(R.layout.fragment_fast_scroll_index_list_view, container, false);
        initToolBar();
        fastScrollList = (ListView)fastScrollView.findViewById(R.id.fast_scroll_list);

        fastScrollList.setAdapter(new FastScrollAdapter(getActivity(),simpleDTOType1List,mapIndex,sections));
        displayIndex();
        return  fastScrollView;
    }


    private Map<String, Integer>  getIndexList(List<SimpleDTOType1> simpleDTOType1List) {

        //sort employees array using Comparator by Name

        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < simpleDTOType1List.size(); i++) {
            String titleName = simpleDTOType1List.get(i).title;
            String index = titleName.substring(0, 1);

            if (mapIndex.get(index) == null)
                mapIndex.put(index, i);
        }
        return  mapIndex;
    }

    private String[] getSections(Map<String,Integer> mapIndex){
        Set<String> sectionLetters = mapIndex.keySet();
        // create a list from the set to sort
        ArrayList<String> sectionList = new ArrayList<String>( sectionLetters);
        Collections.sort(sectionList);
       String[] sections = new String[sectionList.size()];
        sections = sectionList.toArray(sections);
        return  sections;
    }

    private void displayIndex() {
        LinearLayout indexLayout = (LinearLayout) fastScrollView.findViewById(R.id.side_index);
        TextView textView;
        List<String> indexList = new ArrayList<String>(mapIndex.keySet());
        for (String index : indexList) {
            textView = (TextView) getActivity().getLayoutInflater().inflate(
                    R.layout.side_index_layout, null);
            textView.setText(index);
            textView.setOnClickListener(FastScrollIndexListView.this);
            indexLayout.addView(textView);
        }
    }

    @Override
    public void onClick(View v) {
        TextView selectedIndex = (TextView) v;
        fastScrollList.setSelection(mapIndex.get(selectedIndex.getText()));

     //   indexedRecyclerView.getLayoutManager().scrollToPosition(mapIndex.get(selectedIndex.getText()));
    }

    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Indexed Lists");

    }
}
