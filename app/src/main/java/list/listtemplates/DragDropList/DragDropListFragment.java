package list.listtemplates.DragDropList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;
import list.listtemplates.Utils.ListUtils;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DragDropListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DragDropListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView drag_drop_recycler_view = null;
    View dragDropView = null;
    DragDropAdapter dragDropAdapter;

    public DragDropListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DragDropListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DragDropListFragment newInstance(String param1, String param2) {
        DragDropListFragment fragment = new DragDropListFragment();
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
        dragDropView =  inflater.inflate(R.layout.fragment_drag_drop_list, container, false);
        drag_drop_recycler_view = (RecyclerView)dragDropView.findViewById(R.id.drag_drop_recycler_view);

        // Setup Adapter
        dragDropAdapter = new DragDropAdapter(getActivity(), ListUtils.getSimpleListData());
        drag_drop_recycler_view.setAdapter(dragDropAdapter);

        // Setup ItemTouchHelper
        ItemTouchHelper.Callback callback = new DragDropTouchHelper(dragDropAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(drag_drop_recycler_view);

        drag_drop_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        drag_drop_recycler_view.addItemDecoration(itemDecoration);
        drag_drop_recycler_view.setItemAnimator(new DefaultItemAnimator());
        return  dragDropView;
    }

}
