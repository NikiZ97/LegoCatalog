package ru.nikiz.data.net

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.nikiz.data.entity.LegoCategory
import ru.nikiz.domain.BaseResponse

interface LegoService {

    companion object {
        const val BASE_URL = "https://rebrickable.com/api/v3/"
    }

    @GET("lego/themes")
    suspend fun getCategories(@Query("page") page: Int? = null,
                              @Query("page_size") pageSize: Int? = null,
                              @Query("ordering") order: String? = null)
            : Response<BaseResponse<LegoCategory>>
}