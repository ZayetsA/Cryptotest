package com.onix.internship.cryptotest.ui.ping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.cryptotest.data.api.RetrofitBuilder
import com.onix.internship.cryptotest.data.api.ping.Client
import com.onix.internship.cryptotest.databinding.FragmentPingBinding
import com.onix.internship.cryptotest.util.DialogFragmentStates
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class PingFragment : Fragment() {
    private val viewModel: PingViewModel by viewModels {
        PingViewModelFactory(
            Client(RetrofitBuilder.apiService)
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
        viewModel.navigationEvent.observe(viewLifecycleOwner, ::navigate)
        viewModel.data.observe(viewLifecycleOwner, ::showSneakBar)
        viewModel.isDataLoading.observe(viewLifecycleOwner, ::showDialogFragment)
    }


    private fun showDialogFragment(state: DialogFragmentStates) {
        when (state) {
            DialogFragmentStates.SHOW -> {
                showProgressDialog()
            }
            DialogFragmentStates.HIDE -> {
                dismissProgressDialog()
            }
            else -> return
        }
    }

    private fun showProgressDialog() {
        navigate(
            PingFragmentDirections.actionPingFragmentToProgressDialogFragment(
                "some title",
                "some message"
            )
        )
    }

    private fun dismissProgressDialog() {
        with(findNavController()) {
            popBackStack()
        }
    }

    private fun showSneakBar(data: String) {
        Snackbar.make(requireView(), data, Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun navigate(navDirection: NavDirections) {
        findNavController().navigate(navDirection)
    }
}