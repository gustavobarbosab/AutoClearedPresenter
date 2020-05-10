package com.gustavobarbosab.autodispose.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gustavobarbosab.autodispose.R
import com.gustavobarbosab.autodispose.data.PersonAPI
import com.gustavobarbosab.autodispose.data.RetrofitFactory
import com.gustavobarbosab.autodispose.domain.Person
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment(), ThirdContract.View {

    lateinit var presenter: ThirdContract.Presenter
    val adapter = ThirdAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_third, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ThirdPresenter(this, RetrofitFactory.getAPI(PersonAPI::class.java))
        presenter.loadPeople()
        thirdRecycler.adapter = adapter
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    override fun showPeople(people: List<Person>) {
        adapter.people = people
        adapter.notifyDataSetChanged()
    }

    override fun showToastDestroyed() {
        Toast.makeText(context, "Third Destroyed!", Toast.LENGTH_SHORT).show()
    }
}