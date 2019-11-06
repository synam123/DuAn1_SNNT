package com.example.duan1_snnt.PKGlogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan1_snnt.MainActivity;
import com.example.duan1_snnt.R;

public class Login extends AppCompatActivity {
    EditText edUserName, edPassword;
    ImageView img;
    Button btnLogin, btnCancel, btndagky;
    CheckBox chkRememberPass;
    String strUser, strPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btndagky = (Button) findViewById(R.id.btndangky);
        img = (ImageView) findViewById(R.id.imgview);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.aninn_button);
        btndagky.startAnimation(animation);
        edUserName.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.button);
        edPassword.startAnimation(animation1);
        btnLogin.startAnimation(animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.aninn_img);
        img.startAnimation(animation2);
        chkRememberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        chkRememberPass.setOnCheckedChangeListener(ck);
    }
    public void checkLogin(View v){
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();

        if (strUser.isEmpty()||strPass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không được bỏ trống",
                    Toast.LENGTH_SHORT).show();
        }else {
            if (strUser.equalsIgnoreCase("Sy Nam")&&strPass.equalsIgnoreCase("123456")){
                Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText( getApplicationContext(),"Xin Chào Bạn " + edUserName.getText(), Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(getApplicationContext(),"Thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }
    CompoundButton.OnCheckedChangeListener ck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                Toast.makeText(Login.this, "Lưu Tài Khoản " + compoundButton.getText().toString(), Toast.LENGTH_LONG).show();


            }
        }

    };
    public void exit(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Xác nhận");

        alertDialogBuilder.setIcon(R.drawable.ifo);

        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Đóng Activity hiện tại
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Login.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
