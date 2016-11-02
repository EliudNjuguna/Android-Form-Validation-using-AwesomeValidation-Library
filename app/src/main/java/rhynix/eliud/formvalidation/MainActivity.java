package rhynix.eliud.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import android.util.Patterns;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName,editTextEmail,editTextMobile,editTextDob,editTextAge;
    private Button buttonSubmit;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextMobile = (EditText)findViewById(R.id.editTextMobile);
        editTextDob= (EditText)findViewById(R.id.editTextDob);
        editTextAge = (EditText)findViewById(R.id.editTextAge);

        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);

        //adding validation to edittexts

        awesomeValidation.addValidation(this,R.id.editTextName,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.editTextEmail, Patterns.EMAIL_ADDRESS,R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.editTextMobile, "^[2-9]{2}[0-9]{8}$",R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.editTextDob, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.editTextAge, Range.closed(13,60),R.string.nameerror);





        buttonSubmit.setOnClickListener(this);

    }
    private void submitForm(){
        if (awesomeValidation.validate()){
            Toast.makeText(this,"Validation Successful",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit){
            submitForm();
        }

    }
}
