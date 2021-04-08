package arsensaliev.io.movieapp.mvp.view.movies.list

interface IMovieItemView : ItemView {
    fun setTitle(text: String)
    fun setPoster(url: String)
}