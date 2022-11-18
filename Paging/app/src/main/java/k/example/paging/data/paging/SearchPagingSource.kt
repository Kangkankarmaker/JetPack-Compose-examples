package k.example.paging.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import k.example.paging.data.remote.UnSplashApi
import k.example.paging.model.UnSplashImage
import k.example.paging.util.Constants.ITEM_PER_PAGE

class SearchPagingSource(
    private val unsplashApi: UnSplashApi,
    private val query: String
) : PagingSource<Int, UnSplashImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response=unsplashApi.searchImages(query = query, per_page = ITEM_PER_PAGE)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UnSplashImage>): Int? {
        return state.anchorPosition
    }

}