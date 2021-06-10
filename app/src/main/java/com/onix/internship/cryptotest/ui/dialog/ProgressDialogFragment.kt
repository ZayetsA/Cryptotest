package com.onix.internship.cryptotest.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.onix.internship.cryptotest.databinding.FragmentDialogBinding


class ProgressDialogFragment : DialogFragment() {

    private val viewModel: ProgressDialogViewModel by viewModels {
        ProgressDialogViewModelFactory(
            arguments
        )
    }
    private lateinit var binding: FragmentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}