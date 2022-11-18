package k.example.paging.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import k.example.paging.data.local.dao.UnsplashImageDao
import k.example.paging.data.local.dao.UnsplashRemoteKeysDao
import k.example.paging.model.UnSplashImage
import k.example.paging.model.UnSplashRemoteKeys

@Database(entities = [UnSplashImage::class,UnSplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase:RoomDatabase() {

    abstract fun unsplashImageDao():UnsplashImageDao
    abstract fun unsplashRemoteKeysDao():UnsplashRemoteKeysDao
}