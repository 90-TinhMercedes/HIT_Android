package com.example.searchncovi;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    private int INTERNET_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        viewPager2.setAdapter(new PagerFragment(this));
        tabLayout = findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("Policy");
                        tab.setIcon(R.drawable.ic_baseline_policy_24);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                    case 1: {
                        tab.setText("Statistical");
                        tab.setIcon(R.drawable.ic_baseline_place_24);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                    case 2: {
                        tab.setText("About us");
                        tab.setIcon(R.drawable.ic_baseline_verified_user_24);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)
                        );
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(7);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                }
            }
        });
        tabLayoutMediator.attach();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                BadgeDrawable badgeDrawable = tabLayout.getTabAt(position).getOrCreateBadge();
                badgeDrawable.setVisible(false);
            }
        });


//        tabLayout = findViewById(R.id.tab_layout);
//        viewPager = findViewById(R.id.view_pager);
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Statistical");
//        arrayList.add("About us");
//        prepareViewPager(viewPager, arrayList);
//        tabLayout.setupWithViewPager(viewPager);


        // request permission
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(MainActivity.this, "You have", Toast.LENGTH_SHORT).show();
//        } else {
//            requestInternetPermission();
//        }



    }


//        private void requestInternetPermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)){
//            new AlertDialog.Builder(this)
//                    .setTitle("Permission need")
//                    .setMessage("You confirm")
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.INTERNET}, INTERNET_PERMISSION_CODE);
//                        }
//                    })
//                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    }).create().show();
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, INTERNET_PERMISSION_CODE);
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == INTERNET_PERMISSION_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


    // TabLayout and ViewPager ver 2
    //        private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {
//        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
//        SearchFragment searchFragment = new SearchFragment();
//        for (int i=0; i<arrayList.size(); i++){
//            Bundle bundle = new Bundle();
//            // put string
//            bundle.putString("title", arrayList.get(i));
//
//            // add argument
//            searchFragment.setArguments(bundle);
//
//            // add fragment
//            adapter.addFragment(searchFragment, arrayList.get(i));
//
//            searchFragment = new SearchFragment();
//        }
//        viewPager.setAdapter(adapter);
//    }

//    private class MainAdapter extends FragmentPagerAdapter {
//        ArrayList<String> arrayList = new ArrayList<>();
//        List<Fragment> fragmentList = new ArrayList<>();
//        // create constructor
//        public void addFragment(Fragment fragment, String title){
//            // add title
//            arrayList.add(title);
//            // add fragment
//            fragmentList.add(fragment);
//        }
//
//        public MainAdapter(@NonNull FragmentManager fm) {
//            super(fm);
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//            // return fragment position
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            // return fragment list size
//            return fragmentList.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            // return array list position
//            return arrayList.get(position);
//        }
//    }
    }