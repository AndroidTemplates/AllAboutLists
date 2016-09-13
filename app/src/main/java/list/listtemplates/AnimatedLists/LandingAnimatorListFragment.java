package list.listtemplates.AnimatedLists;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;
////Add  compile 'jp.wasabeef:recyclerview-animators:2.0.1' in build.Grdle

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LandingAnimatorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LandingAnimatorListFragment extends Fragment implements View.OnClickListener {  // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View simpleListType1View = null;
    private RecyclerView simpleType1RecyclerView;
    private AnimationListAdapter simpleListType1Adapter;
    FloatingActionButton add_item;
    public LandingAnimatorListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleListType1.
     */
    // TODO: Rename and change types and number of parameters
    public static LandingAnimatorListFragment newInstance(String param1, String param2) {
        LandingAnimatorListFragment fragment = new LandingAnimatorListFragment();
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
        simpleListType1View =  inflater.inflate(R.layout.fragment_simple_list_type1, container, false);
        initToolBar();
        simpleType1RecyclerView = (RecyclerView)simpleListType1View.findViewById(R.id.simpletype1recyclerview);
        add_item = (FloatingActionButton)simpleListType1View.findViewById(R.id.add_item);
        add_item.setOnClickListener(this);
        simpleListType1Adapter = new AnimationListAdapter(getActivity(),getData(),"ScaleTypeAnimation");
        simpleType1RecyclerView.setAdapter(simpleListType1Adapter);
        simpleType1RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        simpleType1RecyclerView.addItemDecoration(itemDecoration);
        LandingAnimator scaleInAnimator = new LandingAnimator();
        scaleInAnimator.setAddDuration(2000);
        scaleInAnimator.setRemoveDuration(2000);
        simpleType1RecyclerView.setItemAnimator(scaleInAnimator);
     //   simpleType1RecyclerView.setItemAnimator(new SlideInLeftAnimator());
        //simpleType1RecyclerView.setItemAnimator(new DefaultItemAnimator());
        return  simpleListType1View;
    }

    public static List<SimpleDTOType1> getData(){
        List<SimpleDTOType1> dataList = new ArrayList<>();
        int[] images = {R.drawable.ic_india_flag,R.drawable.ic_brazil_flag,R.drawable.ic_eeuu_flags,R.drawable.ic_iran_flag,
                R.drawable.ic_malaysia_flag,R.drawable.ic_netherlands_flag,R.drawable.ic_romania_flag,R.drawable.ic_turkey_flag,
                R.drawable.ic_united_kingdom_flag,R.drawable.ic_uzbekistan_flag};
        String[] titles  = {"India","Brazil","EEUU","Iran","Malaysia","NetherLands","Romania","Turkey","UK","Uzebkistan"};

        for(int i=0;i<titles.length && i<images.length;i++){
            SimpleDTOType1 temp = new SimpleDTOType1();
            temp.iconId = images[i];
            temp.title = titles[i];
            dataList.add(temp);

        }
        return  dataList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_item:
                if(simpleListType1Adapter!=null){
                    simpleListType1Adapter.add();
                }
                break;
        }
    }

    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Animation Lists");

    }
}
