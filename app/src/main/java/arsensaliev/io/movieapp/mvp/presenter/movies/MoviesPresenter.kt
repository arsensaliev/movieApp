package arsensaliev.io.movieapp.mvp.presenter.movies

import arsensaliev.io.movieapp.mvp.model.entity.Movie
import arsensaliev.io.movieapp.mvp.model.navigation.IScreens
import arsensaliev.io.movieapp.mvp.model.repo.IMoviesRepo
import arsensaliev.io.movieapp.mvp.view.movies.MoviesView
import arsensaliev.io.movieapp.mvp.view.movies.list.IMovieItemView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import javax.inject.Inject
import javax.inject.Named

class MoviesPresenter : MvpPresenter<MoviesView>() {
    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var moviesRepo: IMoviesRepo

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    val moviesListPresenter = MoviesListPresenter()
    val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        moviesListPresenter.itemClickListener = { itemView ->
            val movie = moviesListPresenter.movies[itemView.pos]
//            router.navigateTo(screens.movies(movie))
        }
    }

    private fun loadData() {
        val disposable: Disposable = moviesRepo.getMovies()
            .observeOn(uiScheduler)
            .subscribe({
                moviesListPresenter.movies.addAll(it)
                viewState.updateList()
            }, {
                it.printStackTrace()
            })

        compositeDisposable.addAll(disposable)
    }

    class MoviesListPresenter : IMoviesListPresenter {
        val movies = mutableListOf<Movie>()
        override var itemClickListener: ((IMovieItemView) -> Unit)? = null

        override fun bindView(view: IMovieItemView) {
            val movie = movies[view.pos]
            movie.title?.let { view.setTitle(it) }
            movie.poster?.let { view.setPoster(it) }
        }

        override fun getCount(): Int = movies.size
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
