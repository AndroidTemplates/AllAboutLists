package list.listtemplates.ExpandableAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/28/2016.
 */
public class ExpandableListViewAdapter  extends BaseExpandableListAdapter {

     private Context context;
    private List<String> headerList;
    private HashMap<String, List<Object>> childMap;

    public  ExpandableListViewAdapter(Context context, List<String> headerList, HashMap<String, List<Object>> childMap){
        this.context = context;
        this.headerList = headerList;
        this.childMap = childMap;
    }


    @Override
    public int getGroupCount() {
        return headerList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerList.get(groupPosition);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder viewHolder;
        String groupTitle = headerList.get(groupPosition);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_header_row, parent, false);
            viewHolder = new GroupHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (GroupHolder)convertView.getTag();
        }
        viewHolder.headerView.setText(groupTitle);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childMap.get(headerList.get(groupPosition)).size();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder viewHolder;
        List<Object> childItemList = (List<Object>)  getChild(groupPosition, childPosition);
        Object childItem = childItemList.get(childPosition);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.simple_row_type1, parent, false);
            viewHolder = new ChildHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ChildHolder)convertView.getTag();
        }
        if(childItem instanceof SimpleDTOType1){
            SimpleDTOType1 simpleDTOType1 =(SimpleDTOType1) childItem;
            viewHolder.title.setText(simpleDTOType1.title);
            viewHolder.title_icon.setImageResource(simpleDTOType1.iconId);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(headerList.get(groupPosition));
    }

    private class GroupHolder {
       public final TextView headerView;
        public GroupHolder(View view){
            headerView = (TextView) view.findViewById(R.id.header_label);
        }
    }

    public class ChildHolder{
        public final TextView title;
        public final ImageView title_icon;
        public ChildHolder(View view){
            title = (TextView) view.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) view.findViewById(R.id.simple_type1_image);
        }
    }
}
