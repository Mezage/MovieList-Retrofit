package edu.uci.swe264p.retrofit;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class TopRatedResponse {
    @SerializedName("results")
    private List<Movie> result;


    public TopRatedResponse(List<Movie> result) {
        this.result = result;
    }

    public List<Movie> getResult(){
        return result;
    }
}
