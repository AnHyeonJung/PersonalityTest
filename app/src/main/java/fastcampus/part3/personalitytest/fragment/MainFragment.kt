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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    var fragmentMainBinding : FragmentMainBinding? = null
    lateinit var navController : NavController

    override fun onDestroyView(){

        fragmentMainBinding = null //여기서 null 줌으로써 날리는거임

        super.onDestroyView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        fragmentMainBinding = binding

        return fragmentMainBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        fragmentMainBinding?.nextButton?.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_questionFragment)
        }
    }
}