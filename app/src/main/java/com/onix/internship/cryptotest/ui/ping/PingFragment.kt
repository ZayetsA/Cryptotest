package com.onix.internship.cryptotest.ui.ping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.cryptotest.data.api.RetrofitBuilder
import com.onix.internship.cryptotest.data.api.ping.Helper
import com.onix.internship.cryptotest.data.model.Response
import com.onix.internship.cryptotest.databinding.FragmentPingBinding
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class PingFragment : Fragment() {
    private val viewModel: PingViewModel by viewModels {
        PingViewModelFactory(
            Helper(RetrofitBuilder.apiService)
        )
    }

    private lateinit var binding: FragmentPingBinding

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
    }

    private fun showMessage(response: Response) {
        Snackbar.make(requireView().rootView, response.geckoSays.toString(), Snackbar.LENGTH_SHORT)
            .show()
    }
}