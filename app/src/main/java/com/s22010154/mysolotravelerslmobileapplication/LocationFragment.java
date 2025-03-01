package com.s22010154.mysolotravelerslmobileapplication;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LocationFragment extends Fragment {
    private EditText editTextStart;
    private EditText editTextEnd;
    private Button btnGetPath;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_location, container, false);

        editTextStart = rootView.findViewById(R.id.editTextStart);
        editTextEnd = rootView.findViewById(R.id.editTextEnd);
        btnGetPath = rootView.findViewById(R.id.btnGetPath);
        // Set an OnClickListener for the button to handle the click event
        btnGetPath.setOnClickListener(v -> {
            String startingPoint = editTextStart.getText().toString();
            String endPoint = editTextEnd.getText().toString();

            if (startingPoint.isEmpty() || endPoint.isEmpty()) {
                Toast.makeText(getActivity(), "Please enter starting location and destination",
                        Toast.LENGTH_SHORT).show();
            } else {
                getPath(startingPoint, endPoint);
            }
        });
        return rootView;
    }
    // Method to get the path between two locations
    private void getPath(String startingPoint, String endPoint) {
        try {
            Uri uri = Uri.parse("https://www.google.com/maps/dir/" + startingPoint + "/" + endPoint);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } catch (ActivityNotFoundException exception) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps&hl=en&gl=US");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
