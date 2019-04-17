package com.example.unsplashcoroutines.PhotosFragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashcoroutines.ApplicationSingleton
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.Response.SearhResponse
import kotlinx.android.synthetic.main.fr_photos.*
import android.app.Application as Application1

class PhotosFragment : Fragment() {

    lateinit var photosViewModel: PhotosViewModel
    lateinit var photosAdapter: PhotosAdapter

    companion object {
        fun newInstanse(): PhotosFragment {
            return PhotosFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.retainInstance = true
        val v: View = inflater.inflate(R.layout.fr_photos, container, false)
        setHasOptionsMenu(true)
        photosViewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = LinearLayoutManager(context)

        photosAdapter = PhotosAdapter(ArrayList<Result>(10))
        photosAdapter.photosList = ApplicationSingleton.currentPhotos
        recycler.adapter = photosAdapter
        Log.i("photosFragmentb", photosViewModel.toString())
        photosViewModel.searhResponse.observe(this, Observer { photos ->
            photosAdapter.photosList = photos.results
            photosAdapter.notifyDataSetChanged()
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setQueryHint("Search Photos")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                photosViewModel.searchPhotos(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}