package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieEntity
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-09-24.
 */

class FakeRepo @Inject constructor(){

    val movieList = mutableListOf<MovieEntity>()

    private val _movieLiveData = MutableLiveData<List<MovieEntity>>()

    private val movieLiveData : LiveData<List<MovieEntity>>
        get() = _movieLiveData


    fun fetchMovie(): LiveData<List<MovieEntity>> {
        provideMovieData()
        _movieLiveData.value = movieList
        return movieLiveData
    }

    private fun provideMovieData() {
        //definitely need to remove this very long string,
        // only temporary for fake data
        var movie = MovieEntity("A Star is Born",
            "Seasoned musician Jackson Maine discovers -- and falls in love with -- struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jackson coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking dow…",
            R.drawable.poster_a_start_is_born,
            "7.7"
            )
        movieList.add(movie)
        movie = MovieEntity("Alita",
            "Set several centuries in the future, the abandoned Alita is found in the scrapyard of Iron City by Ido, a compassionate cyber-doctor who takes the unconscious cyborg Alita to his clinic. When Alita awakens, she has no memory of who she is, nor does she have any recognition of the world she finds herself in. As Alita learns to navigate her new life and the treacherous streets of Iron City, Ido tries to shield her from her mysterious past.",
            R.drawable.poster_alita,
            "7.4")
        movieList.add(movie)
        movie = MovieEntity("Aquaman",
            "Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people -- and then the surface world. Standing in his way is Aquaman, Orm's half-human, half-Atlantean brother and true heir to the throne. With help from royal counselor Vulko, Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep.",
            R.drawable.poster_aquaman,
            "7")
        movieList.add(movie)
        movie = MovieEntity("Bohemian Rhapsody",
            "A film about popular music band",
            R.drawable.poster_bohemian,
            "8")
        movieList.add(movie)
        movie = MovieEntity("Cold Pursuit",
            "Hmm, I never watch this movie, can't describe it",
            R.drawable.poster_cold_persuit,
            "0")
        movieList.add(movie)
        movie = MovieEntity("Creed",
            "A film about boxer from wakanda, he failed to be king in Wakanda so pivot become a successful boxer",
            R.drawable.poster_creed,
            "7.8")
        movieList.add(movie)
        movie = MovieEntity("Crimes",
            "Also never watch this movie, but I think it's about crime",
            R.drawable.poster_crimes,
            "0.2")
        movieList.add(movie)
        movie = MovieEntity("Glass",
            "A film about multi personalities, a good movie with a plot twist",
            R.drawable.poster_glass,
            "7.7")
        movieList.add(movie)
        movie = MovieEntity("How to Train your Dragon",
            "A movie, animated movie about training your dragon become your ride",
            R.drawable.poster_how_to_train,
            "6.6")
        movieList.add(movie)
        movie = MovieEntity("Infinity War",
            "Mannn, I am not a marvel die hard fan but I think I don't need to describe this movie",
            R.drawable.poster_infinity_war,
            "8")
        movieList.add(movie)
    }

}