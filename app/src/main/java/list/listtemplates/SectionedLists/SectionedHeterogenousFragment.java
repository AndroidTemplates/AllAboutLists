package list.listtemplates.SectionedLists;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.SectionedAdapters.SectionedHeterogenousAdapter;
import list.listtemplates.SectionedAdapters.SectionedHomogenousAdapter;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
import list.listtemplates.simplelistTypes.SimpleGridDTO;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SectionedHeterogenousFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionedHeterogenousFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

   private  RecyclerView sectionHomogeneous_recycler_vew;
    View section_homogeneous_view = null;
    SectionedHeterogenousAdapter sectionedHeterogenousAdapter = null;

    public SectionedHeterogenousFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SectionedHomogeneousFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SectionedHeterogenousFragment newInstance(String param1, String param2) {
        SectionedHeterogenousFragment fragment = new SectionedHeterogenousFragment();
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
        section_homogeneous_view =  inflater.inflate(R.layout.fragment_sectioned_homogeneous, container, false);
        sectionHomogeneous_recycler_vew = (RecyclerView)section_homogeneous_view.findViewById(R.id.sec_homog_recyclerviewtype);

        sectionedHeterogenousAdapter = new SectionedHeterogenousAdapter(getActivity(), ListUtils.getSectionedHeterogeneousData());
        sectionHomogeneous_recycler_vew.setAdapter(sectionedHeterogenousAdapter);

        sectionHomogeneous_recycler_vew.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        sectionHomogeneous_recycler_vew.addItemDecoration(itemDecoration);
        sectionHomogeneous_recycler_vew.setItemAnimator(new DefaultItemAnimator());

        return  section_homogeneous_view;
    }




}
