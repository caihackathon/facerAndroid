package com.facer.client.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tadipar on 3/15/2017.
 */

public class Application {
    private String application;
    private String status;
    private String statusDate;

    public Application(JSONObject jsonObject){
        try {
            this.application=jsonObject.getString("application");
            this.status=jsonObject.getString("status");
            this.statusDate=jsonObject.getString("statusDate");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
