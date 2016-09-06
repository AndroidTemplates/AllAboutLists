package list.listtemplates.IndexedLists;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import list.listtemplates.R;
import list.listtemplates.simpleListAdapters.SimpleListType1Adapter;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 8/31/2016.
 */
public class FastScrollRecyclerAdapter extends  RecyclerView.Adapter <FastScrollRecyclerAdapter.SimpleType1ViewHolder> implements SectionIndexer {
    List<SimpleDTOType1> simpleDTOTypeList = Collections.EMPTY_LIST;
    Context context;
    String[] sections;
    Map<String, Integer> alphaIndexer;
    private  LayoutInflater inflator;

    public FastScrollRecyclerAdapter(Context context, List<SimpleDTOType1> data, Map<String, Integer> alphaIndexer, String[] sections){
        inflator = LayoutInflater.from(context);
        simpleDTOTypeList = data;
        this.context = context;
        this.sections = sections;
        this.alphaIndexer = alphaIndexer;
    }
 /*   @Override
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
*/

    @Override
    public int getItemCount() {
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



    @Override
    public SimpleType1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.simple_row_type1,parent,false);
        SimpleType1ViewHolder simpleType1ViewHolder = new SimpleType1ViewHolder(view);
        return simpleType1ViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleType1ViewHolder  holder, int position) {
        SimpleDTOType1 simpleDTOType1 = simpleDTOTypeList.get(position);
        holder.title.setText(simpleDTOType1.title);
        holder.title_icon.setImageResource(simpleDTOType1.iconId);
    }

    class SimpleType1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView title_icon;
        LinearLayout rootLayout;
        public SimpleType1ViewHolder(View itemView ){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.simple_type1_title);
            title_icon = (ImageView) itemView.findViewById(R.id.simple_type1_image);
            rootLayout = (LinearLayout)itemView.findViewById(R.id.root_layout);
            // rootLayout.setOnClickListener(this);
        //    title.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            rootLayout.setSelected(false);
            switch (v.getId()){
                case R.id.simple_type1_title:
                    break;
                case  R.id.root_layout:
                    rootLayout.setSelected(true);
                    break;
            }


        }
    }
}
