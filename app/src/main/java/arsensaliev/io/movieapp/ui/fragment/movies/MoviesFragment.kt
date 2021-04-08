package arsensaliev.io.movieapp.ui.fragment.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import arsensaliev.io.movieapp.databinding.FragmentMoviesBinding
import arsensaliev.io.movieapp.mvp.presenter.movies.MoviesPresenter
import arsensaliev.io.movieapp.mvp.view.movies.MoviesView
import arsensaliev.io.movieapp.ui.App
import arsensaliev.io.movieapp.ui.BackButtonListener
import arsensaliev.io.movieapp.ui.adapter.MoviesRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MoviesFragment : MvpAppCompatFragment(), MoviesView, BackButtonListener {
    private val presenter by moxyPresenter {
        MoviesPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private var ui: FragmentMoviesBinding? = null
    private var adapter: MoviesRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun init() {
        ui?.rvMovies?.layoutManager = LinearLayoutManager(requireContext())
        adapter = MoviesRVAdapter(presenter.moviesListPresenter).apply {
            App.instance.appComponent.inject(this)
        }
        ui?.rvMovies?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }


    override fun backPressed(): Boolean = presenter.backClick()

    companion object {
        fun newInstance() = MoviesFragment().apply {}
    }
}