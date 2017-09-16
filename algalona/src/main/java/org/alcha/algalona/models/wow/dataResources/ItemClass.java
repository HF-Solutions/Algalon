package org.alcha.algalona.models.wow.dataResources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on Sep 15, 2017 @ 22:18.</p>
 */

public class ItemClass {
    private int mClass;
    private String mName;
    private List<SubClass> mSubClasses;

    public ItemClass() {

    }

    public static ItemClass newInstanceFromJson(JsonObject jsonObject) {
        ItemClass itemClass = new ItemClass();

        if (jsonObject.has("class"))
            itemClass.setClassInt(jsonObject.get("class").getAsInt());
        else itemClass.setClassInt(-1);

        if (jsonObject.has("name"))
            itemClass.setName(jsonObject.get("name").getAsString());
        else itemClass.setName("");

        if (jsonObject.has("subclasses"))
            itemClass.setSubClasses(SubClass.parseJsonArray(jsonObject.getAsJsonArray("subclasses")));
        else itemClass.setSubClasses(new ArrayList<SubClass>());

        return itemClass;
    }

    public static List<ItemClass> parseJsonArray(JsonArray jsonArray) {
        List<ItemClass> itemClasses = new ArrayList<>();

        for (JsonElement element : jsonArray)
            itemClasses.add(newInstanceFromJson(element.getAsJsonObject()));

        return itemClasses;
    }

    public int getClassInt() {
        return mClass;
    }

    public void setClassInt(int aClass) {
        mClass = aClass;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<SubClass> getSubClasses() {
        return mSubClasses;
    }

    public void setSubClasses(List<SubClass> subClasses) {
        mSubClasses = subClasses;
    }

    public static class SubClass {
        private int subclass;
        private String name;

        public SubClass() {
        }

        public static SubClass newInstanceFromJson(JsonObject jsonObject) {
            SubClass subClass = new SubClass();

            if (jsonObject.has("subclass"))
                subClass.setSubclass(jsonObject.get("subclass").getAsInt());
            else subClass.setSubclass(-1);

            if (jsonObject.has("name"))
                subClass.setName(jsonObject.get("name").getAsString());
            else subClass.setName("");

            return subClass;
        }

        public static List<SubClass> parseJsonArray(JsonArray jsonArray) {
            List<SubClass> subClasses = new ArrayList<>();

            for (JsonElement element : jsonArray)
                subClasses.add(newInstanceFromJson(element.getAsJsonObject()));

            return subClasses;
        }

        public int getSubclass() {
            return subclass;
        }

        public void setSubclass(int subclass) {
            this.subclass = subclass;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
