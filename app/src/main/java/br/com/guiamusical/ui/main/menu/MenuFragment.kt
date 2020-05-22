package br.com.guiamusical.ui.main.menu


import android.view.View
import androidx.fragment.app.Fragment
import br.com.guiamusical.R
import br.com.guiamusical.databinding.FragmentMenuBinding
import br.com.infrastructure.base.AbstractFragment
import br.com.infrastructure.base.AbstractViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : AbstractFragment<FragmentMenuBinding>() {

    override val layoutId: Int get() = R.layout.fragment_menu

    override fun initVars(view: View) {}

    override fun initAction() {}

    override fun initBinder(binder: FragmentMenuBinding){

    }

    private val menuViewModel : MenuViewModel by viewModel()

    override val abstractViewModel: AbstractViewModel
        get() = menuViewModel


}
