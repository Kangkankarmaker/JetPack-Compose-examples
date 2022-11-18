package k.example.paging.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import k.example.paging.model.UnSplashImage
import k.example.paging.model.UnSplashRemoteKeys

@Dao
interface UnsplashRemoteKeysDao {

    @Query("SELECT * FROM unsplash_remote_keys_image WHERE id=:id")
    suspend fun getRemoteKeys(id:String): UnSplashRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnSplashRemoteKeys>)

    @Query("DELETE  FROM unsplash_remote_keys_image")
    suspend fun deleteAllRemoteKeys()
}