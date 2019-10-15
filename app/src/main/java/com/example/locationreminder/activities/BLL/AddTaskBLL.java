package com.example.locationreminder.activities.BLL;

import com.example.locationreminder.activities.interfaces.Url;
import com.example.locationreminder.activities.models.LongLat;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static com.example.locationreminder.activities.interfaces.Url.cookie;

public class AddTaskBLL {
    private LongLat longLat;
    private boolean isSuccess = false;

    public AddTaskBLL(LongLat longLat)
    {
        this.longLat = longLat;
    }

    public boolean addTask() {
        try {
            Response<ResponseBody> body = Url.getEndPoints().postlonglat(cookie, longLat).execute();
            if(body.isSuccessful()){
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
