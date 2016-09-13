package list.listtemplates.IndexedLists;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IndexedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IndexedListFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View indexedListView  = null;
    RecyclerView indexedRecyclerView;
    SimpleListType1Adapter simpleListType1Adapter;
    Map<String, Integer> mapIndex;
    public IndexedListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IndexedListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IndexedListFragment newInstance(String param1, String param2) {
        IndexedListFragment fragment = new IndexedListFragment();
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
        indexedListView =  inflater.inflate(R.layout.fragment_indexed_list, container, false);
        initToolBar();

        indexedRecyclerView = (RecyclerView)indexedListView.findViewById(R.id.index_recycler_view);

        getIndexList();
        displayIndex();


        simpleListType1Adapter = new SimpleListType1Adapter(getActivity(),getData());
        indexedRecyclerView.setAdapter(simpleListType1Adapter);
        indexedRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        indexedRecyclerView.addItemDecoration(itemDecoration);
        indexedRecyclerView.setItemAnimator(new DefaultItemAnimator());


        return  indexedListView;
    }


    public  List<SimpleDTOType1> getData(){
        List<SimpleDTOType1> dataList = new ArrayList<>();
        int[] images = {R.drawable.ic_india_64,R.drawable.ic_sl_64,R.drawable.ic_zim_64,
                R.drawable.ic_india_64,R.drawable.ic_aus_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_zim_64,R.drawable.ic_sl_64,
                R.drawable.ic_sa_64,R.drawable.ic_india_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_sl_64,R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_aus_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,
                R.drawable.ic_sa_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_india_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_india_64,
                R.drawable.ic_sa_64,R.drawable.ic_zim_64,R.drawable.ic_sl_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_sa_64,R.drawable.ic_aus_64,
                R.drawable.ic_sl_64,R.drawable.ic_sa_64,R.drawable.ic_sa_64,
                R.drawable.ic_india_64,R.drawable.ic_india_64,R.drawable.ic_zim_64,
                R.drawable.ic_aus_64,R.drawable.ic_zim_64,R.drawable.ic_india_64
               };

       String[] titles={"Azhar","ArvindDSilva","Aliastar",
                       "BishenSinghBedi","Bevan","Badrinath",
                        "CAPujara","Cronje","Chaminda",
                       "Dhoni","Dravid","DKartik",
                       "Elgar","Edwards","Ekanayake,B",
                       "FAF","Fazal","FDM Karunaratne",
                       "Gambhir","Ganguly","Gaekwad",
                       "Harbhajan","HashimAmla","Hudson",
                       "Ishant","Imran Tahir",
                       "Jadeja","Jaques Kallis","J Faulkner","Jonty",
                       "Kanitkar","KLRahul","KAbbott",
                       "LD Chandimal","Lans Klusner","LalaAmarnadh",
                       "MSDhoni","MskPrasad","MathewHayden",
                       "NayanMongia","Navjyot Sidhu","NLTC Perera",
                       "Ojha","Oakes JP","O Brien",
                        "Pollock","Pandya","PraveenKumar",
                       "QDCock","Qasim Khurshid",
                        "RJadeja","Rabada","Rayudu",
                        "Sachin","Shikar","Shami",
                        "T Bavuma","T Mupariwa","TDilshan",
                        "Unadket","Utseya P ",
                         "Virat","VD Philander",
                         "WP Saha","WD Parnell","Wade",
                          "Xavier","Xosa","Xaba",
                         "Yuvraj","Yusuf Patan","Young",
                        "Zampa","Zambuko","Zaheer"
             };

     //   String[] titles  = {"India","Brazil","EEUU","Iran","Malaysia","NetherLands","Romania","Turkey","UK","Uzebkistan"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            dataList.add(temp);

        }
        Collections.sort(dataList, new TitleComparator());
        return  dataList;
    }

    private void getIndexList() {
        List<SimpleDTOType1> dataList = new ArrayList<>();
        dataList = getData();
        //sort employees array using Comparator by Name

        mapIndex = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < dataList.size(); i++) {
            String titleName = dataList.get(i).title;
            String index = titleName.substring(0, 1);

            if (mapIndex.get(index) == null)
                mapIndex.put(index, i);
        }
    }

    private void displayIndex() {
        LinearLayout indexLayout = (LinearLayout) indexedListView.findViewById(R.id.side_index);
        TextView textView;
        List<String> indexList = new ArrayList<String>(mapIndex.keySet());
        for (String index : indexList) {
            textView = (TextView) getActivity().getLayoutInflater().inflate(
                    R.layout.side_index_layout, null);
            textView.setText(index);
            textView.setOnClickListener(IndexedListFragment.this);
            indexLayout.addView(textView);
        }
    }

    @Override
    public void onClick(View v) {
        TextView selectedIndex = (TextView) v;
    //    indexedRecyclerView.getLayoutManager().scrollToPosition(mapIndex.get(selectedIndex.getText()));
        indexedRecyclerView.smoothScrollToPosition(mapIndex.get(selectedIndex.getText()));

        //.setSelection(mapIndex.get(selectedIndex.getText()));
    }


    /**
     * Comparator to sort employees list or array in order of Salary
     */

    class TitleComparator implements Comparator{
        public int compare(Object o1,Object o2){
            SimpleDTOType1 s1=(SimpleDTOType1)o1;
            SimpleDTOType1 s2=(SimpleDTOType1)o2;

            return s1.title.compareTo(s2.title);
        }
    }

    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Indexed Lists");

    }
}
