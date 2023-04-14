package com.example.guessnumbergame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.guessnumbergame.databinding.FragmentGameScreenBinding


class GameScreenFragment : Fragment() {
    private lateinit var binding: FragmentGameScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= FragmentGameScreenBinding.inflate(inflater, container, false)

        val bundle: GameScreenFragmentArgs by navArgs()
        val receivedNumber= bundle.randomNo

        var remainingRight: Int= 5

        binding.buttonGuess.setOnClickListener {






            val guessedNumberString = binding.editTextNumber.text.toString()
            if (!guessedNumberString.isNullOrEmpty()) {
                remainingRight -= 1
                binding.textViewGuessRight.text = "Remaining Right: $remainingRight"
                try {
                    val guessedNumber = guessedNumberString.toInt()

                    if (guessedNumber == receivedNumber) {
                        val switch = GameScreenFragmentDirections.actionGameScreenFragmentToResultFragment(true)
                        Navigation.findNavController(it).navigate(switch)
                        return@setOnClickListener
                    } else if (guessedNumber < receivedNumber) {
                        binding.textViewClue.text = getString(R.string.lowClue)
                    } else {
                        binding.textViewClue.text = getString(R.string.highClue)
                    }



                } catch (e: Exception) {
                    Toast.makeText(context, e.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(requireActivity(), "Please Enter the Number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (remainingRight == 0) {
                val switch = GameScreenFragmentDirections.actionGameScreenFragmentToResultFragment(false)
                Navigation.findNavController(requireView()).navigate(switch)
            }

            binding.editTextNumber.setText("")

        }







        return binding.root

    }


}