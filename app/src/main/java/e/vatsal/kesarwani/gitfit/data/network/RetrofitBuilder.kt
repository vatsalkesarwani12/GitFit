package e.vatsal.kesarwani.gitfit.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import e.vatsal.kesarwani.gitfit.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpInterceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .header("Content-type", "application/json")
            .header("charset", "UTF-8")
            .build()

        chain.proceed(request)
    }

    // OkhttpClient for building http request url
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiInterface = retrofit().create(ApiInterface::class.java)

}
