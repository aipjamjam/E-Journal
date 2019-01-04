package com.example.journalUIN.recycleviewAPI;

import com.google.gson.annotations.SerializedName;

public class Journal {
    @SerializedName("journal_id") private int Journal_id;
    @SerializedName("path") private String Path;
    @SerializedName("setting_value") private String Setting_value;
    @SerializedName("url") private String Url;
    @SerializedName("lastissue") private String Lastissue;

    public int getJournal_id() {
        return Journal_id;
    }

    public String getPath() {
        return Path;
    }

    public String getSetting_value() {
        return Setting_value;
    }

    public String getUrl() {
        return Url;
    }

    public String getLastissue() {
        return Lastissue;
    }
}
