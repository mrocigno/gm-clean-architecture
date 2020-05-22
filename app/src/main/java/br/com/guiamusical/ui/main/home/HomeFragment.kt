package br.com.guiamusical.ui.main.home


import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.guiamusical.R
import br.com.guiamusical.databinding.FragmentHomeBinding
import br.com.guiamusical.ui.main.adapters.HomeAdapter
import br.com.infrastructure.base.AbstractFragment
import br.com.infrastructure.base.AbstractViewModel
import br.com.infrastructure.utils.bind
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : AbstractFragment<FragmentHomeBinding>() {

    override val layoutId: Int get() = R.layout.fragment_home

    override fun initVars(view: View) {}

    override fun initAction() {

    }

    override fun initBinder(binder: FragmentHomeBinding) {
        binder.srlHome.setOnRefreshListener {
            homeViewModel.getHomeData()
        }
        bind(homeViewModel.loading, ::isLoading)
        bind(homeViewModel.homeData, ::setAdapters)
    }

    private fun isLoading(loading : Boolean){
        srlHome.isRefreshing = loading
    }

    private fun setAdapters(list: List<Any>) {
        rcyNews.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rcyNews.adapter = context?.let { HomeAdapter(it, list) }
    }

    private val homeViewModel : HomeViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel
        get() = homeViewModel
}
