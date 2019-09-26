package com.app.muhrahmatullah.dicodingjetpackmovie.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.MovieEntity
import com.app.muhrahmatullah.dicodingjetpackmovie.entity.TvSeriesEntity
import javax.inject.Inject

/**
 * Created by muh.rahmatullah on 2019-09-24.
 */

class FakeRepo @Inject constructor(){

    val movieList = mutableListOf<MovieEntity>()

    val tvSeriesList = mutableListOf<TvSeriesEntity>()

    private val _movieLiveData = MutableLiveData<List<MovieEntity>>()

    private val _tvSeriesLiveData = MutableLiveData<List<TvSeriesEntity>>()

    private val tvSeriesLiveData : LiveData<List<TvSeriesEntity>>
        get() = _tvSeriesLiveData

    private val movieLiveData : LiveData<List<MovieEntity>>
        get() = _movieLiveData


    fun fetchMovie(): LiveData<List<MovieEntity>> {
        provideMovieData()
        _movieLiveData.value = movieList
        return movieLiveData
    }

    fun fetchTvSeries(): LiveData<List<TvSeriesEntity>> {
        provideTvSeriesData()
        _tvSeriesLiveData.value = tvSeriesList
        return tvSeriesLiveData
    }

    private fun provideTvSeriesData() {
        //definitely need to remove this very long string,
        // only temporary for fake data
        var tvSeries = TvSeriesEntity("Arrow",
            "Arrow is an American superhero television series developed by Greg Berlanti, Marc Guggenheim, and Andrew Kreisberg based on the DC Comics character",
            R.drawable.poster_arrow,
            "7.7"
        )
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Dragon ball",
            "Dragon Ball is a Japanese media franchise created by Akira Toriyama in 1984. The initial ... Almost all of the Dragon Ball series, except for parts of Dragon Ball Super, takes place in Universe 7.",
            R.drawable.poster_dragon_ball,
            "7.4")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Fairytail",
            "Fairy Tail is a Japanese manga series written and illustrated by Hiro Mashima. It was serialized in Kodansha's Weekly Shōnen Magazine",
            R.drawable.poster_fairytail,
            "7")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Family Guy",
            "Basically a cartoon fro grownup people, there is also doc who can speaks",
            R.drawable.poster_family_guy,
            "8")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Gotham",
            "DC Series which took settings in the city where Batman lived",
            R.drawable.poster_cold_persuit,
            "6")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Grey's Anatomy",
            "A drama series about doctor, from intern to a doctor",
            R.drawable.poster_grey_anatomy,
            "7.8")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Naruto Shippuden",
            "Anime about a kid who has dream to be a village leader (Hokage)",
            R.drawable.poster_naruto_shipudden,
            "0.2")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("Super Girl",
            "A series about Superman's not so popular cousin",
            R.drawable.poster_supergirl,
            "7.7")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("The Simpson",
            "Cartoon with all the characters have a yellow skin",
            R.drawable.poster_the_simpson,
            "6.6")
        tvSeriesList.add(tvSeries)
        tvSeries = TvSeriesEntity("The Walking Dead",
            "Zombies Everywhere",
            R.drawable.poster_the_walking_dead,
            "8")
        tvSeriesList.add(tvSeries)
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