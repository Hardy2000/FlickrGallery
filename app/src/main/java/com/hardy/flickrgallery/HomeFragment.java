package com.hardy.flickrgallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hardy.flickrgallery.Models.Photo;
import com.hardy.flickrgallery.Models.RecentPhotos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

private View PhotoView;
private RecyclerView recyclerView;
SwipeRefreshLayout swipeRefreshLayout;

final String apikey=BuildConfig.Api_Key;    //Api key is hidden in gradle
    List<Photo> photo = new ArrayList<>();
    ProgressDialog dialog;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PhotoView= inflater.inflate(R.layout.fragment_home, container, false);
        dialog= new ProgressDialog(getContext());
        dialog.setMessage("Loading....");
        dialog.setCancelable(false);
        dialog.show();
        recyclerView=(RecyclerView)PhotoView.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager((new LinearLayoutManager(PhotoView.getContext())));
        swipeRefreshLayout = (SwipeRefreshLayout)PhotoView.findViewById(R.id.swipeRefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retriveJson(apikey);
            }
        });

        retriveJson(apikey);
        return PhotoView;
    }


    public void retriveJson(String apikey) {
        Call<RecentPhotos> call;
       swipeRefreshLayout.setRefreshing(true);

        call = ApiClient.getInstance().getApi().getRecentPhotos(apikey);
        call.enqueue(new Callback<RecentPhotos>() {

            @Override
            public void onResponse(Call<RecentPhotos> call, Response<RecentPhotos> response) {
                if (response.isSuccessful() && response.body().getPhotos() != null) {
                   swipeRefreshLayout.setRefreshing(false);
                    photo.clear();
                    dialog.dismiss();
                    photo = response.body().getPhotos().getPhoto();
                    Adapter adapter=new Adapter(getContext(),photo);
                    recyclerView.setAdapter(adapter);

//                    textView.setText(response.toString());
  //                  Toast.makeText(getContext(), "DatA Fetched : "+response.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecentPhotos> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                dialog.dismiss();
                Toast.makeText(getContext(), "Error Found : " + t, Toast.LENGTH_LONG).show();

            }
        });
    }

}