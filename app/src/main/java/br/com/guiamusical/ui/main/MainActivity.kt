package br.com.guiamusical.ui.main

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.guiamusical.R
import br.com.guiamusical.databinding.ActivityMainBinding
import br.com.infrastructure.base.AbstractActivity
import br.com.infrastructure.base.AbstractViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AbstractActivity<ActivityMainBinding>() {

    override val layoutId: Int get() = R.layout.activity_main

    private val mainViewModel : MainViewModel by viewModel()
    override val abstractViewModel: AbstractViewModel get() = mainViewModel

    override fun initVars(binder: ActivityMainBinding) {
        binder.helloWord = "Olá meu mundinho TOPPER!"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.frgNavigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.bnvHome, R.id.bnvNews, R.id.bnvShows, R.id.bnvMenu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bnvMainActivity.setupWithNavController(navController)
    }

}
