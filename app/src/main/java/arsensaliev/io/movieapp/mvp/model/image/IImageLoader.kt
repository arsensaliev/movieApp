package arsensaliev.io.movieapp.mvp.model.image

interface IImageLoader<T> {
    fun load(url: String, container: T)
}