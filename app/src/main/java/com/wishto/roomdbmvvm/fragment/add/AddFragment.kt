package com.wishto.roomdbmvvm.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.wishto.roomdbmvvm.R
import com.wishto.roomdbmvvm.databinding.FragmentAddBinding
import com.wishto.roomdbmvvm.model.User
import com.wishto.roomdbmvvm.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {

        val firstname = binding.etFirstName.text.toString()
        val lastname = binding.etSecondName.text.toString()
        val age = binding.etAge.text.toString()

        if (inputCheck(firstname, lastname, age)) {
            val user = User(0, firstname, lastname, Integer.parseInt(age))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG)
                .show()

        }
    }

    private fun inputCheck(firstname: String, lastname: String, age: String): Boolean {
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =
            null // <- whenever we destroy our fragment, _binding is set to null. Hence it will avoid memory leaks.
    }
}