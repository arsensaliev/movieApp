package arsensaliev.io.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import arsensaliev.io.movieapp.databinding.ItemMoviesBinding
import arsensaliev.io.movieapp.mvp.model.image.IImageLoader
import arsensaliev.io.movieapp.mvp.presenter.movies.IMoviesListPresenter
import arsensaliev.io.movieapp.mvp.view.movies.list.IMovieItemView
import javax.inject.Inject

class MoviesRVAdapter(val presenter: IMoviesListPresenter) :
    RecyclerView.Adapter<MoviesRVAdapter.ViewHolder>() {
    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount(): Int = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    inner class ViewHolder(val ui: ItemMoviesBinding) : RecyclerView.ViewHolder(ui.root),
        IMovieItemView {

        override var pos = -1

        override fun setTitle(text: String) = with(ui) {
            tvItemTitle.text = text
        }

        override fun setPoster(url: String) = with(ui) {
            imageLoader.load(url, tvItemPoster)
        }
    }
}