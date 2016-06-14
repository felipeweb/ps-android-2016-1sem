package br.com.fiap.provasemesrtalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	private EditText edtUser = null;
	private EditText edtPass = null;
	private DatePicker dpData = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void validarLogin(View v) {

		edtUser = (EditText) findViewById(R.id.edtUser);
		edtPass = (EditText) findViewById(R.id.edtPass);
		dpData = (DatePicker) findViewById(R.id.datePicker);

		Intent i = new Intent(this, ValidaLoginService.class);
		i.putExtra("email", edtUser.getText().toString());
		i.putExtra("senha", edtPass.getText().toString());

		i.putExtra("dia", dpData.getDayOfMonth());
		i.putExtra("mes", dpData.getMonth());
		i.putExtra("ano", dpData.getYear());

		startService(i);
	}
}
