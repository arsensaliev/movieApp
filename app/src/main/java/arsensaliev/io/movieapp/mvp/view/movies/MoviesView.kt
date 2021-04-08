package arsensaliev.io.movieapp.mvp.view.movies

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface MoviesView : MvpView {
    fun init()
    fun updateList()
}