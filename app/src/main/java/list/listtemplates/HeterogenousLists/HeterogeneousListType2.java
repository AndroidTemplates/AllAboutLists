package list.listtemplates.HeterogenousLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.HeterogeneousAdapters.HeterogeneousType1Adapter;
import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeterogeneousListType2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeterogeneousListType2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView heterogeneousType1RecyclerView = null;
    HeterogeneousType1Adapter heterogeneousType1Adapter = null;

  View heterogeneousListView = null;
    public HeterogeneousListType2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HeterogeneousListType1.
     */
    // TODO: Rename and change types and number of parameters
    public static HeterogeneousListType2 newInstance(String param1, String param2) {
        HeterogeneousListType2 fragment = new HeterogeneousListType2();
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
        heterogeneousListView =  inflater.inflate(R.layout.fragment_heterogeneous_list_type1, container, false);
        initToolBar();
        heterogeneousType1RecyclerView = (RecyclerView) heterogeneousListView.findViewById(R.id.heterorecyclerviewtype1);
        heterogeneousType1Adapter = new HeterogeneousType1Adapter(getActivity(), ListUtils.getHeterogeneousType2Data());
        heterogeneousType1RecyclerView.setAdapter(heterogeneousType1Adapter);
        heterogeneousType1RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        heterogeneousType1RecyclerView.addItemDecoration(itemDecoration);
        heterogeneousType1RecyclerView.setItemAnimator(new DefaultItemAnimator());

        return heterogeneousListView;
    }



    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Heterogeneous Lists");

    }






}
