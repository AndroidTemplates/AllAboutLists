package list.listtemplates.IndexedLists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/31/2016.
 */
public class FastScrollAdapter extends BaseAdapter implements SectionIndexer {
    List<SimpleDTOType1> simpleDTOTypeList = Collections.EMPTY_LIST;
    Context context;
    String[] sections;
    Map<String, Integer> alphaIndexer;
    public  FastScrollAdapter(Context context, List<SimpleDTOType1> data,Map<String, Integer> alphaIndexer,String[] sections){
        simpleDTOTypeList = data;
        this.context = context;
        this.sections = sections;
        this.alphaIndexer = alphaIndexer;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        SimpleDTOType1 simpleDTOType1 = simpleDTOTypeList.get(position);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.simple_row_type1, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

            viewHolder.title.setText(simpleDTOType1.title);
            viewHolder.title_icon.setImageResource(simpleDTOType1.iconId);

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return simpleDTOTypeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return simpleDTOTypeList.size();
    }

    @Override
    public Object[] getSections() {
        return  sections;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return alphaIndexer.get(sections[sectionIndex]);
    }

    public class ViewHolder{
        public final TextView title;
        public final ImageView title_icon;
        public ViewHolder(View view){
            title = (TextView) view.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) view.findViewById(R.id.simple_type1_image);
        }
    }
}
