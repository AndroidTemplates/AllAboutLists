package list.listtemplates.CheckedList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckedListFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
  View checkedListView = null;
    RecyclerView checked_recycler_view;
    CheckedListAdapter checkedListAdapter;
    Button show_checked_data;

    public CheckedListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckedListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckedListFragment newInstance(String param1, String param2) {
        CheckedListFragment fragment = new CheckedListFragment();
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
        checkedListView =  inflater.inflate(R.layout.fragment_checked_list, container, false);
        initToolBar();
        checked_recycler_view = (RecyclerView) checkedListView.findViewById(R.id.checked_recycler_view);
        show_checked_data = (Button)checkedListView.findViewById(R.id.show_checked_data);
        show_checked_data.setOnClickListener(this);

        // use this setting to improve performance if you know that changes  in content do not change the layout size of the RecyclerView
        checked_recycler_view.setHasFixedSize(true);

        checked_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        checked_recycler_view.addItemDecoration(itemDecoration);
        checked_recycler_view.setItemAnimator(new DefaultItemAnimator());

        checkedListAdapter = new CheckedListAdapter(getActivity(),getData());
        checked_recycler_view.setAdapter(checkedListAdapter);
         return checkedListView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_checked_data:
                displayData();
                break;
        }
    }

    private  void displayData(){
        String selectedInfo="";
        if(checkedListAdapter!=null) {
            List<CheckedListDTO> checkedList  = ((CheckedListAdapter) checkedListAdapter)
                    .getCheckedListDTOList();
            for(int i=0;i<checkedList.size();i++){
                CheckedListDTO checkedListDTO = checkedList.get(i);
                if (checkedListDTO.isSelected() == true) {
                    selectedInfo = selectedInfo + "\n" + checkedListDTO.getTitle().toString();
                }
            }
            if(!TextUtils.isEmpty(selectedInfo)) {
                Toast.makeText(getActivity(),
                        "Selected Info: \n" + selectedInfo, Toast.LENGTH_LONG)
                        .show();
            }
        }
    }
    private static  List<CheckedListDTO> getData(){
        List<CheckedListDTO> checkedListDTOList = new ArrayList<>();
        int[] images = {R.drawable.ic_msd_wc,R.drawable.ic_kapil,R.drawable.ic_ricky,R.drawable.ic_tunga};
        String[] titles  = {"MS Dhoni(IND)","Kapil Dev(IND)","RickyPonting(AUS)","Rana Tunga(SL)"};
        for(int i=0;i<titles.length && i<images.length;i++) {
            CheckedListDTO temp = new CheckedListDTO(images[i],titles[i],false);
            checkedListDTOList.add(temp);
        }
        return  checkedListDTOList;
    }

    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("Checked List");

    }
}
