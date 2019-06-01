package com.example.unsplashcoroutines.Random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.data.NetworkRepository
import com.example.unsplashcoroutines.PhotosFragment.PhotosAdapter
import com.example.unsplashcoroutines.PhotosFragment.PhotosViewModel
import com.example.unsplashcoroutines.R
import com.example.data.Response.PhotoResult
import kotlinx.android.synthetic.main.fr_photos.*
import org.koin.android.ext.android.inject

class RandomFragment() : Fragment(){

    val networkService: NetworkRepository  by inject()


    val photosViewModel: PhotosViewModel by inject()
    lateinit var photosAdapter: PhotosAdapter

    companion object{
        fun newInstance():RandomFragment{
            return RandomFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_photos,container,false)
        setHasOptionsMenu(true)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = GridLayoutManager(context,3)
        photosAdapter = PhotosAdapter(ArrayList<PhotoResult>(30))
        recycler.adapter = photosAdapter
        photosViewModel.randomResponse.observe(this, Observer { photos ->
            photosAdapter.photosList = photos
            photosAdapter.notifyDataSetChanged()
        })

        photosViewModel.getRandomPhotos()
//        var randomPhoto:PhotoResult
//        randomBtn.setOnClickListener {
//            GlobalScope.launch(Dispatchers.Main) {
//                randomPhoto = networkService.getRandomPhoto().await()
//                Glide.with(this@RandomFragment).load(randomPhoto.urls.regular).into(randomPhotoIv)
//                randomPhotoIv.setOnClickListener {
//                    (context as MainActivity).openBigImage(randomPhoto.urls.regular,randomPhoto.urls.full,randomPhotoIv,randomPhoto)
//                }
//            }
//        }
    }

}