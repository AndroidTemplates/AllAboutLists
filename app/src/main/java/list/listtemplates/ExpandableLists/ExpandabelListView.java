package list.listtemplates.ExpandableLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import list.listtemplates.ExpandableAdapters.ExpandableListViewAdapter;
import list.listtemplates.ExpandableParentDTO.ExpandableParentDTO;
import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpandabelListView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpandabelListView extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View expandableView = null;
    private List<String> listDataHeader;
    private HashMap<String, List<Object>> listDataChild;
    ExpandableListView expandableListView;
    ExpandableListViewAdapter expandableListViewAdapter;


    public ExpandabelListView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpandabelListView.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpandabelListView newInstance(String param1, String param2) {
        ExpandabelListView fragment = new ExpandabelListView();
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
        expandableView =  inflater.inflate(R.layout.fragment_expandabel_list_view, container, false);
        expandableListView = (ExpandableListView) expandableView.findViewById(R.id.expandable_list_view);
        HashMap<String, List<Object>> expandableHash = getExpandableListData();
                expandableListViewAdapter = new ExpandableListViewAdapter(getActivity(),listDataHeader,expandableHash);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                SimpleDTOType1 simpleDTOType1 = (SimpleDTOType1)listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(
                        getActivity(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + simpleDTOType1.title, Toast.LENGTH_SHORT)
                        .show();

                return false;
            }
        });


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Expanded Group",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Collapsed Group",
                        Toast.LENGTH_SHORT).show();
            }
        });




        return  expandableView;
    }




    private   HashMap<String, List<Object>>  getExpandableListData(){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();
        int[] images = {R.drawable.ic_msd_wc,R.drawable.ic_kapil,R.drawable.ic_ricky,R.drawable.ic_tunga};
        String[] titles  = {"MS Dhoni(IND)","Kapil Dev(IND)","RickyPonting(AUS)","Rana Tunga(SL)"};


        int[] images1 = {R.drawable.ic_msd,R.drawable.ic_mark,R.drawable.ic_gilly,R.drawable.ic_sanga};
        String[] titles1  = {"MS Dhoni(IND)",
                "Mark Boucher (RSA)",
                "GilChrist(AUS)",
                "Sangakarra(SL)"};


        List<Object>heterogenousList = new ArrayList<>();

        for(int i=0;i<titles.length && i<images.length;i++) {
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            heterogenousList.add(temp);
        }
        listDataChild.put("WorldCup Winning Captains",heterogenousList);

        heterogenousList = new ArrayList<>();
        for(int j=0;j<titles1.length && j<images1.length;j++){
            SimpleDTOType1 temp2 = new SimpleDTOType1();
            temp2.iconId = images1[j];
            temp2.title = titles1[j];
            heterogenousList.add(temp2);
        }
        listDataChild.put("Best Wicket Keepers",heterogenousList);

        listDataHeader.add("WorldCup Winning Captains");
        listDataHeader.add("Best Wicket Keepers");

        return  listDataChild;
    }

}
