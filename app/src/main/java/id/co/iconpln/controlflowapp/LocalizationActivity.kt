package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_localization.*

class LocalizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localization)

        displayLocalizedTexts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_localization, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_language){
            val settingsIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(settingsIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun displayLocalizedTexts(){
        val pokeCount = 3
        val helo: String = resources.getString(
            R.string.locale_count_hello, "Iconplus", pokeCount, "ame"
        )
        tvLocalHello.text = helo

        // plural
        val songCount = 5
        val pluralText = resources.getQuantityText(
            R.plurals.locale_count_plural_songs, songCount
        )
        tvLocalPlural.text = pluralText
    }
}
