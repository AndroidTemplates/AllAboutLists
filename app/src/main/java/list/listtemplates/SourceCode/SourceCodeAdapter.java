package list.listtemplates.SourceCode;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import list.listtemplates.R;
import list.listtemplates.simplelistTypes.SimpleDTOType1;

/**
 * Created by CHANDRASAIMOHAN on 9/2/2016.
 */
public class SourceCodeAdapter extends RecyclerView.Adapter <SourceCodeAdapter.SourceHolder> {

    List<String> sourceData = Collections.EMPTY_LIST;
    Context ctx;
    private LayoutInflater inflator;
    public SourceCodeAdapter(Context ctx,List<String> sourceData){
        this.ctx = ctx;
        this.sourceData = sourceData;
        inflator = LayoutInflater.from(ctx);
    }

    @Override
    public SourceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.source_row_item,parent,false);
        SourceHolder soureViewHolder = new SourceHolder(view);
        return soureViewHolder;
    }

    @Override
    public void onBindViewHolder(SourceHolder holder, int position) {

        holder.title.setText(sourceData.get(position));
    }

    @Override
    public int getItemCount() {
        return sourceData.size();
    }


    public class SourceHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        SourceHolder(View itemView){
                super(itemView);
            title = (TextView) itemView.findViewById(R.id.source_row_label);
            title.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String url = "https://github.com/AndroidTemplates/AllAboutLists";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            ctx.startActivity(i);
        }
    }
}
