package id.co.iconpln.controlflowapp.network

import id.co.iconpln.controlflowapp.BuildConfig
import id.co.iconpln.controlflowapp.models.myContact.BaseContactResponse
import id.co.iconpln.controlflowapp.models.myContact.ContactResponse
import id.co.iconpln.controlflowapp.models.myProfile.BaseProfileResponse
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginResponse
import id.co.iconpln.controlflowapp.models.myProfile.ProfileLoginUser
import id.co.iconpln.controlflowapp.models.myUser.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

class NetworkConfig {

    companion object {

        @Volatile
        private var retrofit: Retrofit? = null

        private fun getRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
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

        private fun getUserRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
                retrofit ?: buildUserRetrofit().also {
                    retrofit = it
                }
            }
        }

        private fun buildUserRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.USER_BASE_URL)
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getProfileRetrofit(): Retrofit {
            return retrofit ?: synchronized(this) {
                retrofit ?: buildProfileRetrofit().also {
                    retrofit = it
                }
            }
        }

        private fun buildProfileRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BuildConfig.PROFILE_BASE_URL)
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



        fun contactApi(): ContactApiService {
            return getRetrofit().create(ContactApiService::class.java)
        }

        fun userApi(): UserApiService {
            return getUserRetrofit().create(UserApiService::class.java)
        }

        fun profileApi(): ProfileApiService {
            return getProfileRetrofit().create(ProfileApiService::class.java)
        }
    }
}

interface ContactApiService {

    @GET("contacts")
    fun fetchContacts(): Call<BaseContactResponse<ContactResponse>>
}

interface UserApiService {
    @POST("api/v1/user")
    fun createUser(@Body userData: UserDataResponse)
            : Call<CreateUserResponse>

    @GET("api/v1/users")
    fun fetchUsers()
            : Call<BaseUserResponse>

    @PUT("api/v1/user/{id}")
    fun updateUser(@Path("id") id: Int, @Body userData: UserDataResponse):
            Call<UpdatedUserResponse>

    @DELETE("api/v1/user/{id}")
    fun deleteUser(@Path("id") id: Int)
            : Call<DeleteUserResponse>

    @GET("api/v1/user/{id}")
    fun getUser(@Path("id") id: Int)
            :Call<SingleUserResponse<UserDataResponse>>
    
}

interface ProfileApiService {
    @POST ("api/v1/customer/login")
    fun loginUser(@Body profileLoginUser: ProfileLoginUser)
        : Call<BaseProfileResponse<ProfileLoginResponse>>
}
