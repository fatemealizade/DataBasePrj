package com.example.databaseprj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DataBaseHandler dataBaseHandler = new DataBaseHandler(MainActivity.this);

        //create contact obj first
        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNum("0809343849");

        dataBaseHandler.addContact(jeremy);
        List<Contact> contactList = dataBaseHandler.getAllContacts();

        for (Contact contact : contactList) {
            Log.d("Main", "onCreate: " + contact.getId());
        }
    }
}
