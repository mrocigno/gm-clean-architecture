package br.com.guiamusical.ui.main.news


import android.view.View
import androidx.fragment.app.Fragment
import br.com.guiamusical.R
import br.com.guiamusical.databinding.FragmentNewsBinding
import br.com.infrastructure.base.AbstractFragment
import br.com.infrastructure.base.AbstractViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : AbstractFragment<FragmentNewsBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_news

    override fun initVars(view: View) {}

    override fun initAction() {}

    override fun initBinder(binder: FragmentNewsBinding) {}

    private val newsViewModel : NewsViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel
        get() = newsViewModel


}
