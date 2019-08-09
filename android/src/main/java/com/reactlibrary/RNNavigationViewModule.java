
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.mapbox.mapboxsdk.Mapbox;

import retrofit2.Call;
import retrofit2.Response;

import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.geojson.Point;

import android.os.Handler;
import android.os.Looper;

public class RNNavigationViewModule extends ReactContextBaseJavaModule implements retrofit2.Callback<DirectionsResponse> {

  private final ReactApplicationContext reactContext;

  public RNNavigationViewModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Mapbox.getInstance(RNNavigationViewModule.this.reactContext, "pk.eyJ1IjoibWljaGFlbHNsYWJlbnlhayIsImEiOiJjanoxZWhvN3Iwa2t4M2N1b3h2ZHkwNHR1In0.TkL-kezlHSnPdkl0uIQomg");
            }
        });
    
  }

  @Override
  public String getName() {
    return "RNNavigationView";
  }

  @ReactMethod
  public void helloWorld() {
    
  }

  @ReactMethod
  public void navigate(Double originLat, Double originLong, Double destLat, Double destLong) {

    Point origin = Point.fromLngLat(originLong, originLat);
    Point destination = Point.fromLngLat(destLong, destLat);

    NavigationRoute.builder(reactContext)
            .accessToken("pk.eyJ1IjoibWljaGFlbHNsYWJlbnlhayIsImEiOiJjanoxZWhvN3Iwa2t4M2N1b3h2ZHkwNHR1In0.TkL-kezlHSnPdkl0uIQomg")
            .origin(origin)
            .destination(destination)
            .build()
            .getRoute(this);
  }

  @Override
  public void onResponse(Call<DirectionsResponse> call, final Response<DirectionsResponse> response) {
    System.out.println(response);
   new Handler(Looper.getMainLooper()).post(new Runnable() {
      @Override
      public void run() {
          boolean simulateRoute = true;
          NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                  .directionsRoute(response.body().routes().get(0))
                  .shouldSimulateRoute(simulateRoute)
                  .build();

          NavigationLauncher.startNavigation(getCurrentActivity(), options);
        }
    });
  }

  @Override
  public void onFailure(Call<DirectionsResponse> call, Throwable t) {

  }

}