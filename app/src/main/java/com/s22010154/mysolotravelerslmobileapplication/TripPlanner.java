package com.s22010154.mysolotravelerslmobileapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TripPlanner extends AppCompatActivity {
    DatabaseHelper databaseHelper = new DatabaseHelper(this); // Create database object
    EditText editTrip_name, editDestination, editStart_Date, editEnd_Date, editNotes, updateDetails;
    Button btnAddDetails, btnViewAllDetails, btnUpdateDetails, btnDeleteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_planner);

        editTrip_name = findViewById(R.id.editTextTripName);  //Define edit texts & buttons
        editDestination = findViewById(R.id.editTextDestination);
        editStart_Date = findViewById(R.id.editTextStatDate);
        editEnd_Date = findViewById(R.id.editTextEndDate);
        editNotes= findViewById(R.id.editTextNotes);
        updateDetails = findViewById(R.id.editTextEnter_ID);
        btnAddDetails = findViewById(R.id.btn_insert);
        btnViewAllDetails = findViewById(R.id.btn_view);
        btnUpdateDetails = findViewById(R.id.btn_update);
        btnDeleteDetails = findViewById(R.id.btn_delete);

        addDetails();// Calling methods
        viewAllDetails();
        updateDetails();
        deleteDetails();

    }
    public void addDetails(){  // Create addDetails method
        btnAddDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean isInserted = databaseHelper.insertDetails(editTrip_name.getText().toString(),
                        editDestination.getText().toString(),
                        editStart_Date.getText().toString(),editEnd_Date.getText().toString(),
                        editNotes.getText().toString() );
                if(isInserted == true)
                    Toast.makeText(TripPlanner.this,"Trip Details Inserted Successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TripPlanner.this,"Trip Details Not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void viewAllDetails(){  // Create viewAll method & onClickListener method to handle view details button functionality
        btnViewAllDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor results = databaseHelper.getAllData();
                if(results.getCount()==0){
                    showMessage("Error Message :", "No trip details available in the database");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (results.moveToNext()){
                    buffer.append("ID : " + results.getString(0) + "\n");
                    buffer.append("Trip_name : "+ results.getString(1)+ "\n");
                    buffer.append("Destination : "+ results.getString(2)+ "\n");
                    buffer.append("Start_Date : "+ results.getString(3)+ "\n");
                    buffer.append("End_Date : "+ results.getString(4)+ "\n");
                    buffer.append("Notes : "+ results.getString(5)+ "\n\n");

                    showMessage("List of Trip Details",buffer.toString());
                }
            }
        });
    }
    public void showMessage (String title, String message){   //Show message via alert dialog box
        AlertDialog.Builder builder = new AlertDialog.Builder(TripPlanner.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void updateDetails(){  // Create updateData method & onClickListener method to handle update data button functionality
        btnUpdateDetails.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        boolean isUpdate = databaseHelper.updateData(updateDetails.getText().toString(),
                                editTrip_name.getText().toString(),
                                editDestination.getText().toString(),
                                editStart_Date.getText().toString(),
                                editEnd_Date.getText().toString(),
                                editNotes.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(TripPlanner.this,"Trip Details Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(TripPlanner.this, "Trip Details not updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void deleteDetails(){  // Create deleteData method & onClickListener method to handle delete data button functionality
        btnDeleteDetails.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Integer deletedatarows = databaseHelper.deleteData(updateDetails.getText().toString());
                        if(deletedatarows > 0)
                            Toast.makeText(TripPlanner.this,"Trip Details Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(TripPlanner.this, "Trip Details not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}