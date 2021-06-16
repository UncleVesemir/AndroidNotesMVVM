package com.example.mvvm_room.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_room.R
import com.example.mvvm_room.databinding.FragmentStartBinding
import com.example.mvvm_room.utils.*
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewmodel: StartFragmentViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        mViewmodel = ViewModelProvider(this).get(StartFragmentViewmodel::class.java)
        if (AppPreference.getInitUser()){
            mViewmodel.initDatabase(AppPreference.getTypeDB()) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        } else {
            initialization()
        }
        initialization()
    }

    private fun initialization() {
        mBinding.btnRoom.setOnClickListener {
            mViewmodel.initDatabase(TYPE_ROOM) {

                AppPreference.setInitUser(true)
                AppPreference.setTypeDB(TYPE_ROOM)

                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }

        mBinding.btnFirebase.setOnClickListener {
            mBinding.inputPassword.visibility = View.VISIBLE
            mBinding.inputEmail.visibility = View.VISIBLE
            mBinding.btnLogin.visibility = View.VISIBLE
            mBinding.btnLogin.setOnClickListener {
                val inputEmail = mBinding.inputEmail.text.toString()
                val inputPassword = mBinding.inputPassword.text.toString()
                if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                    EMAIL = inputEmail
                    PASSWORD = inputPassword
                    mViewmodel.initDatabase(TYPE_FIREBASE) {

                        AppPreference.setInitUser(true)
                        AppPreference.setTypeDB(TYPE_FIREBASE)

                        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainFragment)
                    }
                } else {
                    showToast(getString(R.string.toast_wrong_login))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}