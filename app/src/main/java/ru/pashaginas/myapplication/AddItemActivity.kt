package ru.pashaginas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class AddItemActivity : AppCompatActivity() {
    private lateinit var addButton: Button
    private lateinit var amount: TextInputEditText
    private lateinit var purpose: TextInputEditText

    private val KEY_AMOUNT = "amount"
    private val KEY_PURPOSE = "purpose"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        amount = findViewById(R.id.et_amount)
        purpose = findViewById(R.id.et_purpose)

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener(clickListener)

        fun buttonEnabled() {
            addButton.isEnabled =
                amount.text.toString().isNotEmpty() && purpose.text.toString().isNotEmpty()
        }

        amount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                buttonEnabled()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        purpose.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                buttonEnabled()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        val costId = intent.getIntExtra("COST_ID", 0)
        Log.e("TAG", "Cost Id = $costId") //what?
    }

    private val clickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.add_button -> {
                Toast.makeText(applicationContext, R.string.toast, Toast.LENGTH_SHORT).show()
                val a = amount.text.toString()
                val p = purpose.text.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(KEY_AMOUNT, a)
                intent.putExtra(KEY_PURPOSE, p)
                startActivity(intent)

//                setResult(Activity.RESULT_OK, Intent())
            }
        }
    }
}