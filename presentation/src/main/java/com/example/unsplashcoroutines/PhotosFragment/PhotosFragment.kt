package com.example.unsplashcoroutines.PhotosFragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unsplashcoroutines.Exeptions.NoConnectivityException
import com.example.unsplashcoroutines.R
import com.example.unsplashcoroutines.Response.Result
import kotlinx.android.synthetic.main.fr_photos.*
import org.koin.android.ext.android.inject
import android.app.Application as Application1

class PhotosFragment : Fragment() {

//TODO добавить нормальный футер
//TODO переписать все с использованием репы

    val photosViewModel:PhotosViewModel by inject()
    lateinit var photosAdapter: PhotosAdapter

    companion object{
        fun newInstanse(): PhotosFragment {
            return PhotosFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.fr_photos, container, false)
        setHasOptionsMenu(true)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler.layoutManager = GridLayoutManager(context,3)
        photosAdapter = PhotosAdapter(ArrayList<Result>(30))
        recycler.adapter = photosAdapter
        photosViewModel.searchResponse.observe(this, Observer { photos ->
            photosAdapter.photosList = photos
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
                try {
                    photosViewModel.searchPhotos(query.toString())
                } catch (e:NoConnectivityException){
//                    Toast.makeText(this,"You are offline",Toast.LENGTH_LONG).show()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        Log.i("PhotosFragment","on Pause")
        super.onPause()
    }
    override fun onDestroy() {
        Log.i("PhotosFragment","on Destroy")
        super.onDestroy()
    }
}