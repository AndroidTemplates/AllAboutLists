package list.listtemplates.ExpandableLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.ExpandableAdapters.ExpandableVerticalAdapter;
import list.listtemplates.ExpandableParentDTO.ExpandableParentDTO;
import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

//  compile 'com.bignerdranch.android:expandablerecyclerview:2.1.1'
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpandableRecycleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpandableRecycleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

   private View expandableRecyclerView = null;
    RecyclerView expandable_recycler;
    ExpandableVerticalAdapter expandableVerticalAdapter;
    List<ExpandableParentDTO> expandableParentDTOList;
    public ExpandableRecycleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpandableRecycleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpandableRecycleFragment newInstance(String param1, String param2) {
        ExpandableRecycleFragment fragment = new ExpandableRecycleFragment();
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
        expandableRecyclerView =  inflater.inflate(R.layout.fragment_expandable_recycle, container, false);
        initToolBar();
        expandable_recycler = (RecyclerView) expandableRecyclerView.findViewById(R.id.expandable_recyclerview);
        expandableParentDTOList = ListUtils.getExpandableRecyclerViewData();
        expandableVerticalAdapter = new ExpandableVerticalAdapter(getActivity(),ListUtils.getExpandableRecyclerViewData());
        expandableVerticalAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                ExpandableParentDTO expandableParentDTO = expandableParentDTOList.get(position);
                Toast.makeText(getActivity(),
                        "Expanded"+expandableParentDTO.getmName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onListItemCollapsed(int position) {
                ExpandableParentDTO expandableParentDTO = expandableParentDTOList.get(position);
                Toast.makeText(getActivity(),
                        "Collapsed"+expandableParentDTO.getmName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        expandable_recycler.setAdapter(expandableVerticalAdapter);
        expandable_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        return  expandableRecyclerView;
    }


    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Expandable Lists");

    }
}
