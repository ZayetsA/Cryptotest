package com.onix.internship.cryptotest.ui.ping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.cryptotest.data.api.RetrofitBuilder
import com.onix.internship.cryptotest.data.api.ping.Client
import com.onix.internship.cryptotest.databinding.FragmentPingBinding
import com.onix.internship.cryptotest.ui.dialog.ProgressDialogFragment
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class PingFragment : Fragment() {
    private val viewModel: PingViewModel by viewModels {
        PingViewModelFactory(
            Client(RetrofitBuilder.apiService)
        )
    }

    private lateinit var binding: FragmentPingBinding
    private val fragment = ProgressDialogFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.data.observe(viewLifecycleOwner, ::showMessage)
        viewModel.isDataLoading.observe(viewLifecycleOwner, ::showDialogFragment)
    }


    private fun showDialogFragment(show: Boolean) {
        if (show) {
            fragment.show(parentFragmentManager, "some tag")
        } else {
            if (fragment.isAdded) {
                fragment.dismiss()
            }
        }
    }

    private fun showMessage(data: String) {
        Snackbar.make(requireView(), data, Snackbar.LENGTH_SHORT)
            .show()

    }
}