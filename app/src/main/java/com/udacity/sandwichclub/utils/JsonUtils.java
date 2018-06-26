package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;
        try
        {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject sandwichNameObject = jsonObject.optJSONObject("name");
            String sandwichName = sandwichNameObject.optString("mainName");

            JSONArray sandwichAlsoKnownAsArray = sandwichNameObject.optJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsArray = new ArrayList<>();
            for(int i = 0; i < sandwichAlsoKnownAsArray.length(); i++)
            {
                alsoKnownAsArray.add(sandwichAlsoKnownAsArray.getString(i));
            }

            String sandwichPlaceOfOrigin = jsonObject.optString("placeOfOrigin");

            String sandwichDescription = jsonObject.optString("description");

            String sandwichImage = jsonObject.optString("image");

            JSONArray sandwichIngredients = jsonObject.optJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();

            for(int i=0; i < sandwichIngredients.length(); i++ )
            {
                ingredients.add(sandwichIngredients.getString(i));
            }
            return new Sandwich(sandwichName, alsoKnownAsArray, sandwichPlaceOfOrigin, sandwichDescription, sandwichImage, ingredients);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return sandwich;
    }
}
