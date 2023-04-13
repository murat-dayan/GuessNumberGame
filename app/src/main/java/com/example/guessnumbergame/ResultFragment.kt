package com.example.guessnumbergame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.guessnumbergame.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentResultBinding.inflate(inflater, container, false)

        val bundle: ResultFragmentArgs by navArgs()
        val isWin= bundle.isWin

        if (isWin == false){
            binding.imageViewResultFace.setImageResource(R.drawable.lose_image)
            binding.textViewResult.text= getString(R.string.loseText)
        }

        binding.buttonPlayAgain.setOnClickListener {
            val switch= ResultFragmentDirections.actionResultFragmentToHomeScreenFragment()
            Navigation.findNavController(it).navigate(switch)
        }

        return binding.root
    }


}