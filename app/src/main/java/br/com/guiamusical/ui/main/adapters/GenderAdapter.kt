package br.com.guiamusical.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.domain.entity.Gender
import br.com.guiamusical.R
import br.com.guiamusical.databinding.CardGenderBinding

class GenderAdapter(val context: Context, val data: List<Gender>) : RecyclerView.Adapter<GenderAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binder = DataBindingUtil.inflate<CardGenderBinding>(inflater, R.layout.card_gender, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


    class ViewHolder(private val binder : CardGenderBinding) : RecyclerView.ViewHolder(binder.root) {

        fun bind(data: Gender){
            binder.model = data
        }
    }
}