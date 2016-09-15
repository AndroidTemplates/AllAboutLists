package list.listtemplates.WebServiceLists;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import list.listtemplates.DividerItemDecoration;
import list.listtemplates.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebServiceRefreshFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebServiceRefreshFragment extends Fragment  implements SwipeRefreshLayout.OnRefreshListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String  URL_VOLLEY = "http://api.walmartlabs.com/v1/paginated/items?format=json&category=3944&apiKey=xxxxxxxxxxxxxxxxx";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View webServiceView  = null;
    RecyclerView webServiceRecycler;
    private WebServiceAdapter webServiceAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    public WebServiceRefreshFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebServiceRefreshFragment newInstance(String param1, String param2) {
        WebServiceRefreshFragment fragment = new WebServiceRefreshFragment();
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
        webServiceView =  inflater.inflate(R.layout.fragment_web_refresh, container, false);
        initToolBar();
        webServiceRecycler = (RecyclerView) webServiceView.findViewById(R.id.webservice_recycler_view);

        swipeRefreshLayout = (SwipeRefreshLayout)webServiceView.findViewById(R.id.swiperefreshlayout) ;
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL);
        webServiceRecycler.addItemDecoration(itemDecoration);
        webServiceRecycler.setItemAnimator(new DefaultItemAnimator());
        webServiceRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        webServiceAdapter = new WebServiceAdapter(getActivity());
        webServiceRecycler.setAdapter(webServiceAdapter);
        if(checkNetworkConnectivity()) {
            getJSON();
        }else{
            Toast.makeText(getActivity(),"No Netwrok Connectivity...",Toast.LENGTH_LONG).show();
        }
        return webServiceView;
    }
    ProgressDialog ringProgressDialog;
    private void getJSON(){
        ringProgressDialog = ProgressDialog.show(getActivity(), "Please wait ...", "Downloading ...", true);
        RequestQueue volleyRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest volleyJSONObjectRequest  = new JsonObjectRequest(Request.Method.GET,URL_VOLLEY,(String)null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MainActivity","Response:::"+response.toString());
                if(response!=null){
                    if(swipeRefreshLayout.isRefreshing()){
                        swipeRefreshLayout.setRefreshing(false);
                    }
                    ringProgressDialog.dismiss();
                    webServiceAdapter.setVolleyData(prepareVolleyList(response));


                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                ringProgressDialog.dismiss();
                Log.d("MainActivity","error:::"+error.toString());
            }
        });
        volleyRequestQueue.add(volleyJSONObjectRequest);
    }

    private void getJSONForSwipe(){
     //   ringProgressDialog = ProgressDialog.show(getActivity(), "Please wait ...", "Downloading ...", true);
        RequestQueue volleyRequestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest volleyJSONObjectRequest  = new JsonObjectRequest(Request.Method.GET,URL_VOLLEY,(String)null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MainActivity","Response:::"+response.toString());
                if(response!=null){
                    if(swipeRefreshLayout.isRefreshing()){
                        swipeRefreshLayout.setRefreshing(false);
                    }
               //     ringProgressDialog.dismiss();
                    webServiceAdapter.setVolleyData(prepareVolleyList(response));


                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
         //       ringProgressDialog.dismiss();
                Log.d("MainActivity","error:::"+error.toString());
            }
        });
        volleyRequestQueue.add(volleyJSONObjectRequest);
    }
    private List<VolleyDTO> prepareVolleyList(JSONObject volleyJSON){
        List<VolleyDTO> volleyLit = new ArrayList<>();
        try{
            JSONArray volleyJsonArray = volleyJSON.getJSONArray("items");
            if(volleyJsonArray!=null && volleyJsonArray.length()>0){
                for(int i=0;i<volleyJsonArray.length();i++){
                    JSONObject volleyJson = volleyJsonArray.getJSONObject(i);
                    VolleyDTO temp = new VolleyDTO();
                    temp.setVolleyLabel(volleyJson.getString("name"));
                    temp.setVolleyImg(volleyJson.getString("thumbnailImage"));
                    volleyLit.add(temp);
                }
            }
        }catch (JSONException e ){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  volleyLit;
    }
    public  boolean checkNetworkConnectivity() {
        ConnectivityManager connectionManager = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectionManager.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    @Override
    public void onRefresh() {
        getJSONForSwipe();
    }


    private void initToolBar(){
        Toolbar mToolBar = (Toolbar)getActivity().findViewById(R.id.app_toolbar);
        TextView toolBarTitle = (TextView)mToolBar.findViewById(R.id.title);
        toolBarTitle.setText("WebService Refresh List ");

    }
}
