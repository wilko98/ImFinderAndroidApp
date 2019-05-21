package com.example.unsplashcoroutines

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.example.unsplashcoroutines.BigImale.BigImageActivity
import com.example.unsplashcoroutines.PhotosFragment.PhotosFragment
import com.example.unsplashcoroutines.Random.RandomFragment
import com.example.unsplashcoroutines.Response.Result
import com.example.unsplashcoroutines.SavedPhotos.SavedPhotosFragment
import com.example.data.DAO
import kotlinx.android.synthetic.main.fr_photos.*
import org.koin.android.ext.android.inject
import org.koin.standalone.KoinComponent


class MainActivity : AppCompatActivity(), KoinComponent {

    val dao: com.example.data.DAO by inject()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)
        changeFragment(PhotosFragment.newInstanse())

    }

    override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId) {
        R.id.action_random -> {changeFragment(RandomFragment.newInstance())}
        R.id.action_saved -> {changeFragment(SavedPhotosFragment.newInstance())}
        else -> super.onOptionsItemSelected(item)
    }

    fun changeFragment(fragment: Fragment):Boolean {
        val addToBackStack:Boolean = supportFragmentManager.findFragmentById(R.id.container) != null
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment,fragment.toString())
        if(addToBackStack){
            transaction.addToBackStack(fragment::class.java.simpleName)
        }
        transaction.commit()
        return true
    }

    fun openBigImage(url: String,urlFull: String,imageView: ImageView,photo: Result){
        val intent = Intent(this, BigImageActivity::class.java)
        intent.putExtra("url",url)
        intent.putExtra("urlFull",urlFull)
        intent.putExtra("author",photo.user.username)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            imageView,
            imageView.transitionName
        )
        startActivity(intent,options.toBundle())
    }

}
