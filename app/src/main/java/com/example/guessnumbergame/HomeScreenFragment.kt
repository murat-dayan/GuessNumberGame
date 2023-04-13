package com.example.guessnumbergame

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.guessnumbergame.databinding.FragmentHomeScreenBinding
import kotlin.random.Random


class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentHomeScreenBinding.inflate(inflater, container, false)

        binding.buttonStartGame.setOnClickListener {
            val randomNumber= Random.nextInt(0, 101)
            Log.e("GUESS", randomNumber.toString())
            val switch= HomeScreenFragmentDirections.actionHomeScreenFragmentToGameScreenFragment(randomNumber)
            Navigation.findNavController(it).navigate(switch)

        }

        return binding.root
    }


}