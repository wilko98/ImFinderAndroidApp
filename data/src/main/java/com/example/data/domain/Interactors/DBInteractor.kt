package com.example.data.domain.Interactors

import com.example.data.db.DAO
import com.example.data.dbPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class dbInteractor(val dao:DAO){
    fun getPhotos():List<dbPhoto>{
         var res:List<dbPhoto> = ArrayList(1)
        runBlocking (Dispatchers.Default){
        res = dao.getPhotos()
        }
        return res
    }

    fun insertPhoto(dbPhoto: dbPhoto){
        runBlocking (Dispatchers.Default) {
            dao.insertPhoto(dbPhoto)
        }
    }

    fun deletePhoto(dbPhoto: dbPhoto){
        runBlocking (Dispatchers.Default){
            dao.deletePhoto(dbPhoto)
        }
    }
}