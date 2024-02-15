package fastcampus.part3.personalitytest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import fastcampus.part3.personalitytest.R
import fastcampus.part3.personalitytest.databinding.FragmentResultBinding
import fastcampus.part3.personalitytest.databinding.FragmentSelectionBinding

class ResultFragment : Fragment() {

    var option = -1

    lateinit var navController: NavController
    var fragmentResultBinding : FragmentResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentResultBinding.inflate(inflater, container, false)
        option = arguments?.getInt("index1") ?: -1
//        option = savedInstanceState?.getInt("index1") ?: -1
        fragmentResultBinding = binding
        return fragmentResultBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setResult(option)
        fragmentResultBinding?.nextButton?.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_questionFragment)
        }
    }

    fun setResult(option : Int){
        when(option){
            1 -> {fragmentResultBinding?.result1?.text = "그리핀도르"}
            2 -> {fragmentResultBinding?.result1?.text = "슬리데린"}
            3 -> {fragmentResultBinding?.result1?.text = "후풀푸프"}
            4 -> {fragmentResultBinding?.result1?.text = "레번클로"}
        }
    }
}