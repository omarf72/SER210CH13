package com.example.guessinggames

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.example.guessinggames.databinding.FragmentResultBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
  private var _binding:FragmentResultBinding?=null
    private val binding get()=_binding!!
    lateinit var viewModel:ResultViewModel
    lateinit var viewModelFactory:ResultViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentResultBinding.inflate(inflater,container,false)
        val view =binding.root

        val result=ResultFragmentArgs.fromBundle(requireArguments()).result

        viewModelFactory=ResultViewModelFactory(result)

        viewModel=ViewModelProvider(this,viewModelFactory)
            .get(ResultViewModel::class.java)

        binding.resultViewModel=viewModel

        binding.newGameButton.setOnClickListener{
            view.findNavController()
                .navigate(R.id.action_resultFragment_to_gameFragment)
        }
        return view


    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding=null
    }


}