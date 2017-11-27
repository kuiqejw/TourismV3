package com.example.ongajong.tourismv3;

/**
 * Created by ongajong on 27/11/2017.
 */


import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ongajong.tourismv3.Recycler.Album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ShaunActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private AlbumAdaptor adapter;
        private List<Album> albumList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_paul);

            recyclerView = findViewById(R.id.activity_recyclerview);

            albumList = new ArrayList<>();
            adapter = new AlbumsAdapter(this, albumList);

            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);

            prepareAlbums();
        }

        private int getIndex(String text) {
            if (text.equals("bus")) {
                return 0;
            }
            else if (text.equals("taxi")) {
                return 1;
            }
            else if (text.equals("walk")) {
                return 2;
            }
            return 2;
        }

        private void prepareAlbums() {
            int[] icons = new int[]{
                    R.drawable.bus,
                    R.drawable.car,
                    R.drawable.pedestrianwalking
            };

            Map<String, double[]> data = MapData.generateCostTimeMap();

            String[][] result = (String[][]) getIntent().getSerializableExtra("RESULT");

            TextView paulTV = findViewById(R.id.paulTextView);

            String route;
            String fromToTo;
            String transport;
            Album a;
            int index;

            double[] costsAndTimeForTrip;
            for (int i = 0; i < result[0].length; i++) {
                route = result[0][i];
                transport = result[1][i];
                index = getIndex(transport);
                costsAndTimeForTrip = data.get(route);
                fromToTo = MapData.alphaToLocMap.get(route.charAt(0)) + " to " + MapData.alphaToLocMap.get(route.charAt(1));
                a = new Album(fromToTo, "$" + costsAndTimeForTrip[index * 2], costsAndTimeForTrip[index * 2 + 1] + "min", icons[index]);
                albumList.add(a);
            }

            String paulText = String.format(Locale.US, "Cost: $%.2f Total Time: %smins", Double.parseDouble(result[2][0]), result[2][1]);

            paulTV.setText(paulText);
            adapter.notifyDataSetChanged();
        }

        /**
         * RecyclerView item decoration - give equal margin around grid item
         */
        public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

            private int spanCount;
            private int spacing;
            private boolean includeEdge;

            public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
                this.spanCount = spanCount;
                this.spacing = spacing;
                this.includeEdge = includeEdge;
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view); // item position
                int column = position % spanCount; // item column

                if (includeEdge) {
//                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                    outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)

                    outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                    if (position < spanCount) { // top edge
                        outRect.top = spacing;
                    }
                    outRect.bottom = spacing; // item bottom
                } else {
                    outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                    outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                    if (position >= spanCount) {
                        outRect.top = spacing; // item top
                    }
                }
            }
        }

        /**
         * Converting dp to pixel
         */
        private int dpToPx(int dp) {
            Resources r = getResources();
            return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
        }
    }