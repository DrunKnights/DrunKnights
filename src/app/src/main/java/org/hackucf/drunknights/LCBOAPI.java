
package org.hackucf.drunknights;

import java.util.ArrayList;
import org.json.JSONObject; // Might need to append https://stackoverflow.com/questions/28588802/android-studio-cannot-resolve-import-org-json-jsonobject to Gradle
import java.net.HttpURLConnection;
import android.os.AsyncTask;
import java.net.*;
import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONArray;
import android.util.Log;
import java.net.URLEncoder;

class LCBOAPI extends AsyncTask<ArrayList<String>, Void, ArrayList<JSONArray>> {
      private static final String API_KEY = "n o p e";
      private static final String API_URL = "https://lcboapi.com/products";

      protected ArrayList<JSONArray> doInBackground(ArrayList<String>... params) {
          Log.d("LCBO", "doInBackground");
          ArrayList<String> labels = params[0];
          ArrayList<JSONArray> results = new ArrayList<JSONArray>();

          for(String label : labels){
            try {
                URL url = new URL(API_URL + "?q=" + URLEncoder.encode(label, "UTF-8") + "&access_key=" + API_KEY);
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String res;
                    while ((res = reader.readLine()) != null)
                        sb.append(res).append("\n");

                    reader.close();

                    JSONObject response = new JSONObject(sb.toString());

                    results.add(response.getJSONArray("result"));
                    Log.d("LCBO", sb.toString());
                }
                finally{
                    conn.disconnect();
                }
            }

            catch(Exception e) {
                e.printStackTrace();
                Log.d("LCBO", e.toString());
            }
        }

        return results;
      }

      protected void onPostExecute(ArrayList<JSONObject> results) {

          Log.d("LCBO", results.get(0).toString());
          /*
            Each entry in the results ArrayList will be a JSON array. The entries in each array look like:
              {
                "id": 311787,
                "is_dead": false,
                "name": "Budweiser",
                "tags": "budweiser beer lager canada ontario labatt breweries can",
                "is_discontinued": false,
                "price_in_cents": 1495,
                "regular_price_in_cents": 1495,
                "limited_time_offer_savings_in_cents": 0,
                "limited_time_offer_ends_on": null,
                "bonus_reward_miles": 0,
                "bonus_reward_miles_ends_on": null,
                "stock_type": "LCBO",
                "primary_category": "Beer",
                "secondary_category": "Lager",
                "origin": "Canada, Ontario",
                "package": "6x473 mL can",
                "package_unit_type": "can",
                "package_unit_volume_in_milliliters": 473,
                "total_package_units": 6,
                "volume_in_milliliters": 2838,
                "alcohol_content": 500,
                "price_per_liter_of_alcohol_in_cents": 1053,
                "price_per_liter_in_cents": 526,
                "inventory_count": 61915,
                "inventory_volume_in_milliliters": 175714770,
                "inventory_price_in_cents": 92562925,
                "sugar_content": null,
                "producer_name": "Labatt Breweries Ontario",
                "released_on": null,
                "has_value_added_promotion": false,
                "has_limited_time_offer": false,
                "has_bonus_reward_miles": false,
                "is_seasonal": false,
                "is_vqa": false,
                "is_ocb": false,
                "is_kosher": false,
                "value_added_promotion_description": null,
                "description": null,
                "serving_suggestion": null,
                "tasting_note": null,
                "updated_at": "2017-10-07T14:18:53.078Z",
                "image_thumb_url": "https://dx5vpyka4lqst.cloudfront.net/products/311787/images/thumb.png",
                "image_url": "https://dx5vpyka4lqst.cloudfront.net/products/311787/images/full.jpeg",
                "varietal": "North American Lager",
                "style": "Light \u0026 Malty",
                "tertiary_category": "Pale Lager",
                "sugar_in_grams_per_liter": null,
                "clearance_sale_savings_in_cents": 0,
                "has_clearance_sale": false,
                "product_no": 311787
              }

              Specifically, we are interested in the values of:
                      - name
                      - primary_category
                      - package_unit_type
                      - package_unit_volume_in_milliliters
                      - alcohol_content
                      - image_thumb_url

              Often the response will have multiple entries of the same type, though volumes will be the same, but
              you can skip those and only show the user one entry for each type of container.

              Duplicates can be found by comparing:
                - package_unit_type
                - name
                - volume_in_milliliters
          */
      }
  }
