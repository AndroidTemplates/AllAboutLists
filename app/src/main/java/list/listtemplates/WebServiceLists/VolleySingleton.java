package list.listtemplates.WebServiceLists;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import list.listtemplates.MyApplication;

/**
 * Created by CHANDRASAIMOHAN on 7/21/2016.
 */
public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getMyAppContext());
        mImageLoader = new ImageLoader(mRequestQueue,new ImageLoader.ImageCache(){
private LruCache<String,Bitmap> cache = new LruCache<>((int)(Runtime.getRuntime().maxMemory()/1024/8));
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });
    }
    public static synchronized VolleySingleton getInstance() {
        if (mInstance == null) {
            mInstance = new VolleySingleton();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }

    public  ImageLoader getmImageLoader(){
        return  mImageLoader;
    }
}
