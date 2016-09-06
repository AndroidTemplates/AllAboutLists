package list.listtemplates;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import list.listtemplates.AnimatedLists.FlipInTopAnimatorListFragment1;
import list.listtemplates.AnimatedLists.LandingAnimatorListFragment;
import list.listtemplates.AnimatedLists.ScaleInAnimatorListFragment;
import list.listtemplates.AnimatedLists.ScaleInAnimatorListFragment1;
import list.listtemplates.AnimatedLists.ScrollingAnimatorListFragment;
import list.listtemplates.AnimatedLists.ScrollingAnimatorThirdPartyLibListFragment;
import list.listtemplates.CheckedList.CheckedListFragment;
import list.listtemplates.DBLists.DBWebServiceFragment;
import list.listtemplates.ExpandableLists.ExpandabelListView;
import list.listtemplates.ExpandableLists.ExpandableRecycleFragment;
import list.listtemplates.HeterogenousLists.HeterogeneousListType1;
import list.listtemplates.HeterogenousLists.HeterogeneousListType2;
import list.listtemplates.IndexedLists.FastScrollIndexListView;
import list.listtemplates.IndexedLists.FastScrollListView;
import list.listtemplates.IndexedLists.IndexedListFragment;
import list.listtemplates.SectionedLists.SectionedHeterogenousFragment;
import list.listtemplates.SectionedLists.SectionedHomogeneousFragment;
import list.listtemplates.SourceCode.SourceCodeListFragment;
import list.listtemplates.WebServiceLists.WebServiceFragment;
import list.listtemplates.WebServiceLists.WebServiceRefreshFragment;
import list.listtemplates.simplelistTypes.SimpleGridFragment;
import list.listtemplates.simplelistTypes.SimpleGridHorizontalFragment;
import list.listtemplates.simplelistTypes.SimpleListType1Fragment;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    private static final String  SELECTED_ITEM_ID = "selected_item_id";
    private static final String FIRST_TIME = "first_time";
    private Toolbar mToolbar;
    private NavigationView navigationViewDrawer;
    private DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    private int mSelectedId;
    private boolean mUserSawDrawer = false;
    Menu popUpMenu;
    private  AppCompatActivity appCompatActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(mToolbar);
        saveActivityStateInGlobal();
        navigationViewDrawer = (NavigationView)findViewById(R.id.main_nav_view_drawer);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
         mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        navigationViewDrawer.setNavigationItemSelectedListener(this);
        if (!didUserSeeDrawer()) {
            showDrawer();
            markDrawerSeen();
        } else {
            hideDrawer();
        }
        mSelectedId = savedInstanceState==null ? R.id.navigation_item_2:savedInstanceState.getInt(SELECTED_ITEM_ID);
        navigate(mSelectedId);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
        saveActivityStateInGlobal();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();

        navigate(mSelectedId);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(SELECTED_ITEM_ID,mSelectedId);
    }

    @Override
    protected void onPause() {

        super.onPause();
    }



    @Override
    protected void onStop() {
        Log.d("Activity","OnStop()....");
        super.onStop();
    }

    private void navigate(int mSelectedId) {
        Intent intent = null;
        if(mSelectedId == R.id.navigation_item_2){
            mDrawerLayout.closeDrawer(GravityCompat.START);
          //  return  true;
            //SimpleListType1
            Fragment simpleListType1Frag = new SimpleListType1Fragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, simpleListType1Frag)
                    .commit();
        }
        if(mSelectedId == R.id.navigation_item_3){
            mDrawerLayout.closeDrawer(GravityCompat.START);
          //  return  true;
            Fragment simpleGridFragment = new SimpleGridFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, simpleGridFragment)
                    .commit();
        }
        if(mSelectedId == R.id. navigation_item_6){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            //   return  true;
            Fragment horizontalGrid = new SimpleGridHorizontalFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, horizontalGrid)
                    .commit();
        }
        if(mSelectedId == R.id.navigation_item_5){
            //Heterogeneous List
            mDrawerLayout.closeDrawer(GravityCompat.START);
         //   return  true;
            Fragment heterogenousType1Fragment  = new HeterogeneousListType1();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, heterogenousType1Fragment)
                    .commit();
        }else if(mSelectedId==R.id.navigation_item_22){
            //Heterogeneous List
            mDrawerLayout.closeDrawer(GravityCompat.START);
            //   return  true;
            Fragment heterogenousType2Fragment  = new HeterogeneousListType2();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, heterogenousType2Fragment)
                    .commit();
        }else if(mSelectedId == R.id.navigation_item_66){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment sectionedHomogeneousFragment  = new SectionedHomogeneousFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, sectionedHomogeneousFragment)
                    .commit();
        }else if(mSelectedId == R.id.section_heterogeneous){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment sectionedHeterogeneousFragment  = new SectionedHeterogenousFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, sectionedHeterogeneousFragment)
                    .commit();
        }else if(mSelectedId == R.id.expandable_type1){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment expandableListType1 = new ExpandableRecycleFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, expandableListType1)
                    .commit();

        }else if(mSelectedId == R.id.checked_list_type){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment checkedListFragment = new CheckedListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, checkedListFragment)
                    .commit();
        }else if(mSelectedId == R.id.webservice_type){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment webServiceListFragment = new WebServiceFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, webServiceListFragment)
                    .commit();
        }else if(mSelectedId == R.id.swipe_type){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment swipeRefreshFrag = new WebServiceRefreshFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, swipeRefreshFrag)
                    .commit();
        }else if(mSelectedId == R.id.animated_list_type1){

            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type1AnimatedFrag = new ScaleInAnimatorListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type1AnimatedFrag)
                    .commit();
        }else if(mSelectedId == R.id.animated_list_type2){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type2AnimatedFrag = new ScaleInAnimatorListFragment1();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type2AnimatedFrag)
                    .commit();

        }else if(mSelectedId == R.id.animated_list_type3){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type3AnimatedFrag = new FlipInTopAnimatorListFragment1();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type3AnimatedFrag)
                    .commit();

        }else if(mSelectedId==R.id.animated_list_type4){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type4AnimatedFrag = new LandingAnimatorListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type4AnimatedFrag)
                    .commit();
        }else if(mSelectedId==R.id.animated_list_type5){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type5AnimatedFrag = new ScrollingAnimatorListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type5AnimatedFrag)
                    .commit();
        }else if(mSelectedId==R.id.animated_list_type6){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type6AnimatedFrag = new ScrollingAnimatorThirdPartyLibListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type6AnimatedFrag)
                    .commit();
        }else if(mSelectedId == R.id.expandable_list_type2){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment type2ExpandableFrag = new ExpandabelListView();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, type2ExpandableFrag)
                    .commit();
        }else if(mSelectedId == R.id.db_list_type1){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment DBListFrag = new DBWebServiceFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, DBListFrag)
                    .commit();
        }else if(mSelectedId == R.id.indexed_list_type1){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment indexedListFrag = new IndexedListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, indexedListFrag)
                    .commit();
        }else if(mSelectedId == R.id.indexed_list_type2){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment indexedListFrag2 = new FastScrollListView();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, indexedListFrag2)
                    .commit();
        }else if(mSelectedId == R.id.indexed_list_type3){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Fragment indexedListFrag3 = new FastScrollIndexListView();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frag_parentLayout, indexedListFrag3)
                    .commit();
        }
    }

    private boolean didUserSeeDrawer() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = sharedPreferences.getBoolean(FIRST_TIME, false);
        return mUserSawDrawer;
    }

    private void markDrawerSeen() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserSawDrawer = true;
        sharedPreferences.edit().putBoolean(FIRST_TIME, mUserSawDrawer).apply();
    }

    private void showDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    private void hideDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        this.popUpMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId()==R.id.action_settings){
                Fragment sourceFrag = new SourceCodeListFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frag_parentLayout, sourceFrag)
                        .addToBackStack(null)
                        .commit();

            }
            return super.onOptionsItemSelected(item);
    }



    private void saveActivityStateInGlobal(){
        appCompatActivity = MainActivity.this;
        MyApplication.getAppInstance().setmActivityContext(appCompatActivity);
    }
}
