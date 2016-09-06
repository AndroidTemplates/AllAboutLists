package list.listtemplates.simplelistTypes;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.MyApplication;
import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleListType1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleListType1Fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View simpleListType1View = null;
    private RecyclerView simpleType1RecyclerView;
    private SimpleListType1Adapter simpleListType1Adapter;
    FloatingActionButton add_item;
    Toolbar mToolBar;
    Context activityContext;
    public SimpleListType1Fragment() {
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
    public static SimpleListType1Fragment newInstance(String param1, String param2) {
        SimpleListType1Fragment fragment = new SimpleListType1Fragment();
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
        simpleType1RecyclerView = (RecyclerView)simpleListType1View.findViewById(R.id.simpletype1recyclerview);
        add_item = (FloatingActionButton)simpleListType1View.findViewById(R.id.add_item);
        add_item.setOnClickListener(this);
    //    initTooBar("Basic List");
        simpleListType1Adapter = new SimpleListType1Adapter(getActivity(), ListUtils.getSimpleListData());
        simpleType1RecyclerView.setAdapter(simpleListType1Adapter);
        simpleType1RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        simpleType1RecyclerView.addItemDecoration(itemDecoration);
        simpleType1RecyclerView.setItemAnimator(new DefaultItemAnimator());
        return  simpleListType1View;
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


    private void initTooBar(String title){
        AppCompatActivity activity = (AppCompatActivity) MyApplication.getAppInstance().getmActivityContext();
        mToolBar = (Toolbar) activity.findViewById(R.id.app_toolbar);
        mToolBar.setTitle(title);
    }
}
