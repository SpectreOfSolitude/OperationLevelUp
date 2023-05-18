package com.example.whizz.ui.quest

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whizz.R
import com.example.whizz.R.layout.fragment_dashboard
import com.example.whizz.databinding.FragmentDashboardBinding
import com.example.whizz.ui.data.Adapter.QuestAdapter
import com.example.whizz.ui.data.model.Quest


class DashboardFragment : Fragment() {

    lateinit var questAdapter:QuestAdapter
    val lm = LinearLayoutManager(activity)
    val addQuestList: MutableList<Quest> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

//    private var binding: FragmentDashboardBinding? = null
//    override fun onCreateView(inflater: LayoutInflater,
//                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
//        binding = FragmentDashboardBinding.inflate(inflater, container, false)
//        val root: View = binding!!.root
//        val textView = binding!!.dashboardPage
//        dashboardViewModel.text.observe(viewLifecycleOwner) { text: String? -> textView.text = text }
//        return root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }

    fun initView()
    {
        rv_quest.layoutManager = lm
        questAdapter = QuestAdapter(requireActivity())
        rv_quest.adapter = questAdapter
    }
}