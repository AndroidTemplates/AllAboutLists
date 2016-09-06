package list.listtemplates.ExpandableParentDTO;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by CHANDRASAIMOHAN on 8/25/2016.
 */
public class ExpandableParentDTO implements ParentListItem{
    private String mName;
    private List<Object> mChild;

    public ExpandableParentDTO(String mName, List<Object> mChild) {
        this.mName = mName;
       this.mChild = mChild;
    }
    @Override
    public List<?> getChildItemList() {
        return mChild;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }


    public String getmName(){
        return  mName;
    }

}
