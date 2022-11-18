package k.example.paging.data.remote

import k.example.paging.model.SearchResult
import k.example.paging.model.UnSplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {

    @Headers("Authorization: Client-ID gMHlgJigMxF4-kryD2lp1-BPvoEgPsOvbHM56WrPXak")
    @GET("/photos")
    suspend fun getAllImage(
        @Query("page")page: Int,
        @Query("per_page")per_page:Int
    ):List<UnSplashImage>

    @Headers("Authorization: Client-ID gMHlgJigMxF4-kryD2lp1-BPvoEgPsOvbHM56WrPXak")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query")query: String,
        @Query("per_page")per_page:Int
    ):SearchResult


}