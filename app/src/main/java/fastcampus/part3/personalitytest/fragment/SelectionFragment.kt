package fastcampus.part3.personalitytest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import fastcampus.part3.personalitytest.R
import fastcampus.part3.personalitytest.databinding.FragmentMainBinding
import fastcampus.part3.personalitytest.databinding.FragmentSelectionBinding

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    var fragmentSelectionBinding : FragmentSelectionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSelectionBinding.inflate(inflater, container, false)

        fragmentSelectionBinding = binding
        return fragmentSelectionBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        fragmentSelectionBinding?.option1?.setOnClickListener(this)
        fragmentSelectionBinding?.option2?.setOnClickListener(this)
        fragmentSelectionBinding?.option3?.setOnClickListener(this)
        fragmentSelectionBinding?.option4?.setOnClickListener(this)
        fragmentSelectionBinding?.beforeButton?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_1 -> {
                navigateWithIndex(1)
            }
            R.id.option_2 -> {
                navigateWithIndex(2)
            }
            R.id.option_3 -> {
                navigateWithIndex(3)
            }
            R.id.option_4 -> {
                navigateWithIndex(4)
            }
            R.id.beforeButton -> {
                navController.popBackStack()
            }

        }
    }

    fun navigateWithIndex(index1 : Int){
        val bundle = bundleOf("index1" to index1)
        navController.navigate(R.id.action_selectionFragment_to_resultFragment,bundle)
    }
}
