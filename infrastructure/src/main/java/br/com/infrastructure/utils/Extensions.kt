package br.com.infrastructure.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any> LifecycleOwner.bind(data: LiveData<T>, function: (id: T) -> Unit) {
    data.observe(this, Observer {
        it?.also {source ->
            function(source)
        }
    })
}