package list.listtemplates.ExpandableAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

import list.listtemplates.ExpandableParentDTO.ExpandableParentDTO;
import list.listtemplates.R;

/**
 * Created by CHANDRASAIMOHAN on 8/25/2016.
 */
public class ExpandableVerticalAdapter extends ExpandableRecyclerAdapter<ExpandableParentViewHolder, ExpandableChildViewHolder> {
    private LayoutInflater mInflator;


    public ExpandableVerticalAdapter(Context context, @NonNull List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflator = LayoutInflater.from(context);
    }


    @Override
    public ExpandableParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View parentView = mInflator.inflate(R.layout.expandable_header_row, parentViewGroup, false);
        return new ExpandableParentViewHolder(parentView);
    }


    @Override
    public ExpandableChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View childView = mInflator.inflate(R.layout.simple_row_type1, childViewGroup, false);
        return new ExpandableChildViewHolder(childView);
    }

    @Override
    public void onBindParentViewHolder(ExpandableParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        ExpandableParentDTO expandableParentDTO = (ExpandableParentDTO) parentListItem;
        parentViewHolder.bind(expandableParentDTO);
    }

    @Override
    public void onBindChildViewHolder(ExpandableChildViewHolder childViewHolder, int position, Object childListItem) {
        Object childItem = (Object) childListItem;
        childViewHolder.bind(childItem);
    }
}
