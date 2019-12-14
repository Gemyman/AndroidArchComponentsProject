package com.ex.androidarchcomponentsproject.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Items extends RealmObject
{
    private String photoUrl;

    @Required
    private String name;

    @Required
    private String description;

    @PrimaryKey
    @Required
    private String id;

    public String getPhotoUrl ()
    {
        return photoUrl;
    }

    public void setPhotoUrl (String photoUrl)
    {
        this.photoUrl = photoUrl;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [photoUrl = "+photoUrl+", name = "+name+", description = "+description+", id = "+id+"]";
    }
}
