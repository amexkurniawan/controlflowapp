package id.co.iconpln.controlflowapp.network

import id.co.iconpln.controlflowapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkConfig {

    companion object { // retrofit object
        @Volatile
        private var retrofit: Retrofit? = null

        private fun buildRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.CONTACT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
