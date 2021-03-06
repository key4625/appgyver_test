package plugin.google.maps.appGyver;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;

import org.json.JSONException;
import org.json.JSONArray;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.LatLng;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMaps extends CordovaPlugin {
  public CordovaWebView webView;
  private Activity activity;
  public GoogleMap map = null;

  @Override
  public void initialize(CordovaInterface cordova, final CordovaWebView webView) {
    super.initialize(cordova, webView);
    activity = cordova.getActivity();
    this.webView = webView;
  }
  @Override
  public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
    Runnable runnable = new Runnable() {
      public void run() {
        // ------------------------------
        // Initialize Google Maps SDK
        // ------------------------------
        try {
          MapsInitializer.initialize(activity);
        } catch (Exception e) {
          e.printStackTrace();
          callbackContext.error(e.getMessage());
          return;
        }
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL);
        options.compassEnabled(true);
        Builder builder = CameraPosition.builder();
        builder.target(new LatLng(0, 0));
        builder.zoom(0);
        options.camera(builder.build());
        MapView mapView = new MapView(activity, options);
       
        // Hack for AppGyver (I don't know why, but it works well)
        try {
          mapView.onCreate(null);
        } catch(Exception e) {
          mapView.onCreate(new Bundle());
        }
        mapView.onResume();
        webView.addView(mapView);
        callbackContext.success();
        map = mapView.getMap();
        map.setMyLocationEnabled(true);
      }
    };
    cordova.getActivity().runOnUiThread(runnable);
    return true;
  }
 
 
}
