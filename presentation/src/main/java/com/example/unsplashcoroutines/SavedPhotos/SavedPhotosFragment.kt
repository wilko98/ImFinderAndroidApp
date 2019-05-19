package com.example.unsplashcoroutines.SavedPhotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.unsplashcoroutines.PhotosFragment.PhotosAdapter
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.db.DAO
import com.example.unsplashcoroutines.db.dbPhoto
import kotlinx.android.synthetic.main.fr_saved_photos.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SavedPhotosFragment : Fragment() {

    val dao: DAO by inject()
    val savedPhotosViewModel: SavedPhotosViewModel by inject()

    companion object {
        fun newInstance(): SavedPhotosFragment {
            return SavedPhotosFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_saved_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = GridLayoutManager(activity, 1)
        val savedPhotosAdapter = SavedPhotosAdapter(savedPhotosViewModel.getPhotos())
        savedPhotosAdapter.notifyDataSetChanged()
        recycler.adapter = savedPhotosAdapter

    }

}