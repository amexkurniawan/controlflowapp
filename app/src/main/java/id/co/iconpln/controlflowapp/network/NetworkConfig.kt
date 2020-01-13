package id.co.iconpln.controlflowapp.network

import id.co.iconpln.controlflowapp.BuildConfig
import id.co.iconpln.controlflowapp.models.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.models.myContact.ContactResponse
import id.co.iconpln.controlflowapp.models.myUser.BaseUserResponse
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

class NetworkConfig {

    companion object { // retrofit object
        @Volatile
        private var retrofit: Retrofit? = null

        private fun getRetrofit(): Retrofit {
            return retrofit?: synchronized(this) {

                retrofit ?: buildRetrofit().also {
                    retrofit = it
                }
            }

        }

        private fun buildRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.CONTACT_BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getInterceptor(): OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        }

        fun contactAPI(): ContactAPIService {
            return getRetrofit().create(ContactAPIService::class.java)
        }
    }
}

interface ContactAPIService {
    @GET("contacts") // get endpoint
    fun fetchContacts()
        : Call<BaseContactResponse<ContactResponse>>
}

interface UserAPIService {
    @GET("api/v1/users")
    fun getAllUsers() : Call<BaseUserResponse<UserDataResponse>>
}
