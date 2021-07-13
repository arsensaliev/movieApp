package arsensaliev.io.movieapp.ui.activity

import android.os.Bundle
import arsensaliev.io.movieapp.R
import arsensaliev.io.movieapp.databinding.ActivityMainBinding
import arsensaliev.io.movieapp.mvp.presenter.main.MainPresenter
import arsensaliev.io.movieapp.mvp.view.main.MainView
import arsensaliev.io.movieapp.ui.App
import arsensaliev.io.movieapp.ui.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    val navigator = AppNavigator(this, R.id.container)

    private val ui: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val presenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)
        App.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }
}