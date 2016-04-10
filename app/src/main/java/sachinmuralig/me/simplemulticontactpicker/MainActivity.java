package sachinmuralig.me.simplemulticontactpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView contactsDisplay;
    Button pickContacts;
    final int CONTACT_PICK_REQUEST = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactsDisplay = (TextView) findViewById(R.id.txt_selected_contacts);
        pickContacts = (Button) findViewById(R.id.btn_pick_contacts);

        pickContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentContactPick = new Intent(MainActivity.this,ContactsPickerActivity.class);
                MainActivity.this.startActivityForResult(intentContactPick,CONTACT_PICK_REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CONTACT_PICK_REQUEST && resultCode == RESULT_OK){

            ArrayList<Contact> selectedContacts = data.getParcelableArrayListExtra("SelectedContacts");

            String display="";
            for(int i=0;i<selectedContacts.size();i++){

                display += (i+1)+". "+selectedContacts.get(i).toString()+"\n";

            }
            contactsDisplay.setText("Selected Contacts : \n\n"+display);

        }

    }


}
