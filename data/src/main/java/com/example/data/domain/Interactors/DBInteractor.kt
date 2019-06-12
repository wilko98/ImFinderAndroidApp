package com.example.data.domain.Interactors

import com.example.data.db.DAO
import com.example.data.dbPhoto
import kotlinx.coroutines.*

class dbInteractor(val dao:DAO){
    fun getPhotos():List<dbPhoto>{
         var res:List<dbPhoto> = ArrayList(1)
        CoroutineScope (Dispatchers.IO).launch{
        res = dao.getPhotos()
        }
        return res
    }

    fun insertPhoto(dbPhoto: dbPhoto){
        CoroutineScope (Dispatchers.IO).launch {
            dao.insertPhoto(dbPhoto)
        }
    }

    fun deletePhoto(dbPhoto: dbPhoto){
        CoroutineScope (Dispatchers.IO).launch{
            dao.deletePhoto(dbPhoto)
        }
    }
}