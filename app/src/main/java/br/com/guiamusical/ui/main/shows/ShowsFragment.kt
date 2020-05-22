package br.com.guiamusical.ui.main.shows


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.guiamusical.R
import br.com.guiamusical.databinding.FragmentShowsBinding
import br.com.infrastructure.base.AbstractFragment
import br.com.infrastructure.base.AbstractViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class ShowsFragment : AbstractFragment<FragmentShowsBinding>() {

    override val layoutId: Int get() = R.layout.fragment_shows

    override fun initVars(view: View) {}

    override fun initAction() {}

    override fun initBinder(binder: FragmentShowsBinding) {}

    private val showsViewModel : ShowsViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel get() = showsViewModel


}
