package com.udacity.sandwichclub.utils;

import android.util.EventLogTags;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        JSONObject sandwichJson;
        String mainName = null;
        ArrayList<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin = null;
        String Description = null;
        String Image = null;
        ArrayList<String> Ingredients = new ArrayList<>();


        try {

            sandwichJson = new JSONObject(json);

            if (sandwichJson.has("mainName")) {
                mainName = sandwichJson.getString("mainName");
            }

            if (sandwichJson.has("placeOfOrigin")) {
                placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            }

            if (sandwichJson.has("description")) {
                Description = sandwichJson.getString("description");
            }

            if (sandwichJson.has("image")) {
                Image = sandwichJson.getString("image");
            }


            if (sandwichJson.has("alsoKnownAs")) {

                JSONArray akaJSONArr = sandwichJson.getJSONArray("alsoKnownAs");

                if (akaJSONArr != null) {

                    for (int i = 0; i < akaJSONArr.length(); i++) {

                        alsoKnownAs.add(akaJSONArr.get(i).toString());

                    }
                }

            }

            if (sandwichJson.has("ingredients")) {

                JSONArray ingredientsJSONArray = sandwichJson.getJSONArray("ingredients");

                if (ingredientsJSONArray != null) {

                    for (int i = 0; i < ingredientsJSONArray.length(); i++) {

                        Ingredients.add(ingredientsJSONArray.get(i).toString());

                    }

                }

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, Description, Image, Ingredients);



        return sandwich;
    }
}
