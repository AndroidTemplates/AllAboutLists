package list.listtemplates;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import list.listtemplates.DBLists.DBProducts;

/**
 * Created by CHANDRASAIMOHAN on 7/21/2016.
 */
public class MyApplication extends Application {
    private static MyApplication appInstance;
    private static DBProducts mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public  static  MyApplication getAppInstance(){
        return  appInstance;
    }

    public static Context getMyAppContext(){
        return  appInstance.getApplicationContext();
    }

    public synchronized static DBProducts getWritableDatabase() {
        if (mDatabase == null) {
            mDatabase = new DBProducts(getMyAppContext());
        }
        return mDatabase;
    }

    AppCompatActivity mActivityContext;

    public Context getmActivityContext() {
        return mActivityContext;
    }

    public void setmActivityContext(AppCompatActivity mActivityContext) {
        this.mActivityContext = mActivityContext;
    }
}
