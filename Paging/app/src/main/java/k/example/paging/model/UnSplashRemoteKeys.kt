package k.example.paging.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import k.example.paging.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE


@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnSplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?
)
