package com.challenge.weather.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.challenge.weather.R
import com.challenge.weather.databinding.DialogFragmentProgresBinding

class ProgressDialogFragment : BaseDialogFragment<DialogFragmentProgresBinding>() {

    companion object {
        const val TAG = "dialog.loading"
    }

    var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Black_NoTitleBar)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        isCancelable = false
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DialogFragmentProgresBinding {
        return DialogFragmentProgresBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMessage.text = message ?: getString(R.string.loading)
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            manager.beginTransaction().remove(this).commit()
            super.show(manager, tag)
        } catch (e: IllegalStateException) {
            e.message
        }
    }

    override fun dismiss() {
        super.dismissAllowingStateLoss()
    }

    fun isShowing(): Boolean {
        dialog?.let {
            return it.isShowing
        }
        return false
    }
}