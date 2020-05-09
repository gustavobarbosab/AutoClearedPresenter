package com.gustavobarbosab.autodispose.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gustavobarbosab.autodispose.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), FirstContract.View {

    private lateinit var presenter: FirstPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        presenter = FirstPresenter(this)
        presenter.init()
    }

    override fun showInitToast() {
        Toast.makeText(context, "First created!", Toast.LENGTH_SHORT).show()
    }

    override fun showDestroyToast() {
        Toast.makeText(context, "First destroyed!", Toast.LENGTH_LONG).show()
    }
}
