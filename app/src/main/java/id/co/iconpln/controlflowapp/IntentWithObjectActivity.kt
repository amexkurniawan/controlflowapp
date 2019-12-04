package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.models.Person
import kotlinx.android.synthetic.main.activity_intent_with_object.*

class IntentWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    lateinit private var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_with_object)

        getIntentExtra()
        showData()
    }

    private fun showData() {
        val str = "Intent with object, name: ${person.name}, age: ${person.age}, email: ${person.city}, city: ${person.city}"
        tvDataReceivedObject.text = str
    }

    private fun getIntentExtra() {
        person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
    }
}
