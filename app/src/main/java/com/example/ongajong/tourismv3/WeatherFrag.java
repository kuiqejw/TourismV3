package com.example.ongajong.tourismv3;

/**
 * Created by ongajong on 27/11/2017.
 */

        import android.content.res.AssetManager;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.text.Html;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.Locale;

public class WeatherFrag extends Fragment {



    TextView cityField, detailsField, currentTemperatureField, weatherIcon, updatedField;

    Typeface weatherFont;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflatedView = inflater.inflate(R.layout.weather_fragment,container, false);
        AssetManager am = getActivity().getApplicationContext().getAssets();

        weatherFont = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "weathericons-regular-webfont.ttf"));

        //setTypeface(typeface);

        //weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView) inflatedView.findViewById(R.id.city_field);
        updatedField = (TextView) inflatedView.findViewById(R.id.updated_field);
        detailsField = (TextView) inflatedView.findViewById(R.id.details_field);
        currentTemperatureField = (TextView) inflatedView.findViewById(R.id.current_temperature_field);
        weatherIcon = (TextView) inflatedView.findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        Function.placeIdTask asyncTask = new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        });
        //asyncTask.execute("37.871853", "-122.258423"); //  asyncTask.execute("Latitude", "Longitude")
        asyncTask.execute("1.250111", "103.830933"); //  asyncTask.execute("Latitude", "Longitude")

        return inflatedView;
    }
}