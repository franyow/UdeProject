package com.franyow.myappdagger.login;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.franyow.myappdagger.R;
import com.franyow.myappdagger.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @BindView(R.id.et_first_name)
    EditText et_firstname;
    @BindView(R.id.et_last_name)
    EditText et_lastname;
    @BindView(R.id.btn_ingresar)
    Button btnIngresar;

    @Inject
    LoginActivityMVP.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App) getApplication()).getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @OnClick(R.id.btn_ingresar)
    public void btnLogClick( ){
        Toast.makeText(this,"Login Pulsado",Toast.LENGTH_LONG).show();
    }

    @Override
    public String getFirstName() {
        return this.et_firstname.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.et_lastname.getText().toString();
    }

    @Override
    public void showUserNotAvalaible() {
        Toast.makeText(this,"Error, el usuario no está disponible",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Error, El nombre y el apellido no pueden estar vacíos",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this,"Usuario guardado correctamente",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setFirstName(String firstName) {
        this.et_firstname.setText(firstName);

    }

    @Override
    public void setLastName(String lastName) {
        this.et_lastname.setText(lastName);

    }
}
