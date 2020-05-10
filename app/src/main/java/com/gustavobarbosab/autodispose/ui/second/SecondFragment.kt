package com.gustavobarbosab.autodispose.ui.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.gustavobarbosab.autodispose.R
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), SecondContract.View {

    lateinit var presenter: SecondContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_second.setOnClickListener {
            findNavController().popBackStack()
        }
        presenter = SecondPresenter(this)
        presenter.getNamesFromService()
    }

    override fun showDestroyToast() {
        Toast.makeText(context, "Second Destroyed!", Toast.LENGTH_LONG).show()
    }

    override fun showSuccess() {
        Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
    }

    override fun showError() {
        Toast.makeText(context, "Ops... Sorry =[", Toast.LENGTH_LONG).show()
    }
}
