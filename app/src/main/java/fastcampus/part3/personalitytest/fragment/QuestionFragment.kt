package fastcampus.part3.personalitytest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import fastcampus.part3.personalitytest.R
import fastcampus.part3.personalitytest.databinding.FragmentMainBinding
import fastcampus.part3.personalitytest.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {

    var fragmentQuestionBinding : FragmentQuestionBinding? = null
    lateinit var navController : NavController

    override fun onDestroyView(){

        fragmentQuestionBinding = null //여기서 null 줌으로써 날리는거임

        super.onDestroyView()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQuestionBinding.inflate(inflater, container, false)

        fragmentQuestionBinding = binding

        return fragmentQuestionBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        fragmentQuestionBinding?.nextButton?.setOnClickListener {
            navController.navigate(R.id.action_questionFragment_to_selectionFragment)
        }
    }
}