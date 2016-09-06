package list.listtemplates.WebServiceLists;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.Collections;
import java.util.List;

import list.listtemplates.R;

/**
 * Created by CHANDRASAIMOHAN on 8/25/2016.
 */
public class WebServiceAdapter extends RecyclerView.Adapter<WebServiceAdapter.WebServiceViewHolder> {

    // The items to display in your RecyclerView
    private List<VolleyDTO> volleyList =   Collections.EMPTY_LIST;;
    private LayoutInflater inflator;
    private  VolleySingleton volleySingleton;
    private ImageLoader volleyImageLoader;
    private int previousPosition  = 0;
    private Context ctx;


    public  WebServiceAdapter(Context context){
        inflator = LayoutInflater.from(context);
        ctx = context;
        volleySingleton = VolleySingleton.getInstance();
        volleyImageLoader = volleySingleton.getmImageLoader();
    }
    @Override
    public WebServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =   inflator.inflate(R.layout.web_service_view_row,parent,false);
        WebServiceViewHolder volleyViewHolder = new WebServiceViewHolder(view);

        return volleyViewHolder;
    }

    public void setVolleyData(List<VolleyDTO> volleyList){
        this.volleyList = volleyList;
        notifyItemRangeChanged(0,volleyList.size());
    }
    @Override
    public void onBindViewHolder(final  WebServiceViewHolder holder, int position) {
        VolleyDTO temp = volleyList.get(position);
        holder.volleyLabel.setText(temp.getVolleyLabel());
        String volleyThumbNailURL = temp.getVolleyImg();
        if(volleyThumbNailURL!=null){
            volleyImageLoader.get(volleyThumbNailURL, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.volleyImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return volleyList.size();
    }

    class WebServiceViewHolder extends RecyclerView.ViewHolder{
        ImageView volleyImage;
        TextView volleyLabel;
        private  WebServiceViewHolder(View itemView){
            super(itemView);
            volleyImage = (ImageView)itemView.findViewById(R.id.volley_img);
            volleyLabel = (TextView)itemView.findViewById(R.id.volley_tview);
        }
    }
}
