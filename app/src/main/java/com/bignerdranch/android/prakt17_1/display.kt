package com.bignerdranch.android.prakt17_1

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class display : AppCompatActivity() {

    lateinit var login: EditText
    lateinit var password: EditText
    lateinit var saveButton: Button
    lateinit var loadButton: Button
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        login = findViewById(R.id.login)
        password = findViewById(R.id.pass)
        saveButton = findViewById(R.id.save)
        loadButton = findViewById(R.id.load)
    }

    fun handler(v: View) {
        if(login.text.toString().isEmpty() && password.text.toString().isEmpty())
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Обнаружены пустые поля")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
        else {
            when (v.id) {
                R.id.save -> {
                    pref = getPreferences(MODE_PRIVATE)
                    val ed = pref.edit()
                    ed.putString("login", login.text.toString())
                    ed.putString("password", password.text.toString())
                    ed.apply()
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Успешно")
                        .setMessage("Файл сохранен")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()
                }

                R.id.load -> {
                    pref = getPreferences(MODE_PRIVATE)
                    login.setText(pref.getString("login", ""))
                    password.setText(pref.getString("password", ""))
                }
            }
        }
    }
}
    /*private final var APP_PREFERENCES = "mysettings"

    private var PREFS_FILE="Account"
    private var PREF_NAME="Name"

    lateinit var settings: SharedPreferences

    private lateinit var nameBox: EditText
    lateinit var nameView: TextView

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE)
    }

    fun saveName(view: View){
        nameBox = findViewById(R.id.nameBox)
        var name = nameBox.getText().toString()

        var prefEditor = settings.edit()

        prefEditor.putString(PREF_NAME, name)
        prefEditor.apply()
    }

    public fun getName(view: View){
        nameView = findViewById(R.id.nameView)

        var name = settings.getString(PREF_NAME, "не определено")
        nameView.setText(name)
        nameBox = findViewById(R.id.nameBox)
        nameBox.setText(name)
    }*/
