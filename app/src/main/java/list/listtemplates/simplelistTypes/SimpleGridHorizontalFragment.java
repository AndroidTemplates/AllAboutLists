package list.listtemplates.simplelistTypes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simpleListAdapters.SimpleGridListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleGridHorizontalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleGridHorizontalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
private View simpleGridView = null;
    private RecyclerView simpleGridRecyclerView;

    public SimpleGridHorizontalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleGridFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleGridHorizontalFragment newInstance(String param1, String param2) {
        SimpleGridHorizontalFragment fragment = new SimpleGridHorizontalFragment();
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
        simpleGridView =  inflater.inflate(R.layout.fragment_simple_grid, container, false);
        simpleGridRecyclerView = (RecyclerView) simpleGridView.findViewById(R.id.simplegridrecyclerview);

     //   initTooBar("Horizontal GridList");
        simpleGridRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2, LinearLayoutManager.HORIZONTAL,false);
        simpleGridRecyclerView.setLayoutManager(layoutManager);

        List<SimpleGridDTO> androidVersions = ListUtils.getSimpleGridHorizontalData();
        SimpleGridListAdapter adapter = new SimpleGridListAdapter(getActivity(),androidVersions);
        simpleGridRecyclerView.setAdapter(adapter);
        return  simpleGridView;
    }


    Toolbar mToolBar;
    private void initTooBar(String title){
        mToolBar = (Toolbar) getActivity().findViewById(R.id.app_toolbar);
        mToolBar.setTitle(title);
    }

}
